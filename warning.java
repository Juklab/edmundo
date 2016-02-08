import greenfoot.*;
public class warning extends mainmenu 
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
GreenfootImage BG = new GreenfootImage("gui/warning/memory_warning.png"); 
music m = new music();
public warning()
    {
    setBackground(BG);
    removeObjects(getObjects(null));
    MouseCursor.setImage(); 
    }
public void act()
    {    
    if(Greenfoot.isKeyDown("escape")) 
    {
       SFX2.play();
       removeObjects(getObjects(null));
       Greenfoot.setWorld(new mainmenu());
    }
    if(Mansion.BGOisPlaying() || Mainframe.BGSisPlaying() || Office.BGFisPlaying()) {
        Mansion.stopBGO();
        Mainframe.stopBGS();
        Office.stopBGF();
    }
}
}

