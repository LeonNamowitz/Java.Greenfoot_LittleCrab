import java.util.List;
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
    private static int wormAmount = 3;
    private int lobsterAmount = 2;
    public int scoreValue;
    public int livesValue = 3;
    private int level = 1;

    Counter score = new Counter(scoreValue);
    Crab crab = new Crab(livesValue);
    Counter lives = new Counter(livesValue);

    /**
     * Create the crab world (the beach). Our world has a size
     * of 600x600 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() {
        super(worldWidth, worldHeight, 1);
        setPaintOrder(Crab.class, Lobster.class, Worm.class, Counter.class); // draw order
        populate();

    }


    public void act()
    {
        score.updateScoreCounter(scoreValue);
        lives.updateLivesCounter(livesValue);
        progress();

    }


    public void populate() 
    {
        addObject(crab, 250, 250);
        spawnWorms(wormAmount);
        spawnLobsters(lobsterAmount);
        // level1();
        spawnScoreCounter();
        spawnLivesCounter();
        Lobster.speed = 2;
    }

    public void progress()
    {
        if (Crab.wormsEaten == wormAmount)  {
            List lobsterList;
            // getObjects(<);
            // removeObjects(Lobster.class);
            nextLevel();
            Crab.wormsEaten = 0;
            System.out.println("Worms: " + wormAmount);
            System.out.println("Level: " + level);

        }
    }

    public void spawnWorms(int amount)
    {
        for (int i = 0; i < amount; i++)    {
            addObject(new Worm(i), generator("Width"), generator("Height"));
        }
    }

    public void spawnLobsters(int amount)
    {
        for (int i = 0; i < amount; i++) {
            addObject(new Lobster(i, generator("rotation")), generator("Width"), generator("Height"));
        }
    }

    public void spawnScoreCounter()
    {
        Crab.wormsEaten = 0;
        addObject(score, 50, 20);
    }

    public void increaseScoreCounter()
    {
        scoreValue++;
    }

    public void spawnLivesCounter()
    {
        // crab.crabLives = livesValue;
        addObject(lives, getWidth() - 50, 20);
    }

    public void decreaseLivesCounter()
    {
        livesValue--;
    }


    /**
     * TODO level system
     */
    public void nextLevel()
    {
        if (level == 1) {
            wormAmount = 4;
            spawnWorms(wormAmount);
            spawnLobsters(2);
            level++;
            
        }
        else if (level == 2)    {
            wormAmount = 5;
            spawnWorms(wormAmount);
            spawnLobsters(3);
            level++;
        }
        else if (level == 3)    {
            wormAmount = 6;
            spawnWorms(wormAmount);
            spawnLobsters(4);
            level++;
        }
        else if (level == 4)    {
            wormAmount = 6;
            Lobster.speed = 4;
            spawnWorms(wormAmount);
            spawnLobsters(5);
            level++;
        }
        else if (level == 5)    {
            wormAmount = 8;
            Lobster.speed++;
            spawnWorms(wormAmount);
            spawnLobsters(7);
            level++;
        }
        else if (level == 6)    {
            wormAmount = 10;
            Lobster.speed++;
            spawnWorms(wormAmount);
            spawnLobsters(8);
            level++;
        }
    }



    /**
     * Generates random numbers based on the type of need (input String).
     */
    public static int generator(String input)
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
        else if (input == "lobsterMoveTime")    {
            int returnTime = Greenfoot.getRandomNumber(40);
            return(returnTime + 20);
        }
        else if (input == "rotation")   {
            int returnRotation = Greenfoot.getRandomNumber(360);
            return(returnRotation);
        }
        else if (input == "turning")    {
            int returnTurning = Greenfoot.getRandomNumber(40);
            return(returnTurning - 20);
        }
        return(0);
    }

    public static void gameOver()
    {

    }

}