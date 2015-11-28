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
        image = new GreenfootImage(50, 50);
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
    
    State small = new StateSmall();
    State medium = new StateMedium();
    State large = new StateLarge();
    State currentState = large;
    String size = currentState.setImage();
    
    public void setCurrentState(){
        //UserInfo me = UserInfo.getMyInfo();
        //Welt welt = (Welt)getWorld().getObjects(Welt.class).get(0);
        //if (getWorld()==null)
        //{System.out.println("world is null");}
        //else{
        int count = ((Welt)getWorld()).getScore();
        if (count<50){
            this.currentState = large;
            this.size = currentState.setImage();
        }
        else if (count>=50&&count<100){
            this.currentState = medium;
            this.size = currentState.setImage();
        }
        else if (count>=100){
            this.currentState = small;
            this.size = currentState.setImage();
        }
    //}
    }
    
    public void setChaserImage(){
        if(size.equals("large"))
        {
            //image.fillOval(0, 0, 30, 30);
            image.fillOval(0, 0, 50, 50);
            image.setColor(new java.awt.Color(224, 240, 255));
            image.fillOval(12, 12, 27, 27);
            setImage(image);
           // image.fillOval(0, 0, 16, 16);
            //setImage(image);
        }
        
        if(size.equals("medium"))
        {
            //image.fillOval(0, 0, 30, 30);
            image.fillOval(0, 0, 40, 40);
            image.setColor(new java.awt.Color(224, 240, 255));
            image.fillOval(10, 10, 20, 20);
            setImage(image);
        }
        if(size.equals("small"))
        {
            //image.fillOval(0, 0, 30, 30);
            image.fillOval(0, 0, 30, 30);
            image.setColor(new java.awt.Color(224, 240, 255));
            image.fillOval(7, 7, 16, 16);
            setImage(image);
        }
    }
    
    public void draw() {
    // create image for this actor
        //GreenfootImage image = new GreenfootImage(30, 30);
        setCurrentState();
        setChaserImage();
      // image.fillOval(0, 0, 30, 30);
       // image.setColor(new java.awt.Color(224, 240, 255));
       // image.fillOval(7, 7, 16, 16);
      //  setImage(image);
    }
}
