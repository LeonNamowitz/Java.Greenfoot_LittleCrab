import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUp extends Actor
{   
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    public PopUp(String type, int value)
    {
        // setImage(new GreenfootImage("", 0, new Color(0, 0, 0, 0), new Color(0, 0, 0, 0)));
        if (type == "lifeLost") {
            lifeLost(value);
        }
        else if (type == "gameOver") {
            gameOver(value);
        }
        else if (type == "nextLevel")   {
            nextLevel(value);
        }
    }

    public void lifeLost(int livesRemaining)
    {
        GreenfootImage lost = new GreenfootImage(livesRemaining + " live(s) remaining", 40, Color.WHITE, Color.BLACK);
        setImage(lost);

    }

    public void nextLevel(int currentLevel)
    {
        GreenfootImage level = new GreenfootImage("Level: " + currentLevel, 40, Color.WHITE, Color.BLACK);
        setImage(level);

    }

    public void gameOver(int score)
    {
        // GreenfootImage end = new GreenfootImage("Score: " + score, 40,  Color.BLACK, new Color(0, 0, 0, 0));
        GreenfootImage end = new GreenfootImage( WIDTH, HEIGHT);

        end.setColor(new Color(255, 255, 255, 128));
        end.fillRect(0, 0, WIDTH, HEIGHT);
        end.setColor(new Color(0, 0, 0, 200));
        end.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        // end.setColor(new Color(0, 0, 0, 255));
        Font font = end.getFont();
        font = font.deriveFont(36);
        end.setFont(font);
        end.setColor(Color.RED);
        end.drawString("GAME OVER", 50, 70);
        end.setColor(Color.WHITE);
        end.drawString("Final Score: " + score, 50, 160);
        end.drawString("Time: " + Counter.returnTime() + " s", 50, 240);

        setImage(end);
    }



}
