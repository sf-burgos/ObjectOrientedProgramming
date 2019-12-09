package aplicacion;

import java.io.Serializable;

public class BarrilRojo extends Barril implements Serializable {
	public BarrilRojo(int x, int y) {
		super(x, y);
		setImagen("rsc/barrilRojo.png");
}

	public void moverHastaUnaPlataforma() {
		while(caida && y < 804) {
			moverAbajo();
			break;
		}
		while(!caida && y < 804) {
			moverAbajo();
			break;
			
		}
		if(y == 804) {
			this.setVisible(false);
		}
		
	}
}