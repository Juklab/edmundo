import greenfoot.*;  
public class about extends mainmenu 
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3"); 
GreenfootImage BG = new GreenfootImage("gui/about/about.png");
public about()
    {
    setBackground(BG);
    removeObjects(getObjects(null));
    addObject(new exit_white(), 1080, 22);
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
}
}
