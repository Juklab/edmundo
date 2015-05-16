import greenfoot.*;

public class storyboard extends gui
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            SFX.play();
            setImage("gui/console/storyboard_hover.png");  
            mouseOver = true;  
            HandCursorWhite.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/console/storyboard.png");  
             mouseOver = false;  
             MouseCursorWhite.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this) && getWorld().getObjects(first.class).isEmpty()  && getWorld().getObjects(next.class).isEmpty())  
        {  
         SFX2.play();
         getWorld().addObject(new first(),550,275);
         getWorld().addObject(new next(),550,498);
        }
    }  
}
