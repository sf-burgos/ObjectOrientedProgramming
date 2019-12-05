package aplicacion;

public class Manzana extends Sorpresa {

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
