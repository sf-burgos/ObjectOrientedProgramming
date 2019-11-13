package presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class PantallaInicial extends JPanel {
	public static final String fondoInicial = "rsc/donkeyIni.png";
	public static final String fondoInstrucciones = "rsc/donkeyInstrucciones.png";
	protected JButton unPlayer,dosPlayer,playerVsCpu,cpuProtector,cpuMimo,cpuTemeroso,instrucciones,abrir,salir,volver;
	private Image imagenFondo;
	
	public PantallaInicial(String imagen)  {
		super(null);
		prepareElementosInicio();
		setFondo(imagen);
		
	}
	
	private void setFondo(String root) {
		try {
			imagenFondo = new ImageIcon(root).getImage();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void prepareElementosInicio(){
		removeAll();
		setFondo(PantallaInicial.fondoInicial);		
		unPlayer = new Boton("1Jugador",120,500);
		add(unPlayer);			
		dosPlayer = new Boton("2Jugador",350,500);		
		add(dosPlayer);
		playerVsCpu = new Boton("vsCPU",620,500);
		add(playerVsCpu);
		instrucciones = new Boton("controles",120,600);		
		add(instrucciones);
		abrir = new Boton("Abrir",380,600);
		add(abrir);		
		salir = new Boton("salir",630,600);
		add(salir);
		repaint();
		
	}
	
	
	public void paintBorder(Graphics g) {
		super.paintComponents(g);
		g.drawImage(imagenFondo,0,0,getSize().width, getSize().height,null);
	
	}
	
	public void prepareElementosCpu() {
		removeAll();
		
		cpuProtector = new Boton("salir",100,500);
		add(cpuProtector);
		
		cpuMimo = new Boton("salir",230,500);
		add(cpuMimo);
		
		cpuTemeroso = new Boton("salir",360,500);
		add(cpuTemeroso);
		
		volver = new  Boton("atras", 10, 10);
		add(volver);
		repaint();
	}
	
	public void prepareElementosControl() {
		removeAll();
		volver = new  Boton("atras", 10, 10);
		add(volver);
		setFondo(PantallaInicial.fondoInstrucciones);
		repaint();
	}
}
