import greenfoot.*;
public class option extends pause
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    private static boolean fromGame = false;
    public void act()
    {
       setLocation(585, 308);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            SFX.play();
            setImage("gui/pause/options_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/pause/options.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
            SFX2.play();
            Greenfoot.setWorld(new options());
            setTrue();
        }    
    }    
    
    private static void setTrue()
    {
        fromGame = true;
    }
    public boolean checkfromGame()
    {
        return fromGame;
    }
}
