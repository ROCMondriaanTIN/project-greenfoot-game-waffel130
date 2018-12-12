import greenfoot.*;

/**
 *
 * @author N. Kuijper
 */
public class Hero extends Mover {
    private int frame = 1;
    boolean keyBlue=false;
    boolean DeurOpSlot=false;
    private final double gravity;
    private final double acc;
    private final double drag;
    private int animatieTimer = 0;
    
    boolean isDood = false;
    int leven  = 0;
    int startX = 0;
    int startY = 0;
    
    int coin = 0;
    
    Coins coins;
    Levens levens;

    public Hero(int levens,int coins)
    {
        super();
        
        leven = levens;
        coin = coins;
        
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_walk00.png");
    }

    public boolean onGround1()
    {
        Actor underLeft = getOneObjectAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2, Tile.class);
        Actor underRight = getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Tile.class);
        Tile tile1 = (Tile) underLeft;
        Tile tile2 = (Tile) underRight;
        
        return (tile1 != null && tile1.isSolid) || (tile2 != null && tile2.isSolid);
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
        if (CollisionEngine.DEBUG == false) {
            handleInput();
        }
        
        if (levens == null) {
            levens = new Levens();
            getWorld().addObject(levens, -10, -10);
            
            levens.setLevens(leven);
        }
        
        if (coins == null) {
            coins = new Coins();
            getWorld().addObject(coins, -10, -10);
            
            coins.setCoins(coin);
        }
        
        // Zet de spawn locatie van de player
        if (startX == 0 && startY == 0) {
            startX = getX();
            startY = getY();
        }
        
        // Als de speler dood gaat zet de speler terug op de spawn locatie en haal er een leven af.
        // Als alle 3 de levens op zijn ga dan naar het gameover scherm.
        if (isDood) {
            if (leven == 1) {
                Greenfoot.setWorld(new Gameover());
            }
            
            leven--;
            
            
            
            levens.removeLeven(leven);
            
            isDood = false;
        }
        
        getCoin();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) 
           {
            velocityY = gravity;
        }
        applyVelocity();
        checkDoorCollision();
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
        
        for (Actor liquidWater : getIntersectingObjects(TileExtended.class)) {
            TileExtended tile = (TileExtended) liquidWater;
            if (tile != null && tile.type == "water") {
                // Zet eerst de player naar spawn locatie anders registreerd de code dat de player 2x
                // in de lava is gevallen.
                setLocation(startX, startY);
                isDood = true;
                break;
            }
        }
    }
    
    public void checkDoorCollision() {
        if (isTouching(Deur.class)) {
            Greenfoot.setWorld(new Level2());
        }
    }
    
    public int getCoin()
            {
                if (isTouching(Coin.class)) {
                    removeTouching(Coin.class);
                    coin++;
                    coins.updateCoins(coin);
                }
                return coin;
            }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space") && onGround1() == true) 
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
            animatieRight();
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
