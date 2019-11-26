package aplicacion;
//import java.io.Serializable;
//import java.util.*;

public abstract class Personaje extends Elemento implements Runnable {
	
	public static final int limiteX = 850;
	public static final int limiteY = 800;
	protected static final int Desplazamiento = 1;
	public static int estado=0;
	
	public boolean salto = false;
	public boolean caida = true;
	
	public double gravity = 0.0;
	
	public  int  [][] puntosPlataforma = {{0,270},{580,270},{581,273},{645,273},{646,276},{710,276},
										{711,279},{776,279},{777,282},{841,282},{840,350},{900,352},{774,356}};
	public int [] salida,salidaDos;
	public double corte; 
	
	public double pendiente;
	
	private Thread tk; 
	
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
			estaSobreUnaPlataforma(x,y+33);
		}if(estado == 3) {
			estado = 2;
		}else {
			estado = 3;
		}
	}
	public void estaSobreUnaPlataforma(int x, int y) {
		for (int i=0; i<puntosPlataforma.length-1;i++) {

			 salida=puntosPlataforma[i];
			 salidaDos=puntosPlataforma[i+1];
			 pendiente=  (salidaDos[1]-(salida[1]))/salidaDos[0]-(salida[0]);
			 corte=salida[1]-(pendiente*x);
			 if (x>=salida[0] && x<=salidaDos[0]) {
				 if (i%2==0) {
						System.out.println(y+" Y");
						System.out.println(pendiente+" pendiente");
						//System.out.println(x+" X");
						//System.out.println(corte+" corte");
					 if (y==(pendiente*x)+corte) {
					 	//System.out.println("sisa,todo bien")
						 caida=false;
					 }else {
						 caida = true;
					 }
			
				 	}	
				 }
			
			 }
	}
	public void moverHastaUnaPlataforma(){
		while(caida) {
			
			moverAbajo();
			estaSobreUnaPlataforma(x,y+33);
		}
		
	}	
	
}
