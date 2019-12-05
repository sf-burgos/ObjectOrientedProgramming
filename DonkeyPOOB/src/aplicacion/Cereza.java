package aplicacion;

public class Cereza extends Sorpresa {

	public Cereza(int x, int y) {
		super(x, y);
		super.setImagen("rsc/cereza.png");
	}

	@Override
	public void aplicarPoder(Jugador jugador) {
		jugador.addPuntaje(10);
		
	}	
}
