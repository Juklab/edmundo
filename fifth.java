import greenfoot.*;

public class fifth extends story
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
public void act()
      {  
       if(Greenfoot.isKeyDown("enter") || Greenfoot.mouseClicked(this))  
       {  
       SFX2.play();
       getWorld().removeObjects(getWorld().getObjects(null));
       Greenfoot.setWorld(new console()); 
       }   
       if(Greenfoot.isKeyDown("escape")) 
       {
       getWorld().removeObjects(getWorld().getObjects(null));
       Greenfoot.setWorld(new console()); 
       }   
    }
}
