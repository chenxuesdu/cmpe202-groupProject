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
                image.fillRect(0, 0, 50, 50);//bodor
                image.setColor(new java.awt.Color(224, 240, 255));
                image.fillRect(12, 12, 27, 27);//interior
                setImage(image);
          //  image.fillRect(0, 0, 16, 16);
           // setImage(image);
        }
        
        if(size.equals("medium"))
        {
            //image.fillOval(0, 0, 30, 30);
           // image.fillRect(0, 0, 32, 32)
                image.fillRect(0, 0, 40, 40);//bodor
                image.setColor(new java.awt.Color(224, 240, 255));
                image.fillRect(10, 10, 20, 20);//interior
                setImage(image);
            
          //  setImage(image);
        }
        if(size.equals("small"))
        {
            //image.fillOval(0, 0, 30, 30);
                image.fillRect(0, 0, 30, 30);//bodor
                image.setColor(new java.awt.Color(224, 240, 255));
                image.fillRect(7, 7, 16, 16);//interior
                setImage(image);
          //  image.fillRect(0, 0, 8, 8);
          //  setImage(image);
        }
    }
    
    
    public void draw() {
    // create image for this actor
        setCurrentState();
        setChaserImage();
     //   image.fillRect(0, 0, 30, 30);//bodor
     //   image.setColor(new java.awt.Color(224, 240, 255));
     //   image.fillRect(7, 7, 16, 16);//interior
      //  setImage(image);
    }
}
