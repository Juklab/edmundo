import greenfoot.*;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.util.List;

public class player extends Actor
{
    final int jSpeed = 25; // the initial 'jump' speed
    int ySpeed = 0, xSpeed = 0; // the initial vertical and horizontal speeds
    boolean aboutFace; // the direction (left or right) the actor is facing
    boolean onGround; // the state of the actor being set on an object or not
    static boolean left;
    GreenfootSound shootSFX = new GreenfootSound("sfx/shoot.wav");
    GreenfootSound failedSFX = new GreenfootSound("sfx/failed.mp3");
    GreenfootSound PSFX = new GreenfootSound("sfx/troll.mp3");
    public boolean paused = false;
    private static boolean key;
    int timer =0;
    pause p = new pause();
    public void act()
    {
    if(p.getPaused()==false) 
    {     
    timer ++;    
    if(timer == 0)
    setImage("characters/player/walking/1.gif");
    if(timer == 5)
    setImage("characters/player/walking/2.gif");
    if(timer == 10)
    setImage("characters/player/walking/3.gif");
    if(timer == 15)
    setImage("characters/player/walking/4.gif");
    if(timer == 20)
    setImage("characters/player/walking/5.gif");
    if(timer == 25)
    setImage("characters/player/walking/6.gif");
    if(timer == 30)
    setImage("characters/player/walking/7.gif");
    if(timer == 35)
    setImage("characters/player/walking/8.gif");
    if(timer == 40)
    setImage("characters/player/walking/9.gif");
    if(timer == 45) {
    setImage("characters/player/walking/10.gif");
    timer = 0;}
    getDirection();
    move();
}
else if(p.getPaused()==true)  {
    if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){ xSpeed=0; left = true; }// check left && xSpeed>-50
    if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){ xSpeed=0; left = false;} // check right && xSpeed<50
    if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w") && onGround) // check jump
    {
       ySpeed = jSpeed; // add jump speed
    }
}
 if(Greenfoot.isKeyDown("escape") && getWorld().getObjects(pause.class).isEmpty() && getWorld().getObjects(wood_frame1.class).isEmpty() && getWorld().getObjects(wood_frame2.class).isEmpty() && getWorld().getObjects(labtop.class).isEmpty()  && getWorld().getObjects(inside_safe.class).isEmpty()  && getWorld().getObjects(note_show.class).isEmpty()  && getWorld().getObjects(paper_open.class).isEmpty() && getWorld().getObjects(insert.class).isEmpty() || Greenfoot.isKeyDown("p") && getWorld().getObjects(pause.class).isEmpty()) 
{
        p.setPaused(true);
        //removeObjects(getObjects(null));
        getWorld().addObject(new resume(), 585, 118);
        getWorld().addObject(new save(), 585, 180);
        getWorld().addObject(new menu(), 585, 244);
        getWorld().addObject(new option(), 585, 308);
        getWorld().addObject(new help(), 585, 367);
        getWorld().addObject(new out(), 585, 434);
        getWorld().addObject(new pause(), 550,275);
}
 if(Greenfoot.isKeyDown("m") && getWorld().getObjects(map.class).isEmpty()) 
{
        p.setPaused(true);
        MouseCursorWhite.setImage(); 
        getWorld().addObject(new generator_map(), 762,476);
        getWorld().addObject(new lab_map(), 475,257);
        getWorld().addObject(new freezer_map(), 520,475);
        getWorld().addObject(new office_map(), 521,352);
        getWorld().addObject(new mainframe_map(), 787,354);
        getWorld().addObject(new lobby_map(), 259,321);
        getWorld().addObject(new map(), 550,275);
}
if(Greenfoot.isKeyDown("r")) 
{
        getWorld().removeObjects(getWorld().getObjects(null));
        Greenfoot.setWorld(new mainmenu());
}
if(Greenfoot.isKeyDown("h") && getWorld().getObjects(control.class).isEmpty()) 
{
        p.setPaused(true);    
        getWorld().addObject(new control(),550,275);
}
if(Greenfoot.isKeyDown("t") && getWorld().getObjects(failed.class).isEmpty()) 
{
        getWorld().addObject(new failed(),getWorld().getWidth()/2, getWorld().getHeight()/2);
        failedSFX.play();
} 
if (Greenfoot.mouseClicked(this))  
{  
        PSFX.play();
} 
}
    
private void move()
    {
        ySpeed++; // adds gravity
        if (xSpeed != 0 && onGround) xSpeed+=aboutFace?1:-1; // add friction
        setLocation(getX()+xSpeed/6, getY()+ySpeed/3);
        // check for change in horizontal direction
        if((xSpeed>0 && aboutFace) || (xSpeed<0 && !aboutFace)) 
        {
            getImage().mirrorHorizontally();
            aboutFace = !aboutFace;
        }
        
        // check for obstacles
        onGround=false; // initialize value
        // check below the actor
        while(getOneObjectAtOffset(0, getImage().getHeight()/2+1, floor.class)!=null)
        {
            setLocation(getX(), getY()-1); 
            onGround=true; 
            ySpeed=0;
        }
        // check above the actor
        while(getOneObjectAtOffset(0, -getImage().getHeight()/2-1, floor.class)!=null) 
        {
            setLocation(getX(), getY()+1);
            ySpeed = 0;
        }
        // check to right of actor
        while(getOneObjectAtOffset(getImage().getWidth()/2+1, 0, floor.class)!=null)
        {
            setLocation(getX()-1, getY());
            xSpeed = 0;
        }
        // check to left of actor
        while(getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, floor.class)!=null)
        {
            setLocation(getX()+1, getY());
            xSpeed = 0;
        }
    }

private void getDirection()
    {
//         if (!onGround) return; // if not mid-air changes allowed
        // sets requested direction of move, or continues in current direction
   if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){ xSpeed-=1; left = true; }// check left && xSpeed>-50
   if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){ xSpeed+=1; left = false;} // check right && xSpeed<50
   if (Greenfoot.isKeyDown("up")  && onGround || Greenfoot.isKeyDown("w") && onGround || Greenfoot.isKeyDown("space") && onGround) // check jump
   {
            ySpeed -= jSpeed; // add jump speed
   }
   if (Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("shift")){ xSpeed-=2; left = true; }// check left && xSpeed>-50
   if (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("shift")){ xSpeed+=2; left = false;} // check right && xSpeed<50
    }

public boolean isLeft() {
   return left;
}

public void setKey(boolean a) {
    key = a;
}
public boolean getKey() {
    return key;
}
}