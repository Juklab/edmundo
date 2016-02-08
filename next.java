import greenfoot.*;

public class next extends story
{
    private boolean mouseOver = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    int count;
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            SFX.play();
            setImage("gui/console/next_hover.png");  
            mouseOver = true;  
            HandCursorWhite.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             setImage("gui/console/next.png");  
             mouseOver = false;  
             MouseCursorWhite.setImage(); 
         } 
    if (count == 0 && Greenfoot.mouseClicked(this))
    {
        SFX2.play();
        getWorld().removeObjects(getWorld().getObjects(first.class));
        getWorld().addObject(new second(),550,275);
        getWorld().addObject(new next(),550,498);
        count = 1;
        System.out.println(count);
    }
    if (count == 1 && Greenfoot.mousePressed(this))
    {
        SFX2.play();
        getWorld().removeObjects(getWorld().getObjects(second.class));
        getWorld().addObject(new third(),550,275);
        getWorld().addObject(new next(),550,498);
        count = 2;
    }
    if (count == 2 && Greenfoot.mousePressed(this))
    {
        SFX2.play();
        getWorld().removeObjects(getWorld().getObjects(third.class));
        getWorld().addObject(new fourth(),550,275);
        getWorld().addObject(new next(),550,498);
        count = 3;
    }
     if (count == 3 && Greenfoot.mousePressed(this))
    {
        SFX2.play();
        getWorld().removeObjects(getWorld().getObjects(fourth.class));
        getWorld().addObject(new fifth(),550,275);
        getWorld().addObject(new next(),550,498);
        count = 4;
    }
     if (count == 4 && Greenfoot.mousePressed(this))
    {
        SFX2.play();
        getWorld().removeObjects(getWorld().getObjects(fifth.class));
        count = 0;
        //getWorld().removeObjects(getWorld().getObjects(null));
        Greenfoot.setWorld(new console()); 
    }
    }
}
