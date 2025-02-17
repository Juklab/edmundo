import greenfoot.*;
public class bg_animate extends Actor
{
    private   int     timer; // Variable for method to use when using timeter method.
    protected boolean pass;
    private   boolean fadeInpass      = true;
    private   boolean increseSizepass = true;
    private   int     number          = 0;
    private   boolean change          = true;
    private   boolean fade            = true;
    private   int     scrollSpeed     = 5;
    private   int transparency = 255;
    private   GreenfootImage bgImage;
    private   GreenfootImage scrollingImage;
    private   int            scrollPosition;
    private String[] animated = {"gui/mainmenu/a.png","gui/mainmenu/b.png","gui/mainmenu/c.png","gui/mainmenu/d.png"};
    public void act() 
    {
      imageChange(7,5,animated);
    }    
    public void timeter(int time){
        pass = false;
        timer++;
        if(timer<time) return;
        pass = true;
        timer= 0;
    }
    public void increaseSize(int timedelay,int smooth,int endSize,String[] picture){
        if(increseSizepass==true){
            timeter(timedelay);
            if(pass==true){
                getImage().scale(getImage().getWidth()+smooth,getImage().getHeight()+smooth);
                if(getImage().getWidth()>=endSize||getImage().getHeight()>=endSize){
                    increseSizepass=false;   
                }
            }
        }
    }
    public void fadeInImage(int delay){
        timeter(delay);
        if(fadeInpass==true){
            if(pass==true){
                getImage().setTransparency(getImage().getTransparency()+delay);
                if(getImage().getTransparency()>=200){
                    fadeInpass =false;    
                }
            }
        }
    }  
    public void fadeOutImage(int timedelay,int smooth){
        timeter(timedelay);
        if(pass==true){
            getImage().setTransparency(getImage().getTransparency()-smooth);
            if(getImage().getTransparency()<=100){
                getWorld().removeObject(this);    
            }
        }
     }

     public void imageChange(int timedelay,int smooth,String[] picture){
        timeter(timedelay);
        if(pass==true){

            if(change==true){
                setImage(picture[number]);
                getImage().setTransparency(0);
                number++;
                change=false;
                if(number >= picture.length-1){
                    number=0;
                }
            }

            if(fade==true ){

                if(getImage().getTransparency()<=250){
                    getImage().setTransparency(getImage().getTransparency()+smooth); 

                }else{ 
                    fade=false;
                }
            }else if(fade==false ){

                if(getImage().getTransparency()>= 10){
                    getImage().setTransparency(getImage().getTransparency()-smooth);

                }else {
                    change=true;
                    fade=true;
                }
            }

        }

    }

}

