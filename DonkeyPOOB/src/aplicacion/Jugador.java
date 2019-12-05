package aplicacion;

public abstract class Jugador {
	protected Personaje personaje; 
	public static final int limiteXFinal = 890;
	public static final int limiteXInicial = 10;
	protected static final int velocidad = 5; 
	private int vidas;
	private int puntaje;
	protected boolean esHumano;
	
	public Jugador(int x, int y, boolean esHumano) {
		vidas = 3; 
		puntaje = 0;
		this.esHumano = esHumano;
		personaje = new Mario(x,y);
	}
	public void poderMartillo(){
		personaje.utilizarMartillo();
		
	}
	
	public void moveRight() {
		personaje.moverDerecha();
	}
	
	public void moveLeft() {
		personaje.moverIzquierda();
	}
	
	public void moveUp() {
		personaje.moverArriba();
	}
	
	public void moveDown() {
		personaje.moverAbajo();
	}

	public void moveJump() {
		personaje.saltar();
	}
	
	public String getRoot() {
		return personaje.getImagen();
	}
	
	public void setRoot(String root) {
		personaje.setImagen(root);
	}
	
	public int getX(){
		return personaje.getX();
	}
	

	public int getY(){
		return personaje.getY();
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public int getPuntaje() {
		return puntaje; 
	}
	
	public boolean isVisible() {
		return personaje.isVisible();
	}
	
	public void addPuntaje(int puntos) {
		puntaje += puntos;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void quitarVida() {
		vidas--;
	}
	
	public void addVida() {
		if(vidas < 3);
			vidas++;
		
	}
	
	public boolean comprobarColision(Barril barril) {
		if(personaje.comprobarColision(barril)) {
			return true;
		}
		return false;
	}
}
