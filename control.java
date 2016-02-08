import greenfoot.*;
public class control extends Actor
{
    private boolean mouseOver = false;
    public void act()
    {
       setLocation(550, 275);
       pause p = new pause();
        if(Greenfoot.isKeyDown("escape")) 
        {
        getWorld().removeObject(this);
        p.setPaused(false);
       }
    }   
}
