import greenfoot.*;
public class first extends story
{
     GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act()
    {  
       if(Greenfoot.isKeyDown("enter") && getWorld().getObjects(second.class).isEmpty() || Greenfoot.mouseClicked(this) && getWorld().getObjects(second.class).isEmpty())  
       {  
           SFX2.play();
           getWorld().addObject(new second(),550,275);    
       }     
       if(Greenfoot.isKeyDown("escape")) 
       {
       getWorld().removeObjects(getWorld().getObjects(null));
       Greenfoot.setWorld(new console()); 
       }   
    }
}
