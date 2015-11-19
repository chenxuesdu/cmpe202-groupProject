import greenfoot.*;

/**
 * Write a description of class GunDec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunDec extends Weapon
{
    /**
     * Act - do whatever the GunDec wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected Weapon gun;
    public GunDec(Weapon gun) {
        this.gun = gun;
    } 
    
    public void updateGun() 
    {
        gun.updateGun();
    }
}
