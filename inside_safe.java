import greenfoot.*;

public class inside_safe extends object
{
    public void act() {
    setLocation(550, 275);
    pause p = new pause();
    if(Greenfoot.isKeyDown("escape")) 
    {
    getWorld().removeObjects(getWorld().getObjects(inside_safe.class));
    p.setPaused(false);
    }
    Greenfoot.delay(300);
    getWorld().removeObjects(getWorld().getObjects(null));
    Greenfoot.setWorld(new Office()); 
    }
}
