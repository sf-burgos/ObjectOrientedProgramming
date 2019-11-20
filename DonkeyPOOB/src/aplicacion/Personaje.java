package aplicacion;

public abstract class Personaje extends Elemento {
	
	public static final int limiteXFinal = 890;
	public static final int limiteXInicial = 10;
	protected static final int velocidad = 5;
	public int moveCont=0; 
	public int estado=0; 
	
	
	public Personaje(int x, int y, String imagen) {
		super(x,y);
		super.setImagen("rsc/"+imagen+estado+".png");		
	}
	
	public void moverDerecha() {
		if (x + velocidad < limiteXFinal) {
			x += velocidad;
		}else {
			x = limiteXFinal;
		}
		if (estado == 4) {
			estado = 5;
		}else if(estado == 5) {
			estado = 4;
		}else {
			estado = 4;
		}
	}
	
	public void moverIzquierda(){
		if(x-velocidad > limiteXInicial) { 
			x-= velocidad;
		}else {
			x = limiteXInicial;
		}
		if (estado == 3) {
			estado = 2;
		}else if(estado == 2) {
			estado = 3;
		}else {
			estado = 3;
		}
	}
	
	public void saltar() {
		y += velocidad;
	}
	
	public int getEstado() {
		return estado;
	}
	
}
