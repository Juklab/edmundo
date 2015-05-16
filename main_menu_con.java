import greenfoot.*;

public class main_menu_con extends gui
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
            setImage("gui/console/main_menu_console_hover.png");  
            mouseOver = true;  
            HandCursorWhite.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/console/main_menu_console.png");  
             mouseOver = false;  
             MouseCursorWhite.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
         SFX2.play();
         getWorld().removeObjects(getWorld().getObjects(null));
         Greenfoot.setWorld(new mainmenu());
        }
    }
}
        
