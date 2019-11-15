package aplicacion;
import java.applet.*;
import java.awt.*;
import java.util.Random;


public class Armario implements EnEscena {
    public Color color;
    int posicionx;
    int posiciony;
    
    public Armario(int x,int y){
        posicionx = x;
        posiciony = y;
        color = Color.gray;  
       
    }
    public String forma(){
        return FORMAS[2];
    }
    public void corte(){
        posicionx = 0;
        posiciony = 500;
        color = Color.gray; 
        
    
    } 
    public void actue(){
        posicionx = 570;
        posiciony = 500;
        color = Color.gray; 
    }
    public void decida(){
        color =Color.magenta;
       
        
    } 
    public Color getColor(){
        return color;
    } 
    public int getPosicionX(){
        return posicionx;
    }
    public int getPosicionY(){
        return posiciony;
    }
}