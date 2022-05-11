import java.util.*;
import greenfoot.*; // (Actor, World, Greenfoot, GreenfootImage)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author Leon Namowitz
 * @version (a version number or a date)
 */
public class CrabWorld extends World 
{
    private static int worldWidth = 600;
    private static int worldHeight = 600;
    private static int amount = 8;
    private static int wormAmount;
    public int scoreValue;
    public int livesValue = 3;
    private int levelValue = 0;

    SimpleTimer timeElapsed = new SimpleTimer();
    Crab crab = new Crab(livesValue, 0);
    Counter scoreCount = new Counter(scoreValue);
    Counter livesCount = new Counter(livesValue);
    Counter timerCount = new Counter(0);
    Counter levelCount = new Counter(0);


    /**
     * Create the crab world (the beach). Our world has a size
     * of 600x600 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() {
        super(worldWidth, worldHeight, 1);
        setPaintOrder(PopUp.class, Crab.class, Lobster.class, Worm.class, Counter.class); // draw order
        prepare();

    }


    public void act()
    {
        updateCounters();
        progress();
        
    }


    public void prepare() 
    {
        addObject(crab, 250, 250);
        nextLevel();
        spawnScoreCounter();
        spawnLivesCounter();
        spawnTimerCounter();
        spawnLevelCounter();
        Lobster.speed = 2;
    }
    
    public void updateCounters()
    {
        scoreCount.updateScoreCounter(scoreValue);
        livesCount.updateLivesCounter(livesValue);
        levelCount.updateLevelCounter(levelValue);
        double timeElapsedDeci = timeElapsed.millisElapsed();
        timerCount.updateTimeCounter(timeElapsedDeci/1000);
    }

    public void progress()
    {
        if (Crab.wormsEaten == wormAmount)  {
            List lobsterList = getObjects(Lobster.class);
            removeObjects(lobsterList);
            nextLevel();
            Lobster.delayTimer.mark();
            Crab.wormsEaten = 0;
            PopUp levelPopUp = new PopUp("nextLevel", levelValue);
            addObject(levelPopUp, getWidth()/2, getHeight()/2);
            Greenfoot.delay(50);
            removeObject(levelPopUp);

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
        addObject(scoreCount, getWidth()/2, 20);
    }
    
    public void spawnLivesCounter()
    {
        // crab.crabLives = livesValue;
        addObject(livesCount, getWidth() - 60, 20);
    }
    
    public void spawnTimerCounter()
    {
        addObject(timerCount, 80, 20);
    }

    public void spawnLevelCounter()
    {
        addObject(levelCount, 55, 50);
    }
    
    public void changeScoreCounter(int value)
    {
        scoreValue += value;
    }

    public void decreaseLivesCounter()
    {
        livesValue--;
    }


    /**
     * Basic level system. First first 6 (+ Start) levels are created by hand.
     * After that it continues forever..
     */
    public void nextLevel()
    {   
        if (levelValue == 0) {
            wormAmount = 3;
            spawnWorms(wormAmount);
            spawnLobsters(2);
            levelValue++;    
        }
        else if (levelValue == 1) {
            wormAmount = 4;
            spawnWorms(wormAmount);
            spawnLobsters(2);
            levelValue++;    
        }
        else if (levelValue == 2)    {
            wormAmount = 5;
            spawnWorms(wormAmount);
            spawnLobsters(3);
            levelValue++;
        }
        else if (levelValue == 3)    {
            wormAmount = 6;
            spawnWorms(wormAmount);
            spawnLobsters(4);
            levelValue++;
        }
        else if (levelValue == 4)    {
            wormAmount = 6;
            Lobster.speed = 4;
            spawnWorms(wormAmount);
            spawnLobsters(5);
            levelValue++;
        }
        else if (levelValue == 5)    {
            wormAmount = 8;
            Lobster.speed = 5;
            spawnWorms(wormAmount);
            spawnLobsters(7);
            levelValue++;
        }
        else if (levelValue == 6)    {
            wormAmount = 10;
            Lobster.speed = 6;
            spawnWorms(wormAmount);
            spawnLobsters(8);
            levelValue++;
        }
        else if (levelValue >= 7)   {
            wormAmount = (levelValue + 3);
            Lobster.speed = 6;
            spawnWorms(wormAmount);
            spawnLobsters(levelValue + 2);
            levelValue++;
        }
    }


    /**
     * Generates random numbers based on the type of need (input String).
     */
    public static int generator(String input)
    {
        if (input == "Width")   {
            int randomX = (Greenfoot.getRandomNumber(worldWidth)+1);
            return(randomX);
        }
        else if (input == "Height") {
            int randomY = (Greenfoot.getRandomNumber(worldHeight-40)+40);
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


}