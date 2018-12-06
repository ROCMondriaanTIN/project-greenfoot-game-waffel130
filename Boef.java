
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Boef extends Mover {

    private final double gravity;
   // public int MAX_IMAGES = 1;
   // public int MAX_ANIMATION_SPEED = 2;
    private final double acc;
    private final double drag;
    
    boolean jump = true;
   // private int frame = 0;
   // private int animationSpeed = 0;

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
       // animationSpeed++;
      //  Animator();
      //  applyVelocity();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
    }
    
    public void handleInput() 
    {
        velocityX = 5;
        if(onGround() == false && jump == false){
            velocityY = -10;
            jump = true;
        } else if(onGround() == true) {
            jump = false;
        }
    }
    //private void Animator () {
    //    setImage("spider_"+frame+".png");
     // /  
      //  if (animationSpeed > MAX_ANIMATION_SPEED) {
       //     animationSpeed = 0;
       //     
        //    frame++;
        //    if (frame > MAX_IMAGES) {
        //        frame = 0;
        //    }
       // }
   // }
    
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
