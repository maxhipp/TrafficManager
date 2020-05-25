package CONTENT;


/**
 * Write a description of class Map here.
 *
 * @Max Hipp
 * @25.05.2020
 */
public class Map{
    private Tile map[][];
    private static int size = 64;

    public Map(){
        map = new Tile[128][128];
        for(int x=0; x<128; x++) {
            for(int y=0; y<128; y++) {
                map[y][x] = new Tile((byte)0, x*size, y*size);
            }
        } 
    }
}
