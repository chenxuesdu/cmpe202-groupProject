import greenfoot.*;
import java.awt.*;
import java.util.List;
/**
 * Write a description of class StateLarge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StateLarge implements State
{
    /**
     * Act - do whatever the StateSmall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String setImage(){
        String size = "large";
        return size;
    }
}