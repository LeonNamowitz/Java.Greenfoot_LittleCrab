import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 600x600 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(600, 600, 1);
        setPaintOrder(Crab.class, Lobster.class, Worm.class);  // draw order
        populate();
    }

    public void populate()
    {
        
        Crab crab = new Crab();
        addObject(crab, 250, 250);
        Worm worm = new Worm();
        addObject(worm, 445, 137);
        Worm worm2 = new Worm();
        addObject(worm2, 454, 369);
    
    }
}