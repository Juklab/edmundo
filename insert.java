import greenfoot.*;

public class insert extends Actor
{
    pause p = new pause();
    player pa = new player();
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    public void act() 
    {
    setLocation(550, 275);
    if(Greenfoot.isKeyDown("escape")) 
    {
    SFX2.play();
    getWorld().removeObjects(getWorld().getObjects(insert.class));
    p.setPaused(false);
    }
    if(Greenfoot.isKeyDown("enter")) 
    {
      SFX2.play();
      if(pa.getKey() && getWorld().getObjects(complete.class).isEmpty()) {
       getWorld().addObject(new complete(),550,275);    
       }
      else if(!pa.getKey() && getWorld().getObjects(no_key.class).isEmpty()) {
        getWorld().addObject(new no_key(),550,275); 
       }    
    }
}
}