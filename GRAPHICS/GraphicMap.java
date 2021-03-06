package GRAPHICS;
import CONTENT.*;
import UTIL.*;
import javafx.scene.image.Image;
import javafx.scene.canvas.*;
/**
 * Beschreiben Sie hier die Klasse Tile.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GraphicMap extends Map{
    private GraphicTile map[][];
    private static int size = 64;

    /**
     * Konstruktor für Objekte der Klasse Tile
     * 
     */
    public GraphicMap()
    {
        map = new GraphicTile[128][128];
        for(int x=0; x<128; x++) {
            for(int y=0; y<128; y++) {
                map[y][x] = new GraphicTile((byte)0, x*size, y*size);
            }
        } 
    }
    
    public void draw(GraphicsContext gc, Vector2D viewpos, double viewscale)
    {
        for(int x=0; x<128; x++) {
            for(int y=0; y<128; y++) {
                map[y][x].draw(gc, viewpos, viewscale);
            }
        }      
    }
    
    public void setTile(Vector2D clickpos, Vector2D viewpos, double viewscale, byte id) 
    {
        map[(int)((clickpos.y / viewscale + viewpos.y)/this.size)][(int)((clickpos.x / viewscale + viewpos.x)/this.size)].id = id;
    }
    

    public int getSize() {return this.size;}
        
}
