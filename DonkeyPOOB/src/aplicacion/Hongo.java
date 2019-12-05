package aplicacion;

public class Hongo extends Sorpresa {

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
