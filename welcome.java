import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class welcome extends World
{
    music m = new music();
    public welcome()
    {    
        super(1100, 550, 1); 
        setBackground(new GreenfootImage("gui/welcome/welcome.png"));
        addObject(new wel_blink(), 552, 473);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter")) {
            //m.setSong("bg.mp3");
            m.setVolumeBGM(100);
            m.startBGM();
            Greenfoot.setWorld(new mainmenu()); 
        }
        if(Greenfoot.isKeyDown("escape")) {
            removeObjects(getObjects(null));
            Greenfoot.stop();
        }
    }
}
