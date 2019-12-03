package aplicacion;

public abstract class Sorpresa extends Elemento {
	public Sorpresa (int x, int y) {
		super(x,y);
		
	
	}
	/**
	 * Aplica el poder de la sorpresa que impacta con Mario
	 * @param jugador Jugador que tendrá la sorpresa
	 */
	public abstract void aplicarPoder(Jugador jugador); 
	
	
}
