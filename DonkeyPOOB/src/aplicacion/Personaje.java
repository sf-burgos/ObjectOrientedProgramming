package aplicacion;

import java.util.ArrayList;

//import java.io.Serializable;
//import java.util.*;

public abstract class Personaje extends Elemento{
	
	
	public static final int limiteX = 850;
	public static final int limiteY = 805;
	protected static final int Desplazamiento = 1;
	public static int estado=0;
	//public int limiteSalto=50;
	public ArrayList<Plataforma> puntosPlataforma = DonkeyPOOB.getPlataformas();
	public ArrayList<Escalera> puntosEscalera= DonkeyPOOB.getEscaleras();
	public boolean salto = true;
	public boolean caida = true;
	public boolean arriba = false;
	public boolean abajo = false;
	
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
			if(estado % 10 == 0) {
				estado += 2;
				super.setImagen("rsc/marioSprite4.png");
			}else {
				estado +=3; 
				super.setImagen("rsc/marioSprite0.png");
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
	public void saltar() {
		int limiteSalto = y-70;
		System.out.println("limiteSalto"+" "+limiteSalto);
		while (y>=limiteSalto) {
			System.out.println("y"+" "+y);
			if(y-Desplazamiento > 2)
				y-=Desplazamiento;	
			
		}
		caida = true;
		if (caida&&salto){
			moverHastaUnaPlataforma();
			salto = false;							
		}
		salto =true;
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
					if(estaSobreEscalera(x,y)) {
						abajo = true;
						arriba = false;
					}else if(estaBajoEscalera(x,y)) {
						arriba = true;
						abajo = false;
					}else {
						arriba = false;
						abajo = false;
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
			if ((izquierda[0]-10<=x && izquierda[0]+10>=x && izquierda[1]==y)) {
				//System.out.println("si arriba funciono ");
				//System.out.println(x+" "+y+" posicion" );
				return true;
			}
		}
		return false;
	}
	
	public boolean estaBajoEscalera(int x,int y) {
		for (int i = 0; i < puntosEscalera.size(); i++) {
			int[] derecha = puntosEscalera.get(i).getPuntoDos();
			if ((derecha[0]-10<=x && derecha[0]+10>=x && derecha[1]==y)) {
				//System.out.println("si abajo funciono ");
				//System.out.println(x+" "+y+" posicion" );
				return true;
			}
		}
		return false;
	}
	
	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			moverAbajo();
			break;
			
		}
	
		
	}	

	public void activarBotonesEscaleras() {
		
	}
	public void cambiarEstado() {
		
	}
}
