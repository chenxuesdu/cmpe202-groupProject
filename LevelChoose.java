import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class LevelChoose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelChoose extends World
{
    Actor btnEasy, btnMid, btnHard;
    Actor mouseButton;
    /**
     * Constructor for objects of class LevelChoose.
     * 
     */
    public LevelChoose()
    {    
        super(500, 500, 1); 
        GreenfootImage bg = getBackground();
        bg.setColor(Color.gray);
        bg.fill(); // fills the background with gray for frame
        bg.setColor(new Color(208, 208, 208));
        bg.fillRect(10, 10, getWidth()-20, getHeight()-20); // fills main area with a lighter gray
        GreenfootImage selection = new GreenfootImage("Please choose level", 36, Color.blue, new Color(0,0,0,0));
        bg.drawImage(selection, getWidth()/2 - selection.getWidth()/2, selection.getHeight()*2);
        // Add button to this world
        addObject(btnEasy = getNewButton("Easy"), 240, 200);
        addObject(btnMid = getNewButton("Middle"), 240, 250);
        addObject(btnHard = getNewButton("Hard"), 240, 300);
    }
    
    public void act() {
        // Listen to the mouse click, choose different Welt instance to set up
        if(Greenfoot.mouseClicked(btnEasy)) {
            int hp = 1, speed = 3;
            SetEasyLevel easyLevel = new SetEasyLevel();
            easyLevel.setLevel(hp, speed);
        }else if(Greenfoot.mouseClicked(btnMid)) {
            int hp = 2, speed = 5;
            SetMiddleLevel midLevel = new SetMiddleLevel();
            midLevel.setLevel(hp, speed);
        }else if(Greenfoot.mouseClicked(btnHard)) {
            int hp = 3, speed = 7;
            SetHardLevel hardLevel = new SetHardLevel();
            hardLevel.setLevel(hp, speed);
        }
        
    }
    
    
    private Actor getNewButton(String caption)
    {
        // create the image for the actor not yet created
        GreenfootImage base = new GreenfootImage(100, 30); // create the base image for the button
        base.fill(); // fill with black (default drawing color) to be used for the frame
        base.setColor(new java.awt.Color(192, 192, 255)); // set drawing color to a light blue
        base.fillRect(3, 3, 94, 24); // fill background of button leaving the outer frame
        GreenfootImage text = new GreenfootImage(caption, 24, java.awt.Color.black, null); // create text image
        base.drawImage(text, 50-text.getWidth()/2, 15-text.getHeight()/2); // draw text image onto base image
        base.setTransparency(160); // adjust the intensity of the image to 'mouse not over' state
        Actor button = new Actor() // create the Actor
        {
            /**
             * Method act (for button Actor): changes intensity of image for mouse hovering action
             */
            public void act()
            {
                if (getImage().getTransparency() < 100) return;
                // gaining mouse hover
                if (mouseButton == null && Greenfoot.mouseMoved(this))
                {
                    mouseButton = this;
                    getImage().setTransparency(255);
                }
                // losing mouse hover
                if (mouseButton == this && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
                {
                    mouseButton = null;
                    getImage().setTransparency(160);
                }
            }
        };
        button.setImage(base); // give button its image
        return button; // return the button Actor object
    }
}
