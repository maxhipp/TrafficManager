package GRAPHICS;

import javafx.scene.Scene;
import javafx.event.EventHandler;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import javafx.scene.paint.*;
import javafx.scene.canvas.*;

import UTIL.*;

/**
 * Beschreiben Sie hier die Klasse TileView.
 * 
 * @author tresonic
 * @version 20200513
 */

public class TileView
{
    public Vector2D mousepos = new Vector2D();
    public Vector2D viewpos = new Vector2D(0, 0);
    private double viewscale = 1;
    
    private Scene scene;
    private GraphicsContext gc;
    private GraphicMap map;
    
    /**
     * Konstruktor für Objekte der Klasse TileView
     */
    public TileView(GraphicsContext gc, Scene sc)
    {
        this.gc = gc;
        this.scene = sc;
        map = new GraphicMap();
        
        
        this.scene.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                if(scrollEvent.getDeltaY() > 0) {
                    Vector2D mouseBefore = util.screenToWorld(mousepos, viewpos, viewscale);
                    viewscale *= 1.05;
                    Vector2D mouseAfter = util.screenToWorld(mousepos, viewpos, viewscale);                        
                    viewpos.add(mouseBefore.getSubtracted(mouseAfter));    
                }
                if(scrollEvent.getDeltaY() < 0) {
                    Vector2D mouseBefore = util.screenToWorld(mousepos, viewpos, viewscale);
                    viewscale *= 0.95;
                    Vector2D mouseAfter = util.screenToWorld(mousepos, viewpos, viewscale);                        
                    viewpos.add(mouseBefore.getSubtracted(mouseAfter));    
                }
            }
        });
        
        this.scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if(keyEvent.getCode() == KeyCode.E) {
                        Vector2D mouseBefore = util.screenToWorld(mousepos, viewpos, viewscale);
                        viewscale *= 1.01;
                        Vector2D mouseAfter = util.screenToWorld(mousepos, viewpos, viewscale);                        
                        viewpos.add(mouseBefore.getSubtracted(mouseAfter));                                                
                    }
                    
                    if(keyEvent.getCode() == KeyCode.Q) {
                        Vector2D mouseBefore = util.screenToWorld(mousepos, viewpos, viewscale);
                        viewscale *= 0.99;
                        Vector2D mouseAfter = util.screenToWorld(mousepos, viewpos, viewscale);                        
                        viewpos.add(mouseBefore.getSubtracted(mouseAfter));                        
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
        
        this.scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(mouseEvent.isPrimaryButtonDown()) {
                        map.setTile(new Vector2D(mouseEvent.getSceneX(), mouseEvent.getSceneY()), viewpos, viewscale, (byte)2);
                    }
                }
            });
            
        this.scene.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mousepos.set(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                }
            });
            
        this.scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mousepos.set(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                    if(mouseEvent.isPrimaryButtonDown()) {
                        map.setTile(new Vector2D(mouseEvent.getSceneX(), mouseEvent.getSceneY()), viewpos, viewscale, (byte)2);
                    }
                }
            });
    }

    public void draw()
    {
        this.map.draw(this.gc, this.viewpos, this.viewscale);
        
        Vector2D mouseWorldPos = util.screenToWorld(this.mousepos, this.viewpos, this.viewscale);
        // get the world pos of the tile currently hovered over
        Vector2D selectedTileWorldPos = new Vector2D((int)mouseWorldPos.x/this.map.getSize()*this.map.getSize(), (int)mouseWorldPos.y/this.map.getSize()*this.map.getSize());
        // convert that to screen position
        Vector2D selectedTileScreenPos = util.worldToScreen(selectedTileWorldPos, viewpos, viewscale);
        // draw a white square with the size of a tile with at the screen position
        gc.setStroke(Color.WHITE);
        gc.strokeRect(selectedTileScreenPos.x, selectedTileScreenPos.y, this.map.getSize()*viewscale, this.map.getSize()*viewscale);
    }
}
