import greenfoot.*;

public class bullet extends Actor
{
    //public Bullet(int x, GreenfootImage bul) {
        //setImage(bul);
        //setRotation(x + (Player.getGun().acc > 0 ? (Greenfoot.getRandomNumber(Player.getGun().acc) - (Player.getGun().acc)) /2 : 0));
        //shootSFX.play();
    //}
    GreenfootSound HitSFX = new GreenfootSound("sfx/ouch.mp3");
    player g = new player();
    public void act() 
    {     
        if(g.isLeft()) {move(-30); }
        if(!g.isLeft()) { move(30);}
        if(getY() > 2600 || getY() < 300 || getX() > 2600 || getX() < 300 || atWorldEdge()) {
        getWorld().removeObject(this); }
        
        //Alien alen = (Alien)getOneIntersectingObject(Alien.class);
        //if(alen != null && !alen.dead && this != null && getWorld() != null) {
        //    getWorld().removeObject(this);
        //    alen.health--;
        //    alen.hit(player.getGun().damage);
        //checkHitBot();
        }  
    
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    private void checkHitBot()
    {
        if(isTouching(jukbot.class)){
           HitSFX.play();
        }
    }
}
