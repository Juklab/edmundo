import greenfoot.*; 
public class credits extends mainmenu 
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3"); 
public credits()
{
    setBackground(new GreenfootImage("gui/credit/credit2.png"));
    removeObjects(getObjects(null));
    MouseCursor.setImage(); 
    addObject(new exit_white(), 1080, 22);
}
public void act()
{
    if(Greenfoot.isKeyDown("escape")) {
        SFX2.play();
        Greenfoot.setWorld(new mainmenu());
    }
}
}
