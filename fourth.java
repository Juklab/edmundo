import greenfoot.*;

public class fourth extends story
{
 GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
public void act()
      {  
       if(Greenfoot.isKeyDown("enter") && getWorld().getObjects(fifth.class).isEmpty() || Greenfoot.mouseClicked(this) && getWorld().getObjects(fifth.class).isEmpty())  
       {  
       SFX2.play();
       getWorld().addObject(new fifth(),550,275);     
       }   
       if(Greenfoot.isKeyDown("escape")) 
       {
       getWorld().removeObjects(getWorld().getObjects(null));
       Greenfoot.setWorld(new console()); 
       }   
    }
}
