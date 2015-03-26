import greenfoot.*;  
public class floor extends Actor
{
    public void act() 
    {
        GreenfootImage floor = new GreenfootImage("bg/transpalent_floor.png");
        GreenfootImage image = new GreenfootImage(1040, floor.getHeight());
        int w = floor.getWidth(); // to measure the floor object
        for(int offset=0; offset<6000; offset+=w) image.drawImage(floor, offset, 0);
        setImage(image);
    }    
}
