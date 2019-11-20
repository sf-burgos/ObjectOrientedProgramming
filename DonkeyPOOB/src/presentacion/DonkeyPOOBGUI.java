package presentacion;

import aplicacion.DonkeyPOOB;
import aplicacion.DonkeyPOOBException;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;;


public class DonkeyPOOBGUI extends JFrame implements Runnable,KeyListener{
	private PantallaInicial menuInicial;
	private JPanel principal;
	private CardLayout layout;
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem nuevo, abrir, guardar, salir, importar;
	private Icon icono; 
	private Tablero tablero;
	private DonkeyPOOB juego;
	private Thread t; 
	public DonkeyPOOBGUI() {
		super("DonkeyPOOB");
		prepareElementos();
		prepareAcciones();
		addKeyListener(this);
		setFocusable(true);
		ImageIcon icono = new ImageIcon("rsc/donkeyKongLogo.png");
		Image icon = icono.getImage();
		setIconImage(icon);
		
	}
	
	public static void main(String args[]) {
		DonkeyPOOBGUI juego = new DonkeyPOOBGUI();
		juego.setVisible(true);
		
	}
	

	private void prepareElementos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(900, 900));
		setLocationRelativeTo(null);
	    prepareElementosInicial(); 
	    prepareElementosMenu();
	   
	    
	}

	private void prepareElementosMenu() {
		barraMenu = new JMenuBar();
		menu = new JMenu("Menu");
		nuevo = new JMenuItem("Nuevo");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar");
		salir = new JMenuItem("Salir");
		importar = new JMenuItem("Importar");
		menu.add(nuevo);
		menu.addSeparator();
		menu.add(abrir);
		menu.addSeparator();
		menu.add(guardar);
		menu.addSeparator();
		menu.add(importar);
		menu.addSeparator();
		menu.add(salir);
		barraMenu.add(menu);
		setJMenuBar(barraMenu);
	}
	
	public void prepareElementosInicial() {
		layout = new CardLayout();
		setSize(new Dimension(900, 900));
		principal = new JPanel(layout);
		menuInicial = new PantallaInicial(PantallaInicial.fondoInicial);
		add(principal);
		principal.add(menuInicial,"tini");
		layout.show(principal,"tini");		
	
	}
	
	public void prepareAcciones() {
		menuInicial.unPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.numeroJugadores = 1;
				iniciar(1,0);
			}
		});
		menuInicial.dosPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuInicial.playerVsCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.prepareElementosCpu();
				prepareAccionesCPU();
			}
		});
		menuInicial.instrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.prepareElementosControl();
				prepareAccionesControl();							
			}
		});
		menuInicial.abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuInicial.salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				salir();
			}
		});
		
	
		
	
	}
	
	private void prepareAccionesControl() {
		menuInicial.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(new Dimension(900, 900));
				menuInicial.prepareElementosInicio();
				prepareAcciones();
			}
		});
	}
	public void salir(){
		int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Confirmacion de salida: ",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION)
			System.exit(0);
		else if (result == JOptionPane.NO_OPTION)
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	private void prepareAccionesCPU() {		
		menuInicial.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(new Dimension(900, 900));
				menuInicial.prepareElementosInicio();
				prepareAcciones();
			}
		});
	}
	
	public void iniciar(int jugadores,int maquinas) {
		DonkeyPOOB.nuevoJuego();
		juego = DonkeyPOOB.getJuego();
		juego.prepareJugadores(jugadores, maquinas);
		ponerElementos();
	}
	
	public void ponerElementos() {
		menuInicial.prepareElegirElementos();
		prepareAccionesElementos();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (juego != null && tablero != null) {
			if(keyCode == KeyEvent.VK_P) {
				juego.pausa();
				tablero.pausa();
			}
			if(keyCode == KeyEvent.VK_D) juego.JugadorRigth(0);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	private void prepareAccionesElementos() {
		menuInicial.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(new Dimension(900, 900));
				menuInicial.prepareElementosInicio();
				prepareAcciones();
			}
		});
	
		menuInicial.aceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ponerElementosJuego();
				prepareElementosJuego(1);
				prepareAccionesElementosJuego();
				
			}
		});
	}	
	private void  ponerElementosJuego() {
		try {
			juego.barrilesParaJugar(menuInicial.barrilesSelecionados);
			juego.sorpresasParaJugar(menuInicial.sorpresasSelecionados);
		}catch(DonkeyPOOBException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "¡Cuidado!", JOptionPane.WARNING_MESSAGE, icono);
		}
	}
	
	private void prepareElementosJuego(int jugadores){
		setSize(new Dimension(900, 900));
		tablero = new Tablero(jugadores);
		principal.add(tablero,"tablero");		
		t = new Thread(this);
		prepareJugadores();
		actualizar();
		layout.show(principal,"tablero");
		t.start();
	}
	public void prepareAccionesElementosJuego() {
		tablero.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				  int x = e.getX();
		          int y = e.getY();
		          System.out.println(x+ " "+y);
		          
		        
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	
	private void prepareJugadores() {
		for (int i = 0; i < juego.numeroJugadores(); i++) {
			tablero.addJugador();
			tablero.getJugador(i).setRoot(juego.getJugador(i).getRoot());
			
		}
		actualizarJugadores();
	}
	private void actualizarJugadores(){
		for(int i = 0; i < juego.numeroJugadores(); i++){
			Sprite s = tablero.getJugador(i);
			s.setX(juego.getJugador(i).getX());
			s.setY(juego.getJugador(i).getY());
			s.setRoot(juego.getJugador(i).getRoot());
		}
	}
	
	public void actualizar() {
		actualizarSprite();
	}
	
	private void actualizarSprite() {
		Sprite s;
		s = tablero.getJugador(0);
		if(s == null) {
			tablero.addJugador();
			s = tablero.getJugador(0);
		}
		s.setX(juego.getJugador(0).getX());
		s.setY(juego.getJugador(0).getY());
		s.setRoot(juego.getJugador(0).getPersonaje().getImagen());
		s.setVisible(juego.getJugador(0).getPersonaje().isVisible());
	}
	

}
		
	
	
		

