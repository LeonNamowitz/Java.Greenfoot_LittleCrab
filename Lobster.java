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
    private int defaultRotation;
    private int moveSteps = 0;
    private int moveTime = CrabWorld.generator("lobsterMoveTime");

    /**
     * Constructor
     */
    public Lobster(int index, int defaultRotation)
    {
        lobsterIndex = index;
        setRotation(defaultRotation);
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
        // move(3);
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
            move(2);
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
            move(2);
            moveSteps++;
            
        }
        else if (moveSteps == moveTime)   {
            turn(CrabWorld.generator("turning"));
            moveSteps = 0;
            moveTime = CrabWorld.generator("lobsterMoveTime");
        }  
    }
    
    public void eatCrab()
    {
        if (isTouching(Crab.class) == true) {
            removeTouching(Crab.class);
            CrabWorld.gameOver();
            Greenfoot.stop();
        }
    }  
}

