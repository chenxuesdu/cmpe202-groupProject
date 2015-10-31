import greenfoot.*;

/**
 * Write a description of class GreenChaserDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenChaserDecorator extends ChaserDecorator
{
    Chaser chaser;
    public GreenChaserDecorator(Chaser chaser) {
        super(chaser);
    }
    public void draw() {
        addColor();
        super.draw();
    }
    public void addColor() {
        super.getImage().setColor(new java.awt.Color(0, 255, 0));
    }
    public void setHp(int hp) {
        super.setHp(1);
    }
}
