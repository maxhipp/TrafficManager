package CONTENT;
/**
 * Write a description of class Street here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Street{
    private Crossing tocrossing;
    
    public Street(Crossing tocrossing){
        this.tocrossing = tocrossing;
    }
    public int returnToCrossing(){
        return tocrossing.returnID();
    }
}
