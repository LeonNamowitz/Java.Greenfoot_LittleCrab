import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUp extends Actor
{   

    public PopUp()
    {
        setImage(new GreenfootImage("", 0, new Color(0, 0, 0, 0), new Color(0, 0, 0, 0)));

    }

    public void lifeLost(int livesRemaining)
    {
        GreenfootImage lost = new GreenfootImage(livesRemaining + " live(s) remaining", 40, Color.WHITE, Color.BLACK);
        setImage(lost);

    }









    /**
     * Act - do whatever the PopUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
