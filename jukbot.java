import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class jukbot extends enemy
{
boolean mouseOver = false;
GreenfootSound JukBotSFX = new GreenfootSound("sfx/robot_hover.mp3");
    public void act() 
    {
       //setLocation(810, 355);
       Lobby lob = (Lobby) getWorld();
       if(!lob.isPaused()) { run(); }
       MouseInfo mouse = Greenfoot.getMouseInfo();    
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            mouseOver = true;  
            JukBotSFX.play();
            HandCursor.setImage(); 
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
         {  
             mouseOver = false;  
             MouseCursor.setImage(); 
         } 
    }  
    public void run()
    {
       turnAtEdge();
       //randomTurn();
       move();
        //lookForPlayer();
    }
    public void turnAtEdge()
    {
        if ( atWorldEdge() ) 
        {
            turn(90);
        }
    }

    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }

/*
    public void lookForPlayer()
    {
        if ( canSee(player.class) ) 
        {
            shoot(player.class);
        }
    }
    */
}
