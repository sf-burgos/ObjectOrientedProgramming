package aplicacion;

import java.util.ArrayList;

//import java.io.Serializable;
//import java.util.*;

public abstract class Personaje extends Elemento{
	
	public static final int limiteX = 850;
	public static final int limiteY = 805;
	protected static final int Desplazamiento = 1;
	public static int estado=0;
	
	public ArrayList<Plataforma> puntosPlataforma = DonkeyPOOB.getPlataformas();; 
	public boolean salto = false;
	public boolean caida = true;
	
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
	
	
	public Personaje(int x, int y, String marioRight, String marioRRun, String marioR, String marioLeft, String marioLRun, String marioL, String kill, String scaleL, String scaleR) {
		super(x,y);
		super.setImagen("rsc/"+marioRight+".png");
		

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
					System.out.println("sisas");
					caida = false;
					break;
				} else {
					caida = true;
					System.out.println("noks");
				}
			}

			// System.out.println(puntosPlataforma.get(i));
		}
		System.out.println(x + " " + y);

	}

	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			moverAbajo();
			System.out.println(caida);
		}
	
		
	}	
}
