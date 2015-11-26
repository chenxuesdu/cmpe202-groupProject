import greenfoot.*;

/**
 * Write a description of class SetMiddleLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetMiddleLevel extends SetLevel
{

    /**
     * Constructor for objects of class SetMiddleLevel.
     * 
     */
    public SetMiddleLevel()
    {
    }
    
    public void setLevel(int hp, int speed) {
        QActor.setHealthPower(hp);
        QActor.setSpeed(speed);
        Greenfoot.setWorld(new Welt());
    }
}
