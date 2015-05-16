import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Office extends SWorld
{
    GreenfootSound SFX = new GreenfootSound("sfx/button_click.mp3");
    GreenfootImage of = new GreenfootImage("bg/office.png");
    private static GreenfootSound BGF = new GreenfootSound("bg/drama.mp3");
    private static boolean isPlay;
    public Office()
    {    
        super(1100, 550, 1, 2800);
        addMainActor(new player(), 696, 342, 450, 450);
        setScrollingBackground(of);
        MouseCursor.setImage(); 
        prepare();
        setPaintOrder(control.class,intro.class,save.class,out.class,resume.class,menu.class,help.class,option.class,pause.class,failed.class, exit_white.class,exit.class,generator_map.class, lab_map.class,freezer_map.class,office_map.class,mainframe_map.class,lobby_map.class,map.class, note_show.class,desktop.class, paper_show.class,player.class, paper.class, safe_box.class, lift.class,door.class, wood_frame1.class, labtop.class); 
        if(Mansion.BGOisPlaying() || Mainframe.BGSisPlaying()) { 
            Mansion.stopBGO();
            Mainframe.stopBGS();
            BGF.playLoop();
        }
    }
    private void prepare()
    {
        addObject(new labtop(),1102, 271);
        addObject(new lift(),456, 288);
        addObject(new lift(),2567, 288);
        addObject(new paper(),1460, 482);
        addObject(new note(), 754, 475);
        addObject(new floor(), 10, 620);
        addObject(new floor(), 500, 620);
        addObject(new floor(), 1500, 620);
        addObject(new floor(), 2500, 620);
    }

    public static boolean BGFisPlaying() {
        if(BGF.isPlaying()) {isPlay = true;}
        if(!BGF.isPlaying()) {isPlay = false;}
        return isPlay;
    }   
    public static void stopBGF() {
       BGF.stop();
       isPlay = false;
    }
}
