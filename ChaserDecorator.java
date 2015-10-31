import greenfoot.*;

/**
 * Write a description of class ChaserDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChaserDecorator extends Chaser
{
    public Chaser chaser;
    public ChaserDecorator(Chaser chaser) {
        this.chaser = chaser;
    }
    public void draw() {
        chaser.draw();
    }
    public GreenfootImage getImage() {
        return chaser.getImage();
    }
    public void addColor() {
    }
    public void setHp(int hp) {
    }
}
