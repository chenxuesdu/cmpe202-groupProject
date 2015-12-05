import greenfoot.*;

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends QActor
{
     /**
     * sets bounds fields and creates the image for this actor
     */
    private int RotationDegree;
    private Weapon gun;
    public Shot(int degree, Weapon gun)
    {
        this.gun = gun;
        this.RotationDegree = degree;
        setBoundedAction(QActor.REMOVE, 5); // set bounds fields
        // create image for this actor
        GreenfootImage image = new GreenfootImage(10, 8);
        image.setColor(java.awt.Color.white);
        image.fill();
        setImage(image);
    }
    
    /**
     * initializes rotation and position of actor
     *
     * @param world the world this actor was added into
     */
    public void addedToWorld(World world)
    {
         setRotation(gun.getRotation() + RotationDegree); // set rotation (to that of gun)
         move(gun.getImage().getWidth()/2); // set position (at end of gun)
    }
    
    /**
     * moves actor and checks for removal of actor
     */
    public void act()
    {
        setVX(0);
        setVY(0);
        addForce(500, getRotation()*QVAL);
        move(); // moving (equivalent to 'move(5)' for a non-QActor)
        try {
            if (hits(Chaser.class) || atWorldEdge())
                getWorld().removeObject(this); // removing
        } catch (IllegalStateException e) {
            
        }
    }
    
    /**
     * internal method to detect object collision; returns true if collision detected, else false
     *
     * @param cls the class of object to check for collision with
     * @return a flag indicating whether an object of given class was detected or not
     */
//     private boolean hits(Class cls)
//     {
//         // get intersecting object and return result
//         Actor clsActor = getOneIntersectingObject(cls);
//         if (clsActor != null)
//         {
//             // remove intersector and bump score
//             getWorld().removeObject(clsActor);
//             ((Welt)getWorld()).adjustScore(1);
//             return true; 
//         }
//         return false;
//     }
    private boolean hits(Class cls)
    {
        // get intersecting object and return result
        try{
            Actor clsActor = getOneIntersectingObject(cls);
            if(clsActor != null){
                if (clsActor.getClass().getName() == "SpecialChaser"){
                    int count = ((Welt)getWorld()).notifyChasers();
                    ((Welt)getWorld()).adjustScore(count);
                    return true;
                }
                // remove intersector and bump score
                getWorld().removeObject(clsActor);
                ((Welt)getWorld()).removeChaser((Chaser)clsActor);
                ((Welt)getWorld()).adjustScore(1);
                return true; 
            }
            return false;
        }catch (IllegalStateException e) {
                    
        }
        return false;
    }
    
    /**
     * internal method that returns a flag indicating world edge encroachment
     *
     * @return a flag indicating whether the actor has encroached on a world edge or not
     */
    private boolean atWorldEdge()
    {
        // return state of encroachment on world edge
        return getX() <= 0 || getY() <= 0 ||
            getX() >= getWorld().getWidth()-1 ||
            getY() >= getWorld().getHeight()-1;
    }  
}
