import greenfoot.*;

public class wood_frame1 extends object
{
    boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/wood_frame.mp3"); 
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/picture_frame1_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/picture_frame1.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this) && getWorld().getObjects(frame1_zoom.class).isEmpty() )  
        {  
            getWorld().addObject(new frame1_zoom(),550,275);     
        }   
    }    
}
