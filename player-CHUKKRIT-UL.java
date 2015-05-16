import greenfoot.*;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
/**
 * A user-controlled actor that walks and jumps, and is pulled down by gravity.
 * <l><li>Left arrow moves actor left (toward left scroll limit)</li>
 * <li>Right arrow moves actor right (toward right scroll limit)</li>
 * <li>Up arrow makes the actor jump</li><l>
 */
public class player extends Actor
{
    final int jSpeed = 25; // the initial 'jump' speed
    int ySpeed = 0, xSpeed = 0; // the initial vertical and horizontal speeds
    boolean aboutFace; // the direction (left or right) the actor is facing
    boolean onGround; // the state of the actor being set on an object or not
    static boolean left;
    GreenfootSound shootSFX = new GreenfootSound("sfx/shoot.wav");
    GreenfootSound failedSFX = new GreenfootSound("sfx/failed.mp3");
    public boolean paused = false;
    int timer =0;
    public void act()
    {
    Lobby lob = (Lobby) getWorld();
    Office off = (Office) getWorld();
    if(!lob.isPaused() && !off.isPaused()) 
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
    timer = 0;
}
        getDirection();
        move();
    }
     if(Greenfoot.isKeyDown("escape") && getWorld().getObjects(pause.class).isEmpty()) 
    {
        //SFX.play();
        paused = true;
        //removeObjects(getObjects(null));
        getWorld().addObject(new resume(), 585, 118);
        getWorld().addObject(new save(), 585, 180);
        getWorld().addObject(new menu(), 585, 244);
        getWorld().addObject(new option(), 585, 308);
        getWorld().addObject(new help(), 585, 367);
        getWorld().addObject(new out(), 585, 434);
        getWorld().addObject(new pause(), getWorld().getWidth()/2, getWorld().getHeight()/2);
    }
    if(Greenfoot.isKeyDown("t") && getWorld().getObjects(failed.class).isEmpty()) 
    {
        getWorld().addObject(new failed(),getWorld().getWidth()/2, getWorld().getHeight()/2);
        failedSFX.play();
    } 
    String key = Greenfoot.getKey();
   // if("p".equals(key)) new pass("1181", "Safe is locked, insert the passcode to deactivated security system.", this); 
    
}
    
    /**
     * Moves the actor with appropriate image.  Checks for obstacles and adjusts
     * the position of the actor accordingly.
     */
    private void move()
    {
        ySpeed++; // adds gravity
        if (xSpeed != 0 && onGround) xSpeed+=aboutFace?1:-1; // add friction
        setLocation(getX()+xSpeed/5, getY()+ySpeed/2);
        // check for change in horizontal direction
        if((xSpeed>0 && aboutFace) || (xSpeed<0 && !aboutFace)) 
        {
            getImage().mirrorHorizontally();
            aboutFace = !aboutFace;
        }
        
        // check for obstacles
        onGround=false; // initialize value
        // check below the actor
        while(getOneObjectAtOffset(0, getImage().getHeight()/2+1, null)!=null)
        {
            setLocation(getX(), getY()-1); 
            onGround=true; 
            ySpeed=0;
        }
        // check above the actor
        while(getOneObjectAtOffset(0, -getImage().getHeight()/2-1, null)!=null) 
        {
            setLocation(getX(), getY()+1);
            ySpeed = 0;
        }
        // check to right of actor
        /*while(getOneObjectAtOffset(getImage().getWidth()/2+1, 0, null)!=null)
        {
            setLocation(getX()-1, getY());
            //xSpeed = 0;
        }
        // check to left of actor
        while(getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, null)!=null)
        {
            setLocation(getX()+1, getY());
            //xSpeed = 0;
        }*/
    }


    /**
     * Determines any changes in horizontal and vertical speeds for the actor.
     */
    private void getDirection()
    {
//         if (!onGround) return; // if not mid-air changes allowed
        // sets requested direction of move, or continues in current direction
        if (Greenfoot.isKeyDown("left") ){ xSpeed-=1; left = true; }// check left && xSpeed>-50
        if (Greenfoot.isKeyDown("right") ){ xSpeed+=1; left = false;} // check right && xSpeed<50
        if (Greenfoot.isKeyDown("up") && onGround) // check jump
        {
            ySpeed -= jSpeed; // add jump speed
        }
    }
    

    public boolean isLeft() {
       return left;
    }
    
   public void setPaused(boolean x) {
   paused = x;
}
public boolean isPaused() {
   return paused;
}
    
    
    
    /*
    

    private int speed = 5;
    private int vSpeed = 10;
    private int gravity = 2;
    public void act() 
    {
       keyControl();
       fall();
    }
    
    public Onodera(){
    }
    
    public void keyControl(){
      if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY() - speed);
      }
      if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY() + speed);
      }
      if(Greenfoot.isKeyDown("left")){
          setImage("onoderaLeft.png");
          setLocation(getX() - speed,getY());
      }
      if(Greenfoot.isKeyDown("right")){
          setImage("onoderaRight.png");
          setLocation(getX() + speed,getY());
      }
      if(Greenfoot.isKeyDown("space")){
            jump();
      }
    }
    
    public void fall(){
        setLocation(getX(), getY() + vSpeed);
        vSpeed = gravity + vSpeed;
    }
    
    public void jump(){
        vSpeed = -10;
        fall();
    }
}
*/
}
