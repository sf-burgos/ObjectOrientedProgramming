package aplicacion;
import java.util.*;


/**
 * @author ECI 2014
 * 
 */
/**
 * @author ECI
 * Constructor de Teatro
 */
public class Teatro{
    public static final int MAXIMO = 500;
    private static Teatro teatro = null;
    public static Actor romeo  = null;
    public static Actor julieta  = null;
    public static ActorNecio homero  = null;
    public static ActorNecio bart  = null;
    public static ActorPerezoso eduard = null;
    public static ActorPerezoso bella = null;
    public static Luz centralIzquierda = null;
    public static Luz centralDerecha = null;
    /**
     * Da el teatro que usan los actores 
     * @return Teatro teatro
     */
    public static Teatro demeTeatro() {
        if (teatro==null){
            teatro=new Teatro();
        }
        return teatro;
    }
    /**
     * Crea un nuevo Teatro 
     */
    private static void nuevoTeatro() {
        teatro=new Teatro();
    }   
    /**
     * @param Teatro d
     * cambia el teatros por el que se da por parametro 
     */
    public static void cambieTeatro(Teatro d) {
        teatro=d;
    }       


    private ArrayList<EnEscena> elementos;
    /**
     * Constructor de teatro, añadimos un arreglo de en escena que guardara
     * actores y luces 
     */
    private Teatro() {
        elementos= new ArrayList<EnEscena>();
    }
    /**
     * Se crean los actores y se añaden al ArrayList EnEscena 
     */
    public void algunosEnEscena(){
        romeo = new Actor(this.teatro,"Romeo",50,10);
        julieta = new Actor(this.teatro,"Julieta",100,10);
        homero = new ActorNecio(this.teatro,"Homer",150,10);
        bart = new ActorNecio(this.teatro,"Homer",200,10);
        eduard = new ActorPerezoso(this.teatro,"Eduard",250,10);
        bella = new ActorPerezoso(this.teatro,"Bella",300,10);
        centralIzquierda = new Luz(0,250);
        centralDerecha = new Luz(500,250);
        elementos.add(romeo);
        elementos.add(julieta);
        elementos.add(homero);
        elementos.add(bart);
        elementos.add(eduard);
        elementos.add(bella);
        elementos.add(centralIzquierda);
        elementos.add(centralDerecha);

    }  
    
    /**
     * @param int n 
     * Devuelve un objeto del arreglo EnEscena ya sea un actor o una luz 
     * @return EnEscena h
     */
    public EnEscena demeEnEscena(int n){
        EnEscena h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    /**
     * @param EnEscena e 
     * Agrega los elementos de tipo EnEscena al ArrayList
     */
    public void adicione(EnEscena e){
        elementos.add(e);
    }
    
    /**
     * Numero de elementos que existen en EnEscena 
     */
    public int numeroEnEscena(){
        return elementos.size();
    }
    
    
    /**
     * Recorre los elementos EnEscena y los pone a actuar
     */
    public void accion(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).actue();
        }
    }
    /**
     * Recorre los elementos EnEscena y ejecuta corte 
     */
    
    public void corten(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).corte();
        }
    }    
    /**
     * Recorre los elementos EnEscena y ejecuta decida 
     */
    public void decidan(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).decida();
        }
    }  
    
}
