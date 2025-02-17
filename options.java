import greenfoot.*;
import greenfoot.World;
import java.io.*;
import java.util.*;
public class options extends mainmenu 
{
    GreenfootSound SFX = new GreenfootSound("sfx/button_hover.mp3");
    GreenfootSound SFX2 = new GreenfootSound("sfx/button_click.mp3");
    music_bar BGMbar = new music_bar("Volume", "%", BGMvolume, 100); // default
    fps_box fpsbox = new fps_box("Switch", FPSstatus); // default
    private static int BGMvolume; // static variable to store volume status
    private static boolean FULLstatus;  // static variable to store Full screen status
    private static boolean FPSstatus; // static variable to store FPS status
    private boolean BGMIsPlay;
    // call actor
    music m = new music();
    FPS f = new FPS();

    public options()
    {
        setBackground(new GreenfootImage("gui/options/options.png"));
        removeObjects(getObjects(null)); 
        addObject(new exit_white(), 1080, 22);
        addObject(new reset(),400, 460);
        addObject(new save_change(),160, 460);
        MouseCursor.setImage(); 
        addBars();
        addFullBoxs();
        addFPSBoxs();
        CheckFPSstatus();
        CheckBGMvolume();
        BGM_speaker();
    }   
    public void act()
    {    
        if(Greenfoot.isKeyDown("escape")) 
        {
            //saveOptions();
            SFX2.play();
            removeObjects(getObjects(null)); 
            Greenfoot.setWorld(new mainmenu());
        }
        if (BGMbar.isChanged())
        {
            //removeObjects(getObjects(music_bar.class));  
            //addObject(BGMbar, 395, 165);
        }
        if (fpsbox.isChanged())
        {
            // code to perform when the value of the switch changes
            if (fpsbox.getState()) {
                addObject(new FPS(), 60, 15); 
                FPSenabled();
            }
            else if(!fpsbox.getState()) { 
                removeObjects(getObjects(FPS.class)); 
                FPSdisabled();
            }       
        }
    }

    private void addBars()
    {
        // prepare the mouse adjustable bar and add it to the world
        BGMbar.setBreakPercent(0);
        BGMbar.setSafeColor(Color.WHITE);
        music_bar BGMbar = new music_bar("Volume", "%", BGMvolume, 100);
        addObject(BGMbar, 395, 165);
    }   

    private void addFullBoxs()
    {        
        String[] sbTexts = {"WINDOWS MODE", "FULL SCREEN MODE"};
        fpsbox.setValueText(sbTexts);
        //addObject(fullbox, 467, 375);
    }

    private void addFPSBoxs()
    {        
        String[] sbTexts = {"OFF", "ON"};
        fpsbox.setValueText(sbTexts);
        addObject(fpsbox, 467, 315);
    }

    private void BGM_speaker()
    {
        if(m.BGMisPlaying()) {
            addObject(new ON(), 585, 165);
            removeObjects(getObjects(OFF.class)); 
            BGMIsPlay = true;
        }    
        else if(!m.BGMisPlaying()){
            addObject(new OFF(), 585, 165);
            removeObjects(getObjects(ON.class)); 
            BGMIsPlay = false;
        }
    }

    private void CheckFPSstatus() 
    {
        if(FPSstatus && f.FPS_curstatus()) {
            fps_box fpsbox = new fps_box("Switch", true); 
            removeObjects(getObjects(fps_box.class)); 
            addObject(fpsbox, 467, 315); 
            addObject(new FPS(), 60, 15); 
        }
        if(!FPSstatus && !f.FPS_curstatus()) {
            fps_box fpsbox = new fps_box("Switch", false); 
            removeObjects(getObjects(FPS.class));
        }
        else {
            addObject(new FPS(), 60, 15); 
        }
    }

    private void CheckBGMvolume()
    {
        BGMvolume = m.getVolumeBGM();
        music_bar BGMbar = new music_bar("Volume", "%", BGMvolume, 100);
        removeObjects(getObjects(music_bar.class));  
        addObject(BGMbar, 395, 165);
        BGMvolume = BGMbar.getValue();
    }

    private static void FPSenabled() { // stored static tick value and status
        fps_box fpsbox = new fps_box("Switch", true); 
        FPSstatus = true;
    }

    private static void FPSdisabled() { // stored static tick value and status
        fps_box fpsbox = new fps_box("Switch", false); 
        FPSstatus = false;
    }

    public boolean BGM_status()
    {
        return BGMIsPlay;
    }

    public boolean FPS_status() 
    {
        return FPSstatus;
    }

    private void setFPS() {
        f.FPS_status(FPSstatus);
    }

    public void reset()
    {
        if(fpsbox.getState()) { 
            FPSdisabled();
            removeObjects(getObjects(FPS.class)); 
        } 
        if(!m.BGMisPlaying() || BGMbar.getValue() != 100 || m.getVolumeBGM() != 100){
            m.startBGM();
            m.setVolumeBGM(100);
            music_bar BGMbar = new music_bar("Volume", "%", 100, 100);
            removeObjects(getObjects(music_bar.class));  
            addObject(BGMbar, 395, 165);
            removeObjects(getObjects(OFF.class)); 
            addObject(new ON(), 585, 165);
        }
    }

}