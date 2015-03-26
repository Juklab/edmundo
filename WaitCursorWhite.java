import greenfoot.*;
import greenfoot.core.WorldHandler;
import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
public abstract class WaitCursorWhite
{
    private static GreenfootImage CursorImage=new GreenfootImage("cursors/wait_white.png");
    private static Point MousePoint=new Point(0,0);
    private static JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
    private static Cursor cursor;
    private static Toolkit Tk = Toolkit.getDefaultToolkit();
    public static void setImage()
    {
         Panel.setCursor(Tk.createCustomCursor(CursorImage.getAwtImage(),MousePoint,"Somehow"));
    }
}

