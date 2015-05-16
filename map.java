import greenfoot.*;

public class map extends gui
{
    public void act() {
    setLocation(550, 275);
    pause p = new pause();
    if(Greenfoot.isKeyDown("escape")) 
    {
    //getWorld().removeObject(this);
    getWorld().removeObjects(getWorld().getObjects(map.class));
    p.setPaused(false);
    }
    }
}
