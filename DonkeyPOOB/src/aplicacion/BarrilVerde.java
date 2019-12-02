package aplicacion;

public class BarrilVerde extends Barril {
	public BarrilVerde(int x, int y) {
		super(x, y);
		setImagen("rsc/barrilVerdeVida.png");
		
		// TODO Auto-generated constructor stub
	}
	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			moverAbajo();
			break;
		}while(!caida) {
			
			if(y == 440-33 || y == 620-33 || y == 805-33) {
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

}
