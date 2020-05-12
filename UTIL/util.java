package UTIL;


/**
* Beschreiben Sie hier die Klasse util.
* 
* @author (Ihr Name) 
* @version (eine Versionsnummer oder ein Datum)
*/
public class util
{
    public static Vector2D worldToScreen(Vector2D worldpos, Vector2D viewpos, double viewscale) 
    {
        double x = (worldpos.x - viewpos.x) * viewscale;
        double y = (worldpos.y - viewpos.y) * viewscale;
        return new Vector2D(x, y);
    }
    
    public static Vector2D screenToWorld(Vector2D screenpos, Vector2D viewpos, double viewscale) 
    {
        double x = screenpos.x / viewscale + viewpos.x;
        double y = screenpos.x / viewscale + viewpos.x;
        return new Vector2D(x, y);
    }
}
