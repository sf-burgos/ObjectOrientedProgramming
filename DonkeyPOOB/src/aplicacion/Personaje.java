package aplicacion;
//import java.io.Serializable;
//import java.util.*;

public abstract class Personaje extends Elemento {
	
	public static final int limiteX = 850;
	public static final int limiteY = 800;
	protected static final int VELOCIDAD = 30;
	
	//Variables de imagen
	private final String right;
	private final String rightRun;
	private final String rightJump;
	private final String left;
	private final String leftRun;
	private final String leftJump;
	private final String scaleLeft;
	private final String scaleRight;
	private final String kill;
	
	//variables de juego
	//por agregar
	
	
	public Personaje(int x, int y, String marioRight, String marioRRun, String marioR, String marioLeft, String marioLRun, String marioL, String kill, String scaleL, String scaleR) {
		super(x,y);
		super.setImagen("rsc/"+marioRight+".png");
		 right =  "rsc/"+marioRight+".png";
		 rightRun =  "rsc/"+marioRRun+".png";
		 rightJump =  "rsc/"+marioR+".png";
		 left =  "rsc/"+marioLeft+".png"; 
		 leftRun =  "rsc/"+marioLRun+".png";
		 leftJump =  "rsc/"+marioL+".png";
		 scaleLeft =  "rsc/"+scaleL+".png";
		 scaleRight =  "rsc/"+scaleR+".png";
		 this.kill =  "rsc/"+kill+".png";	
	}
	
	//Metodos de movimiento
	public void moverArriba(){
		if(y-VELOCIDAD > -16)
			y-=VELOCIDAD;
	}
		
	public void moveAbajo(){
		if(y+VELOCIDAD < limiteY)
			
			y+=VELOCIDAD;
	}
		
	public void moverDerecha(){
		
		if(x+VELOCIDAD < limiteX) {
			System.out.println("here");
			x+=VELOCIDAD;
			setX(x);
			}
		}
	
	public void moverIzquierda(){
		if(x-VELOCIDAD > -16)
			super.setImagen(left);
		System.out.println("estoy aqui");
			x-=VELOCIDAD;
	}
		
	

	
}
