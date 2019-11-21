package aplicacion;

public class Plataforma {
	private int[] puntoUno;
	private int[] puntoDos;
	private float pendiente; 
	private float puntoCorte;
	
	public Plataforma(int[] puntoUno, int[] puntoDos) {
		this.puntoUno = puntoUno;
		this.puntoDos = puntoDos;
	}
	
	public void calcularPendiente() {
		pendiente = (float) (puntoDos[1] - puntoUno[1])/(puntoDos[0] - puntoUno[0]);
	}
	
	public void calculaPuntoCorte() {
		puntoCorte = (float) puntoUno[1] - (pendiente*puntoUno[0]);
	}
	

}
