import greenfoot.*;
import java.awt.Color;

/**
 * Class Chased (subclass of Actor): a user-controlled object with a mouse-controlled gun
 */
public class Chased extends Actor
{
   // Gun gun = new Gun(); // the gun for this actor
    Weapon gun = new Gun();
    /**
     * creates image for actor
     */
    public Chased()
    {
        // the image for this actor
        GreenfootImage image = new GreenfootImage(50, 50);
        image.fillOval(0, 0, 50, 50);
        image.setColor(Color.green);
        image.fillOval(7, 7, 36, 36);
        setImage(image);
    }
    
    /**
     * adds the gun for this actor into the world
     *
     * @param world the world this actor was added into
     */
    public void addedToWorld(World world)
    {
        world.addObject(gun, getX(), getY()); // add the gun belonging to this actor into the world
    }

    /**
     * move user-controlled actor and its gun; also, check for game over
     */
    public void act()
    {
        // user-controlled movement
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("a")) dx--;
        if (Greenfoot.isKeyDown("d")) dx++;
        if (Greenfoot.isKeyDown("w")) dy--;
        if (Greenfoot.isKeyDown("s")) dy++;
        setLocation(getX()+3*dx, getY()+3*dy);
        // limit to world bounds
        if (getX() < 25) setLocation(25, getY());
        if (getY() < 25) setLocation(getX(), 25);
        if (getX() > getWorld().getWidth()-25) setLocation(getWorld().getWidth()-25, getY());
        if (getY() > getWorld().getHeight()-25) setLocation(getX(), getWorld().getHeight()-25);
        // position gun
        gun.setLocation(getX(), getY());
        // check game over
        if (!getObjectsInRange(40, Chaser.class).isEmpty())
        {
            World world = getWorld();
            world.removeObjects(world.getObjects(null));
            if (UserInfo.isStorageAvailable())
                Greenfoot.setWorld(new Stats(((Welt)world).score));
            else
                Greenfoot.stop();
        }
    }
}