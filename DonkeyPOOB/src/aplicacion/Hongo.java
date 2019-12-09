package aplicacion;

import java.io.Serializable;

public class Hongo extends Sorpresa implements Serializable {

	public Hongo(int x, int y) {
		super(x, y);
		super.setImagen("rsc/hongo.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarPoder(Jugador jugador) {
		jugador.poderHongo();
		
	}

}
