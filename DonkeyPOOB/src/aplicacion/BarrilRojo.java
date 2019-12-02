package aplicacion;

public class BarrilRojo extends Barril {
	public BarrilRojo(int x, int y) {
		super(x, y);
		setImagen("rsc/barrilRojo.png");
}

	public void moverHastaUnaPlataforma() {
		while(caida && y<=800) {
			moverAbajo();
			System.out.println(y);
			break;
		}
		while(!caida && y<=800) {
			moverAbajo();
			System.out.println(y+"estoy aqui");
			caida=true;
			break;
		}
		
	}
}