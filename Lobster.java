    // import java.io.ObjectInputStream.GetField;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author Leon Namowitz 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    private int lobsterIndex;
    private int moveSteps = 0;
    private int moveTime = CrabWorld.generator("lobsterMoveTime");
    public static int speed = 2;
    public static SimpleTimer delayTimer = new SimpleTimer();

    /**
     * Constructor
     */
    public Lobster(int index, int rotation)
    {
        lobsterIndex = index;
        setRotation(rotation);
        // System.out.println(moveTime);
    }


    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // randomMove();
        naturalMove();
        eatCrab();
    }

    /**
     * Random Movement
     */
    public void randomMove()
    {
        if (isAtEdge() == true) {
            turn(20);
        }
        if (moveSteps < moveTime) {
            move(speed);
            moveSteps++;
            
        }
        else if (moveSteps == moveTime)   {
            setRotation(CrabWorld.generator("rotation"));
            moveSteps = 0;
            moveTime = CrabWorld.generator("lobsterMoveTime");
        }
    }

    /**
     * Semi Natural Movement
     */
    public void naturalMove()
    {
        if (isAtEdge() == true) {
                turn(20);
        }
        if (moveSteps < moveTime) {
            move(speed);
            moveSteps++;
            
        }
        else if (moveSteps == moveTime)   {
            turn(CrabWorld.generator("turning"));
            moveSteps = 0;
            moveTime = CrabWorld.generator("lobsterMoveTime");
        }  
    }

    
    /**
     * Removes the Crab and decreases the Lives of the player.
     * You need to "typecast" (inform the compiler) where it can find the method of the subclass of the World.
     * typcast the current Crab object into the Crab variable crab to check the current lives. (I think..)
     * Score and Lives variables are held in CrabWorld. 
     * 1-2 seconds invincible after (re)spawning.
     */
    public void eatCrab()
    {
        Crab crab = (Crab) getOneIntersectingObject(Crab.class);
        CrabWorld crabWorld = (CrabWorld) getWorld();
        
        // 1,8 Second delay on respawn, independent for each Crab.
        if (isTouching(Crab.class) == true && crab.crabLives > 0 && delayTimer.millisElapsed() > 2000 ) {
            int lastRotation = crab.getRotation();
            int lastX = crab.getX();
            int lastY = crab.getY();
            PopUp livesPopUp = new PopUp("lifeLost", crab.crabLives-1);

            removeTouching(Crab.class);
            crabWorld.decreaseLivesCounter();
            crabWorld.changeScoreCounter(-150);
            crabWorld.addObject(livesPopUp, crabWorld.getWidth()/2, crabWorld.getHeight()/2);
            Greenfoot.delay(80);
            crabWorld.removeObject(livesPopUp);
            crabWorld.addObject(new Crab((crab.crabLives-1), lastRotation), lastX, lastY);
            delayTimer.mark();  // Starts Timer
        }
        else if (isTouching(Crab.class) == true && crab.crabLives == 0 && delayTimer.millisElapsed() > 2000 )    {
            removeTouching(Crab.class);
            int finalScore = finalScore();
            PopUp endPopUp = new PopUp("gameOver", finalScore);

            crabWorld.addObject(endPopUp, crabWorld.getWidth()/2, crabWorld.getHeight()/2);
            // Greenfoot.stop(); 
        }
    }  

    public int finalScore()
    {
        CrabWorld crabWorld = (CrabWorld) getWorld();
        int wormScore = crabWorld.scoreValue;
        return wormScore;
    }
}

