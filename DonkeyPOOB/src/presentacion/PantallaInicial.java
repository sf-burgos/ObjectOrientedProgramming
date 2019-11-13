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
	protected JCheckBox barrilAzul, barrilAmarillo, barrilRojo, barrilVerde, cereza, manzana, corazon, hongo, martillo,soga;
	private Image imagenFondo;
	private boolean elementos;
	
	protected int[] barrilesSelecionados;
	protected int[] sorpresasSelecionados;
	
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
	
	public void tipoBarril() {
		add(new Boton("barrilAmarillo",100,400));
		add(new Boton("barrilAzul",200,400));
		add(new Boton("barrilVerde",300,400));
		add(new Boton("barrilRojo",400,400));
		
		barrilAmarillo = new JCheckBox("",true);
		barrilAmarillo.setOpaque(false);
		barrilAmarillo.setBackground(Color.white);
		barrilAmarillo.setBounds(100, 450, 20, 20);
		add(barrilAmarillo);
		
		barrilAzul = new JCheckBox("",true);
		barrilAzul.setOpaque(false);
		barrilAzul.setBackground(Color.white);
		barrilAzul.setBounds(200, 450, 20, 20);
		add(barrilAzul);
		
		barrilVerde = new JCheckBox("",true);
		barrilVerde.setOpaque(false);
		barrilVerde.setBackground(Color.white);
		barrilVerde.setBounds(300, 450, 20, 20);
		add(barrilVerde);
		
		barrilRojo = new JCheckBox("",true);
		barrilRojo.setOpaque(false);
		barrilRojo.setBackground(Color.white);
		barrilRojo.setBounds(400, 450, 20, 20);
		add(barrilRojo);
	}
	
	public void prepareElegirElementos() {
		removeAll();
		elementos = true;
		tipoBarril();
		repaint();
		
	}
	
}
