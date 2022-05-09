import greenfoot.*;

/**
 * Write a description of class Crab here.
 * 
 * @author Leon Namowitz 
 * @version (a version number or a date)
 */
public class Crab extends Actor
{   
    private int wormsEaten;
    public static int speed = 3;

    /**
     * Constructor
     */
    public Crab()
    {

    }

    
    public void act()
    {
        inputCheck();
        eatWorm();
        gameFinish();
    }

    public void inputCheck()
    {
        if (Greenfoot.isKeyDown("left"))
            turn(-4);
        
        if (Greenfoot.isKeyDown("right"))
            turn(4);
        
        if (Greenfoot.isKeyDown("up"))
            move(speed);
        
        if (Greenfoot.isKeyDown("down"))
            move(-speed);
    }

    // Deprecated
    
    // public void wormCheck()
    //     {
    //         if (isTouching(Worm.class)) {
    //             removeTouching(Worm.class);
                
    //         }
    //     }

    public void eatWorm()
    {
        if (isTouching(Worm.class) == true) {
            removeTouching(Worm.class);
            Score.score++;
            wormsEaten++;
        }
    }  
    
    public void gameFinish()
    {
        if (wormsEaten == CrabWorld.wormAmount) {
            Greenfoot.stop();
        }
    }
}




