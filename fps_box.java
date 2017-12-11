import greenfoot.*;

public class fps_box extends tick_box
{
    private boolean changed = false;
    private Color altSafeColor = new Color(232, 23, 93, 255);
    private Color altTextColor = new Color(232, 23, 93, 255);
    private Color altDangerColor = new Color(232, 23, 93, 255);
    private Color altBackgroundColor = new Color(0, 0, 0, 0);;
    private boolean mouseOn = false;
    private boolean alternatingText = false;
    private String[] valueText = {"", ""};
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    /**
     * SwitchBar Constructor:
     * calls the super-class 'settings' constructor with the same parameters
     * @param 'ref' the title for the bar
     * @param 'status' the initial value of the bar 
     */
    public fps_box(String ref, boolean status)
    {
        // DO NOT EDIT THIS OBJECT
        super(ref, "", 1, 1);
        setBarWidth(25);
        setBreakPercent(50);
        setBreakLow(status);
        setDangerColor(new Color(0, 0, 0, 0));
        setShowTextualUnits(false);
    }
    
    /**
     * Method 'act': allows the user to perform mouse clicks to change its value (and text if alternating text is being used).
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
            Color bColor = getBackgroundColor();
            setBackgroundColor(altBackgroundColor);
            setAltBackgroundColor(bColor);
            mouseOn = !mouseOn;
            SFX.play();
        }
        // check for mouse button click
        if (Greenfoot.mouseClicked(this))
        {
            //switch color of bar and set 'changed' to true
          SFX2.play();
          setBreakLow(!getBreakLow());
          if (alternatingText) setReferenceText(getBreakLow() ? valueText[1] : valueText[0]);
          changed = true;
        }
    }
    
    public void setAltSafeColor(Color color) { altSafeColor = color; }
    public Color getAltSafeColor() { return altSafeColor; }
  
    public void setAltDangerColor(Color color) { altDangerColor = color; }
    public Color getAltDangerColor() { return altDangerColor; }

    public void setAltTextColor(Color color) { altTextColor = color; }
    public Color getAltTextColor() { return altTextColor; }
    
    public void setAltBackgroundColor(Color color) { altBackgroundColor = color; }
    public Color getAltBackgroundColor() { return altBackgroundColor; }
    
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
     * Method 'setValueText': sets the text to display for both states of the switch.  The text for false (or off) is listed first.
     *
     * @param 'vText': a String array that contains the text for both switch states
     */
    public void setValueText(String[] vText)
    {
        valueText = vText;
        setReferenceText(getBreakLow() ? valueText[1] : valueText[0]);
        alternatingText = true;
    }
    
    /**
     * Method 'getState': returns the state (status value) of the switch; 'on' (true) or 'off' (false)
     *
     * @return: the current 'value' of the switch
     */
    public boolean getState()
    {
        return getBreakLow();
    }
}
