
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startscherm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startscherm extends World
{
    /**
     * Constructor for objects of class Startscherm.
     * 
     */
    public Startscherm()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        prepare();
        
    }
    
    private void prepare ()
    {

        One one = new One();
        addObject(one,326,163);
        two two = new two();
        addObject(two,804,170);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            Greenfoot.setWorld(new Level1());
        }
        if(Greenfoot.isKeyDown("2"))
        {
            Greenfoot.setWorld(new Level2());
        }
    }

}
