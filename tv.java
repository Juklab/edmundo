import greenfoot.*;
public class tv extends Actor
{
    int frame2 = 0;
    int frame3 = 0;
    int frame = 0;
    int frameH = 9;
    int frame2H = 100;
    int time = 0;
    String name ="video";
    boolean stop = false;
    public void act() 
    {        
        if(!stop)
            try
            {
                frame ++;
                setImage("video "+frame+".jpg"); 
            }
            catch (java.lang.IllegalArgumentException iae)
            {
                stop = true;
                //Office.finished();
            }

        if("space".equals(Greenfoot.getKey()))    
        {
            if(!stop){
                stop = true;
                //Office.finished();
            }
            else
            {
                stop=false;
                //Office.unfinished();
            }
        }
        getImage().scale(200,130);
    }  
}
