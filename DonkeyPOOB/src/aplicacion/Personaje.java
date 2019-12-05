package aplicacion;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//import java.io.Serializable;
//import java.util.*;

public abstract class Personaje extends Elemento{
	
	
	public static final int limiteX = 850;
	public static final int limiteY = 805;
	protected static final int Desplazamiento = 2;
	public static int estado=0;
	public int desplazamientoMartillo = 0;
	//public int limiteSalto=50;
	public ArrayList<Plataforma> puntosPlataforma = DonkeyPOOB.getPlataformas();
	public ArrayList<Escalera> puntosEscalera= DonkeyPOOB.getEscaleras();
	public boolean salto = false;
	public boolean caida = true;
	public boolean arriba = false;
	public boolean abajo = false;
	public boolean martillo = false; 
	
	
	public int [] salida,salidaDos;
	public double corte; 
	
	//variables de juego
	//por agregar
	
	
	public Personaje(int x, int y) {
		super(x,y);
	}
	
	//Metodos de movimiento
	public void moverArriba(){
		if(y-Desplazamiento > 2)
			y-=Desplazamiento;			
	estaSobreUnaPlataforma(x,y+33);
	}
	
		
	public void moverAbajo() {
		
		if(y+Desplazamiento < limiteY)
				y+=Desplazamiento;
		estaSobreUnaPlataforma(x,y+33);	
	}
	
		
	public void moverDerecha(){
		
		if(x+Desplazamiento < limiteX) {
				x+=Desplazamiento;
				estaSobreUnaPlataforma(x,y+33);
			}
			if(estado % 2 == 0) {
				estado =1;
			}else {
				estado +=2; 
			}
		}
	
	public void moverIzquierda(){
		if(x-Desplazamiento > 10) {
			x-=Desplazamiento; 
			estaSobreUnaPlataforma(x+30 ,y+33);
		}if(estado == 3) {
			estado = 2;
		}else {
			estado = 3;
		}
	}
	
	public void utilizarMartillo() {
		
		martillo = true;
		/**
		Timer reloj = new Timer();
		TimerTask tarea = new TimerTask(){

			@Override
			public void run() {
				martillo = true;			
			}
			
		};
		
		reloj.schedule(tarea, 0, 10000);
		*/


	}
	public void saltar() {
		int limiteSalto = y-40;
		while (y>=limiteSalto) {
			System.out.println("y"+" "+y);
			if(y-Desplazamiento > 2)							
				if(super.getImagen().equals("rsc/marioSprite4.png") || super.getImagen().equals("rsc/marioSprite0.png")) {
					y-=Desplazamiento;	
					x+=Desplazamiento;
				}
				if(super.getImagen().equals("rsc/marioSprite1.png") || super.getImagen().equals("rsc/marioSprite2.png")) {
					x-=Desplazamiento;
					y-=Desplazamiento;	
				}			
		}
		caida = true;
		if (caida&&salto){
			moverHastaUnaPlataforma();
			salto = false;							
		}
		salto =true;
	}
	
	public void estaSobreUnaPlataforma(int x, int y) {

		for (int i = 0; i < puntosPlataforma.size(); i++) {
			int[] izquierda = puntosPlataforma.get(i).getPuntoUno();
			int[] derecha = puntosPlataforma.get(i).getPuntoDos();
			if (y-1 == derecha[1]|| y == derecha[1]) {
				if ((izquierda[0] <= x && x <= derecha[0])) {
					if(estaSobreEscalera(x,y)) {
						abajo = true;
						arriba = false;
					}
					else if(estaBajoEscalera(x,y)) {
						arriba = true;
						abajo = false;
					}else {
						arriba = false;
						abajo = false;
					}
					caida = false;					
				} else {
					caida = true;
				}
			}else if ((y > izquierda[1] && y < puntosPlataforma.get(i+1).getPuntoDos()[1]) && i < puntosPlataforma.size()) {
				arriba = true;
				abajo = true;

			}
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
	
	public boolean estaBajoEscalera(int x,int y) {
		for (int i = 0; i < puntosEscalera.size(); i++) {
			int[] derecha = puntosEscalera.get(i).getPuntoDos();
			if ((derecha[0]-15<=x && derecha[0]+14>=x) && ((derecha[1]==y-1)||(derecha[1]==y))) {
				return true;
			}
		}
		return false;
	}
	
	public void moverHastaUnaPlataforma(){
		
		while(caida) {
			moverAbajo();
			break;
			
		}
	
		
	}	
	
	public boolean comprobarColision(Barril barril) {
		boolean colisiono = false;
		if(this.getY() == barril.getY() || this.getY()-1==barril.getY()) {
			if((barril.getX() > this.getX() && this.getX()+33 > barril.getX())) {
				if(barril instanceof BarrilRojo || barril instanceof BarrilAzul || barril instanceof BarrilAmarillo) {
					if(!martillo) {
						colisiono = true;
						this.setX(60);
						this.setY(772);
					}else{
						colisiono = true;
						barril.setX(1000);
						barril.setY(1000);
					}
				}
			}
			else if((barril.getX() == this.getX()) && barril instanceof BarrilVerde) {
				colisiono = true;
			}
		}
		return colisiono;
	}
	
	public boolean comprobarColisionSorpresa(int xSorpresa, int ySorpresa) {
		if(((this.getX() <= xSorpresa&& this.getX()+33 >= xSorpresa) && (this.getY() >= ySorpresa && this.getY()-33 <= ySorpresa))) {
			return true;
		}
		return false;
	}
	
	

	public void activarBotonesEscaleras() {
		
	}
	public void cambiarEstado() {
		
	}
}