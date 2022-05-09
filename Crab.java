import greenfoot.*;

/**
 * Write a description of class Crab here.
 * 
 * @author Leon Namowitz 
 * @version (a version number or a date)
 */
public class Crab extends Actor
{   
    public int wormsEaten;
    public int crabSpeed;
    public int crabLives;

    /**
     * Constructor
     */
    public Crab(int lives)
    {
        crabSpeed = 3;
        crabSpeed = lives;
        wormsEaten = 0;

    }

    
    public void act()
    {
        inputCheck();
        eatWorm();
        
    }

    public void inputCheck()
    {
        if (Greenfoot.isKeyDown("left"))
            turn(-4);
        
        if (Greenfoot.isKeyDown("right"))
            turn(4);
        
        if (Greenfoot.isKeyDown("up"))
            move(crabSpeed);
        
        if (Greenfoot.isKeyDown("down"))
            move(-crabSpeed);
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
    
}




