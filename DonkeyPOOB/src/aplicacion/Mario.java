package aplicacion;

public  class Mario extends Personaje {

	public Mario(int x, int y) {
		// Personaje(int x, int y, String marioRight, String marioRRun, String marioR, String marioLeft, String marioLRun, String marioL, String kill, String scaleL, String scaleR) {
		super(x, y);
		setImagen("rsc/marioSprite0.png");
	}
	
	public void moverDerecha(){
		
		if(x+Desplazamiento < limiteX) {
				x+=Desplazamiento;
				estaSobreUnaPlataforma(x,y+33);
		}if(!martillo) {
			if(estado % 10 == 0) {
				estado += 2;
				super.setImagen("rsc/marioSprite4.png");
			}else {
				estado +=3; 
				super.setImagen("rsc/marioSprite0.png");
			}
		}else {
			super.setImagen("rsc/martilloDerecha.png");
			desplazamientoMartillo += Desplazamiento; 
			if(desplazamientoMartillo > 500) {
				martillo = false;
			}
		}
	}
	public void moverIzquierda(){
		if(x-Desplazamiento > 10) {
			x-=Desplazamiento; 
			estaSobreUnaPlataforma(x+30 ,y+33);
		}
		if(!martillo) {
			if(estado % 10 == 0) {
				estado += 2;
				super.setImagen("rsc/marioSprite2.png");
			}else {
				estado += 3;
				super.setImagen("rsc/marioSprite1.png");
			}
		}else {
			super.setImagen("rsc/martilloIzquierda.png");
			desplazamientoMartillo += Desplazamiento;
			if(desplazamientoMartillo > 500) {
				martillo = false;
			}
		}
	}
	
	public void saltar() {
		
		salto = true;
		int limiteSalto = y-50;
		super.getImagen().equals("rsc/marioSprite5.png");
		while (y>=limiteSalto&&salto) {
				y-=Desplazamiento;					
				if(super.getImagen().equals("rsc/marioSprite4.png") || super.getImagen().equals("rsc/marioSprite0.png")) {					
					
					super.setImagen("rsc/marioSprite5.png");
				}
				else if(super.getImagen().equals("rsc/marioSprite1.png") || super.getImagen().equals("rsc/marioSprite2.png")) {
					
					super.setImagen("rsc/marioSprite3.png");
				}
				
		}
		caida = true;
		if (caida&&!salto){
			moverHastaUnaPlataforma();
			salto = false;							
		}
	}
	
	public void moverArriba(){
		if(y-Desplazamiento > 2)
			y-=Desplazamiento;			
	estaSobreUnaPlataforma(x,y+33);
		if(estado % 10==0) {
			super.setImagen("rsc/scaleL.png");
		estado+=2;
		}
		else{ 
			super.setImagen("rsc/scaleD.png");
			estado+=3;
		}
		
		
	
	}
	
		
	public void moverAbajo() {
		
		if(y+Desplazamiento < limiteY)
				y+=Desplazamiento;
		estaSobreUnaPlataforma(x,y+33);
		if(estado % 10==0) {
		super.setImagen("rsc/scaleL.png");
		estado+=2;
		}
		else{ 
			super.setImagen("rsc/scaleD.png");
			estado+=3;
		}
	}
	
	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			super.moverAbajo();
			break;
			
		}
	}
	
}
