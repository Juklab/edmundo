import greenfoot.*;

public class lobby_map extends map
{
    boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    public void act()
    {
       setLocation(259,321);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("gui/map/main_lobby_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/map/main_lobby.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
         Greenfoot.setWorld(new Mansion());
        }   
    }   
}