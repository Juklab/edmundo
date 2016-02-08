import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
public class CheckMem extends Actor
{
    public void CheckMemory()
    {          
       int mb = 1024*1024;
       Runtime runtime = Runtime.getRuntime();
       long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / mb;
       long freeMem =  runtime.freeMemory() / mb;
       long totalMem = runtime.totalMemory() / mb;
       long maxMem = runtime.maxMemory() / mb;
       System.out.println("##### Heap utilization statistics [MB] #####");
        //Print used memory
       System.out.println("Used Memory:"+ usedMem);
        //Print free memory
       System.out.println("Free Memory:" + freeMem);
        //Print total available memory
       System.out.println("Total Heap Memory:" + totalMem);
        //Print Maximum available memory
       System.out.println("Max Memory:" + maxMem);
       if (freeMem >= 30 && freeMem <= 50) {
        JOptionPane.showMessageDialog (null, "Your computer is low on memory, please close or restart all open programs. \n" + "Memory available: " + freeMem + " MB" + "   Total heap memory: " + totalMem + " MB", "Warning", JOptionPane.WARNING_MESSAGE);
       }
       else if (freeMem < 30) {
        JOptionPane.showMessageDialog (null, "Your computer is out of memory, the game will be terminated.", "Error", JOptionPane.ERROR_MESSAGE);
        Greenfoot.setWorld(new warning());
        Greenfoot.stop();
       }
    }
    public void act() {
    
    }
}
