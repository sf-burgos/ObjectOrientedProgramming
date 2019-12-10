package aplicacion;

import java.io.Serializable;

public class mono extends Elemento implements Serializable  {
	int estado = 0;
	public mono(int x, int y) {
		super(x, y);
		super.setImagen("rsc/mono.png");
	}
	
	public void changeEstado() {
		if(estado == 0) {
			estado = 1;
			super.setImagen("rsc/monoDerecha.png");
		}else if(estado == 1) {
			estado = 2;
			super.setImagen("rsc/monoIzquierda.png");
		}else {
			estado = 0;
			super.setImagen("rsc/mono.png");
		}
		
	}
	

}
