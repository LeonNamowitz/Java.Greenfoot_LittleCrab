import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    public void act()
    {
        inputCheck();
        eatWorm();
        move(3);
    }

    public void inputCheck()
    {
        if (Greenfoot.isKeyDown("left")) {
            turn(-4);
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(4);
        }
    }

    public void wormCheck()
        {
            if (isTouching(Worm.class)) {
                removeTouching(Worm.class);
            }
        }

    public void eatWorm()
    {
        if (isTouching(Worm.class) == true) {
            removeTouching(Worm.class);
        }
    }
    
}




