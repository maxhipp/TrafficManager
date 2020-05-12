package GRAPHICS;

import UTIL.*;
import javafx.scene.canvas.*;
/**
 * Beschreiben Sie hier die Klasse Tile.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Tile
{
    public Vector2D pos;
    public byte id;
    
    public Tile(byte id, double x, double y)
    {
        this.pos = new Vector2D(x, y);
        this.id = id;
    }
    
    public void draw(GraphicsContext gc, Vector2D viewpos, double viewscale) 
    {
        gc.save();
        gc.scale(viewscale, viewscale);
        gc.drawImage(Textures.textures[this.id], pos.x - viewpos.x, pos.y - viewpos.y);
        gc.restore();
    }
    
}
