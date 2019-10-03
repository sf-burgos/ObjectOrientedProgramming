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
    public static ActorNecio homero  = null;
    public static ActorNecio bart  = null;
    public static ActorPerezoso eduard = null;
    public static ActorPerezoso bella = null;
    
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
        romeo = new Actor(this.teatro,"Romeo",50,10);
        julieta = new Actor(this.teatro,"Julieta",100,10);
        homero = new ActorNecio(this.teatro,"Homer",150,10);
        bart = new ActorNecio(this.teatro,"Homer",200,10);
        eduard = new ActorPerezoso(this.teatro,"Eduard",250,10);
        bella = new ActorPerezoso(this.teatro,"Bella",300,10);
        elementos.add(romeo);
        elementos.add(julieta);
        elementos.add(homero);
        elementos.add(bart);
        elementos.add(eduard);
        elementos.add(bella);

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
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).actue();
        }
    }

    
    public void corten(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).corte();
        }
    }    

    public void decidan(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).decida();
        }
    }  
    
}
