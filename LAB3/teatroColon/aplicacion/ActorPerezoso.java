package aplicacion;
import java.awt.Color;
import java.util.ArrayList;


public class ActorPerezoso extends Actor 
{
    public ActorPerezoso(Teatro teatro, String name, int posicionx,int  posiciony){
        super (teatro, name, posicionx,posiciony);
        color=Color.green;
        palabras="!Perezoso!";
    }
  
    
    
    public void corte(){
        muevaBrazo('I','B'); 
        //muevaPierna('I','S');
        muevaBrazo('D','B'); 
        //muevaPierna('I','S');       
        palabras="¡aqui perezosos!";
        for (int i=0;i<4;i++){
            muevaPierna('I','S');
            muevaPierna('D','S');
        }
    }



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
        palabras="Soy " + this;
    }


    public String mensaje(){
        return  palabras;
    }
    /**
     * El actorPerezoso decide siempre descansa
     */
    public void decida(){
        corte();
   
    
 
}
}

