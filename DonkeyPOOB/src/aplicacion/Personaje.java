package aplicacion;

import java.util.ArrayList;

//import java.io.Serializable;
//import java.util.*;

public abstract class Personaje extends Elemento{
	
	
	public static final int limiteX = 850;
	public static final int limiteY = 805;
	protected static final int Desplazamiento = 1;
	public static int estado=0;
	public ArrayList<Plataforma> puntosPlataforma = DonkeyPOOB.getPlataformas();
	public ArrayList<Escalera> puntosEscalera= DonkeyPOOB.getEscaleras();
	public boolean salto = false;
	public boolean caida = true;
	public boolean activarDerecha = false;
	public boolean activarIzquierda = false;
	
	public double gravity = 0.0;
	

	public int [] salida,salidaDos;
	public double corte; 
	
	public double pendiente;
	
	//private Thread tk; 
	
	//Variables de imagen
	/**private final String right;
	private final String rightRun;
	private final String rightJump;
	private final String left;
	private final String leftRun;
	private final String leftJump;
	private final String scaleLeft;
	private final String scaleRight;
	private final String kill;*/
	
	
	
	//variables de juego
	//por agregar
	
	
	public Personaje(int x, int y) {
		super(x,y);
	}
	
	//Metodos de movimiento
	public void moverArriba(){
		if(y-Desplazamiento > 2)
			y-=Desplazamiento;
			estaSobreUnaPlataforma(x,y+33);
	}
		
	public void moverAbajo() {
		
		if(y+Desplazamiento < limiteY)
				y+=Desplazamiento;
		estaSobreUnaPlataforma(x,y+33);	
	}
	
		
	public void moverDerecha(){
		
		if(x+Desplazamiento < limiteX) {
				x+=Desplazamiento;
				estaSobreUnaPlataforma(x,y+33);
			}
			if(estado == 1) {
				estado = 0;
			}else {
				estado = 1; 
			}
		}
	
	public void moverIzquierda(){
		if(x-Desplazamiento > 10) {
			x-=Desplazamiento; 
			estaSobreUnaPlataforma(x+30 ,y+33);
		}if(estado == 3) {
			estado = 2;
		}else {
			estado = 3;
		}
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
					if (estaSobreEscalera(x+15,y)) {
						//System.out.println("holi :V");
						activarBotonesEscaleras();
					}
					caida = false;
					break;
				} else {
					caida = true;
				}
			}

			// System.out.println(puntosPlataforma.get(i));
		}
	

	}
	public boolean estaSobreEscalera(int x,int y) {
		for (int i = 0; i < puntosEscalera.size(); i++) {
			int[] izquierda = puntosEscalera.get(i).getPuntoUno();
			int[] derecha = puntosEscalera.get(i).getPuntoDos();
			if ((izquierda[0]-10<=x && izquierda[0]+25>=x && izquierda[1]==y) || (derecha[0]-10<=x && derecha[0]+10>=x && derecha[1]==y)) {
				System.out.println("si funciono ");
				System.out.println(x+" "+y+" posicion" );
				return true;
			}
		}
		//System.out.println("no estoy esc");
		return false;
	}
	
	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			moverAbajo();
		}
	
		
	}	

	public boolean activarBotonesEscaleras() {
		return true;
		
	}
	public void cambiarEstado() {
		
	}
}
