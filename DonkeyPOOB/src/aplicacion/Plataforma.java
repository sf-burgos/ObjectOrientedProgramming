package aplicacion;

import java.io.Serializable;

public class Plataforma implements Serializable  {
	private int[] puntoUno;
	private int[] puntoDos;
	
	
	public Plataforma(int[] puntoUno, int[] puntoDos) {
		this.puntoUno = puntoUno;
		this.puntoDos = puntoDos;
	}
	
	public int[] getPuntoUno() {
		return puntoUno;
	}
	
	public int[] getPuntoDos() {
		return puntoDos;
	}
	

	
	


}
