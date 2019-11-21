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
	private ArrayList<Plataforma> piso; 
	//private Barril[] barriles;
	//private ArrayList<Sorpresa> sorpresas; 
	private boolean enPausa; 
	
	public DonkeyPOOB() {
		//sorpresas = new ArrayList<sorpresas>; 
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
			jugadores[0] = new Usuario(26,420); //Posicion centro
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
		int[] puntoCero = {0,675};int[] puntoUno = {836,712};
 		Plataforma plataformaUno = new Plataforma(puntoCero, puntoUno);
 		piso.add(plataformaUno);
		int[] puntoDos = {61,604};int[] puntoTres = {900,565};		
		Plataforma plataformaDos = new Plataforma(puntoDos, puntoTres);
		piso.add(plataformaDos);
		int[] puntoCuatro = {0,459};int[] puntoCinco = {836,498};		
		Plataforma plataformaTres = new Plataforma(puntoDos, puntoTres);
		piso.add(plataformaTres);
		int[] puntoSeis = {60,391};int[] puntoSiete = {892,351};		
		Plataforma plataformaCuatro = new Plataforma(puntoDos, puntoTres);
		piso.add(plataformaCuatro);
		int[] puntoOcho = {0,270};int[] puntoNueve = {837,285};		
		Plataforma plataformaCinco = new Plataforma(puntoOcho, puntoNueve);
		piso.add(plataformaCinco);
		int[] puntoDiez = {546,177};int[] puntoOnce = {354,177};		
		Plataforma plataformaSeis = new Plataforma(puntoDos, puntoTres);
		piso.add(plataformaSeis);
	}

	
}
