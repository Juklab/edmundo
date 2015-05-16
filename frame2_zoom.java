import greenfoot.*;

public class frame2_zoom extends object
{
    public void act() {
    setLocation(550, 275);
    pause p = new pause();
    if(Greenfoot.isKeyDown("escape")) 
    {
    getWorld().removeObjects(getWorld().getObjects(frame2_zoom.class));
    p.setPaused(false);
    }
    }
}
