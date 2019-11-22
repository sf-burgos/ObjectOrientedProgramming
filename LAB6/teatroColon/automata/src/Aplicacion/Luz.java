package aplicacion;
import java.applet.*;
import java.awt.*;
import java.util.Random;
import java.io.Serializable;


public class Luz implements EnEscena, Serializable {
    public Color color;
    int posicionx;
    int posiciony;
    public Luz(int x,int y){
        posicionx = x;
        posiciony = y;
        color = Color.blue;        
    }
    public String forma(){
        return FORMAS[1];
    }
    public void corte(){
        color= Color.blue;
        
    } 
    public void actue(){
        color= Color.yellow;
        
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
