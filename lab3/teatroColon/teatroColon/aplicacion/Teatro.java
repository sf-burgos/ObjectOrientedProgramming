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
    }

    
    public void corten(){
    }    

    public void decidan(){
    }  
    
}
