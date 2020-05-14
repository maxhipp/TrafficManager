package CONTENT;
import java.util.ArrayList;

/**
 * Crossings sind die Knoten des Graphen
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Crossing{
    private int id;
    private ArrayList<Street> streets = new ArrayList<Street>();
    
    public Crossing(int id){
        this. id = id;
    }
    
    public int returnID(){
        return id;
    }
    public void addStreet(Crossing tocrossing){
        streets.add(new Street(tocrossing));
    }
}
