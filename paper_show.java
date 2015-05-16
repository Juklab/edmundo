import greenfoot.*;

public class paper_show extends object
{
    public void act() {
    setLocation(550, 275);
    pause p = new pause();
    if(Greenfoot.isKeyDown("escape")) 
    {
    getWorld().removeObjects(getWorld().getObjects(paper_show.class));
    p.setPaused(false);
    }
    }
}
