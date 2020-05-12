package CONTENT;


/**
 * Aufbau des Straßensystems in Form eines Graphen (Knoten: Crossing; Kante: Street)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map{
    private int currcr;
    private Crossing[] crossings;
    private int[][] matrix;
    
    public Map(int mapsize){
        currcr = 0;
        crossings = new Crossing[mapsize];
        matrix = new int[mapsize][mapsize];
    }
    
    public void addCrossing(String name, int size){
        if ((currcr < crossings.length) && (crossingNumber(name) == -1)){
            crossings[currcr] = new Crossing(name, size);
            matrix[currcr][currcr] = 0;
            for (int i=0; i<currcr; i++){
                matrix[currcr][i] = -1;
                matrix[i][currcr] = -1;
            }
            currcr = currcr + 1;
        }
    }
    
    public int crossingNumber(String name){
        int x = -1;
        //Ermittlung der Nummer
        return x;
    }
}
