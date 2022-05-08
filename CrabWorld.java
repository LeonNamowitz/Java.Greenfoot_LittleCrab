import greenfoot.*; // (Actor, World, Greenfoot, GreenfootImage)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author Leon Namowitz
 * @version (a version number or a date)
 */
public class CrabWorld extends World {
    private static int worldWidth = 600;
    private static int worldHeight = 600;
    private static int amount = 8;
    public static int wormAmount = 5;

    /**
     * Create the crab world (the beach). Our world has a size
     * of 600x600 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() {
        super(worldWidth, worldHeight, 1);
        setPaintOrder(Crab.class, Lobster.class, Worm.class); // draw order
        populate();

    }




    public void populate() {

        Crab crab = new Crab();
        addObject(crab, 250, 250);
        spawnWorms();

        // Worm worm = new Worm();
        // addObject(worm, generator("Width"), generator("Height"));

        // System.out.println(worldWidth);
        // System.out.println(worldHeight);
    }

    public void spawnWorms()
    {
        for (int i = 0; i < wormAmount; i++)    {
            addObject(new Worm(i), generator("Width"), generator("Height"));
        }

    }

    /**
     * Generates random numbers based on the type of need (input String).
     */
    public int generator(String input)
    {
        if (input == "Width")   {
            int randomX = Greenfoot.getRandomNumber((worldWidth)+1);
            return(randomX);
        }
        else if (input == "Height") {
            int randomY = Greenfoot.getRandomNumber((worldHeight)+1);
            return(randomY);
        }
        else if (input == "Amount") {
            int returnAmount = Greenfoot.getRandomNumber(amount);
            return(returnAmount);
        }
        return(0);
    }

}