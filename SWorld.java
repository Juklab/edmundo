import greenfoot.*;

import java.util.List;
import java.util.ArrayList;

/**
 * SWorld class is a super-class for a scrolling world (horizontal, vertical, scroll-width).<br><br>
 * Author: Juk<br>Version: 2015<br><br>
 * <h2 style="color: lime;">To implement this super-class:</h2>
 * <img src="..\images\characters\player\troll_dancing.gif">
 * <l><li>(1) create a sub-class of this class</li>
 * <li>(2) use a <i>super(....)</i> call to one of the constructors in this class</li>
 * <li>(3) create the main actor (one that always stays in view) and call the <i>setMainActor</i> method</li>
 * <li>(4) (optional) set a scrolling background image using a call to <i>setScrollingBackground</i> or <i>fillScrollingBackground</i></li></l><br>
 * NOTE: the order of steps above is very important<br><br>
 * There are two methods to add other objects into the world:
 * <l><li>the standard method <i>addObject(Actor, int, int)</i> can be used to add a scrollable actor into the world</li>
 * <li>a secondary method <i>addObject(Actor, int, int, boolean)</i> which is equivalent to the standard method, except
 * that the boolean will indicate the scrollable state of the object.  When adding scrolling objects into the world,
 * use scrolling coordinates; when adding non-scrolling objects, use world coordinates.</li></l>
 *
 * SPECIAL NOTE: if you decide to override the 'act' method of this class with an 'act' method in your sub-world, you will
 * need to follow the format below to run the scrolling of the scenario:
 * 
 * <pre>        public void act()
 *        {
 *            // possibly some code here      
 *            super.act();
 *            // possibly some more code here
 *        }<pre>
 */
public class SWorld extends World
{
    private int scrollingWidth, scrollingHeight; // limits for main actor within universal coordinates
    private int actorMinX, actorMaxX, actorMinY, actorMaxY; // limits for main actor within world coordinates
    private int scrolledX, scrolledY; // initial scrolled amount
    private int scrollType; // indicates scrolling directions (0=none, 1=horizontal, 2=vertical, 3=both)
    Actor mainActor = null; // the actor that always stays visible
    private List<Actor>genActors=new ArrayList(); // lists all generic scrolling actor objects
    private GreenfootImage background = null;
    

    public SWorld(int wide, int high, int cellSize, int scrollWide, int scrollHigh)
    {
        super(cellSize==1?wide:(wide/2)*2+1, cellSize==1?high:(high/2)*2+1, cellSize, false);
        scrollType=(scrollWide>wide?1:0)+(scrollHigh>high?2:0);
        scrollingWidth=scrollType%2==1?scrollWide:wide;
        scrollingHeight=scrollType/2==1?scrollHigh:high;
    }
    
  
    public SWorld(int wide, int high, int cellSize, int scrollWide)
    {
        this(wide, high, cellSize, scrollWide, high);
    }
    
 
    public void addMainActor(Actor main, int xLoc, int yLoc, int xRange, int yRange)
    {
        if (main==null)
        {
            System.out.println("A main actor MUST be supplied.");
            System.out.println("");
            return;
        }
        super.addObject(main, xLoc-scrolledX, yLoc-scrolledY);
        mainActor = main;
        xRange=(int)Math.min(xRange, getWidth());
        yRange=(int)Math.min(yRange, getHeight());
        actorMinX=getWidth()/2-xRange/2;
        actorMaxX=getWidth()/2+xRange/2;
        actorMinY=getHeight()/2-yRange/2;
        actorMaxY=getHeight()/2+yRange/2;
        act();
    }
    
 
    public void setScrollingBackground(GreenfootImage scrollingBackground)    
    {
        if(mainActor==null)
        {
            System.out.println("'setMainActor' MUST be called prior to calling 'setScrollingBackground'.");
            System.out.println("");
            return;
        }
        background = new GreenfootImage(scrollingBackground);
        background.scale(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
        scrollBackground();
    }
    

    public void fillScrollingBackground(GreenfootImage fillImage)
    {
        if(mainActor==null)
        {
            System.out.println("'setMainActor' MUST be called prior to calling 'fillScrollingBackground'.");
            System.out.println("");
            return;
        }
        if (fillImage.getWidth()<getWidth() && fillImage.getHeight()<getHeight())
        {
            setBackground(new GreenfootImage(fillImage));
            fillImage = getBackground();
        }
        World world = new World(scrollingWidth*getCellSize(), scrollingHeight*getCellSize(), 1){};
        world.setBackground(fillImage);
        background = new GreenfootImage(world.getBackground());
        scrollBackground();
    }
        
  
    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller)
    {
        if (!scroller)
        {
            super.addObject(obj, xLoc, yLoc);
            if (obj == mainActor) act();
            return;
        }
        super.addObject(obj, xLoc-scrolledX, yLoc-scrolledY);
        genActors.add(obj);
    }
    

