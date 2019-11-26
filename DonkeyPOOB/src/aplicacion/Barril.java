package aplicacion;

import java.util.ArrayList;

public abstract class Barril extends Elemento {



	public static final int limiteX = 850;
	public static final int limiteY = 805;
	protected static final int Desplazamiento = 1;
	public static int estado=0;
	
	public ArrayList<Plataforma> puntosPlataforma = DonkeyPOOB.getPlataformas();

	
	public Barril(int x, int y,String barrilBajando) {
		super(x, y);	
		super.setImagen("rsc/"+barrilBajando+".png");
	}
	
	public boolean isVisible(){
		return super.isVisible();
	}
	
	public void fueraDeJuego() {
		this.setVisible(false);
	}
	

	
	
}
