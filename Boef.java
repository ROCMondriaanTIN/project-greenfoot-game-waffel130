import java.util.*;
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Boef extends Mover {
    int frames=1;
    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private double speed=0.75;
    public boolean klaar=false;
    public boolean ready=false;
    public String actieveWereld="";

    public Boef(String actieveWereld) {
        super();
        setImage("bat1.png");
        walkRange = 7000;
        firstAct = true;
        speed = 1;
        this.actieveWereld=actieveWereld;
 
    }

    @Override
    public void act() {
        for(Actor hero:getObjectsInRange(10000000, Hero.class))
        {
            if(frames==1)
            {
                setImage("bat1.png");  
            }
            
            if(frames==2)
            {
                setImage("bat2.png");    
                frames=1;
            }
            frames++;
    }
        
        List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        //int xpos=myHero.x;
        //int ypos=myHero.y;
        int x= getX();
        int y = getY();
        int b=0;
        boolean dood=myHero.isDood;
        boolean ready=false;
        up(); 
        down();
        if(dood)
        {
        //setLocation((xpos+300),(ypos));   
        }
       
        
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = 4;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -2;
            x = xMax;          
        } else if (getX() <= xMin) {
            speed *= -2;
            x = xMin;
        }
    }
    public void up()
        {
            if(actieveWereld=="MyWorld4"||actieveWereld=="MyWorld2")
            {
                for(Actor d:getObjectsInRange (70,SpringTile.class))
                    {    
                    int s=getY();
                    s-=7;
                    int x= getX();
                    int y = getY();
                    setLocation(x,s) ; 
                    boolean klaar=true;
                   }  
                }
            else
            {
                for(Actor d:getObjectsInRange (70,SpringTile.class))
                {    
                int s=getY();
                s-=10;
                int x= getX();
                int y = getY();
                setLocation(x,s) ; 
                boolean klaar=true;
               } 
            }
            
            if(klaar)
            {
            ready=true;  
            klaar=false;
            }
    
    }
        public void down()
        {
             if(ready)
             {        
            int s=getY();
            int x= getX();
            s-=40;
            setLocation(x,s) ; 
            ready=false;
            
                 for(Actor d:getObjectsInRange (70,SpringTile.class))
                {    
                 s=getY();
                s+=10;
                 x= getX();
                setLocation(x,s) ;    
                }
            }
    
}
}
