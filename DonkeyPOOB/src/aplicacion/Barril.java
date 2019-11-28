package aplicacion;

import java.util.ArrayList;

public abstract class Barril extends Elemento {


	public static final int limiteX = 850;
	public static final int limiteY = 805;
	protected static final float Desplazamiento = 1;
	public static int estado=0;
	public boolean caida = true;


	
	public ArrayList<Plataforma> puntosPlataforma = DonkeyPOOB.getPlataformas();

	
	public Barril(int x, int y) {
		super(x, y);	
	}
	
	public boolean isVisible(){
		return super.isVisible();
	}
	
	public void fueraDeJuego() {
		this.setVisible(false);
	}
	
	public void estaSobreUnaPlataforma(int x, int y) {

		for (int i = 0; i < puntosPlataforma.size(); i++) {
			int[] izquierda = puntosPlataforma.get(i).getPuntoUno();
			int[] derecha = puntosPlataforma.get(i).getPuntoDos();
			// System.out.println(puntosPlataforma.get(i).getPuntoUno()[0]+"
			// "+puntosPlataforma.get(i).getPuntoUno()[1]+"izquierda");
			// System.out.println(puntosPlataforma.get(i).getPuntoDos()[0]+"
			// "+puntosPlataforma.get(i).getPuntoDos()[1]);
			// System.out.println(x+" "+y+" posicion" );
			// System.out.println("estoy aqui");
			if (y == derecha[1]) {
				if ((izquierda[0] <= x && x <= derecha[0])) {
					caida = false;
					System.out.println("sisas");
					break;
				} else {
					System.out.println("nooks");
					caida = true;
				}
			}

			// System.out.println(puntosPlataforma.get(i));
		}
	}
	
	public void moverAbajo() {
		
		if(y+Desplazamiento < limiteY)
				y+=Desplazamiento;
		estaSobreUnaPlataforma(x,y+33);	
	}
	
	public abstract void moverHastaUnaPlataforma();
		
		
	
		
		
	/**
	public void recorrerTablero() {
		moverHastaUnaPlataforma();
		while(!caida) {
			if(direccion) {
				x+=Desplazamiento;
			}else {
				x-=Desplazamiento;
			}
		}
	}*/
	
}
