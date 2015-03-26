import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class wall extends Actor
{
    public void act() 
    {
        GreenfootImage wall = new GreenfootImage("bg/transpalent_wall.png");
        GreenfootImage image = new GreenfootImage(120, wall.getHeight());
        int w = wall.getHeight(); // to measure the wall object
        for(int offset=0; offset<120; offset+=w) image.drawImage(wall, offset, 0);
        setImage(image);
    }    
}
