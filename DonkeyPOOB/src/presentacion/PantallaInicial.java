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

import aplicacion.Plataforma;
import aplicacion.Sorpresa;

import java.awt.event.*;

public class PantallaInicial extends JPanel {
	public static final String fondoInicial = "rsc/donkeyIni.png";
	public static final String fondoSeleccion = "rsc/fondoSeleccion.png";
	public static final String fondoInstrucciones = "rsc/donkeyInstrucciones.png";
	protected JButton unPlayer,dosPlayer,playerVsCpu,cpuProtector,cpuMimo,cpuTemeroso,instrucciones,abrir,salir,volver,aceptar;
	protected JCheckBox barrilAzul, barrilAmarillo, barrilRojo, barrilVerde, cereza, manzana, corazon, hongo, martillo,soga,mario,luigi;
	private Image imagenFondo;
	private boolean elementos;
	protected int numeroJugadores;
	
	protected static int[] barrilesSelecionados;
	protected static  int[] sorpresasSelecionados;
	protected static int[] personajesSelecionados;
	

	
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
		unPlayer = new Boton("1Jugador",120,600);
		add(unPlayer);			
		dosPlayer = new Boton("2Jugador",350,600);		
		add(dosPlayer);
		playerVsCpu = new Boton("vsCPU",620,600);
		add(playerVsCpu);
		instrucciones = new Boton("controles",120,720);		
		add(instrucciones);
		abrir = new Boton("Abrir",380,720);
		add(abrir);		
		salir = new Boton("salir",630,720);
		add(salir);
		repaint();
		
	}
	
	public void paintBorder(Graphics g) {
		super.paintComponents(g);
		g.drawImage(imagenFondo,0,0,getSize().width, getSize().height,null);
		if(elementos){
			g.setColor(Color.white);
			g.setFont(new Font("Proxy 1", Font.BOLD, 20));
			if(numeroJugadores == 1) {				
				g.drawString("Selecione los elementos para su juego:           Personajes:", 100, 450);
				g.drawString("Barriles:", 100, 470);
				g.drawString("Sorpresas:", 100, 590);
				elementos  = false;
			}else {
				g.drawString("Selecione los elementos para su juego: ",100, 450);
				g.drawString("Barriles:", 100, 470);
				g.drawString("Sorpresas:", 100, 590);
				elementos  = false;
				
			}
		}
		paintComponents(g);
	}
	
	public void prepareElementosCpu() {
		removeAll();
		
		cpuProtector = new Boton("Protector",200,600);
		add(cpuProtector);
		
		cpuMimo = new Boton("Mimo",400,600);
		add(cpuMimo);
		
		cpuTemeroso = new Boton("Temeroso",600,600);
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
		add(new Boton("barrilAmarillo",100,480));
		add(new Boton("barrilAzul",200,480));
		add(new Boton("barrilVerde",300,480));
		add(new Boton("barrilRojo",400,480));
		
		
		barrilAmarillo = new JCheckBox("",true);
		barrilAmarillo.setOpaque(false);
		barrilAmarillo.setBackground(Color.white);
		barrilAmarillo.setBounds(100, 530, 20, 20);
		add(barrilAmarillo);
		
		barrilAzul = new JCheckBox("",true);
		barrilAzul.setOpaque(false);
		barrilAzul.setBackground(Color.white);
		barrilAzul.setBounds(200, 530, 20, 20);
		add(barrilAzul);
		
		barrilVerde = new JCheckBox("",true);
		barrilVerde.setOpaque(false);
		barrilVerde.setBackground(Color.white);
		barrilVerde.setBounds(300, 530, 20, 20);
		add(barrilVerde);
		
		barrilRojo = new JCheckBox("",true);
		barrilRojo.setOpaque(false);
		barrilRojo.setBackground(Color.white);
		barrilRojo.setBounds(400, 530, 20, 20);
		add(barrilRojo);
		
		int[] todos = {1,1,1,1};
		barrilesSelecionados = todos;
		
	
	}
	
	public void sorpresas() {
		add(new Boton("cereza",100,600));
		add(new Boton("manzana",200,600));
		add(new Boton("corazon",300,600));
		add(new Boton("hongo",400,600));
		add(new Boton("martillo",500,600));
		add(new Boton("soga",590,600));
		
		cereza = new JCheckBox("",true);
		cereza.setOpaque(false);
		cereza.setBackground(Color.white);
		cereza.setBounds(100, 660, 20, 20);
		add(cereza);
		
		manzana = new JCheckBox("",true);
		manzana.setOpaque(false);
		manzana.setBackground(Color.white);
		manzana.setBounds(200, 660, 20, 20);
		add(manzana);
		
		corazon = new JCheckBox("",true);
		corazon.setOpaque(false);
		corazon.setBackground(Color.white);
		corazon.setBounds(300, 660, 20, 20);
		add(corazon);
		
		hongo = new JCheckBox("",true);
		hongo.setOpaque(false);
		hongo.setBackground(Color.white);
		hongo.setBounds(400, 660, 20, 20);
		add(hongo);
		
		martillo = new JCheckBox("",true);
		martillo.setOpaque(false);
		martillo.setBackground(Color.white);
		martillo.setBounds(500, 660, 20, 20);
		add(martillo);
		
		soga = new JCheckBox("",true);
		soga.setOpaque(false);
		soga.setBackground(Color.white);
		soga.setBounds(590, 660, 20, 20);
		add(soga);
		
		int[] todos = {1,1,1,1,1,1};
		sorpresasSelecionados = todos;
	}
	
	public void personajePrincipal() {
		if (numeroJugadores==1) {
			add(new Boton("mario",550,500));
			add(new Boton("luigi",650,500));
			
			mario = new JCheckBox("",true);
			mario.setOpaque(false);
			mario.setBackground(Color.white);
			mario.setBounds(550, 530, 20, 20);
			add(mario);
			
			luigi = new JCheckBox("",false);
			luigi.setOpaque(false);
			luigi.setBackground(Color.white);
			luigi.setBounds(650, 530, 20, 20);
			add(luigi);
			int[] todos = {1,0};
			personajesSelecionados = todos;
		}
		else {
			int[] todos = {1,1};
			personajesSelecionados = todos;
		}
	}
	
	public void prepareElegirElementos() {
		removeAll();
		setFondo(PantallaInicial.fondoSeleccion);
		elementos = true;
		tipoBarril();
		personajePrincipal();
		sorpresas();
		prepareAccionesBarriles();
		prepareAccionesSorpresas();
		prepareAccionesPersonajes();
		//botonDeVolver		
		volver = new  Boton("atras", 10, 10);
		add(volver);
		
		//botonAceptar
		aceptar = new Boton("aceptar",670,600);
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
		//for (int i=0;i<2;i++) {
			//System.out.println(personajesSelecionados[i]+"estoy aqui");
				
			//}
		if(numeroJugadores==1) {
			mario.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED) {
						personajesSelecionados[0] = 1;
						personajesSelecionados[1] = 0;	
						luigi.setSelected(false);
			
					}else {
						personajesSelecionados[0] = 0;
						personajesSelecionados[1] = 1;				
					}
				}
			});
			
			luigi.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED) {
						personajesSelecionados[1] = 1;
						personajesSelecionados[0] = 0;
						mario.setSelected(false);
					}else {
						personajesSelecionados[1] = 0;
						personajesSelecionados[0] = 1;
					}
				}
			});
		}
	}
	

	
}
