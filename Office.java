import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Office extends SWorld
{
    private boolean paused;
    GreenfootSound SFX = new GreenfootSound("sfx/button_click.mp3");
    public Office()
    {    
        super(2800, 550, 1, 2800);
        GreenfootImage of = new GreenfootImage("bg/office.png");
        setScrollingBackground(of);
        setBackground(new GreenfootImage("bg/office.png"));
        //addMainActor(new player(), 200, 400, 250, 300); 
        //addObject(new tv(),200,100);
        addObject(new labtop(),1104, 272);
        addObject(new lift(),456, 300);
        addObject(new Lab(),2602, 293);
        //sound = new sound();
        prepare();
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("escape")) 
    {
        SFX.play();
        paused = true;
        //removeObjects(getObjects(null));
        pausemenu();
    }
    }
    
    private void pausemenu() {
        removeObjects(getObjects(null));
        addObject(new pause(), 550,275);
        addObject(new resume(), 585, 118);
        addObject(new save(), 585, 180);
        addObject(new menu(), 585, 244);
        addObject(new option(), 585, 308);
        addObject(new help(), 585, 367);
        addObject(new out(), 585, 434);
    }
    
    private void prepare()
    {
        addObject(new floor(), 500, 550);
        addObject(new floor(), 1500, 550);
        addObject(new floor(), 2500, 550);
        addObject(new wall(), 30, 310);
        addObject(new wall(), 2425, 310);
    }
   
}
