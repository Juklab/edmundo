import greenfoot.*; 
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
public class Lobby extends SWorld
{
    GreenfootSound sBGM = new GreenfootSound("bg/lobby.mp3"); 
    GreenfootSound SFX = new GreenfootSound("sfx/button_click.mp3");
    GreenfootImage BG = new GreenfootImage("bg/lobby.png");
    private boolean paused = false;
    music m = new music();
    Countdown cn = new Countdown(); 
    int lineCount; 
    public Lobby()
    {
    super(2800, 550, 1, 2800);   // scroll world constructor call; last parameter is scroll width
    // in the following statement, the main actor is placed at (400, 342) in scroll area coordinates
    addMainActor(new player(), 200, 400, 250, 300); 
        setScrollingBackground(BG);    

    addObject(cn, 550, 275);
    MouseCursor.setImage(); 
       //addObject(new Button(bar, 200, Color.green), getWidth()/2 - 80, getHeight()/2 + 80);
       //addObject(new Button(bar, -200, Color.red), getWidth()/2 + 80, getHeight()/2 + 80);
    //setPaintOrder(safe_box.class, lift.class,jukbot.class, player.class, pause.class);
    }  
    
    public void act()
    {
    //m.stopBGM();
    //sBGM.play();
    if(Greenfoot.isKeyDown("escape") && getObjects(pause.class).isEmpty()) 
    {
        SFX.play();
        paused = true;
        //removeObjects(getObjects(null));
        addObject(new resume(), 585, 118);
        addObject(new save(), 585, 180);
        addObject(new menu(), 585, 244);
        addObject(new option(), 585, 308);
        addObject(new help(), 585, 367);
        addObject(new out(), 585, 434);
        addObject(new pause(), getWidth()/2, getHeight()/2);
    }
    
    if(cn.i == 4)
    {
       cn.i = 5;
    //Greenfoot.setSpeed(60);
       removeObject(cn); // removes the countdown, so that it won't keep counting
    // add other scrollable objects using scroll area coordinates 
       addObject(new lift(), 2600, 300, true);
       addObject(new safe_box(), 810, 355, true); // true for make is scroll
    addObject(new HealthBar(100,100), 83,23, false);
       addObject(new jukbot(), 2070, 466, true);
       addObject(new jukbot(), 1644, 466, true);
       addObject(new jukbot(), 1344, 466, true);

       //setPaintOrder(player.class, newspaper.class);
       //addObject(new Box(), 680, 345, true); // the boolean determines scrollable state
       prepare();
    }

    if(!m.BGMisPlaying()) {
        //sBGM.playLoop();
    }

    String key = Greenfoot.getKey();
    if("p".equals(key)) new pass("1181", "Safe is locked, insert the passcode to deactivated security system.", this); 
    
}

private void pausemenu()
{

}

private void prepare()
    {
        //addObject(new floor(), 10, 580);
        addObject(new floor(), 500, 550);
        addObject(new floor(), 1500, 550);
        addObject(new floor(), 2500, 550);
        addObject(new wall(), 30, 300);
        addObject(new wall(), 2425, 300);
    }
    
private void printLine(String line)
    {
        lineCount++;
        getBackground().setColor(java.awt.Color.black);
        getBackground().drawString(line, 5, lineCount*25);
        if (lineCount == 16)
        {
            lineCount--;
            lineFeed();
        }
    }
    
/**
     * This method moves all data up one line position removing the top-most line.
     */
private void lineFeed()
    {
        GreenfootImage img = new GreenfootImage(getBackground());
        GreenfootImage bg = getBackground();
        bg.setColor(java.awt.Color.white);
        bg.fill();
        bg.drawImage(img, 0, -25);
    }

public void setPaused(boolean x) {
   paused = x;
}
public boolean isPaused() {
   return paused;
}
}
