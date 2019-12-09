package aplicacion;

import java.io.Serializable;

public class Martillo extends Sorpresa implements Serializable {
	public Martillo (int x, int y) {
		super(x,y);
		super.setImagen("rsc/martillo.png");
	}

	@Override
	public void aplicarPoder(Jugador jugador) {
		jugador.poderMartillo();
		
	}

}
