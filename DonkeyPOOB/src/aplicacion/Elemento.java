package aplicacion;

public abstract class Elemento {
	protected static int  x;
	protected static int y;
	protected int deltaX;
	protected int deltaY;
	protected String imagen;
	protected boolean isVisible;
	
	public Elemento(int x, int y) {
		this.x = x;
		this.y = y;
		deltaX = 1;
		deltaY = 1;
		isVisible=true;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public static int getX() {
		return x; 
	}
	
	public static int getY() {
		return y; 
	}
	
	public void setX(int nuevoX) {
		x = nuevoX;
	}
	
	public void setY(int nuevoY) {
		y = nuevoY;
	}

	public boolean isVisible() {
		return isVisible;
	}
	
	public void setImagen(String nuevaImagen) {
		imagen = nuevaImagen;
	}
	
	public void setVisible(boolean visibilidad) {
		isVisible = visibilidad; 
	}
	
	public void setDeltaX(int nuevoDeltaX) {
		deltaX = nuevoDeltaX;
	}
	
	public void setDeltaY(int nuevoDeltaY) {
		deltaX = nuevoDeltaY;
	}
}
