package aplicacion;

import java.io.Serializable;

public abstract class Maquina extends Jugador implements Serializable {

	public Maquina(int x, int y) {
		super(x, y, false);
	}

}
