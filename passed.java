import greenfoot.*;

public class passed extends gui
{
 GreenfootSound passSFX = new GreenfootSound("sfx/fanfare.mp3");
 pause p = new pause();
    public void act() {
    setLocation(550, 275);
    passSFX.play();
    Greenfoot.delay(500);
    getWorld().removeObjects(getWorld().getObjects(null));
    Greenfoot.setWorld(new mainmenu()); 
}
}