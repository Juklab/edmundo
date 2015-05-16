import greenfoot.*; 

public class Mansion extends SWorld
{
    music m = new music(); 
    GreenfootImage bg = new GreenfootImage("bg/mansion.png");
    GreenfootSound SFX = new GreenfootSound("sfx/button_click.mp3");
    private static GreenfootSound BGO = new GreenfootSound("bg/rave3.mp3");
    private static boolean isPlay;
    /**
     * Creates a scrolling world using a main actor, a background, some obstacles, and a non-scrolling score.
     */
    public Mansion()
    {    
        super(1100, 550, 1, 2800); // scroll world constructor call; last parameter is scroll width
        // in the following statement, the main actor is placed at (400, 342) in scroll area coordinates
        addMainActor(new player(), 450, 342,450,450);
        setScrollingBackground(bg);
        // add other scrollable objects using scroll area coordinates
        // use the following for non-scrollable objects using window coordinates (not scroll area coordinates)
        MouseCursor.setImage(); 
        prepare(); 
        if(m.BGMisPlaying() || Mainframe.BGSisPlaying() || Office.BGFisPlaying()) { 
            m.stopBGM();
            Mainframe.stopBGS();
            Office.stopBGF();
            BGO.playLoop();
        }
        setPaintOrder(control.class,intro.class,save.class,out.class,resume.class,menu.class,help.class,option.class,pause.class,failed.class,  exit_white.class,exit.class,generator_map.class, lab_map.class, freezer_map.class, office_map.class, mainframe_map.class,lobby_map.class,map.class,frame1_zoom.class, frame2_zoom.class,  player.class,    safe_box.class, lift.class,door.class, wood_frame1.class); // front to back
    }    
 
    private void prepare()
    {
        addObject(new floor(), 10, 620);
        addObject(new floor(), 500, 620);
        addObject(new floor(), 1500, 620);
        addObject(new floor(), 2500, 620);
        addObject(new door(),219,293);
        addObject(new door2(),1478,293);
        addObject(new door3(),2680,293);
        addObject(new wood_frame1(),728,180);
        addObject(new wood_frame2(),2188,186);
        //addObject(new safe_box(), 810, 355, true); 
    }
    // Mansion sound controller
    public static boolean BGOisPlaying() {
        if(BGO.isPlaying()) {isPlay = true;}
        if(!BGO.isPlaying()) {isPlay = false;}
        return isPlay;
    }   
    public static void stopBGO() {
       BGO.stop();
       isPlay = false;
    }
}

