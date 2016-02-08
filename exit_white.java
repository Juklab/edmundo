import greenfoot.*;
public class exit_white extends Actor
{
    boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    option opt = new option();
    private static final int x = 1080; 
    private static final int y = 22;
    public void act()
    {
       setLocation(x, y);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            SFX.play();
            setImage("gui/exit/exithover_white.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/exit/exit_white.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.setWorld(new mainmenu());
        }  
    }   
}
