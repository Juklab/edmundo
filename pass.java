import greenfoot.*;
public class pass extends World
{
    private static int MAX_WORD_LEN = 4;
    private static final Color transparent = new Color( 0 , 0 , 0 , 0);
    private World passWorld, failWorld;
    private String description = "", answer, input= "";
    private int attempts = 3;
    GreenfootSound SFX_pass = new GreenfootSound("sfx/beep.mp3");
    GreenfootSound SFX_notpass = new GreenfootSound("sfx/denied.mp3");
    GreenfootSound SFX_siren = new GreenfootSound("sfx/siren.mp3");
    GreenfootSound SFX_press = new GreenfootSound("sfx/boop.mp3");
    GreenfootSound failedSFX = new GreenfootSound("sfx/failed.mp3");
    GreenfootSound unlockSFX = new GreenfootSound("sfx/safe_unlock.mp3");
    /**
     * This constructor can be used to prevent any further action unless the password is entered correctly
     *
     * @param correctInput: the password that must be entered correctly
     * @param nextWorld: the world to proceed to when password is entered correctly
     */
    public pass(String correctInput, World nextWorld)
    {
        this(correctInput, "", nextWorld, null);
    }

    /**
     * This constructor can be used to prevent any further action unless the password is entered correctly and will
     * display a custom text message.
     *
     * @param correctInput: the password that must be entered correctly
     * @param descriptor: a text message that is displayed on the security screen
     * @param nextWorld: the world to proceed to when password is entered correctly
     */
    public pass(String correctInput, String descriptor, World nextWorld)
    {
        this(correctInput, descriptor, nextWorld, null);
    }

    /**
     * This constructor can be used to prevent any further action; or,
     * it can be used to only proceed to one world when the password entered is correct, else it proceeds
     * to another world.
     *
     * @param correctInput A parameter
     * @param nextWorld A parameter
     * @param prevWorld A parameter
     */
    public pass(String correctInput, World nextWorld, World prevWorld)
    {
        this(correctInput, "", nextWorld, prevWorld);
    }

    /**
     * This constructor can be used to prevent any further action; or,
     * it can be used to only proceed to one world when the password entered is correct, else it proceeds
     * to another world.  It will also display a custom text message.
     *
     * @param correctInput A parameter
     * @param descriptor: a text message that is displayed on the security screen
     * @param prevWorld A parameter
     */
    public pass(String correctInput, String descriptor, World nextWorld, World prevWorld)
    {
        super(1100, 550, 1);
        answer = correctInput;
        if (answer.length() > MAX_WORD_LEN) answer = answer.substring(0, MAX_WORD_LEN);
        description = descriptor;
        passWorld = nextWorld;
        failWorld = prevWorld;
        updateBackground();
        if (passWorld == null && failWorld == null) return;
        Greenfoot.setWorld(this);        
    }

    /**
     * This method allows user three more attemps after restarting the scenario.<br>
     * <br>
     * NOTE: this method is called by the system when the scenario is re-started.
     */
    public void started()
    {
        attempts = 3;
    }

    private void updateBackground()
    {
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();
        bg.setColor(Color.WHITE);
        bg.fillRect(10, 10, getWidth()-20, getHeight()-20);
        bg.setColor(Color.BLACK);
        GreenfootImage text = new GreenfootImage("Security Protected", 60, Color.BLACK, transparent);
        bg.drawImage(text, (getWidth()-text.getWidth())/2, 40);
        text = new GreenfootImage(description, 28, new Color(128, 0, 0), transparent);
        bg.drawImage(text, (getWidth()-text.getWidth())/2, 100);
        text = new GreenfootImage("Enter Passcode", 40, Color.BLACK, transparent);
        bg.drawImage(text, (getWidth()-text.getWidth())/2, 200);
        text = new GreenfootImage("*", 36, Color.BLACK, transparent);
        for (int i=0; i<input.length(); i++) bg.drawImage(text, getWidth()/2-MAX_WORD_LEN*10+i*20, 280);
    }

    public void act()
    {
        String key = Greenfoot.getKey();
        if (key == null) return;
        boolean update = false;
   
        if (Greenfoot.isKeyDown(key))
           {
            SFX_press.play(); 
           }
         if ("enter".equals(key))
            {
                if (!answer.equals(input))
                {
                    SFX_notpass.play(); 
                    GreenfootImage text = new GreenfootImage("Access Denied", 36, Color.RED, transparent);
                    getBackground().drawImage(text, (getWidth()-text.getWidth())/2, 350);
                    Greenfoot.delay(50);
                    attempts--;
                    input = input.substring(0, input.length()-4);
                    update = true;
                    if (attempts == 0) // try more than 3
                    {
                        if (failWorld == null && getObjects(failed.class).isEmpty()) {
                            SFX_siren.playLoop();
                            Greenfoot.delay(500);
                            // game over screen
                            SFX_siren.stop();
                            addObject(new failed(),getWidth()/2, getHeight()/2);
                            failedSFX.play();
                        }  
                        else { Greenfoot.setWorld(new Laboratory()); }
                        return;
                    }  
                }
                else  // if passed !!
                {
                    SFX_pass.play(); 
                    GreenfootImage text = new GreenfootImage("Access Granted", 36, new Color(0, 128, 0), transparent);
                    getBackground().drawImage(text, (getWidth()-text.getWidth())/2, 350);
                    player p = new player();
                    p.setKey(true);
                    Greenfoot.delay(80);
                    unlockSFX.play(); 
                    Greenfoot.delay(40);
                    if (passWorld != null) { addObject(new inside_safe(),550,275); }
                    return;
                }
         }
        
        if ("escape".equals(key))
            {
               Greenfoot.setWorld(new Laboratory());
            }
        if ("backspace".equals(key) && input.length() > 0)
            {
                input = input.substring(0, input.length()-1);
                update = true;
            }
            //if ("space".equals(key)) key = " ";
        if (key.length() == 1 && input.length() < MAX_WORD_LEN)
            {
                input += key;
                update = true;
            }
        if (update) 
            { 
                updateBackground(); 
            }
        }
    public static void setMaximumLength(int len)
    {
        MAX_WORD_LEN = len;
    }
}