import greenfoot.*;

/**
 *
 * @author N. Kuijper
 */
public class Hero extends Mover {
    private int frame = 1;
    public int leven=3;
    boolean keyBlue=false;
    boolean DeurOpSlot=false;
    private final double gravity;
    private final double acc;
    private final double drag;
    private int animatieTimer = 0;
    boolean isDood=false;
    
  
    

    public Hero() 
    {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_walk00.png");
    }
    public void checkObstacle()
    {
        Actor wall = getOneIntersectingObject(DeurOpSlot.class);
        if(wall != null)
        {
            move (-4);
        }   
    }
    public boolean onGround1()
    {
     Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, DeurOpSlot.class);
       return under != null;
    }
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getHeight()/2, Tile.class);
        Tile tile = (Tile) under;
        return tile != null && tile.isSolid == true;
    }
    public boolean touchingdDeurOpSlot()
    {
        if(keyBlue==true)
        {
            if(isTouching(DeurOpSlot.class)) 
            {
                removeTouching(DeurOpSlot.class);
                 DeurOpSlot=true;
            }
            
        }
        return DeurOpSlot;
    }    
    public void animatieRight()
    {
        if(frame == 1)
        {
            setImage("p1_walk01.png");
            frame = 2;
        }
        else if(frame == 2)
        {
            setImage("p1_walk02.png");
            frame = 3;
        }
        else if(frame == 3)
        {
            setImage("p1_walk03.png");
            frame = 4;
        }
        else if(frame == 4)
        {
            setImage("p1_walk04.png");
            frame = 5;
        }
        else if(frame == 5)
        {
            setImage("p1_walk05.png");
            frame = 6;
        }
        else if(frame == 6)
        {
            setImage("p1_walk06.png");
            frame = 7;
        }
        else if(frame == 7)
        {
            setImage("p1_walk07.png");
            frame = 8;
        }
        else if(frame == 8)
        {
            setImage("p1_walk08.png");
            frame = 9;
        }
        else if(frame == 9)
        {
            setImage("p1_walk09.png");
            frame = 10;
        }
        else if(frame == 10)
        {
            setImage("p1_walk10.png");
            frame = 11;
        }
        else if(frame == 11)
        {
            setImage("p1_walk11.png");
            frame = 1;
        }
    }
    public void animatieLeft()
    {
        if(frame == 1)
        {
            setImage("p1_walk010.png");
            frame = 2;
        }
        else if(frame == 2)
        {
            setImage("p1_walk020.png");
            frame = 3;
        }
        else if(frame == 3)
        {
            setImage("p1_walk030.png");
            frame = 4;
        }
        else if(frame == 4)
        {
            setImage("p1_walk040.png");
            frame = 5;
        }
        else if(frame == 5)
        {
            setImage("p1_walk050.png");
            frame = 6;
        }
        else if(frame == 6)
        {
            setImage("p1_walk060.png");
            frame = 7;
        }
        else if(frame == 7)
        {
            setImage("p1_walk070.png");
            frame = 8;
        }
        else if(frame == 8)
        {
            setImage("p1_walk080.png");
            frame = 9;
        }
        else if(frame == 9)
        {
            setImage("p1_walk090.png");
            frame = 10;
        }
        else if(frame == 10)
        {
            setImage("p1_walk100.png");
            frame = 11;
        }
        else if(frame == 11)
        {
            setImage("p1_walk110.png");
            frame = 1;
        }
    }

    @Override
    public void act() 
    {
       if(isDood)    
            {isDood=false;
            leven--;
            
       }
       if(CollisionEngine.DEBUG == false) {
           
        handleInput();
    }
        checkObstacle();
        touchingdDeurOpSlot();
        getCoin();
       // onGround1();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) 
           {
            velocityY = gravity;
       }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
        for (Actor liquidWater : getIntersectingObjects(TileExtended.class)) {
            TileExtended tile = (TileExtended) liquidWater;
            if (tile != null && tile.type == "water") {
                Greenfoot.setWorld(new Level1());
                break;
            }
        }
    }
    int coin;
    public int getCoin()
            {
                if (isTouching(Coin.class)) {
                    removeTouching(Coin.class);
                    coin ++;
                }
                return coin;
            }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space") && onGround() == true) 
        {
            velocityY = -10;
            setImage("p1_jump.png");
             
        } else setImage ("p1_walk00.png");

        if (Greenfoot.isKeyDown("left")) 
        {
            velocityX = -5;
            animatieLeft();
        } else if (Greenfoot.isKeyDown("right")) 
        {
            velocityX = 5;
            //if (animatieTimer % 3 == 0) 
            //{
                animatieRight();
            //}
             //   animatieTimer ++;
        }
        if (Greenfoot.isKeyDown("down")){
            
            velocityY = 2 ;
            setImage("p1_duck.png");
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

}
