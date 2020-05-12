package CONTENT;


/**
 * Aufbau des Straßensystems in Form eines Graphen (Knoten: Crossing; Kante: Street)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map{
    private int map[][];
    
    public Map(int size){
        count = 0;
        crossings = new Crossing[size];
        map = new int[size][size];
    }
    
    public void addCrossing(String name, int size){
        if ((count < crossings.length) && (crossingNumber(name) == -1)){
            crossings[count] = new Crossing(name, size);
            matrix[count][count] = 0;
            for (int i=0; i<count; i++){
                matrix[count][i] = -1;
                matrix[i][count] = -1;
            }
            count = count + 1;
        }
    }
    
    public int crossingNumber(String name){
        int x = -1;
        //Ermittlung der Nummer
        return x;
    }
}
