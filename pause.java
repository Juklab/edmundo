import greenfoot.*;

public class pause extends gui
{
public static boolean paused;
public pause()
    {
   paused = false;
    }
public void act() {
    setLocation(550, 275);
}
public static void setPaused(boolean x) {
   paused = x;
}
public boolean getPaused() {
    return paused;
}
}