    public void addObject(Actor obj, int xLoc, int yLoc)
    {
        addObject(obj, xLoc, yLoc, true);
    }
    
    /**
     * Removes an object from the world, re-defining fields as neccessary
     *
     * @param obj the object to be removed from the world
     */
    public void removeObject(Actor obj)
    {
        if(obj==null)return;
        if(obj.equals(mainActor))mainActor=null;
        else genActors.remove(obj);
        super.removeObject(obj);
    }
    
    /**
     * Removes a collection of objects from the world, calling <i>removeObject(Actor)</i> for each one in the list
     *
     * @param objs the collection or list of objects to be removed from the world
     */
    public void removeObjects(List<Actor>objs)
    {
        for(Actor obj:objs)removeObject(obj);
    }
  
    /**
     * Runs the scrolling.
     */
    public void act()
    {
        scrollObjects();
        scrollBackground();
    }
    
    /**
     * Scrolls the background image.
     */
    private void scrollBackground()
    {
        if (background==null) return;
        int c = getCellSize();
        getBackground().drawImage(background, -scrolledX*c, -scrolledY*c);
    }
  
    private void scrollObjects()
    {
        if (mainActor==null) return;
        // determine how far the main actor is outside its standard window limits
        int dx=0, dy=0;
        if(mainActor.getX()<actorMinX) dx=actorMinX-mainActor.getX();
        if(mainActor.getX()>actorMaxX) dx=actorMaxX-mainActor.getX();
        if(mainActor.getY()<actorMinY) dy=actorMinY-mainActor.getY();
        if(mainActor.getY()>actorMaxY) dy=actorMaxY-mainActor.getY();
        if(dx==0 && dy==0) return; // not outside window limits
        // ** outside standard window limits **
        int dxSum = dx, dySum = dy; // hold changes in scroll amount
        scrolledX-=dx; scrolledY-=dy;// track scroll amount
        // move main actor back within standard window limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        // determine how far the background is inside the world limits
        dx=0; dy=0;
        if(scrolledX > scrollingWidth-getWidth()) dx=scrolledX-(scrollingWidth-getWidth());
        if(scrolledX < 0) dx=scrolledX;
        if(scrolledY > scrollingHeight-getHeight()) dy=scrolledY-(scrollingHeight-getHeight());
        if(scrolledY < 0) dy=scrolledY;
        // ** background does not completely cover world limits
        dxSum+=dx; dySum+=dy; // keep running sum of changes in scroll amount
        scrolledX-=dx; scrolledY-=dy; // adjust scroll amount
        // move all objects so background covers the world
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        for(Object obj : genActors)
        {
            Actor actor=(Actor)obj;
            actor.setLocation(actor.getX()+dxSum, actor.getY()+dySum);
        }
        // determine how far main actor is outside universal limits
        dx=0; dy=0;
        if(mainActor.getX() < 0) dx=0-mainActor.getX();
        if(mainActor.getX() > getWidth()-1) dx=(getWidth()-1)-mainActor.getX();
        if(mainActor.getY() < 0) dy=0-mainActor.getY();
        if(mainActor.getY() > getHeight()-1) dy=(getHeight()-1)-mainActor.getY();
        if(dx==0 && dy==0) return;
        // ** outside universal limits
        // move main actor back within world limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
    }
    
    public int getUnivX(int worldX)
    {
        return (scrollingWidth-getWidth())/2+worldX+scrolledX;
    }
    
    public int getUnivY(int worldY)
    {
        return (scrollingHeight-getHeight())/2+worldY+scrolledY;
    }

    public int getScrollingWidth()
    {
        return scrollingWidth;
    }
 
    public int getScrollingHeight()
    {
        return scrollingHeight;
    }
}
