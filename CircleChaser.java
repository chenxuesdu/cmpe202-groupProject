import greenfoot.*;

/**
 * Write a description of class CircleChaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleChaser extends Chaser
{
    /**
     * Act - do whatever the CircleChaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int dr;
    private int hp;
    private GreenfootImage image;
    public GreenfootImage getImage() {
        return image;
    }
    public CircleChaser() {
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
        //GreenfootImage image = new GreenfootImage(30, 30);
        image.fillOval(0, 0, 30, 30);
        
        image.fillOval(7, 7, 16, 16);
        setImage(image);
    }
}
