package aplicacion;

public  class Luigi extends Personaje {

	public Luigi(int x, int y, String imagen) {		
		super(x, y);
		setImagen("rsc/luigiSprite0.png");
	}
	
	public void moverDerecha(){
		
		if(x+Desplazamiento < limiteX) {
				x+=Desplazamiento;
				estaSobreUnaPlataforma(x,y+33);
		}if(!martillo) {
			if(estado % 10 == 0) {
				estado += 2;
				super.setImagen("rsc/luigiSprite4.png");
			}else {
				estado +=3; 
				super.setImagen("rsc/luigiSprite0.png");
			}
		}else {
			super.setImagen("rsc/martilloDerechaLuigi.png");
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
				super.setImagen("rsc/luigiSprite2.png");
			}else {
				estado += 3;
				super.setImagen("rsc/luigiSprite1.png");
			}
		}else {
			super.setImagen("rsc/martilloIzquierdaLuigi.png");
			desplazamientoMartillo += Desplazamiento;
			if(desplazamientoMartillo > 500) {
				martillo = false;
			}
		}
	}
	
	public void saltar() {
		
		salto = true;
		int limiteSalto = y-50;
		super.getImagen().equals("rsc/luigiSprite5.png");
		while (y>=limiteSalto&&salto) {
				y-=Desplazamiento;					
				if(super.getImagen().equals("rsc/luigiSprite4.png") || super.getImagen().equals("rsc/luigiSprite0.png")) {					
					
					super.setImagen("rsc/luigiSprite5.png");
				}
				else if(super.getImagen().equals("rsc/luigiSprite1.png") || super.getImagen().equals("rsc/luigiSprite2.png")) {
					
					super.setImagen("rsc/luigiSprite3.png");
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
			super.setImagen("rsc/scaleLluigi.png");
		estado+=2;
		}
		else{ 
			super.setImagen("rsc/scaleDluigi.png");
			estado+=3;
		}
		
		
	
	}
	
		
	public void moverAbajo() {
		
		if(y+Desplazamiento < limiteY)
				y+=Desplazamiento;
		estaSobreUnaPlataforma(x,y+33);
		if(estado % 10==0) {
		super.setImagen("rsc/scaleLluigi.png");
		estado+=2;
		}
		else{ 
			super.setImagen("rsc/scaleDluigi.png");
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





