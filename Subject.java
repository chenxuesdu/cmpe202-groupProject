import greenfoot.*;

/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject
{
    public int notifyChasers();
    public void addChaser(Chaser c);
    public void removeChaser(Chaser c);
}
