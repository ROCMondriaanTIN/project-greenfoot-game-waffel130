import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class VeerTile extends Tile
{
    int frames=1;
    
    public VeerTile(String image,int width,int height)
    {
        super(image,width,height); 
        setImage("springboardUp.png");
    }
    
    public void act() 
    {
        for(Actor hero:getIntersectingObjects(Hero.class))
        {
                if(hero!=null)
                {
                    if(frames==1)
                    {
                    setImage("springboardDown.png");    
                    }
                   
                    if(frames==2)
                    {
                    setImage("springboardUp.png");   
                    frames=1;
                    return;
                    }
                    frames++;
                }
    }
    }    
}