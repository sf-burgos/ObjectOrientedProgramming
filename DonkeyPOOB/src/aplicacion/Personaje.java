package aplicacion;

public abstract class Personaje extends Elemento {
	
	public static final int limiteXFinal = 890;
	public static final int limiteXInicial = 10;
	protected static final int velocidad = 15; 
	
	
	public Personaje(int x, int y, String imagen) {
		super(x,y);
		super.setImagen("rsc/"+imagen+".png");		
	}
	
	public void moverDerecha() {
		if (x + velocidad < limiteXFinal) {
			x += velocidad;
		}else {
			x = limiteXFinal;
		}		
	}
	
	public void moverIzquierda(){
		if(x-velocidad > limiteXInicial) { 
			x-= velocidad;
		}else {
			x = limiteXInicial;
		}
	}
	
	public void saltar() {
		y += velocidad;
	}
	
}
