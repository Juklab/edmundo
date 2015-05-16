import greenfoot.*;

public class switch_server extends object
{
    private boolean timeFlow;
    private int number = 0;
    protected boolean pass;
    private int timer;
    private boolean mouseOver = false;
    private boolean isanimate = true;
    private int delay = 0;

    pause pa = new pause();
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3"); 
    private String[] blink = {"objects/switch.png","objects/switch_hover.png"};
public void act() 
    {
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("objects/switch_hover.png");  
            mouseOver = true;  
            HandCursor.setImage(); 
            SFX.play();
       }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
       {  
             setImage("objects/switch.png");  
             mouseOver = false;  
             MouseCursor.setImage(); 
       } 
       if (Greenfoot.mouseClicked(this) && getWorld().getObjects(insert.class).isEmpty())  
       {  
            getWorld().addObject(new insert(),550,275);     
            pa.setPaused(true); 
       } 
       else {
        isanimate = true;
        delay = 25;
       }    
       animate(isanimate, delay, blink); 
       MouseInfo mouse = Greenfoot.getMouseInfo();    
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



