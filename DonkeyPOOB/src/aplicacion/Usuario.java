package aplicacion;

import java.io.Serializable;

public class Usuario extends Jugador implements Serializable {

	public Usuario(int x, int y, int h ) {
		super(x, y, true,h);
		// TODO Auto-generated constructor stub
	}
	public int tipoMaquina() {
		return -1;
	}

}
