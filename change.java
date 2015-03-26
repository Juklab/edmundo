import greenfoot.*;
import java.awt.Color;
public class change extends Actor
{
    private StatBar statBar;
    private int changer;
    public void act() 
    {
        //statBar.add(changer);
    }  
    public change(StatBar statBar, int changer, Color color)
    {
        this.statBar = statBar;
        this.changer = changer;
        
        GreenfootImage image = new GreenfootImage(120, 40);
        image.setColor(color);
        image.fillRect(0, 0, image.getWidth(), image.getHeight());
        setImage(image);
    }   
}
