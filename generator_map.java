import greenfoot.*;

public class generator_map extends map
{
    boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    public void act()
    {
       setLocation(762,476);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("gui/map/generator_room_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/map/generator_room.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  

        }   
    }
    }