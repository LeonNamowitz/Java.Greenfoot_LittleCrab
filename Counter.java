import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int value = 0;
    DecimalFormat tests = new DecimalFormat("0.00");

    public Counter(int value)
    {
        value = 0;
    }
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Counter updating happens in CrabWorld act() method.        
    }


    public void updateScoreCounter(int newScore)
    {
        setImage(new GreenfootImage("Score: " + newScore, 24, Color.WHITE, Color.BLACK));
    }

    public void updateLivesCounter(int newLives)
    {
        setImage(new GreenfootImage("Lives: " + newLives, 24, Color.GREEN, Color.BLACK));
    }

    public void updateTimeCounter(double newTime)
    {
        setImage(new GreenfootImage("Time: " + tests.format(newTime) + " ss", 24, Color.WHITE, Color.DARK_GRAY ));
    }
}
