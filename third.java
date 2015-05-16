import greenfoot.*;

public class third extends story
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
public void act()
      {  
       if(Greenfoot.isKeyDown("enter") && getWorld().getObjects(fourth.class).isEmpty() || Greenfoot.mouseClicked(this) && getWorld().getObjects(fourth.class).isEmpty())  
       {  
           SFX2.play();
           getWorld().addObject(new fourth(),550,275);     
       }   
       if(Greenfoot.isKeyDown("escape")) 
       {
       getWorld().removeObjects(getWorld().getObjects(null));
       Greenfoot.setWorld(new console()); 
       }   
    }
}
