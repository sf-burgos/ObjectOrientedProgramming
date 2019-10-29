package valley;


import java.util.ArrayList;
import java.util.Arrays;

import shapes.*;
import shapes.Rectangle;

public class Gota
{
    boolean flagRain;
    Rectangle rain;  
    String color;
    int xPosition;
    int yPosition;
    /**
     * Constructor for objects of class Rain
     */
     //public Rectangle(int newHeight, int newWidth, int newXPosition, int newYPosition,String newColor ){
    public Gota(int x, int y){        
        rain = new  Rectangle (1,1,x,y,"blue"); 
        xPosition=x;
        yPosition=y;
        rain.changeColor("blue");
        flagRain=true;
        rain.makeVisible();   
      
    }   
    public void changeColor(String color){
        this.color=color; 
        rain.changeColor(color);
        rain.makeVisible();
        
    }
    public void makeInvisible(){
        rain.makeInvisible();
    }
    public int getXPosition(){
        return xPosition;
    }
    

}
