import greenfoot.*;
public class console extends play
{
GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3"); 
GreenfootImage BG = new GreenfootImage("gui/console/console.png");
public console()
{
    removeObjects(getObjects(null));
    MouseCursorWhite.setImage(); 
    addObject(new mission14(),434,229);
    addObject(new main_menu_con(),254,487);
    addObject(new storyboard(),550,487);
    addObject(new inventory(),845,487);
    setBackground(BG);
    setPaintOrder(next.class,fifth.class,fourth.class,third.class,second.class,first.class); // front to back
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