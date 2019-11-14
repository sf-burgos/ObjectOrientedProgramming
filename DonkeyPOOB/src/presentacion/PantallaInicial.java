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
	protected JButton unPlayer,dosPlayer,playerVsCpu,cpuProtector,cpuMimo,cpuTemeroso,instrucciones,abrir,salir,volver,aceptar;
	protected JCheckBox barrilAzul, barrilAmarillo, barrilRojo, barrilVerde, cereza, manzana, corazon, hongo, martillo,soga,mario,luigi;
	private Image imagenFondo;
	private boolean elementos;
	
	protected int[] barrilesSelecionados;
	protected int[] sorpresasSelecionados;
	protected int[] personajesSelecionados;
	
	
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
		if(elementos){
			g.setColor(Color.white);
			g.setFont(new Font("Proxy 1", Font.BOLD, 20));
			g.drawString("Selecione los elementos para su juego:           Personajes:", 100, 400);
			g.drawString("Barriles:", 100, 430);
			g.drawString("Sorpresas:", 100, 540);
			elementos  = false;
		}
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
		add(new Boton("barrilAmarillo",100,450));
		add(new Boton("barrilAzul",200,450));
		add(new Boton("barrilVerde",300,450));
		add(new Boton("barrilRojo",400,450));
		
		
		barrilAmarillo = new JCheckBox("",true);
		barrilAmarillo.setOpaque(false);
		barrilAmarillo.setBackground(Color.white);
		barrilAmarillo.setBounds(100, 500, 20, 20);
		add(barrilAmarillo);
		
		barrilAzul = new JCheckBox("",true);
		barrilAzul.setOpaque(false);
		barrilAzul.setBackground(Color.white);
		barrilAzul.setBounds(200, 500, 20, 20);
		add(barrilAzul);
		
		barrilVerde = new JCheckBox("",true);
		barrilVerde.setOpaque(false);
		barrilVerde.setBackground(Color.white);
		barrilVerde.setBounds(300, 500, 20, 20);
		add(barrilVerde);
		
		barrilRojo = new JCheckBox("",true);
		barrilRojo.setOpaque(false);
		barrilRojo.setBackground(Color.white);
		barrilRojo.setBounds(400, 500, 20, 20);
		add(barrilRojo);
		
		int[] todos = {1,1,1,1};
		barrilesSelecionados = todos;
		
	
	}
	
	public void sorpresas() {
		add(new Boton("cereza",100,550));
		add(new Boton("manzana",200,550));
		add(new Boton("corazon",300,550));
		add(new Boton("hongo",400,550));
		add(new Boton("martillo",500,550));
		add(new Boton("soga",590,550));
		
		cereza = new JCheckBox("",true);
		cereza.setOpaque(false);
		cereza.setBackground(Color.white);
		cereza.setBounds(100, 600, 20, 20);
		add(cereza);
		
		manzana = new JCheckBox("",true);
		manzana.setOpaque(false);
		manzana.setBackground(Color.white);
		manzana.setBounds(200, 600, 20, 20);
		add(manzana);
		
		corazon = new JCheckBox("",true);
		corazon.setOpaque(false);
		corazon.setBackground(Color.white);
		corazon.setBounds(300, 600, 20, 20);
		add(corazon);
		
		hongo = new JCheckBox("",true);
		hongo.setOpaque(false);
		hongo.setBackground(Color.white);
		hongo.setBounds(400, 600, 20, 20);
		add(hongo);
		
		martillo = new JCheckBox("",true);
		martillo.setOpaque(false);
		martillo.setBackground(Color.white);
		martillo.setBounds(500, 600, 20, 20);
		add(martillo);
		
		soga = new JCheckBox("",true);
		soga.setOpaque(false);
		soga.setBackground(Color.white);
		soga.setBounds(590, 600, 20, 20);
		add(soga);
		
		int[] todos = {1,1,1,1,1,1};
		sorpresasSelecionados = todos;
	}
	
	public void personajePrincipal() {
		add(new Boton("mario",700,420));
		add(new Boton("luigi",800,420));
		
		mario = new JCheckBox("",true);
		mario.setOpaque(false);
		mario.setBackground(Color.white);
		mario.setBounds(700, 470, 20, 20);
		add(mario);
		
		luigi = new JCheckBox("",true);
		luigi.setOpaque(false);
		luigi.setBackground(Color.white);
		luigi.setBounds(800, 470, 20, 20);
		add(luigi);
		
		int[] todos = {1,1};
		personajesSelecionados = todos;
	}
	
	public void prepareElegirElementos() {
		removeAll();
		elementos = true;
		tipoBarril();
		personajePrincipal();
		sorpresas();
		//botonDeVolver
		
		volver = new  Boton("atras", 10, 10);
		add(volver);
		
		//botonAceptar
		aceptar = new Boton("aceptar",670,550);
		add(aceptar);
		
		repaint();
	}
	
		
	
	private void prepareAccionesBarriles() {
		barrilAmarillo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					barrilesSelecionados[0] = 1;
				}else {
					barrilesSelecionados[0] = 0;
				}
			}
		});
		
		barrilAzul.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					barrilesSelecionados[1] = 1;
				}else {
					barrilesSelecionados[1] = 0;
				}
			}
		});
		
		barrilRojo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					barrilesSelecionados[2] = 1;
				}else {
					barrilesSelecionados[2] = 0;
				}
			}
		});
		
		barrilVerde.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					barrilesSelecionados[3] = 1;
				}else {
					barrilesSelecionados[3] = 0;
				}
			}
		});
	}

	private void prepareAccionesSorpresas() {
		cereza.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sorpresasSelecionados[0] = 1;
				}else {
					sorpresasSelecionados[0] = 0;
				}
			}
		});
		
		manzana.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sorpresasSelecionados[1] = 1;
				}else {
					sorpresasSelecionados[1] = 0;
				}
			}
		});
		
		corazon.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sorpresasSelecionados[2] = 1;
				}else {
					sorpresasSelecionados[2] = 0;
				}
			}
		});
		
		hongo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sorpresasSelecionados[3] = 1;
				}else {
					sorpresasSelecionados[3] = 0;
				}
			}
		});
		
		martillo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sorpresasSelecionados[4] = 1;
				}else {
					sorpresasSelecionados[4] = 0;
				}
			}
		});
		
		soga.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					sorpresasSelecionados[5] = 1;
				}else {
					sorpresasSelecionados[5] = 0;
				}
			}
		});
	}
	private void prepareAccionesPersonajes() {
		mario.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					personajesSelecionados[0] = 1;
				}else {
					personajesSelecionados[0] = 0;
				}
			}
		});
		
		luigi.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					personajesSelecionados[1] = 1;
				}else {
					personajesSelecionados[1] = 0;
				}
			}
		});
	}
}
