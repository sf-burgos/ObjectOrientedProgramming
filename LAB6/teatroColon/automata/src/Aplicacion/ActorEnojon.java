package aplicacion;
import java.awt.Color;
import java.util.ArrayList;


public class ActorEnojon  extends Actor 
{
        /**
     * creador del actor Enojon
     */
    public ActorEnojon (Teatro teatro, String name, int posicionx,int  posiciony){
        super (teatro, name, posicionx,posiciony);
        color=Color.black;
        palabras="!enojon!";
    }
  
    
        /**
     * al actor no le gusta que lo corten, por lo que se enoja, "cambia de colo a ROJO"
     */
    public void corte(){
        muevaBrazo('I','S'); 
        muevaPierna('I','S');
        muevaBrazo('D','S'); 
        muevaPierna('I','S');       
        palabras="¡no me gusta cortar!";
        color=Color.red;
        
    }


        /**
     * Actua con normalidad
     */
    public void actue(){
      
        if (getPosicionBrazo('I')==ABAJO && getPosicionBrazo('D')==ABAJO){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if  (getPosicionBrazo('I')==FRENTE){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if (getPosicionBrazo('I')==ARRIBA){
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
        }else if (getPosicionBrazo('D')==FRENTE){
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
        }else if (getPosicionBrazo('D')==ARRIBA){
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        }       
        muevase('P');
        color=Color.black;
        //palabras="Soy " + this;
    }

        /**
     * mensaje del actor enojon
     */
    public String mensaje(){
        return  palabras;
    }
    /**
     * El actorEnojon, le gusta que lo dejen decidir, por ello actua, ya que no le gusta que lo corten decide siempre descansa
     */
    public void decida(){
        actue();
	}
	
	public String toString(){
		String cadena = "ActorEnojon ";
		cadena = cadena + this.getPosicionX()+ " " + this.getPosicionY() + " " + this.getNombre() + "\n";
		return cadena;
		
	}
}

