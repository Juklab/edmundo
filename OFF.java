import greenfoot.*;
public class OFF extends music
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act() 
    {
    MouseInfo mouse = Greenfoot.getMouseInfo();    
    if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("gui/options/speaker/mute_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
    if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/options/speaker/mute.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
    if(Greenfoot.mouseClicked(this))
        {
            SFX2.play();
            setImageON();
            startBGM();
        }
    }
}
