import java.io.ObjectInputStream.GetField;

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
    private static int respawnDelay = 3;

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
        decreaseRespawnDelay();
        // System.out.println(respawnDelay);
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

    /**
     * Jank invinciblility after respawn. Based on act() calls, therefore dependent on speed slider.
     */
    private void decreaseRespawnDelay()
    {
        if (respawnDelay > 0)  {
            respawnDelay--;
        }
        else if (respawnDelay == 0) {
            
        }
    }
    
    /**
     * Removes the Crab and decreases the Lives of the player.
     * You need to "typecast" (inform the compiler) where it can find the method of the subclass of the World.
     * typcast the current Crab object into the Crab variable crab to check the current lives. (I think..)
     * Score and Lives variables are held in CrabWorld. 
     */
    public void eatCrab()
    {
        Crab crab = (Crab) getOneIntersectingObject(Crab.class);

        if (respawnDelay == 0)   {
            if (isTouching(Crab.class) == true && crab.crabLives > 0 ) {
                removeTouching(Crab.class);
                CrabWorld crabWorld = (CrabWorld) getWorld();
                crabWorld.decreaseLivesCounter();
                crabWorld.addObject(new Crab(crab.crabLives-1), this.getX(), this.getY());
                respawnDelay = 400;
                System.out.println(respawnDelay);
                // Greenfoot.stop();
            }
            else if (isTouching(Crab.class) == true && crab.crabLives == 0 )    {
                removeTouching(Crab.class);
                CrabWorld.gameOver();   // not implemented yet
                Greenfoot.stop();       
            }
        }
    }  
}

