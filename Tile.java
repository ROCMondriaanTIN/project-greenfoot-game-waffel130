    
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Tile extends BasicTile {

    /**
     * Constructor of the tile. Creates a tile based on image, width and height
     *
     * @param image Path to the image file
     * @param width Width of the tile
     * @param heigth Height of the tile
     */
    public Tile(String image, int width, int heigth) {
        super(image, width, heigth);
    }
<<<<<<< HEAD
  
=======

>>>>>>> 4372fff5ea53a9c16ee13c8083969eac7aeee2f9
    /**
     * Constructor of the tile. Creates a tile based on image, width, height and
     * a tile type
     *
     * @param image Path to the image file
     * @param width Width of the tile
     * @param heigth Height of the tile
     * @param type
     */
    public Tile(String image, int width, int heigth, TileType type) {
        super(image, width, heigth, type);
    }
}
