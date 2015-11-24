import greenfoot.*;

/**
 * Write a description of class BlueChaserDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueChaserDecorator extends ChaserDecorator
{
    Chaser chaser;
    public BlueChaserDecorator(Chaser chaser) {
        super(chaser);
    }
    public void draw() {
        addColor();
        super.draw();
    }
    public void addColor() {
        super.getImage().setColor(new java.awt.Color(0, 0, 204));
    }  
    public void setHp(int hp) {
        super.setHp(1);
    }
}
