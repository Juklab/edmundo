import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.awt.FileDialog;
import java.awt.Frame;
//import java.net.URLClassLoader;
//import java.net.URL;
//import java.net.MalformedURLException;

public class Files
{
    public static File getFileToSaveWithEnding(String Ending,String FileDialogName)
    {
        //Make the file selector pop up
        FileDialog fileChooser = new FileDialog(new Frame(),FileDialogName,FileDialog.SAVE);
        fileChooser.setSize(300, 300);
        fileChooser.setVisible(true);

        try
        {
            String FileName = fileChooser.getFile();
            String[] FilePArr = FileName.split("\\.");
            if(!FilePArr[FilePArr.length-1].equals(Ending))
            {
                FileName+="."+Ending;
            }
            File FoundFile = new File(fileChooser.getDirectory()+FileName);
            return FoundFile;
        }
        catch(Exception e)
        {
            System.err.println("Error because: "+e.getMessage()); // e.printStackTrack();
        }
        return null;
    }

    public static File OpenFileWithNameEnding(String Ending,String FieldName)
    {
        //Make the file selector pop up
        FileDialog fileChooser = new FileDialog(new Frame(),FieldName,FileDialog.LOAD);
        fileChooser.setSize(300, 300);
        fileChooser.setVisible(true);

        try
        {
            String FileName = fileChooser.getFile();
            System.out.println(FileName);
            String[] FilePArr = FileName.split("\\.");
            if(!FilePArr[FilePArr.length-1].equals(Ending))
            {
                return null;
            }
            System.out.println(FileName); // print out current file name
            System.out.println(fileChooser.getDirectory());
            System.out.println(fileChooser.getDirectory()+FileName);
            File FoundFile = new File(fileChooser.getDirectory()+FileName);
            return FoundFile; 
        }
        catch(Exception e)
        {
            System.err.println("Error because: "+e.getMessage());
        }
        return null;
    }

    public static File OpenFile(String Name)
    {
        //Make the file selector pop up
        FileDialog fileChooser = new FileDialog(new Frame(),Name, FileDialog.LOAD);
        fileChooser.setSize(300, 300);
        fileChooser.setVisible(true);

        try
        {
            File FoundFile = new File(fileChooser.getDirectory()+fileChooser.getFile());
            return FoundFile;
        }
        catch(Exception e)
        {
            System.err.println("Malformed URL: "+e.getMessage());
        }
        return null;
    }

    public static File getFileToSave(String Name)
    {
        //Make the file selector pop up
        FileDialog fileChooser = new FileDialog(new Frame(),Name,FileDialog.SAVE);
        fileChooser.setSize(300, 300);
        fileChooser.setVisible(true);

        try
        {
            File FoundFile = new File(fileChooser.getDirectory()+fileChooser.getFile());
            return FoundFile;
        }
        catch(Exception e)
        {
            System.err.println("Error because: "+e.getMessage());
        }
        return null;
    }
  
}