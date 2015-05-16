import greenfoot.*;

public class frame1_zoom extends object
{
    public void act() {
    setLocation(550, 275);
    pause p = new pause();
    if(Greenfoot.isKeyDown("escape")) 
    {
    getWorld().removeObjects(getWorld().getObjects(frame1_zoom.class));
    p.setPaused(false);
    }
    }  
}
