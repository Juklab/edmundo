import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class HealthBar extends StatBar
{
    int point;
    public void act() 
    {
        //You can just delete the whole act method if you don't need to add anything
        super.act();
    }    
    
    public HealthBar(int max, int current)
    {
        //Creates a new stat bar with a green color, a width of 140 pixels, a height of 24 pixels,
        //the ROUND bar style, a max value and a current value.
        super(new Color(0, 255, 0), 180, 25, Style.RECT, max, current);
        //Sets the update speed to 5.
        setSpeed(5);
        setCurrent(current);
    }
    
    public HealthBar(int max)
    {
        this(max, max);
    }
    
    public void updateColor()
    {
        if (getValue() <= getMax()/4)
        {
            setColor(Color.red);
        }
        else if (getValue() < getMax()/2)
        {
            setColor(Color.yellow);
        }
        else
        {
            setColor(Color.green);
        }
    }
    private void setCurrent(int x)
    {
    point = x;    
    }
    public int getCurrent()
    {
    return point;   
    }
}
