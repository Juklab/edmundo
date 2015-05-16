import greenfoot.*;

public class paper extends object
{
boolean mouseOver = false;
MouseInfo mouse = Greenfoot.getMouseInfo(); 
GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
GreenfootSound SFX2 = new GreenfootSound("sfx/paper_scram.mp3");
public void act() 
    {
 
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/paper_ball_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
            SFX.play();
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/paper_ball.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
         SFX2.play();
         getWorld().addObject(new paper_show(), 550,275);
        } 
    }    
}
