package valley;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import shapes.*;
import shapes.Rectangle;
/** 
 * La clase Tarp nos permitira la creacion de lonas, dando como parametros las coordenadas en X y en Y
 */

public class Tarp
{
    // instance variables - replace the example below with your own
    private Line lona;
    private int[] puntoUno; 
    private int[] puntoDos;
    private int[] puntoUnoInicial; 
    private int[] puntoDosInicial;
    private float pendiente; 
    private float puntoCorte;
    private ArrayList<Puncture> huecos;

    
    //private ArrayList
    /**
     * Constructor for objects of class Tarp
     * @param lowerEnd y higherEnd Arreglos con un punto como coordenada isVisible es el atributo de visibilidad en pantalla
     */
    public Tarp(int[] lowerEnd ,int[] higherEnd,int h, boolean isVisible,String col){        
        puntoUnoInicial= lowerEnd;
        puntoDosInicial= higherEnd;
        if (lowerEnd[0]<higherEnd[0]){
            puntoUno=lowerEnd;
            puntoDos=higherEnd;
            puntoDos[0]=puntoDos[0]-1;
        }
        else{
        puntoUno=higherEnd;
        puntoDos=lowerEnd;
        puntoUno[0]=puntoUno[0]-1;
        }
        
        
        lona = new Line(lowerEnd[0],h-lowerEnd[1],higherEnd[0],h-higherEnd[1],h,col);
        pendiente = (float)(higherEnd[1]-lowerEnd[1])/(higherEnd[0]-lowerEnd[0]);
        puntoCorte = (float) lowerEnd[1]-(pendiente*lowerEnd[0]);  
        huecos = new ArrayList<Puncture>();
        if(isVisible){
            lona.makeVisible(); 
        }   
    }
    
    /**
     * La funcion makeVisible() hace visible el objeto de tipo lona 
     */
    
    public void makeVisible(){
        lona.makeVisible();
    }
    
    /**
     * La funcion makeInvisible() hace invisible el objeto de tipo lona  
     */
    public void makeInvisible(){
        lona.makeInvisible(); 
    }
    public int puntoMinimoY(){
        int minimo = 0;
        if(puntoUno[1] < puntoDos[1]){
            minimo = puntoUno[1];
        }else{
            minimo = puntoDos[1];
        }
        return minimo;
    }
    //Entrada básica con un cuadro de dialogo.



 // JOptionPane.showMessageDialog( null, mensaje, JOptionPane.INFORMATION_MESSAGE );


    public void hacerHueco(int tarp,int x,int h){
        int punto;
        Puncture hueco;
        punto =(int) (h-((pendiente*x) + puntoCorte));
        if (x >= this.getPuntoUno()[0] && x <= this.getPuntoDos()[0]){
            hueco = new Puncture(x,punto,true); 
            hueco.darLona(tarp);
            huecos.add(hueco);
        }else{
            JOptionPane.showMessageDialog(null, "posicion no valida para esta lona ");        }        
    }
    
    public void parcharHueco(int x){
        for(Puncture p: huecos){
            if(p.getXPos() == x){
                p.makeInvisible();
                huecos.remove(p);
            }
        }
    }
    
    public int[] getPuntoUno(){
        return puntoUno;
    }

    public int[] getPuntoDos(){
        return puntoDos;
    }
    
    public float getPuntoCorte (){
        return puntoCorte;
    }
    public float interX (float m,float m2, float b1, float b2){
         float intercX=(float) ((b2-b1)/(m2-m));
         return intercX;
    }

    public float getPendiente(){
        return pendiente;
    }
    
    public ArrayList<Puncture> getHuecos(){
        return huecos;
    }
    
    public int[] posXHuecos(){
        int[] huecosX = new int[huecos.size()];
        for (int i = 0; i<huecos.size(); i++){
            huecosX[i] = huecos.get(i).getXPos();
        }
        return huecosX;
    }
    /**
     * @param Tarp lona, int x, int y 
     * recibe una lona y un punto x y y y esta determina si en esta posicion existe un hueco 
     * @return boolean 
     */
    public boolean verificarHueco(int x, int y){
        //ArrayList<Puncture> huecos = new ArrayList <Puncture>();
        //huecos=lona.getHuecos();
        for (int i=0; i<huecos.size(); i++){
            if (x==huecos.get(i).getXPos() && y==huecos.get(i).getYPos()){
                return true;
             
            }         
        }
        return false; 
    }
    public String toStringCrear(){
        return "CTarp"+","+puntoUno[0]+","+puntoUno[1]+","+puntoDos[0]+","+puntoDos[1];
    }
    public String toStringBorrar(){
        return "BTarp"+","+puntoUno[0]+","+puntoUno[1]+","+puntoDos[0]+","+puntoDos[1];
    }
    public String toStringCrearHueco(int x){
        for(Puncture punto: huecos){
            if (punto.getXPos()==x){
                return punto.toStringCrear();
            }
        }
        return "";
    }
    public String toStringBorrarHueco(int x){
        for(Puncture punto: huecos){
            if (punto.getXPos()==x){
                return punto.toStringBorrar();
            }
        }
        return "";
    }
}