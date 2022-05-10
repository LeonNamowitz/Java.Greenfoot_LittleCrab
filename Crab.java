import greenfoot.*;

/**
 * Write a description of class Crab here.
 * 
 * @author Leon Namowitz 
 * @version (a version number or a date)
 */
public class Crab extends Actor
{   
    public static int wormsEaten = 0;
    public int crabSpeed;
    public int crabLives;

    /**
     * Constructor
     */
    public Crab(int lives)
    {
        crabSpeed = 3;
        crabLives += lives;
        // wormsEaten = 0;

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

    // Not in use.
    public int checkLives()
    {
        return(crabLives);
    }


    /**
     * Removes the worm and increases the Score.
     * You need to "typecast" (inform the compiler) where it can find the method of the subclass of the World.
     * Alternatively: ((CrabWorld)getWorld()).increaseScoreCounter(); 
     */
    public void eatWorm()
    {
        
        if (isTouching(Worm.class) == true) {
            removeTouching(Worm.class);
            CrabWorld crabWorld = (CrabWorld) getWorld();
            crabWorld.changeScoreCounter(+50);
            Crab.wormsEaten++;
            // System.out.println(Crab.wormsEaten);
            // getWorld().addObject(new Counter(1), 10, 10);    //Why is this working??
        }
    }  
    
}




