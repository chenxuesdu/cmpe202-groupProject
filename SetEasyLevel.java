import greenfoot.*;

/**
 * Write a description of class SetEasyLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetEasyLevel extends SetLevel
{

    /**
     * Constructor for objects of class SetEasyLevel.
     * 
     */
    public SetEasyLevel()
    {
    }
    
    public void setLevel(int hp, int speed) {
        QActor.setHealthPower(hp);
        QActor.setSpeed(speed);
        Greenfoot.setWorld(new Welt());
    }
}
