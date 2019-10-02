package aplicacion;
import java.util.*;


/**
 * @author ECI 2014
 * 
 */
/**
 * @author ECI
 *
 */
public class Teatro{
    public static final int MAXIMO = 500;
    private static Teatro teatro = null;
    public static Actor romeo  = null;
    public static Actor julieta  = null;
    public static ActorNecio homero = null;
    public static ActorNecio bart = null;
    
    public static Teatro demeTeatro() {
        if (teatro==null){
            teatro=new Teatro();
        }
        return teatro;
    }
    
    private static void nuevoTeatro() {
        teatro=new Teatro();
    }   
    
    public static void cambieTeatro(Teatro d) {
        teatro=d;
    }       


    private ArrayList<EnEscena> elementos;
    
    private Teatro() {
        elementos= new ArrayList<EnEscena>();
    }
    
    public void algunosEnEscena(){ 
        romeo = new Actor(this.teatro,"Romeo",10,100);
        julieta = new Actor(this.teatro,"Julieta",10,200);
        homero = new ActorNecio(this.teatro,"Homero",10,300);
        bart = new ActorNecio(this.teatro,"Bart",100,400);

    }  
    
    
    public EnEscena demeEnEscena(int n){
        EnEscena h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    
    public void adicione(EnEscena e){
	    elementos.add(e);
    }
	
    public int numeroEnEscena(){
        return elementos.size();
    }
    
    
    
    public void accion(){
        adicione(romeo); adicione(julieta); adicione(homero); adicione(bart); 
        homero.corte();
        bart.corte();
        romeo.actue();
        julieta.actue();
        
    }

    
    public void corten(){
        bart.actue();
        homero.actue();
        romeo.corte();
        julieta.corte();
    }    

    public void decidan(){
        romeo.decida();
        julieta.decida(); 
    }  
    
}
