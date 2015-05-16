import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class key extends object
{
 MouseInfo mouse = Greenfoot.getMouseInfo(); 
 GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
 boolean mouseOver = false;
 public void act() {
 if (!mouseOver && Greenfoot.mouseMoved(this))  
 {  
      setImage("objects/key_hover.png");  
      mouseOver = true;  
      HandCursor.setImage(); 
      SFX.play();
  }  
 if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
 {  
      setImage("objects/key.png");  
      mouseOver = false;  
      MouseCursor.setImage(); 
 } 
 if (Greenfoot.mouseClicked(this))  
 {  
    // open inventory and add to it 
 }   
 }
}
