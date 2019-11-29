package aplicacion;

import java.util.ArrayList;

public class BarrilAzul extends Barril {
	public ArrayList<Escalera> puntosEscalera= DonkeyPOOB.getEscaleras();
	public BarrilAzul(int x, int y) {
		
		super(x, y);
		setImagen("rsc/barrilBajando.png");

		
		// TODO Auto-generated constructor stub
	}
	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			if(estaSobreEscalera(x,y)) {
				moverAbajo();
			}
			break;
		}while(!caida) {
			
			if(y == 481-33 || y == 750-33 || y == 805-33) {
				x-=Desplazamiento;
				estaSobreUnaPlataforma(x+30,y+33);
			}			
			else {
				x+=Desplazamiento;		
				//System.out.println("asdsa");
				estaSobreUnaPlataforma(x,y+33);
			}
			
			//System.out.println(x+" "+y);
			break;
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

}