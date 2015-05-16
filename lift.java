import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class lift extends object
{
    boolean mouseOver = false;
    pause p = new pause();
    GreenfootSound SFX = new GreenfootSound("sfx/lift_bell.mp3"); 
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/elevator_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/elevator.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
             SFX.play();
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
        p.setPaused(true);
        MouseCursorWhite.setImage(); 
        getWorld().addObject(new generator_map(), 762,476);
        getWorld().addObject(new lab_map(), 475,257);
        getWorld().addObject(new freezer_map(), 520,475);
        getWorld().addObject(new office_map(), 521,352);
        getWorld().addObject(new mainframe_map(), 787,354);
        getWorld().addObject(new lobby_map(), 259,321);
        getWorld().addObject(new map(), 550,275);
        }   
    }   
}

