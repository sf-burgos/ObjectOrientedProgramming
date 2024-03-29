package aplicacion;
import java.awt.Color;
import java.util.Random;

public interface EnEscena{
    String[] FORMAS = new String[]{"Persona", "Circulo", "Cuadrado"};
    
    Random r = new Random(1);
    
    int getPosicionX();
    int getPosicionY();
    Color getColor();
    /**
    * Realiza la accion actue segun el tipo de Actor:
    * Actor, ActorNecio, ActorPerezoso
    */
    void actue();
    /**
    * Realiza la accion corte segun el tipo de Actor
    * Actor, ActorNecio, ActorPerezoso
    */
    void corte();
    
    /**
     * Es una persona
     */
    default String forma(){
       return FORMAS[0];
    }
    
    /**
     * El mensaje es la representación cadena del objeto
     */
    default String mensaje(){
       return toString();
    }
    
    /**
     * Decide aleatoriamente la acción a tomar
     */
    default void decida(){
        if (r.nextBoolean()){
            actue();
        }else{
            corte();
        }
    }
    
}
