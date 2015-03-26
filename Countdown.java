import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Countdown extends Actor
    {
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    private GreenfootImage three  = new GreenfootImage("gui/countdown/3.png");
    private GreenfootImage two  = new GreenfootImage("gui/countdown/2.png");
    private GreenfootImage one  = new GreenfootImage("gui/countdown/1.png");
    private GreenfootImage GO    = new GreenfootImage("gui/countdown/start.png");
    int i = 0;
    public void act() 
    {
     SFX.play();
     changeImage3();
     brake();
     SFX.play();
     changeImage2();
     brake();
     SFX.play();
     changeImage1();
     brake();
     SFX.play();
     changeImageGO();
     brake();
     i=4;
    } 
    private void changeImage3()
    {    
        if (i<1) 
        {
            setImage(three);
            i=i+1;
        }
    }
    private void changeImage2()
    {      
        if (i==1)
        {   
            setImage(two);
            i=i+1;
        }
    }
    private void changeImage1()
    {      
        if (i==2)
        {   
            setImage(one);
            i=i+1;
        }
    }
    private void changeImageGO()
    {      
        if (i==3)
        {  
            setImage(GO);
            i=i+1;
        }
    } 
      public void brake()
    {
        Greenfoot.delay(50);
    }
    
}
