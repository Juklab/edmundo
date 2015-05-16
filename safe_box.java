import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class safe_box extends object
{
    boolean mouseOver = false;
    GreenfootSound SafeBoxSFX = new GreenfootSound("sfx/safe_box_hover.mp3"); 
    Mansion man = new Mansion();
    note n = new note();
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/safe_box_hover.png");  
            mouseOver = true;  
            SafeBoxSFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/safe_box.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         }   
       if (Greenfoot.mouseClicked(this))  
       {  
           Greenfoot.setWorld(new pass("3972", "Safe is locked, insert the passcode to deactivated security system.", getWorld()));
       } 
    }   
}

