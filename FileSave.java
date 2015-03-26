import java.io.*;
public class FileSave  
{
    public static void SaveFile(File SaveLocation,String[] TextToSave)
    {
        try
        {
            FileWriter fw = new FileWriter(SaveLocation);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i<TextToSave.length; i++)
            {
                bw.write(TextToSave[i]);
                bw.newLine();
            }
            bw.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
