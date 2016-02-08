import greenfoot.*;

public class third extends story
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
public void act()
      {  
       if(Greenfoot.isKeyDown("escape")) 
       {
       getWorld().removeObjects(getWorld().getObjects(null));
       Greenfoot.setWorld(new console()); 
       }   
    }
}
