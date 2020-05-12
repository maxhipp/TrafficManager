import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.StackPane;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import UTIL.*;
import GRAPHICS.*;
/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * @author tresonic & maxx
 * @version 20200512
 */
public class Main extends Application
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Canvas canvas;
    private GraphicsContext gc;
    private Map map;
    
    public Vector2D mousepos = new Vector2D();
    public Vector2D viewpos = new Vector2D(0, 0);
    private double viewscale = 1;

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
        stage.setTitle("MapPanZoom");
        stage.show();
        
        map = new Map();
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if(keyEvent.getCode() == KeyCode.E) {
                        viewscale *= 1.01;
                        //Vector2D mid = new Vector2D(scene.getWidth()/2, scene.getHeight()/2);
                        //viewpos.add(new Vector2D(mid
                    }
                    
                    if(keyEvent.getCode() == KeyCode.Q) {
                        viewscale *= 0.99;
                        
                    }
                    
                    if(keyEvent.getCode() == KeyCode.W) {
                        viewpos.add(new Vector2D(0, -10));
                    }
                    if(keyEvent.getCode() == KeyCode.A) {
                        viewpos.add(new Vector2D(-10, 0));
                    }
                    if(keyEvent.getCode() == KeyCode.S) {
                        viewpos.add(new Vector2D(0, 10));
                    }
                    if(keyEvent.getCode() == KeyCode.D) {
                        viewpos.add(new Vector2D(10, 0));
                    }
                }
            });
        
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(mouseEvent.isPrimaryButtonDown()) {
                        map.setTile(new Vector2D(mouseEvent.getSceneX(), mouseEvent.getSceneY()), viewpos, viewscale, (byte)2);
                    }
                }
            });
            
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mousepos.set(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                }
            });
        AnimationTimer animator = new AnimationTimer()
            {
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
        map.draw(gc, viewpos, viewscale);
    }
    
}