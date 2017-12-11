import greenfoot.*;
public class TextField extends Actor
{
    private String[] Text;
    private int Scroll=0;
    public TextField()
    {
        Text = new String[]{
            "Please enter your text here:",
            "",
            "You can delete the text with \"backspace\"",
            "",
            "and to start a new line, press \"enter\"",
            "",
            "You can although scroll up and down, if the text is longer than the field, by scrolling with the mouse wheel, or by pressing the arrow keys..."};
        UpdateImage();    
    }

    public void act()
    {
        UpdateScroll();
        checkInput();
        UpdateImage();
    }

    private void UpdateScroll()
    {
        //Scroll+=world.getMouseScroll()*10;
        if(Greenfoot.isKeyDown("up"))
            Scroll-=10;
        if(Greenfoot.isKeyDown("down"))
            Scroll+=10;
        if(Scroll<=0)
        {
            Scroll=0;
            return;
        }
    }

    public void setText(String[] newText)
    {
        this.Text=newText;
        UpdateImage();
    }

    public String[] getText()
    {
        return Text;
    }

    private void checkInput()
    {
        String key = Greenfoot.getKey();
        if(key==null)
            return;
        if(key.equals("enter"))
        {
            Text = addToArray(Text,"");
            Scroll+=30;
            return;
        }
        if(key.equals("backspace"))
        {
            if(Text[Text.length-1].length()>0)
                Text[Text.length-1] = removeLastLetter(Text[Text.length-1]);
            else
                Text=removeLast(Text);
            return;
        }
        if(key.equals("shift") || key.equals("up") || key.equals("down"))
            return;
        if(key.equals("space"))
            key=" ";
        Text[Text.length-1]+=key;
    }

    private String removeLastLetter(String Str)
    {
        char[] chars = Str.toCharArray();
        Str="";
        for(int i=0; i<chars.length-1;i++)
            Str+=chars[i];
        return Str;
    }

    private String[] removeLast(String[] Arr)
    {
        if(Arr.length==1)
            return new String[]{""};
        String[] newArr = new String[Arr.length-1];
        for(int i=0; i<newArr.length; i++)
            newArr[i]=Arr[i];
        return newArr;
    }

    public static String[] addToArray(String[] Arr,String ToAdd)
    {
        String[] newArr = new String[Arr.length+1];
        for(int i=0; i<Arr.length; i++)
            newArr[i]=Arr[i];
        newArr[Arr.length]=ToAdd;
        return newArr;
    }

    public void UpdateImage()
    {
        GreenfootImage i1,i2,i3 = Picture.getTextWithMaxWidth(Text[0],500,30,Color.BLACK,Color.WHITE);
        for(int i=1; i<Text.length; i++)
        {
            i2 = Picture.getTextWithMaxWidth(Text[i],500,30,Color.BLACK,Color.WHITE);
            i1 = new GreenfootImage(598,i2.getHeight()+i3.getHeight());
            i1.drawImage(i3,0,0);
            i1.drawImage(i2,0,i3.getHeight());
            i3=i1;
        }
        i1=new GreenfootImage(598,298);
        if(Scroll>i3.getHeight()-298)
            Scroll=i3.getHeight()-298;
        if(i3.getHeight()<298)
            Scroll=0;
        i1.drawImage(i3,0,-Scroll);
        setImage(i1);
    }
}