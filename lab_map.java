import greenfoot.*;

public class lab_map extends map
{
    boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    public void act()
    {
       setLocation(475,257);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("gui/map/laboratory_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/map/laboratory.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
         Greenfoot.setWorld(new Laboratory());
        }   
}
}