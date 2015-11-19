import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class ConcreteDecoratorA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteDecoratorA extends GunDec
{
    /**
     * Act - do whatever the ConcreteDecoratorA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ConcreteDecoratorA(Weapon gun) {
        super(gun);
        GreenfootImage image = new GreenfootImage(50, 10);
        image.setColor(Color.black);
        for (int i=0; i<4; i++) image.fillRect(20, i, 9+i*4, 10-i*2);
        setImage(image);
    } 
    
    public void updateGun() 
    {
        super.updateGun();
        addPower();
    }
    
    public void addPower() {
        getWorld().addObject(new Shot(22, gun), getX(), getY());
        getWorld().addObject(new Shot(-22, gun), getX(), getY());
    }
    
    public void act() {
        if (Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) turnTowards(mouse.getX(), mouse.getY());
        }
    }
}
