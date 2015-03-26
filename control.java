import greenfoot.*;
public class control extends gui
{
    private boolean mouseOver = false;
    public void act()
    {
       setLocation(550, 275);
        if(Greenfoot.isKeyDown("escape")) 
        {
        getWorld().removeObject(this);
       }
    }   
}
