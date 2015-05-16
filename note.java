import greenfoot.*;

public class note extends object
{
       MouseInfo mouse = Greenfoot.getMouseInfo(); 
       GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
       boolean mouseOver = false;
       private static String code;
       private int randomNum;
    public note() {
    int randomNum = 1 + (int)(Math.random()*3); 
         if(randomNum == 1) { code = "3972"; }
         if(randomNum == 2) { code = "6015"; }
         if(randomNum == 3) { code = "9415"; }
    }
    public void act() {
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/note_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
            SFX.play();
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("objects/note.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
       if (Greenfoot.mouseClicked(this))  
        {  
         getWorld().addObject(new note_show(), 550,275);
       }   
    }
    public static String getcode() {
        return code;
    }
}
