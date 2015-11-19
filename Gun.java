import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Weapon
{
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
     * Class: Gun (subclass of Actor -- inner class of Chased): the gun for this actor
     */
    private GunDec decGun1;
    private GunDec decGun2;
    /**
     * creates image for actor
     */
    public Gun()
    {
        // the image for this actor
        decGun1 = new ConcreteDecoratorA(Gun.this);
        decGun2 = new ConcreteDecoratorB(decGun1);
        GreenfootImage image = new GreenfootImage(50, 10);
        image.setColor(Color.black);
        for (int i=0; i<4; i++) image.fillRect(20, i, 9+i*4, 10-i*2);
        setImage(image);
    }
    
    public void addedToWorld(World world) {
        world.addObject(decGun1, getX(), getY());
        world.addObject(decGun2, getX(), getY());
    }
        
    /**
     * responds to mouse movement and mouse button clicks
     */
    public void act()
    {
        // turn towards mouse when mouse moves
        if (Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) turnTowards(mouse.getX(), mouse.getY());
        }
        decGun1.setLocation(getX(), getY());
        decGun2.setLocation(getX(), getY());
        // detect mouse clicks to fire shot
        if (Greenfoot.mouseClicked(null)) {
            int curScore = ((Welt)getWorld()).score;
            if (curScore < 10) {
                updateGun();
            } else if (curScore < 50) {
                decGun1.updateGun();
            } else {
                decGun2.updateGun();
            } 
        }
    }
    
    /**
     * overwrite updateGun() method
     */
    public void updateGun(){
        getWorld().addObject(new Shot(0, Gun.this), getX(), getY());
    }
    
    public void morePower() {
        getWorld().addObject(new Shot(0, Gun.this), getX(), getY());
        getWorld().addObject(new Shot(22, Gun.this), getX(), getY());
        getWorld().addObject(new Shot(-22, Gun.this), getX(), getY());
    }
    
    public void mostPower() {
        getWorld().addObject(new Shot(0, Gun.this), getX(), getY());
        getWorld().addObject(new Shot(22, Gun.this), getX(), getY());
        getWorld().addObject(new Shot(-22, Gun.this), getX(), getY());
        getWorld().addObject(new Shot(45, Gun.this), getX(), getY());
        getWorld().addObject(new Shot(-45, Gun.this), getX(), getY());
    }
    
    /**
     * Class Shot (subclass of QActor -- inner class of Chased.Gun): the shots from this gun
     */
//     private class Shot extends QActor
//     {
//         /**
//          * sets bounds fields and creates the image for this actor
//          */
//         private int RotationDegree;
//         public Shot(int degree)
//         {
//             this.RotationDegree = degree;
//             setBoundedAction(QActor.REMOVE, 5); // set bounds fields
//             // create image for this actor
//             GreenfootImage image = new GreenfootImage(5, 2);
//             image.fill();
//             setImage(image);
//         }
//         
//         /**
//          * initializes rotation and position of actor
//          *
//          * @param world the world this actor was added into
//          */
//         public void addedToWorld(World world)
//         {
//              setRotation(Gun.this.getRotation() + RotationDegree); // set rotation (to that of gun)
//              move(Gun.this.getImage().getWidth()/2); // set position (at end of gun)
//         }
//         
//         /**
//          * moves actor and checks for removal of actor
//          */
//         public void act()
//         {
//             setVX(0);
//             setVY(0);
//             addForce(500, getRotation()*QVAL);
//             move(); // moving (equivalent to 'move(5)' for a non-QActor)
//             if (hits(Chaser.class) || atWorldEdge()) getWorld().removeObject(this); // removing
//         }
//         
//         /**
//          * internal method to detect object collision; returns true if collision detected, else false
//          *
//          * @param cls the class of object to check for collision with
//          * @return a flag indicating whether an object of given class was detected or not
//          */
//         private boolean hits(Class cls)
//         {
//             // get intersecting object and return result
//             Actor clsActor = getOneIntersectingObject(cls);
//             if (clsActor != null)
//             {
//                 // remove intersector and bump score
//                 getWorld().removeObject(clsActor);
//                 ((Welt)getWorld()).adjustScore(1);
//                 return true; 
//             }
//             return false;
//         }
//         
//         /**
//          * internal method that returns a flag indicating world edge encroachment
//          *
//          * @return a flag indicating whether the actor has encroached on a world edge or not
//          */
//         private boolean atWorldEdge()
//         {
//             // return state of encroachment on world edge
//             return getX() <= 0 || getY() <= 0 ||
//                 getX() >= getWorld().getWidth()-1 ||
//                 getY() >= getWorld().getHeight()-1;
//         }
//     }
}
