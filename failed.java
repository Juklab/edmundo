import greenfoot.*;

public class failed extends gui
{
   boolean mouseOver = false;
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       setLocation(550, 275);
       MouseCursor.setImage(); 
       if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("enter"))  
       {  
         Greenfoot.setWorld(new console());
       }   
    }  
}

