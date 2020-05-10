package UI;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
/**
 * Write a description of class Window here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Window extends JFrame{
    JPanel panel;
    public Window(String name, int x, int y){
        System.out.println("new window: " + name + " " + x + " " + y);
        this.setSize(x,y);
        this.setTitle(name);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(x,y));
        panel.setBackground(new Color(255,255,255));
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void closeWindow(){
        dispose();
    }
}
