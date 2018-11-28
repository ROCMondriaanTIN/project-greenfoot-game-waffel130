import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Coin extends Mover
{
    GreenfootImage coin1 = new GreenfootImage("coin1.png");
    GreenfootImage coin2 = new GreenfootImage("coin2.png");
    GreenfootImage coin3 = new GreenfootImage("coin3.png");
    GreenfootImage coin4 = new GreenfootImage("coin4.png");
    GreenfootImage coin5 = new GreenfootImage("coin5.png");
    GreenfootImage coin6 = new GreenfootImage("coin6.png");
    private int frame = 1;
    private int AninmatieSnelheid = 200;
    int coin;
    private int animatieTimer = 0;
    
    //public boolean isGepakt;
    
    // Coin(boolean isGepakt)
    //{
     //   this.isGepakt = isGepakt;
    //}
    
    /*public void CoinFlip()
    {
        if(frame == 1)
        {
            setImage("coin1.png");
            frame = 2;
        }
        else if(frame == 2)
        {
            setImage("coin2.png");
            frame = 3;
        }
        else if(frame == 3)
        {
            setImage("coin3.png");
            frame = 4;
        }
        else if(frame == 4)
        {
            setImage("coin4.png");
            frame = 5;
        }
        else if(frame == 5)
        {
            setImage("coin5.png");
            frame = 6;
        }
        else if(frame == 6)
        {
            setImage("coin6.png");
            frame = 1;
        }
    *///}
    public void act() 
    {
        animasi();
        if (animatieTimer % 1 == 0) 
            {
                animasi();
            }
                animatieTimer ++;
        
        //CoinFlip();
        //if(isGepakt==false)
        //{
         applyVelocity();
        //}
    }
    public void animasi()
    {
         if (frame == 1) 
            { 
             setImage(coin1);
             frame = 2;
             AninmatieSnelheid = 200;
            } 
            else if (frame == 2) 
            {
             setImage(coin2);
             frame = 3;
             AninmatieSnelheid = 200;
            } 
            else if (frame == 3) 
            { 
             setImage(coin3);
             frame = 4; 
             AninmatieSnelheid = 200;
            }
            else if (frame == 4) 
            { 
             setImage(coin4);
             frame = 5;
             AninmatieSnelheid = 200;
            }  
            else if (frame == 5) 
            { 
             setImage(coin5);
             frame = 6; 
             AninmatieSnelheid = 200;
            }
            else if (frame == 6) 
            { 
             setImage(coin6);
             frame = 1;
             AninmatieSnelheid = 200;
            }  
         }
    }
    
        

