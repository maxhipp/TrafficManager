package CONTENT;
import java.util.ArrayList;

/**
 * Crossings sind die Knoten des Graphen
 *
 * @Max Hipp
 * @15.05.2020
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
    public void removeStreet(){
        
    }
}
