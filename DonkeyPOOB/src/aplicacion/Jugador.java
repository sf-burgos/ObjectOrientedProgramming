package aplicacion;

public abstract class Jugador {
	protected Personaje personaje; 
	public static final int limiteXFinal = 890;
	public static final int limiteXInicial = 10;
	protected static final int velocidad = 15; 
	private int vidas;
	private int puntaje;
	protected boolean esHumano;
	
	public Jugador(int x, int y, boolean esHumano) {
		vidas = 3; 
		puntaje = 0;
		this.esHumano = esHumano;
		personaje = new Mario(x,y);
	}
	
	public void moveRight() {
		personaje.moverDerecha();
	}
	
	public void moveLeft() {
		personaje.moverIzquierda();
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
	
	
	
	
	
}
