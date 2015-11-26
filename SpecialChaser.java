import greenfoot.*;

/**
 * Write a description of class SpecialChaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialChaser extends Chaser
{
    private int dr;
    private int hp;
    private GreenfootImage image;
    public GreenfootImage getImage() {
        return image;
    }
    public SpecialChaser() {
        image = new GreenfootImage("mars.png");
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
        //image.setColor(new java.awt.Color(0, 0, 0));
        //image.fillOval(0, 0, 30, 30);
        //image.setColor(new java.awt.Color(224, 240, 255));
        //image.fillOval(7, 7, 16, 16);
        //setImage("specialBall.png");
        setImage(image);
    } 
}
