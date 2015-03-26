import greenfoot.*;
public class ON extends music
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act() 
    {
    MouseInfo mouse = Greenfoot.getMouseInfo();    
    if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("gui/options/speaker/notmute_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
    if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/options/speaker/notmute.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
    if(Greenfoot.mouseClicked(this) )
        {
            SFX2.play();
            setImageOFF();
            stopBGM();
        }
    } 
}
