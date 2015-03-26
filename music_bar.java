import greenfoot.*;
import java.awt.Color;

public class music_bar extends bar
{
    private boolean changed = false;
    // The following fields are used during the time a mouse button is held down;
    // this one informs that a button is held
    private boolean changing = false;
    // this one adds a delay count between changes
    private int timer = 0;
    // this one determines the length of the delay
    private int delay = 0;
    // this one holds the 'direction' of the change (increasing = 1, decreasing = -1)
    private int changeValue = 0;
    // the following fields hold alternate colors for while mouse hovers over the bar
    private Color altSafeColor = new Color(232, 23, 93, 255);
    private Color altTextColor = new Color(232, 23, 93, 255);
    private Color altDangerColor = new Color(232, 23, 93, 255);
    private Color altBackgroundColor = new Color(0, 0, 0, 0);
    private boolean mouseOn = false;
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    /**
     * Constructor:
     * calls the super-class 'volume' constructor with the same parameters
     * @param ref A parameter to be used as the title for the bar
     * @param units A parameter to be used as the unit of measure text (displayed after the value text)
     * @param val A parameter to set the initial value of the bar 
     * @param max A parameter to set the maximum value of the bar
     */
    public music_bar(String ref, String units, int val, int max)
    {
        super(ref, units, val, max);
    }
    
    /**
     * Method act:
     * allows the user to perform mouse presses and clicks on (and beside) the bar to change its value.
     * The following four places can be clicked at:
     *  1) Outside, to left of color bar: minimizes value, and begins incrementing if mouse press held
     *  2) Outside, to right of color bar: maximizes value, and begins decrementing if mouse press held
     *  3) Inside, on left side of color bar: decrements value, and decrements more if mouse press held
     *  4) Inside, on right side of color bar: increments value, and increments more if mouse press held
     */
    public void act()
    {
        // check mouse hovering
        if ((!mouseOn && Greenfoot.mouseMoved(this)) || (mouseOn && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)))
        {
            Color tColor = getTextColor();
            setTextColor(altTextColor);
            setAltTextColor(tColor);
            
            Color sColor = getSafeColor();
            setSafeColor(altSafeColor);
            setAltSafeColor(sColor);
            
            Color dColor = getDangerColor();
            setDangerColor(altDangerColor);
            setAltDangerColor(dColor);
            
            SFX.play();
            mouseOn = !mouseOn;
        }
        // check for initial mouse button pressing
        if (!changing && Greenfoot.mousePressed(this))
        { // a mouse button was pressed down on the bar object; set flag and set timer
            changing = true;
            timer = 50;
            // get mouse info; need to see where the mouse action took place
            MouseInfo mi = Greenfoot.getMouseInfo();
            // check to see if mouse action was outside the color porion of the bar
            if (Math.abs(getX() - mi.getX()) > getBarWidth() / 2)
            { // mouse was pressed on the outside (left or right) of the color portion of the bar
                if (mi.getX() < getX())
                {
                    setValue(getMinimumValue()); // if left side, minimize value
                    changeValue = 1; // prepare to increment if mouse press held
                }
                if (mi.getX() > getX())
                {
                    setValue(getMaximumValue()); // if right side, maximize value
                    changeValue = -1; // prepare to decrement if mouse press held
                }
            }
            else
            { // mouse pressed on the color portion of the bar; save direction of change, and do initial change
                changeValue = (int) Math.signum(mi.getX() - getX());
                setValue(getValue() + changeValue);
            }
            changed = true;
            SFX2.play();
        }
        if (changing)
        { // mouse button was previously found to be pressed down; check if the button is still down
            if (!Greenfoot.mouseClicked(null))
            { // mouse button still being held down; check if time to adjust value again
                timer--;
                if (timer == 0)
                { // time to adjust value again; change the value, inform the world of change, and reset timer
                    setValue(getValue() + changeValue);
                    changed = true;
                    timer = delay;
                }
            }
            // mouse button clicked (released), action over
            else changing = false;
        }
    }
    
    /**
     * Method 'setAltSafeColor': sets a new mouse hovering safe color
     *
     * @param 'color': the new color to use as safeColor when mouse hovers over the bar
     */
    public void setAltSafeColor(Color color) { altSafeColor = color; }
    
    /**
     * Method 'getAltSafeColor': gets the current mouse hovering safe color
     *
     * @return: the current mouse hovering safe color
     */
    public Color getAltSafeColor() { return altSafeColor; }
    
    /**
     * Method 'setAltDangerColor': sets a new mouse hovering danger color
     *
     * @param 'color': the new color to use as dangerColor when mouse hovers over the bar
     */
    public void setAltDangerColor(Color color) { altDangerColor = color; }
    
    /**
     * Method 'getAltDangerColor': gets the current mouse hovering danger color
     *
     * @return: the current mouse hovering danger color
     */
    public Color getAltDangerColor() { return altDangerColor; }

    /**
     * Method setAltTextColor': sets a new mouse hovering text color
     *
     * @param 'color': the new color to use as textColor when mouse hovers over the bar
     */
    public void setAltTextColor(Color color) { altTextColor = color; }
    
    /**
     * Method 'getAltTextColor': gets the current mouse hovering text color
     *
     * @return: the current mouse hovering text color
     */
    public Color getAltTextColor() { return altTextColor; }
    
    /**
     * Method 'isChanged': gets the current status of whether the value has been changed or not.
     * The status is reset to 'false' automatically when this method is called
     *
     * @return: the current true/false value of 'changed'
     */
    public boolean isChanged()
    {
        if (!changed) return false;
        changed = false;
        return true;
    }
    
    /**
     * Method 'setDelay': sets a new time delay between value changes while mouse button is held down
     *
     * @param 'newDelay': the new number of cycles between value changes while mouse button is held down
     */
    public void setDelay(int newDelay) { if (newDelay > 0) delay = newDelay; }
}
