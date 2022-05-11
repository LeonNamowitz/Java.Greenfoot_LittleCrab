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
    DecimalFormat timeFormat = new DecimalFormat("0.00");
    public static double lastTime;

    public Counter(int value)
    {
        value = 0;
        setImage(new GreenfootImage("", 0, new Color(0, 0, 0, 0), new Color(0, 0, 0, 0)));
        // image.setColor(Color.BLUE);
        // image.fillRect(50, 50, 40, 10);
        // image.drawImage(image, 50, 50);    

    }
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Counter updating happens in CrabWorld act() method.        
    }

    // for transparancy: new Color(0, 0, 0, 0)
    public void updateScoreCounter(int newScore)
    {
        setImage(new GreenfootImage("Score: " + newScore, 24, Color.BLUE, new Color(0,0,0,0)));
    }

    public void updateLivesCounter(int newLives)
    {
        setImage(new GreenfootImage("Lives: " + newLives, 24, Color.GREEN, Color.DARK_GRAY));
    }

    public void updateTimeCounter(double newTime)
    {
        GreenfootImage img = new GreenfootImage("Time: " + timeFormat.format(newTime) + " s", 24, Color.WHITE, Color.DARK_GRAY );
        img.scale(123, 25);
        setImage(img);
        lastTime = newTime;
    }

    public static double returnTime()
    {
        return(lastTime);
    }

    public void updateLevelCounter(int newLevel)
    {
        setImage(new GreenfootImage("Level: " + newLevel, 24, Color.WHITE, Color.DARK_GRAY));
    }

}
