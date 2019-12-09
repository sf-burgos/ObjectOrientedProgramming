package aplicacion;

import java.io.Serializable;

public class Manzana extends Sorpresa implements Serializable {

	public Manzana(int x, int y) {
		super(x, y);
		super.setImagen("rsc/manzana.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarPoder(Jugador jugador) {
		jugador.addPuntaje(5);
		
	}
	

}
