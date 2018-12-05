
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Boef extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    
    boolean jump = true;

    public Boef() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("spider.png");
    }

    @Override
    public void act() {
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
    }
    
    public void handleInput() 
    {
        // if (Greenfoot.isKeyDown("w")) {
            // velocityY = -13;
        // }

        // if (Greenfoot.isKeyDown("a")) {
            // velocityX = -5;
        // } else if (Greenfoot.isKeyDown("d")) {
            // velocityX = 5;
        // }
        
        velocityX = 5;
        if(onGround() == false && jump == false){
            velocityY = -10;
            jump = true;
        } else if(onGround() == true) {
            jump = false;
        }
    }
    
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0,getImage().getHeight()/2, Tile.class);
        Tile tile = (Tile) under;
        return tile != null && tile.isSolid == true;
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
