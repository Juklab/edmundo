import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;
public class mainmenu extends World
{
FPS f = new FPS();
music m = new music();
public mainmenu()
    {    
        super(1100, 550, 1); 
        Greenfoot.setWorld(new welcome());
        setBackground(new GreenfootImage("gui/mainmenu/mainmenu.png"));
        // prepare menu
        removeObjects(getObjects(null));
        addObject(new play_h(), 109, 156);
        addObject(new load_h(), 148, 224);
        addObject(new about_h(), 185, 297);
        addObject(new credit_h(), 207, 367);
        addObject(new option_h(), 267, 439);
        addObject(new juklab(), 325, 517);
        // load photo gallery
        addObject(new bg_animate(), 795, 340);
        checkFPS();
    }
public void act() {
    if(Mansion.BGOisPlaying() || Mainframe.BGSisPlaying() || Office.BGFisPlaying()) {
        Mansion.stopBGO();
        Mainframe.stopBGS();
        Office.stopBGF();
        m.startBGM();
    }
}
private void checkFPS() {
if(f.FPS_curstatus()) {
     addObject(new FPS(), 60, 15); 
    }
}
}