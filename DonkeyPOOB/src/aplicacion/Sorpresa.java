package aplicacion;

import java.io.Serializable;

public abstract class Sorpresa extends Elemento implements Serializable {
	public Sorpresa (int x, int y) {
		super(x,y);
		
	
	}
	/**
	 * Aplica el poder de la sorpresa que impacta con Mario
	 * @param jugador Jugador que tendrá la sorpresa
	 */
	public abstract void aplicarPoder(Jugador jugador); 
	
	
}
