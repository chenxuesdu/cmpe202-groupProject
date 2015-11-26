import greenfoot.*;

/**
 * Write a description of class SetHardLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetHardLevel extends SetLevel
{

    /**
     * Constructor for objects of class SetHardLevel.
     * 
     */
    public SetHardLevel()
    {
    }
    
    public void setLevel(int hp, int speed) {
        QActor.setHealthPower(hp);
        QActor.setSpeed(speed);
        Greenfoot.setWorld(new Welt());
    }
}
