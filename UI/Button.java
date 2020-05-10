package UI;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Write a description of class Button here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Button extends JButton{
    private Window window;
    public Button(Window window, String caption, int posx, int posy, int x, int y){
        super();
        this.window = window;
        setBounds(posx,posy,x,y);
        setText(caption);
        window.panel.add(this);
        setEnabled(true);        
        setVisible(true);
        addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    onClick();
                }
            });
    }
    
    public abstract void onClick();
}
