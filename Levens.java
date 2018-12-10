import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levens extends Actor
{
    int hartX = 60;
    
    Hart[] harten = {new Hart(),new Hart(),new Hart(),new Hart(),new Hart()};
    
    public void setLevens(int levens) {
        for (int i = 0; i < levens; i++) {
            getWorld().addObject(harten[i], hartX, 60);
            hartX = hartX + 60;
        }
        
        hartX = 60;
    }
    
    
    public void removeLeven(int levens) {
        getWorld().removeObject(harten[levens]);
     
    }
    
    public void act() 
    {
        
    }
}
