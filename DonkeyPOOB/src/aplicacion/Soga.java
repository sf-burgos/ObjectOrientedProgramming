package aplicacion;

import java.io.Serializable;

public class Soga extends Sorpresa implements Serializable {

	public Soga(int x, int y) {
		super(x, y);
		super.setImagen("rsc/soga.png");
	}

	@Override
	public void aplicarPoder(Jugador jugador) {
		for(int i=0; i < 2;i++) {
			jugador.moveJump();
		}
	}

}
