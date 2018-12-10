


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author N. Kuijper
 */
public class Level1 extends World {

    private CollisionEngine ce;

    /**
     * Constructor for objects of class Level1.
     *
     */
    public Level1() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        this.setBackground("bg.png");

        int[][] map = {
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,7,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,12,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,-1,-1,-1,-1,-1,-1,-1,-1,-1,127,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,16,16,16,-1,-1,-1,-1,-1,61,-1},
{128,-1,-1,-1,-1,16,16,16,-1,-1,-1,128,-1,-1,-1,16,16,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,60,126},
{81,82,83,-1,-1,-1,-1,-1,-1,-1,16,16,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,16,16,16},
{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},
{90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90},
{90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90},
{90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90},
};

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();
        Boef boef = new Boef();

         addObject(new Coin(),1279,433);
         addObject(new Coin(),1592,492);
        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);
        //camera.follow(boef);
        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero,100, 550);
        addObject(boef,170, 580);
       /* addObject(new Enemy(), 330, 290);
        addObject(new Enemy(), 510, 290);
        addObject(new Enemy(), 690, 290);
        addObject(new Enemy(), 870, 290);
        addObject(new Enemy(), 1050, 290);
        addObject(new Enemy(), 1230, 290);
        addObject(new Enemy(), 1410, 290);
        addObject(new Enemy(), 1590, 290);
        addObject(new Enemy(), 1770, 290);
        addObject(new Enemy(), 1950, 290);
        addObject(new Enemy(), 2130, 290);
        addObject(new Enemy(), 1550, 1005);
        addObject(new Enemy(), 1650, 1005);
        addObject(new Enemy(), 1750, 1005);
        addObject(new Enemy(), 1850, 1005);
        addObject(new DeurOpSlot(), 1050, 1120);
        addObject(new DeurOpSlot(), 1050, 980);
        addObject(new DeurOpSlot(), 1050, 1010);*/

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);

        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        ce.addCollidingMover(boef);
        prepare();
    }

    @Override
    public void act() {
        ce.update();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Coin coin = new Coin();
        addObject(coin,449,508);
        Coin coin2 = new Coin();
        addObject(coin2,750,563);
        Coin coin3 = new Coin();
        addObject(coin3,1050,508);
        Coin coin4 = new Coin();
        addObject(coin4,106,425);
    }
}
