import UI.*;
/**
 * Write a description of class GAME here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GAME{
    public GAME(String player, int x, int y){
        System.out.println("Building new game: " + player + " " + x + " " + y);
        new Window("TrafficManager: " + player, x, y);
        
    }
}
