package aplicacion;
import java.awt.Color;
import java.util.ArrayList;

public class ActorNecio extends Actor
{
    boolean decisiones= true;
    int elNecio = 1;
    /**
     * Constructor for objects of class ActorNecio
     */
    public ActorNecio(Teatro teatro,String name,int posicionx, int posiciony){
        super(teatro,name,posicionx,posiciony);
        color=Color.BLACK;
        palabras="¡Hola!";
    }
    public void corte(){
    if (elNecio==3){
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
    muevase('S');   
    palabras="Soy " + this;
    decisiones=false;
    elNecio=1;
}
else{
super.corte();
elNecio+=1;
}
}



    public void actue(){
    if (elNecio==3){
        muevaBrazo('I','B'); 
        muevaPierna('I','P');
        muevaBrazo('D','B'); 
        muevaPierna('D','P');       
        palabras="";
        decisiones=true;
        elNecio=1;
    }
    else{
    super.actue();
    elNecio+=1;
}
}
    /**
     * Decide como actor necio cada 3 acciones 
     */
    public void decida(){
       if (elNecio==3){
       if (decisiones){
       corte(); 
       
       }
       else{
       actue();
       
    }
    elNecio=1;
   
    }
    else{
		super.decida();
    elNecio+=1;
    }
	}
	public String toString(){
		String cadena = "ActorNecio ";
		cadena = cadena + this.getPosicionX()+ " " + this.getPosicionY() + " " + this.getNombre() + "\n";
		return cadena;
	}
}
