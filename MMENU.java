import UI.*;
/**
 * Write a description of class MMENU here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MMENU extends Window{
    public GAME game;
    private Button StartButton;
    public MMENU(){
        super("TrafficManager", 500, 500);
        Button StartButton = new Button(this,"Start",50,50,70,40){
        public void onClick(){
            closeWindow();
            game = new GAME("test",1000,750);
        }};
    }
}
