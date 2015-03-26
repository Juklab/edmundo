import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class sound
{
    private GreenfootSound music;
    public sound()
    {
        music = new GreenfootSound("tv/video.mp3");  
        music.setVolume(70);        
    }
    public void play(int sound){
        try
        {
            music.setVolume(sound);
            music.play();
        }
        catch( java.lang.IllegalArgumentException fail)
        {   System.err.println("                                                                        ");
            System.err.println("you put "+sound +" as the volume, the minmuim is zero and maxmin is 100.");
            System.err.println("//////////////////////////////////////////////////////////////////////");
            System.err.println(fail);
        }
     }
    public void stop(){        
        music.pause();
    }
    public void play(){        
        music.play();
    }
}
