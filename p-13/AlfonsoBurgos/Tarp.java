import java.util.ArrayList;
/** 
 * La clase Tarp nos permitira la creacion de lonas, dando como parametros las coordenadas en X y en Y
 */

public class Tarp

{
    // instance variables - replace the example below with your own
    private Line lona;
    private double longitud; 
    private int[] puntoUno; 
    private int[] puntoDos;    
    private float pendiente; 
    private float puntoCorte;
    private ArrayList<Puncture> huecos;
    //private ArrayList
    /**
     * Constructor for objects of class Tarp
     * @param lowerEnd y higherEnd Arreglos con un punto como coordenada isVisible es el atributo de visibilidad en pantalla
     */
    public Tarp(int[] lowerEnd ,int[] higherEnd,int h, boolean isVisible,String col){
        puntoUno= lowerEnd;
        puntoDos= higherEnd;
        lona = new Line(lowerEnd[0],h-lowerEnd[1],higherEnd[0],h-higherEnd[1],h,col);
        pendiente = (float)(higherEnd[1]-lowerEnd[1])/(higherEnd[0]-lowerEnd[0]);
        puntoCorte = (float) lowerEnd[1]-(pendiente*lowerEnd[0]);  
        huecos = new ArrayList<Puncture>();
        if(isVisible){
            lona.makeVisible(); 
        }   
        longitud = Math.pow((Math.pow((higherEnd[0]-lowerEnd[0]),2)+Math.pow((higherEnd[1]-lowerEnd[1]),2)),(0.5));
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
    /**
     * Calcula la longitud de la lona 
     * @return Longitud de la lona 
     */
    public double getLongitud(){
        return longitud;
    }
    
    public void hacerHueco(int x,int h){
        int punto;
        Puncture hueco;
        punto =(int) (h-((pendiente*x) + puntoCorte));
        if (x >= this.getPuntoUno()[0] && x <= this.getPuntoDos()[0]){
            hueco = new Puncture(x,punto,true);
            huecos.add(hueco);
        }else{
            System.out.println("Posicion no valida para esta lona"); 
        }        
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
    
        


}
