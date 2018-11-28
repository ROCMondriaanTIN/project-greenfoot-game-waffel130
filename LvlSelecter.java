import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LvlSelecter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LvlSelecter extends World
{

    /**
     * Constructor for objects of class LvlSelecter.
     * 
     */
    public LvlSelecter()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1620, 880, 1, false);
    }
    
    public void act()
    {
    if(Greenfoot.isKeyDown("1"));
    Greenfoot.setWorld(new Level1());
    }
}
