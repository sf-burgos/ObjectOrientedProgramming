package aplicacion;

import java.io.Serializable;

public class Cereza extends Sorpresa implements Serializable {

	public Cereza(int x, int y) {
		super(x, y);
		super.setImagen("rsc/cereza.png");
	}

	@Override
	public void aplicarPoder(Jugador jugador) {
		jugador.addPuntaje(10);
		
	}	
}
