package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	private ArrayList<Sprite> bloques;
	private ArrayList<Sprite> jugadores;
	private ArrayList<Sprite> sorpresas;
	private ArrayList<Sprite> vidas; 
	private String[] puntajes;
	private boolean terminar, gameOver, enPausa;
	
	public Tablero(int numeroJugadores) {
		puntajes = new String[numeroJugadores];
		bloques = new ArrayList<Sprite>();
		jugadores = new ArrayList<Sprite>();
		vidas = new ArrayList<Sprite>();
		sorpresas = new ArrayList<Sprite>();
		terminar = false;
		try {
			nivel = ImageIO.read(new File("rsc/nivel1.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(nivel, 0, 0, this);
		paintComponents(g);
	}
}