package aplicacion;

import java.awt.Color;

public class ActorNecio extends Actor{
    private Teatro teatro;  
    protected String palabras;


	public ActorNecio(Teatro teatro,String name,int posicionx, int posiciony){
	    super(teatro,name,posicionx,posiciony);
	    
		color=Color.BLACK;
		palabras="¡Hola!";
	}
	
	
 	

 
}
	
	