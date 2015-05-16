import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Graphics;
public class FPS extends Actor
{
public enum Mode {AVERAGE, REALTIME}
public static final Mode mode = Mode.AVERAGE;
private static final Color textColor = Color.white;
private static final String prefix = "FPS: ";
private static final int updateFreq = 30;
private static boolean status;
private long countAct;
private long prevTime;
private double fps;
/**
* Create a new FPS reading.
*/
public FPS()
{
countAct = 0;
setImage(new GreenfootImage(100, 16));
GreenfootImage image = getImage();
image.setColor(textColor);
updateImage("-");
}
/**
* Set the value of the frames per second.
* @param val the value to set the FPS to.
*/
private void setFPS(Long val)
{
fps = val;
updateImage(val.toString());
}
/**
* Set the value of the frames per second.
* @param val the value to set the FPS to.
*/
private void setFPS(Double val)
{
fps = val;
updateImage(val.toString());
}
/**
* Get the number of frames per second.
* @return the number of frames per second.
*/
public double getFPS()
{
return fps;
}

/**
* Calculate the FPS based on the mode, and
* update the reading.
*/
public void act()
{
countAct++;
if(mode == Mode.REALTIME) {
long gap = System.currentTimeMillis() - prevTime;
if(gap != 0 && countAct%updateFreq==0) {
countAct=0;
setFPS((1.0/gap)*1000.0);
}
prevTime = System.currentTimeMillis();
}
else if(mode == Mode.AVERAGE) {
long curTime = System.currentTimeMillis();
if(curTime>=prevTime+1000) {
setFPS(countAct);
prevTime = curTime;
countAct = 0;
}
}
}
/**
* Draw the image.
* @param value the FPS value
*/
private void updateImage(String value)
{
GreenfootImage image = getImage();
image.clear();
image.drawString(prefix + value, 1, 16);
}
public static void FPS_status(boolean d)
{
  status = d;
}
public static boolean FPS_curstatus()
{
  return status;
}
}