import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Actor
{
    public void setCoins(int coins) {
        getWorld().addObject(new CoinHud(), 1150, 60);
        getWorld().showText("0", 1200, 60);
    }
    
    public void updateCoins(int coins) {
        getWorld().showText(Integer.toString(coins), 1200, 60);
    }
    
    public void act() 
    {
        
    }
}
