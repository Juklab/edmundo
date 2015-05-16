import greenfoot.*;

public class note_show extends object
{
  note na = new note();
  public note_show() {
      GreenfootImage BG = new GreenfootImage("objects/hint/"+"3972"+".png");
      setImage(BG);
  }
  public void act() {
    setLocation(550, 275);
    pause p = new pause();
    if(Greenfoot.isKeyDown("escape")) 
    {
    getWorld().removeObjects(getWorld().getObjects(note_show.class));
    p.setPaused(false);
    }
    } 
}
