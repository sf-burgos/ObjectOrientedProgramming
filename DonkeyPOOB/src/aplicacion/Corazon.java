package aplicacion;

import java.io.Serializable;

public class Corazon extends Sorpresa implements Serializable {

	public Corazon(int x, int y) {
		super(x, y);
		super.setImagen("rsc/corazon.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarPoder(Jugador jugador) {
		jugador.addVida();
		
	}

}
