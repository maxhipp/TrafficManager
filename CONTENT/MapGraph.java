package CONTENT;
import java.util.ArrayList;

/**
 * Heimat der Adjazenzliste des Mapgraphen
 *
 * @Max Hipp
 * @15.05.2020
 */
public class MapGraph{
    private ArrayList<Crossing> crossings = new ArrayList<Crossing>();

    public MapGraph(){

    }

    /**
     * fügt eine neue Crosing hinzu
     */
    public void addCrossing(int id){
        crossings.add(crossings.size(), new Crossing(id));
    }

    /**
     * fügt eine Street (Kante) zwischen zwei Crossings (Knoten) hinzu
     */
    public void addStreet(int fromid, int toid){
        Crossing fromCr = null;
        Crossing toCr = null;

        for(int i = 0; i < crossings.size(); i++){
            if(fromid == (crossings.get(i)).returnID()){
                fromCr = crossings.get(i);
                System.out.println("Success!");
                for(int j = 0; j < crossings.size(); j++){
                    if(toid == (crossings.get(j)).returnID()){
                        toCr = crossings.get(j);
                        System.out.println("Success!");
                        break;
                    }
                    else if(j == crossings.size()){
                        toCr = null;
                        System.out.println("Crossing 2 not found");
                    }
                }
                break;
            }
            else if(i == crossings.size()){
                fromCr = null;
                System.out.println("Crossing 1 not found");
            }
        }

        if (toCr != null && fromCr != null){
            fromCr.addStreet(toCr);
            toCr.addStreet(fromCr);
            System.out.println("Success!");
        }
        else{
            System.out.println("At least 1 crossing could not be found!");
        }
    }
    
    public void removeCrossing(){
        
    }
    
    public void removeStreet(){
        
    }
}