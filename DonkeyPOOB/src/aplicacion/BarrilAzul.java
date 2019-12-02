package aplicacion;

import java.util.ArrayList;

public class BarrilAzul extends Barril {
	public ArrayList<Escalera> puntosEscalera= DonkeyPOOB.getEscaleras();
	public BarrilAzul(int x, int y) {
		
		super(x, y);
		setImagen("rsc/barrilAzul.png");

		
		// TODO Auto-generated constructor stub
	}
	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			moverAbajo();
			break;
		}while(!caida) {
			System.out.println(x+" "+y);
			if(y == 440-33 || y == 620-33 || y == 805-33) {
				if (estaSobreEscalera(x+33,y+33)){
					//System.out.println("aqui");
					moverAbajo();
					caida=true;
					break;
				}else{
					x-=Desplazamiento;
					estaSobreUnaPlataforma(x+30,y+33);
				}
			}			
			else {
				if (estaSobreEscalera(x,y+33)){
					//System.out.println("aqui");
					moverAbajo();
					caida=true;
					break;
				}else{
					x+=Desplazamiento;
					estaSobreUnaPlataforma(x+30,y+33);
				}
			}	
			
			//System.out.println(x+" "+y);
			break;
		}
	
		
	}
	
	
	public boolean estaSobreEscalera(int x,int y) {
		for (int i = 0; i < puntosEscalera.size(); i++) {
			int[] izquierda = puntosEscalera.get(i).getPuntoUno();
			if ((izquierda[0]-15<=x && izquierda[0]+14>=x) && ((izquierda[1]==y-1)||(izquierda[1]==y))) {
				return true;
			}
		}
		return false;
	}

}