import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

public class Welt extends World implements Subject
{
    GreenfootSound myMusic = new GreenfootSound("starwar.mp3");
    public static int actionType, actionDistance; // the world bounds action fields for the chasers
    public static Chased chased; // the player
    
    public int score; // the score
    //add subjcet list by chenjie
    public ArrayList<Chaser> chasers = new ArrayList<Chaser>();
    private int specialChaserTimes = 0;
    
    public Welt()
    {
        super(800, 600, 1, false);
        Greenfoot.setSpeed(60);
        setBackground(new GreenfootImage("space.jpg"));
        // create background texts
        GreenfootImage bg = getBackground();
        bg.setFont(new Font("SERIF", Font.BOLD, 28));
        bg.setColor(Color.gray);
        bg.drawString("Score:", 600, 40);
        adjustScore(0);
        bg.setColor(Color.gray);
        bg.setFont(new Font("SERIF", Font.BOLD, 20));
        chased = new Chased();
        setAction(0);   
    }
    
    public void act()
    {
        myMusic.play();
        //System.out.println("Start-----------");
        // changing edge action
        String key = Greenfoot.getKey();
        if (key != null)
        {
            if ("e".equals(key)) setAction(actionType+1);
            if ("q".equals(key)) Greenfoot.setWorld(new TextFileViewer("QActor.txt", this));
        }
        // adding chasers to world
        // if (chased.getWorld() == null) return;
        if (numberOfObjects() >= 20+score/10) return;
        if (Greenfoot.getRandomNumber(1000) > 30+score/10) return;
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        int rand = Greenfoot.getRandomNumber(4);
        if (rand < 2) x = (getWidth()-3+actionDistance*2)*rand+1-actionDistance;
        else y = (getHeight()-3+actionDistance*2)*(rand-2)+1-actionDistance;
        // if (Math.abs(x-chased.getX())+Math.abs(y-chased.getY()) < 200) return;
        Chaser chaser = new Chaser();
        
        int random = Greenfoot.getRandomNumber(2);
        switch(random) {
            case 0: chaser = new RectangleChaser(); break;
            case 1: chaser = new CircleChaser(); break;
        }
        //System.out.println("Random is " + random);
        ChaserDecorator  decorator = new ChaserDecorator(chaser);
        random = Greenfoot.getRandomNumber(3);
        switch(random) {
            case 0: decorator = new RedChaserDecorator(chaser); break;
            case 1: decorator = new BlueChaserDecorator(chaser); break;
            case 2: decorator = new GreenChaserDecorator(chaser); break;
        }
        addObject(chaser, x, y);
        decorator.draw();
        //by chenjie
        if(specialChaserTimes > 10) {
            chaser = new SpecialChaser();
            specialChaserTimes = 0;
        }
        
        addObject(chaser, x, y);
        chaser.turnTowards(400, 300);
        //by chenjie
        this.chasers.add(chaser);
        //System.out.println("nd----------");
    }
    
    public void getActorCounts()
    {
        java.util.List<Object> objects = getObjects(null);
        int n = 0;
        while (!objects.isEmpty())
        {
            String name = objects.get(n).getClass().getName();
            int count = 1;
            int index = 1;
            while (index < objects.size())
            {
                if (name.equals(objects.get(index).getClass().getName()))
                {
                    count++;
                    objects.remove(index);
                }
                else index++;
            }
            System.out.println(name+": "+count);
            objects.remove(0);
        }
    }
    
    private void setAction(int action)
    {
        notifyChasers();
        //removeObjects(getObjects(Chaser.class)); // remove old chasers
        actionType = action%5; // set bound action
        int[] distances = { 0, 0, -10, 0, -15 }; // bound ranges
        actionDistance = distances[actionType]; // the range for this action
        String[] texts = { "UNBOUND", "LIMIT", "REMOVAL", "WRAPPING", "BOUNCE" }; // the bounds text
        // adjust bounds display
        GreenfootImage bg = getBackground();
        /*bg.setColor(Color.white);
        bg.fillRect(200, 15, 110, 32);
        bg.setFont(new Font("SERIF", Font.BOLD, 20));
        bg.setColor(Color.black);
        bg.drawString(texts[actionType], 200, 44);*/
        // reset score
        score = 0;
        // ensure player is in world
        if (chased.getWorld() == null) addObject(chased, 400, 300);
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void adjustScore(int adjustment)
    {
        score += adjustment; // adjust score
        specialChaserTimes += adjustment;
        // adjust score display
        GreenfootImage bg = getBackground();
        bg.setColor(Color.white);
        bg.fillRect(684, 15, 100, 30);
        bg.setColor(Color.black);
        bg.setFont(new Font("SERIF", Font.BOLD, 28));
        bg.setColor(Color.black);
        bg.drawString(""+score, 684, 40);
    }

    //by chenjie
    public int notifyChasers(){
        int count = 0;
        for (Chaser c : this.chasers){
            c.remove();
            count++;
        }
        this.chasers = new ArrayList<Chaser>();
        return count;  
    }
    public void addChaser(Chaser c){
        this.chasers.add(c);
    }
    public void removeChaser(Chaser c){
        this.chasers.remove(c);
    }
}