import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int value = 0;

    public Counter(int value)
    {
        value = 0;
    }
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, Color.BLACK));
        // gameFinish();
        
    }

    /**
     * Checks if all the Worms have been eaten and ends the Game.
     */
    public void gameFinish()
    {
        Greenfoot.stop();
    }

    public void updateCounter(int newScore)
    {
        setImage(new GreenfootImage("Score: " + newScore, 24, Color.WHITE, Color.BLACK));
    }
}
