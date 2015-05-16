import greenfoot.*;

public class door2 extends object
{
boolean mouseOver = false;
GreenfootSound SFX = new GreenfootSound("sfx/door_knob.mp3"); 
    public void act() 
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/door_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/door.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
         Greenfoot.setWorld(new Laboratory());
        } 
    }    
}
