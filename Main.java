import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import UTIL.*;
import GRAPHICS.*;

/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * 
 * @author tresonic & maxx
 * @version 20200512
 */
public class Main extends Application
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Canvas canvas;
    private GraphicsContext gc;
    private TileView tileView;

    @Override
    public void start(Stage stage) throws Exception
    {
        StackPane root = new StackPane();
        canvas = new Canvas();
        gc = canvas.getGraphicsContext2D();
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
        root.getChildren().add(canvas);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TrafficManager");
        stage.show();
        
        MouseKeyEvent m = new MouseKeyEvent();
        root.addEventFilter(KeyEvent.KEY_PRESSED, m);
        tileView = new TileView(gc, scene);
            
        AnimationTimer animator = new AnimationTimer() {
                @Override
                public void handle(long arg0) {
                    loop(arg0);    
                }
            };

        animator.start();
    }
    
    public void loop(long delta)
    {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        tileView.draw();
    }
    
}