import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class safe_box extends object
{
    boolean mouseOver = false;
    GreenfootSound SafeBoxSFX = new GreenfootSound("sfx/safe_box_hover.mp3"); 
    Lobby lob = new Lobby();
    public void act()
    {
       setLocation(810, 355);
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
             //pass o = (pass) getWorld();
             //new pass("1181", "Safe is Loacked", this); 
             Greenfoot.setWorld(new pass("1181", "Safe is locked, insert the passcode to deactivated security system.", getWorld()));  
       } 

    }   
}

