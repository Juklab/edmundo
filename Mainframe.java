import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Mainframe extends SWorld
{
    GreenfootSound SFX = new GreenfootSound("sfx/button_click.mp3");
    GreenfootImage om = new GreenfootImage("bg/mainframe_room.png");
    private static GreenfootSound BGS = new GreenfootSound("bg/rave1.mp3");
    private static boolean isPlay;
    public Mainframe()
    {    
        super(1100, 550, 1, 2800);
        addMainActor(new player(), 696, 342, 450, 450);
        setScrollingBackground(om);
        MouseCursor.setImage(); 
        prepare();
        setPaintOrder(passed.class,complete.class , no_key.class ,insert.class, control.class,intro.class,save.class,out.class,resume.class,menu.class,help.class,option.class,pause.class,failed.class,exit_white.class,exit.class, generator_map.class,office_map.class, lab_map.class,freezer_map.class, mainframe_map.class,lobby_map.class,map.class, player.class,    switch_server.class,safe_box.class, lift.class,door.class, wood_frame1.class, labtop.class); 
        if(Mansion.BGOisPlaying() || Office.BGFisPlaying()) { 
            Mansion.stopBGO();
            Office.stopBGF();
            BGS.playLoop();
        }
    }
    private void prepare()
    {
        addObject(new floor(), 10, 620);
        addObject(new floor(), 500, 620);
        addObject(new floor(), 1500, 620);
        addObject(new floor(), 2500, 620);
        addObject(new switch_server(),567,264);
        addObject(new lift_server(),390,318);
    }

    public static boolean BGSisPlaying() {
        if(BGS.isPlaying()) {isPlay = true;}
        if(!BGS.isPlaying()) {isPlay = false;}
        return isPlay;
    }   
    public static void stopBGS() {
       BGS.stop();
       isPlay = false;
    }
}
