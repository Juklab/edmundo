import greenfoot.*;
public class complete extends Actor
{
    GreenfootSound winSFX = new GreenfootSound("sfx/shutdown.mp3");
    player p = new player();
    public void act() 
    {
    winSFX.play();
    Greenfoot.delay(200);
    if(getWorld().getObjects(passed.class).isEmpty()) {
    getWorld().addObject(new passed(),550,275);    
    }    
}
}
