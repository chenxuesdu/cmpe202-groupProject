import greenfoot.*;

/**
 * Write a description of class RectangleChaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RectangleChaser extends Chaser
{
    /**
     * Act - do whatever the RectangleChaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int hp;
    private int dr;
    private GreenfootImage image;
    public GreenfootImage getImage() {
        return image;
    }
    public RectangleChaser() {
        image = new GreenfootImage(30, 30);
    }
    public int getDr() {
        return dr;
    }
    public void setDr(int dr) {
        this.dr = dr;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void draw() {
    // create image for this actor
        image.fillRect(0, 0, 30, 30);//bodor
        
        image.setColor(new java.awt.Color(224, 240, 255));
        image.fillRect(7, 7, 16, 16);//interior
        setImage(image);
    }
}
