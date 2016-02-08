import greenfoot.*;
import java.awt.Desktop;
import java.net.URL;
import java.net.URI;
public class juklab extends Actor
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act()
    {
       setLocation(325, 517);
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            SFX.play();
            setImage("gui/mainmenu/juklabdotcom_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/mainmenu/juklabdotcom.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
        SFX2.play();
        try 
        {
            Desktop.getDesktop().browse(new URL("https://github.com/Juklabs").toURI());
        }           
        catch (Exception e) {
            e.printStackTrace();
        }
        }   
    }   
}
