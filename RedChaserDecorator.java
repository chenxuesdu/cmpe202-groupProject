import greenfoot.*;

/**
 * Write a description of class RedChaserDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedChaserDecorator extends ChaserDecorator
{
    /**
     * Act - do whatever the RedChaserDecorator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Chaser chaser;
    public RedChaserDecorator(Chaser chaser) {
        super(chaser);
    }
    public void draw() {
        addColor();
        super.draw();
    }
    public void addColor() {
        super.getImage().setColor(new java.awt.Color(255, 51, 0));
    }
    public void setHp(int hp) {
        super.setHp(2);
    }
}
