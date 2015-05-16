import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class labtop extends object
{
    boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/typing.mp3"); 
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/macbook/labtop_hover.png");  
            mouseOver = true;  
            SFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/macbook/labtop.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
            getWorld().addObject(new desktop(), 550,275);
        }   
    }   
}

