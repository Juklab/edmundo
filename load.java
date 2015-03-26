import greenfoot.*;
public class load extends mainmenu 
{
GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
public load()
    {
    setBackground(new GreenfootImage("gui/load/no_save.png"));
    removeObjects(getObjects(null));
    addObject(new exit(), 1080, 22);
    MouseCursor.setImage(); 
    }
    public void act()
    {     
    if(Greenfoot.isKeyDown("escape")) {
       SFX.play();
       removeObjects(getObjects(null));
       Greenfoot.setWorld(new mainmenu());
    }
}
}
