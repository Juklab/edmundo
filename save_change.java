import greenfoot.*;
public class save_change extends Actor
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act()
    {
       setLocation(160, 460);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            SFX.play();
            setImage("gui/options/save_change_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/options/save_change.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
        if (Greenfoot.mouseClicked(this))  
       {  
            SFX2.play();
            options op = (options) getWorld();
            // write settings value into ini file 
       }
    }    
}