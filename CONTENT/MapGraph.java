package CONTENT;
import java.util.ArrayList;

/**
 * Aufbau des Straßensystems in Form eines Graphen (Knoten: Crossing; Kante: Street)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapGraph{
    private ArrayList<Crossing> crossings = new ArrayList<Crossing>();
    
    public MapGraph(){
        
    }
    
    public void addCrossing(int id){
        crossings.add(crossings.size(), new Crossing(id));
    }
    public void addStreet(int fromid, int toid){
        
    }
}