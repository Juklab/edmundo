import greenfoot.*;

public class no_key extends Actor
{
    pause p = new pause();
    public void act() 
    {
    setLocation(550, 275);
    if(Greenfoot.isKeyDown("escape")) 
    {
    getWorld().removeObjects(getWorld().getObjects(no_key.class));
    p.setPaused(false);
    }
    }    
}


