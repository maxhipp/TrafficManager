package CONTENT;
import UTIL.*;

/**
 * Write a description of class Tile here.
 *
 * @Max Hipp
 * @25.05.2020
 */
public class Tile{
    public Vector2D pos;
    public byte id;
    public Tile(byte id, double x, double y){
        this.pos = new Vector2D(x, y);
        this.id = id;
    }
}
