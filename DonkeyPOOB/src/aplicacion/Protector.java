package aplicacion;

import java.io.Serializable;

public class Protector extends Maquina implements Serializable {

	public Protector(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public int tipoMaquina() {
		return 1;
	}

}
