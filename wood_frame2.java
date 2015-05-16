import greenfoot.*;

public class wood_frame2 extends object
{
    boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/wood_frame.mp3"); 
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/picture_frame2_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/picture_frame2.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this) &&getWorld().getObjects(frame2_zoom.class).isEmpty())  
       {  
            getWorld().addObject(new frame2_zoom(),550,275);     
       }   
    }    
}
