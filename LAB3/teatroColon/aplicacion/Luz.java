package aplicacion;
import java.applet.*;
import java.awt.*;
import java.util.Random;


public class Luz implements EnEscena {
    public Color color;
    int posicionx;
    int posiciony;
    public Luz(int x,int y){
        posicionx = x;
        posiciony = y;
        color = Color.yellow;        
    }
    public String forma(){
        return FORMAS[1];
    }
    public void corte(){     
        
    } 
    public void actue(){               
        
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
