import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coin extends Mover
{
    // Define the MAX variables, these variables doesn't change
    // (These are common variables you will use in your script)
    public int MAX_IMAGES = 5;
    public int MAX_ANIMATION_SPEED = 4;
    
    // Define dynamic variables, these variables will change through your script.
    private int frame = 0;
    private int animationSpeed = 0;
    
    // This will run every game tick (depends on how fast your game is set(FPS))
    public void act() 
    {
        animationSpeed++;
        Animator();
        applyVelocity();
    }

    // Animate the coin
    private void Animator () {
        setImage("coin_"+frame+".png");
        
        if (animationSpeed > MAX_ANIMATION_SPEED) {
            animationSpeed = 0;
            
            frame++;
            if (frame > MAX_IMAGES) {
                frame = 0;
            }
        }
    }
}