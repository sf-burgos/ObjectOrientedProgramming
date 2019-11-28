package aplicacion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class DonkeyPOOB {
	private static DonkeyPOOB juego = null; 
	private Jugador[] jugadores; 
	private Barril[] barriles;
	public static ArrayList<Plataforma> piso; 
	private boolean enPausa; 
	
	public DonkeyPOOB() {

		piso = new ArrayList<Plataforma>();		
	}
	
	public static DonkeyPOOB getJuego() {
		if(juego == null) {
			juego = new DonkeyPOOB();
		}
		return juego; 		
	}
	
	public static void nuevoJuego() {
		juego = new DonkeyPOOB();
	}
	
	public void prepareBarriles(int Nbarriles) {
		barriles = new Barril[Nbarriles];
		for(int i=0;i<barriles.length;i++) {
			barriles[i]= new BarrilAmarillo(200,0);
		}
		
				
	}
	
	public void prepareJugadores(int NJugadores,int maquina){
		jugadores = new Jugador[NJugadores];
		if(NJugadores == 2){
			jugadores[0] = new Usuario(188,550); //Posicion izquierda
			if(maquina > 0) {
				switch (maquina){
				case 1:
					jugadores[1] = new Protector(556,550); //Posicion derecha
					break;
				case 2:
					jugadores[1] = new Temeroso(556,550); //Posicion derecha
					break;
				default:
					jugadores[1] = new Mimo(556,550); //Posicion derecha
					break;
					}
			}else {
				jugadores[1] = new Usuario(556,550); //Posicion derecha
			}
		}else{
			jugadores[0] = new Usuario(300,0); //Posicion centro
		}
	}
	
	public void barrilesParaJugar(int[] barriles) throws DonkeyPOOBException{
		int numeroBarriles = 0;
		for (int i=0;i<barriles.length;i++) {
			if(barriles[i]==1) {
				numeroBarriles+=1;
			}
		}
		if(numeroBarriles==0) {
			throw new DonkeyPOOBException(DonkeyPOOBException.SIN_BARRILES);
		}
	}
	
	public void sorpresasParaJugar(int[] sorpresas) throws DonkeyPOOBException{
		int numeroSorpresas = 0;
		for (int i=0;i<sorpresas.length;i++) {
			if(sorpresas[i]==1) {
				numeroSorpresas+=1;
			}
		}
		if(numeroSorpresas==0) {
			throw new DonkeyPOOBException(DonkeyPOOBException.SIN_SORPRESAS);
		}
	}
	
	public int numeroJugadores() {
		return jugadores.length;
	}
	
	public Jugador getJugador(int i){
		Jugador jugador = null;
		if (i >- 1 && i < jugadores.length) {
			jugador = jugadores[i];
		}
		return jugador;
	}
	
	public void pausa() {
		enPausa = !enPausa;
	}
	
	public void JugadorRight(int n) {
		jugadores[n].moveRight();
	}
	public void JugadorLeft(int n) {
		jugadores[n].moveLeft();
	}
	
	public void JugadorUp(int n) {
		jugadores[n].moveUp();
	}
	
	public void JugadorDown(int n) {
		jugadores[n].moveDown();
	}
	
	public boolean gameOver() {
		boolean aunActivo = false;
		for(Jugador j: jugadores) {
			aunActivo = (j.getVidas()==0)?true:aunActivo;
		}
		return aunActivo;
	}
	
	public boolean finished() {
		return false;
	}
	
	public boolean enPausa() {
		return enPausa; 
	}
	
	public void addPlataformas() {
		int[] puntoCero = {300,211};int[] puntoUno = {497,211};
 		Plataforma plataformaUno = new Plataforma(puntoCero, puntoUno);
 		piso.add(plataformaUno);
		
 		int[] puntoDos = {0,346};int[] puntoTres = {795,346};		
		Plataforma plataformaDos = new Plataforma(puntoDos, puntoTres);
		piso.add(plataformaDos);
		
		int[] puntoCuatro = {100,440};int[] puntoCinco = {900,440};		
		Plataforma plataformaTres = new Plataforma(puntoCuatro, puntoCinco);
		piso.add(plataformaTres);
		
		int[] puntoSeis = {0,530};int[] puntoSiete = {800,530};		
		Plataforma plataformaCuatro = new Plataforma(puntoSeis, puntoSiete);
		piso.add(plataformaCuatro);
		int[] puntoOcho = {100,620};int[] puntoNueve = {900,620};		
		Plataforma plataformaCinco = new Plataforma(puntoOcho, puntoNueve);
		piso.add(plataformaCinco);
		int[] puntoDiez = {0,715};int[] puntoOnce = {800,715};		
		Plataforma plataformaSeis = new Plataforma(puntoDiez, puntoOnce);
		piso.add(plataformaSeis);
		int[] puntoDoce = {0,805};int[] puntoTrece = {892,805};		
		Plataforma plataformaSiete = new Plataforma(puntoDoce, puntoTrece);
		piso.add(plataformaSiete);
	}	
	public static ArrayList<Plataforma> getPlataformas(){
		return piso; 
		
	}  
	
	public Barril[] getBarriles() {
		return barriles;
	}
	
	/**
	 * Da un bloque en una posicion i especifica
	 * @param i posicion del bloque
	 * @return el bloque en la posicion i, si no hay retorna null
	 */
	public Barril getBarril(int i){
		Barril barril = null;
		if (i >- 1 && i< barriles.length) {
			barril = barriles[i];
		}
		return barril;
	}
}
