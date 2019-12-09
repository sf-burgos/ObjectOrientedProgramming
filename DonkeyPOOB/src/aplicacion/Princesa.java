package aplicacion;

import java.io.Serializable;

public class Princesa extends Elemento implements Serializable  {

	public Princesa(int x, int y) {
		super(x, y);
		super.setImagen("rsc/princesa.png");
	}
	

}