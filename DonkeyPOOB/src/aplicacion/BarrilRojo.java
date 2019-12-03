package aplicacion;

public class BarrilRojo extends Barril {
	public BarrilRojo(int x, int y) {
		super(x, y);
		setImagen("rsc/barrilRojo.png");
}

	public void moverHastaUnaPlataforma() {
		while(caida && y < 804) {
			moverAbajo();
			//System.out.println(y);
			break;
		}
		while(!caida && y < 804) {
			moverAbajo();
			//System.out.println(y+"estoy aqui");
			break;
		}
		if(y == 804) {
			this.setVisible(false);
		}
		
	}
}