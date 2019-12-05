package presentacion;

import aplicacion.DonkeyPOOB;
import aplicacion.Barril;
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
import javax.swing.InputMap;
import javax.swing.JComponent;
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
	private String rightRun;
	private Tablero tablero;
	private DonkeyPOOB juego;
	private Thread t,t2; 
	
	//booleans
	private boolean left=false;
	private boolean right=false;
	private boolean down=false;
	private boolean up=false;
	private boolean jump=false;
	
	
	/**
	 * Constructor de la interfaz grafica 
	 * */
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
	/**
	* Metodo principal donde creamos el juego 
	*@param string arg[]
	*/
	public static void main(String args[]) {
		DonkeyPOOBGUI juego = new DonkeyPOOBGUI();
		juego.setVisible(true);
		
	}
	
	/**
	*Se preparan los elementos de la ventana principal del DonkeyPOOB
	*/
	private void prepareElementos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(900, 900));
		setLocationRelativeTo(null);
	    prepareElementosInicial(); 
	    prepareElementosMenu();
	   
	    
	}
	
	/**
	*Ventana desplegable del menú en la parte superior derecha y botones necesarios en el proceso inicial
	*/
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
	
	/**
	*Elementos como la dimensión, el panel e importar las imágenes que se desean
	*/
	public void prepareElementosInicial() {
		layout = new CardLayout();
		setSize(new Dimension(900, 900));
		principal = new JPanel(layout);
		menuInicial = new PantallaInicial(PantallaInicial.fondoInicial);
		add(principal);
		principal.add(menuInicial,"tini");
		layout.show(principal,"tini");		
	
	}
	
	/**
	*Creación de los oyentes necesarios para el menú inicial
	*/
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
	
	/**
	*Añadiendo los botones de regreso para controlar la operación
	*/
	private void prepareAccionesControl() {
		menuInicial.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(new Dimension(900, 900));
				menuInicial.prepareElementosInicio();
				prepareAcciones();
			}
		});
	}
	
	/**
	*Método para salir de la aplicación, con la flecha de la parte superior derecha
	*/
	public void salir(){
		int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Confirmacion de salida: ",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION)
			System.exit(0);
		else if (result == JOptionPane.NO_OPTION)
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	/**
	*Añadiendo los botones de regreso para controlar la operación
	*/
	private void prepareAccionesCPU() {		
		menuInicial.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(new Dimension(900, 900));
				menuInicial.prepareElementosInicio();
				prepareAcciones();
			}
		});
	}
	
	/**
	* Inicio del juego teniendo en cuentas los personajes, barriles, sorpresas y demás elementos para crear el tablero
	*@param int jugadores 
	*@param int maquinas
	*/
	public void iniciar(int jugadores,int maquinas) {
		DonkeyPOOB.nuevoJuego();
		juego = DonkeyPOOB.getJuego();
		juego.prepareJugadores(jugadores, maquinas);			
		ponerElementos();
	}
	
	/**
	 *  Poner los elementos de la pantalla inicial de seleccion y los oyentes necesarios 
	 * */
	
	public void ponerElementos() {
		menuInicial.prepareElegirElementos();
		prepareAccionesElementos();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	/**
	 * Oyentes para las teclas de movimiento 
	 * */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (juego != null && tablero != null) {
			if(keyCode == KeyEvent.VK_P) {
				juego.pausa();
				tablero.pausa();
			}
			if(keyCode == KeyEvent.VK_RIGHT) {
				juego.JugadorRight(0);
				right=true; 
			}
			if(keyCode == KeyEvent.VK_LEFT) {
				juego.JugadorLeft(0);
				left=true;
				
			}
			if(keyCode == KeyEvent.VK_UP) {
				if(juego.getJugador(0).getPersonaje().arriba) {
					juego.JugadorUp(0);
					up=true;
				}
				//System.out.println("I don't wanna go mr Stark");
			}
			if(keyCode == KeyEvent.VK_DOWN) {

				if(juego.getJugador(0).getPersonaje().abajo) {
					juego.JugadorDown(0);
					down=true;
					
				}
				//System.out.println("I don't wanna go mr Stark");
				//actualizarJugadores();
			}
			if(keyCode == KeyEvent.VK_ENTER){
				juego.jugadorSalto(0);
				jump=true;
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
        if (e.getKeyCode() == KeyEvent.VK_ENTER) jump = false;
		
	}
	
	@Override
	/**
	 * Hilo donde corremos los procesos que tienen que ir actualizandose 
	 * */
	public void run() {
		try {
			while(!juego.gameOver()&&!juego.finished()){
				
				actualizar();
				actualizarBarriles();


			
				while(!juego.gameOver()) {
					if(!juego.enPausa()){
						actualizarBarriles();
						actualizar();
						Thread.sleep(20);
					}
				}
			}
			//terminar(juego.gameOver());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
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
	
	/**
	 * Preparamos los elementos para jugar utilizando la capa de aplicacion 
	 * */
	private void  ponerElementosJuego() {
		try {
			juego.prepareBarriles(5);
			juego.addPlataformas();
			juego.addEscaleras();
			juego.prepareSorpresa(6);
			juego.barrilesParaJugar(menuInicial.barrilesSelecionados);
			juego.sorpresasParaJugar(menuInicial.sorpresasSelecionados);
		}catch(DonkeyPOOBException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "¡Cuidado!", JOptionPane.WARNING_MESSAGE, icono);
		}
	}
	
	/**
	 * Creamos el tablero necesario para jugar preparamos los jugadors y los barriles para jugar 
	 * */
	
	private void prepareElementosJuego(int jugadores){
		setSize(new Dimension(900, 900));
		tablero = new Tablero(jugadores);
		principal.add(tablero,"tablero");		
		t = new Thread(this);
		prepareJugadores();
		prepareBarriles();
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
	
	/**
	 * preparacion de los jugadores validando la informacion de aplicacion y pasandola a presentacion 
	 * */
	
	private void prepareJugadores() {
		for (int i = 0; i < juego.numeroJugadores(); i++) {
			tablero.addJugador();
			tablero.getJugador(i).setRoot(juego.getJugador(i).getRoot());
			ArrayList<Sprite> vidas = tablero.getVidas();
			for(int j = i*3;j <= 3+((i*3)-1);j++){
				vidas.get(j).setRoot("rsc/marioSprite0.png");
			}
		}
			
		
		actualizarJugadores();
	}
	
	/**
	 * Actualizar posicion del jugador y estados del jugador desde la capa de aplicacion a presentacion 
	 * */
	private void actualizarJugadores(){		
		Sprite s;
		try {
			s = tablero.getJugador(0);
		} catch (IndexOutOfBoundsException ex) {
			tablero.addJugador();
			s = tablero.getJugador(0);
		}
		if (juego.getJugador(0).getPersonaje().isVisible()) {
			juego.getJugador(0).getPersonaje().moverHastaUnaPlataforma();
			
			s.setX(juego.getJugador(0).getX());
			s.setY(juego.getJugador(0).getY());
			s.setRoot(juego.getJugador(0).getRoot());
		} 
		s.setVisible(juego.getJugador(0).getPersonaje().isVisible());
	}
	
	/**
	 * Se realiza la actualizacion de los elementos del tablero, jugadores, puntaje, vidas y sorpresas 
	 * */
	
	public void actualizar() {
		
		actualizarJugadores();
		actualizarPuntaje();
		actualizarVidas();
		actualizarSorpresas();
		tablero.repaint();
	}
	
	
	/**
	 * preparacion de los barriles en presentacion teniendo en cuenta la informacion en aplicacion 
	 * */
	private void prepareBarriles() {
			Barril[] barriles = juego.getBarriles(); 
			for (int i=0;i<barriles.length;i++) {
				tablero.addBarril();
				tablero.getBarril(i).setRoot(juego.getBarril(i).getImagen());
				
			}
			actualizarBarriles();
	}
	
	/**
	 * Actualizar la posicion de los barriles segun la capa de aplicacion posicion estado 
	 * */
	private void actualizarBarriles() {
		Barril[] barriles = juego.getBarriles(); 
		for (int i = 0; i < barriles.length; i++) {
			Sprite s;
			try {
				s = tablero.getBarril(i);
			} catch (IndexOutOfBoundsException ex) {
				tablero.addBarril();
				s = tablero.getBarril(i);
			}
			if (juego.getBarril(i).isVisible()) {
				juego.lanzarBarriles();
				juego.colisionBarriles();
				s.setX(barriles[i].getX());
				s.setY(barriles[i].getY());
				s.setRoot(barriles[i].getImagen());
			} 
			s.setVisible(barriles[i].isVisible());						
		}		
	}
	
	/**
	 * Actualizacion del puntaje teniendo en cuenta la informacion en la capa de aplicacion 
	 * */
	private void actualizarPuntaje(){
		for(int i = 0; i < juego.numeroJugadores(); i++){
			tablero.setPuntaje(i, juego.getJugador(i).getPuntaje());
		}
	}
	
	/**
	 * Actualizacion de las vidas solicitando informacion al juego en aplicacion 
	 * */
	
	private void actualizarVidas(){
		for(int i = 0; i < juego.numeroJugadores(); i++){
			int vidasAct = juego.getJugador(i).getVidas();
			ArrayList<Sprite> vidas = tablero.getVidas();
			for(int j = i*3;j <= 3+((i*3)-1);j++)vidas.get(j).setVisible(true);
			for(int j = i*3;j <= 3+((i*3)-1)-(vidasAct);j++) vidas.get(j).setVisible(false);
			//System.out.println(3+((i*3)-1)-(vidasAct));
		}
	}
	private void actualizarSorpresas() {
		for(int i = 0; i < juego.numeroDeSorpresas(); i++){
			Sprite s;
			try {
				s = tablero.getSorpresa(i);
			} catch (IndexOutOfBoundsException ex) {
				tablero.addSorpresa();
				s = tablero.getSorpresa(i);
			}
			if(juego.getSorpresa(i).isVisible()){
				juego.colisionSopresa();
				s.setX(juego.getSorpresa(i).getX());
				s.setY(juego.getSorpresa(i).getY());
				s.setRoot(juego.getSorpresa(i).getImagen());
			}
			s.setVisible(juego.getSorpresa(i).isVisible());
		}
	}
	
	

}
		
	
	
		
