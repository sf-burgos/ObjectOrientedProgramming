
import java.awt.*;
import java.awt.geom.*;

/**
 * La clase linea permite dibujar lineas entre dos puntos 
 * 
 */

public class Line{
    public String color;
    private int x1,y1,x2,y2;
    private boolean isVisible;

    /**
     * Create a new line at default position 
     */
    public Line(int x1,int y1,int x2,int y2,int h,String col){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        color = col;
        isVisible = false;
    }
        /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){

        erase();
        isVisible = false;
        
    }
    
    /**
     * Draw the line with current specifications on screen.
     */
    public void draw(){
        if(isVisible) {
            int[] xpoints = { x1, x2, x2, x1};
            int[] ypoints = { y1, y2, y2+5, y1+5};
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 4));
            canvas.wait(10); 
            
        }
    }
    /** 
     * Erase the line 
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    

}