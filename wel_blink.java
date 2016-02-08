import greenfoot.*;
public class wel_blink extends Actor
{
    private String[] blink = {"gui/welcome/1.png","gui/welcome/2.png"};
    private boolean timeFlow;
    private int number = 0;
    protected boolean pass;
    private int timer;
    private boolean mouseOver = false;
    private boolean isanimate = true;
    private int delay = 0;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    music m = new music();
    public void act() 
    {
    animate(isanimate, delay, blink); 
    setLocation(552, 473);
    MouseInfo mouse = Greenfoot.getMouseInfo();    
    if (!mouseOver && Greenfoot.mouseMoved(this))  
    {  
    setImage("gui/welcome/1.png");  
    mouseOver = true;  
    SFX.play();
    HandCursor.setImage(); 
    }  
    if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))  
    {  
    setImage("gui/welcome/2.png");  
    mouseOver = false;  
    MouseCursor.setImage(); 
    } 
    if (Greenfoot.mouseClicked(this))  
    {  
        SFX2.play();
        Greenfoot.setWorld(new mainmenu());
        m.startBGM();
    }
    else {
    isanimate = true;
    delay = 30;
    }    
}
public void timeter(int time){
        pass = false;
        timer++;
        if(timer<time) return;
        pass = true;
        timer= 0;
}
public void animate(boolean loop,int timedelay,String[] picture){
      timeter(timedelay);
      if(pass==true){
            setImage(picture[number]);
            number++;
            if(loop==true && number >= picture.length){
                number=0;
            } else if(loop==false && number >= picture.length){
                getWorld().removeObject(this);
            }
        }
    }  
}
