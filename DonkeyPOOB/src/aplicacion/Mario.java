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
			}
			if(estado % 10 == 0) {
				estado += 2;
				super.setImagen("rsc/marioSprite4.png");
			}else {
				estado +=3; 
				super.setImagen("rsc/marioSprite0.png");
			}
		}
	

	


}
