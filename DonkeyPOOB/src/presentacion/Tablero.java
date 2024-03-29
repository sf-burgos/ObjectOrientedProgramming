package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
//import aplicacion.Bola;



public class Tablero extends JPanel{
	private BufferedImage nivel; 
	private ArrayList<Sprite> barriles;
	private ArrayList<Sprite> jugadores;
	private ArrayList<Sprite> sorpresas;
	private ArrayList<Sprite> vidas; 
	private ArrayList<Sprite> personajesEstaticos; 
	private String[] puntajes;
	private boolean terminar, gameOver, enPausa;
	protected JButton guardar,abrir,reiniciar;
	public Tablero(int numeroJugadores) {
		puntajes = new String[numeroJugadores];
		barriles = new ArrayList<Sprite>();
		jugadores = new ArrayList<Sprite>();
		vidas = new ArrayList<Sprite>();
		sorpresas = new ArrayList<Sprite>();
		personajesEstaticos = new ArrayList<Sprite>();
		terminar = false;
		try {
			nivel = ImageIO.read(new File("rsc/nivel1.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void addPersonajeEstatico() {
		personajesEstaticos.add(new Sprite(500,500,true));
		
	}
	
	public void addBarril() {
		barriles.add(new Sprite(329,211,true,3,3));
	}
	
	public void addJugador() {
		jugadores.add(new Sprite(400,0,true,3,3));
		addVidas();
	}
	
	public void addSorpresa() {
		sorpresas.add(new Sprite(0,550,true,0,0));
	}
	
	public void addVidas() {
		for(int i = 0; i<3 ; i++) {
			if(jugadores.size() == 1) {
				vidas.add(new Sprite(40 + (i*40), 60,true,1,1));
			}else{
				vidas.add(new Sprite(700 + (i*42), 60,true,1,1));
			}
		}
	}
	
	public void setPuntaje(int jugador,int puntaje) {
		puntajes[jugador] = Integer.toString(puntaje);
	}
	
	public Sprite getJugador(int i) {
		return jugadores.get(i);
	}
	
	public Sprite getSorpresa(int i) {
		return sorpresas.get(i);
	}
	
	public Sprite getPersonajeEstatico(int i) {
		return personajesEstaticos.get(i);
	}
	
	public Sprite getBarril(int i) {
		return barriles.get(i);
	}
	
	public ArrayList<Sprite> getVidas(){
		return vidas;
	}
	
	public void Fin(boolean razon) {
		terminar = true;
		gameOver = razon;
		reiniciar =  new Boton("reiniciar",300,415); add(reiniciar);
		repaint();		
	}
	
	public void pausa() {
		enPausa = !enPausa;
	}
	
	public void setPausa(boolean pausa) {
		enPausa = pausa;
	}
	
	/**public void getPuntosMapa() {
		for(int i = 0; i < puntosMapa.size(); i++) {
			System.out.println(puntosMapa.get(i)[0]+ " " +puntosMapa.get(i)[0]);
		}
		
	}*/
	

	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(nivel, 0, 0, this);
		for (Sprite j: barriles) j.paint((Graphics2D) g);
		for (Sprite v : vidas) v.paint((Graphics2D) g);
		for (Sprite v : sorpresas) v.paint((Graphics2D) g);
		for (Sprite j: jugadores) j.paint((Graphics2D) g);
		for (Sprite j: personajesEstaticos) j.paint((Graphics2D) g);
		
		g.setColor(Color.white);
		g.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		if (puntajes.length == 1) {
			g.drawString("Score", 30, 30);
			g.drawString(puntajes[0], 30, 55);
		}
		else if(puntajes.length==2){
			g.drawString("Score", 30, 30);
			g.drawString(puntajes[0], 30, 55); 	
			g.drawString("Score", 644, 30);
			g.drawString(puntajes[1], 644, 55); 			
		}
	
		paintComponents(g);
	}	
}