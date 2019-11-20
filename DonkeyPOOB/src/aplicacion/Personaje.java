package aplicacion;
//import java.io.Serializable;
//import java.util.*;

public abstract class Personaje extends Elemento {
	
	public static final int limiteX = 850;
	public static final int limiteY = 800;
	protected static final int Desplazamiento = 5;
	public static int estado=0; 
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
	}
		
	public void moverAbajo(){
		if(y+Desplazamiento < limiteY)
			y+=Desplazamiento;
	}
		
	public void moverDerecha(){
		
		if(x+Desplazamiento < limiteX) {
				x+=Desplazamiento;
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
		}if(estado == 3) {
			estado = 2;
		}else {
			estado = 3;
		}
	}

}
