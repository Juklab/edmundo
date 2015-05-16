import greenfoot.*;

public class desktop extends object
{
 public void act() {
    setLocation(550, 275);
    pause p = new pause();
    if(Greenfoot.isKeyDown("escape")) 
    {
    getWorld().removeObjects(getWorld().getObjects(desktop.class));
    p.setPaused(false);
    }
    }
}
