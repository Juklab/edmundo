import greenfoot.*;
public class out extends pause
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act()
    {
       setLocation(585, 434);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            SFX.play();
            setImage("gui/pause/exit_game_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/pause/exit_game.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
            SFX2.play();
            getWorld().removeObjects(getWorld().getObjects(null)); 
            Greenfoot.stop();
        }   
    }    
}
