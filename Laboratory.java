import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Laboratory extends SWorld
{

GreenfootSound SFX = new GreenfootSound("sfx/button_click.mp3");
GreenfootImage lo = new GreenfootImage("bg/laboratory.png");
public Laboratory()
    {    
      super(1100, 550, 1, 2800);
      addMainActor(new player(), 696, 342, 450, 450);
      setScrollingBackground(lo);
      MouseCursor.setImage(); 
      prepare();
       setPaintOrder(control.class,intro.class,save.class,out.class,resume.class,menu.class,help.class,option.class,pause.class,failed.class,  exit_white.class,exit.class,generator_map.class,lab_map.class,freezer_map.class,office_map.class,mainframe_map.class,lobby_map.class,map.class,player.class,    labtop.class,safe_box.class, lift.class,door.class, wood_frame1.class); 
    }
private void prepare()
{
        addObject(new floor(), 10, 620);
        addObject(new floor(), 500, 620);
        addObject(new floor(), 1500, 620);
        addObject(new floor(), 2500, 620);
        addObject(new lift(),290, 295);
        addObject(new safe_box(),1073, 340);
}
}
