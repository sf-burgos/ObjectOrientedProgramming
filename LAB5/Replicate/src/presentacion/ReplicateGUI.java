package presentacion;
import java.awt.*; 
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JColorChooser;
import java.io.File;
import java.util.*;


public class ReplicateGUI extends JFrame{	
	/**Barra menu */
	private JMenuBar menu;
	private JMenu archivo;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem guardarComo;
	private JMenuItem salir;
	/**Paneles */ 
	private JPanel principal;
	private JPanel tablero;
	/**Botones */ 
	private JButton replicar;
	private JButton numeroReplicas;
	private JButton terminarReplica;
	private JButton cambiarColor;
	private JButton cambiarDimension;
	private JButton refrescar;
	private JButton[][] matrizBotones;
	
	/**Colores */
	private Color colorAnteriorM;
	private Color colorAnteriorR;
	/**Constructor */ 
	private ReplicateGUI(){	
		principal = new JPanel();
		tablero = new JPanel();
		colorAnteriorM = Color.white;
		colorAnteriorR = Color.black;
		prepareElementos();		
		prepareAcciones();

		
	}
	
	public static void main(String[] args){
		ReplicateGUI gui=new ReplicateGUI();
		gui.setVisible(true);
	}
	
	public void prepareElementos(){
		this.setTitle("Replicate");			
		Dimension dim=super.getToolkit().getScreenSize();
		this.setMinimumSize(new Dimension(dim.width/2, dim.height/2));
		prepareElementosMenu();
		prepareElementosTablero(10,10);
	}
	public void prepareElementosMenu(){
		menu=new JMenuBar();
		archivo= new JMenu("Archivo");
		nuevo= new JMenuItem("Nuevo");
		abrir= new JMenuItem("Abrir");
		guardar= new JMenuItem("Guardar");
		guardarComo= new JMenuItem("Guardar Como");
		salir= new JMenuItem("Salir");
		archivo.add(nuevo);
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(guardarComo);
		archivo.add(salir);
		menu.add(archivo);
		setJMenuBar(menu);
	}

	public void prepareAcciones(){
		/*Close JFrame*/
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){			
			public void windowClosing(WindowEvent e){
				salga();
			}
		});
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser fc = new JFileChooser();
				int seleccion = fc.showOpenDialog(null);
				if(seleccion == JFileChooser.APPROVE_OPTION){
					File archivo = fc.getSelectedFile();
					JOptionPane.showMessageDialog(null,"Funcion abrir en construccion archivo: "+archivo.getName());					
				}
			}
		});
		guardarComo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser fc = new JFileChooser();
				int guardar = fc.showSaveDialog(null);
				if(guardar == JFileChooser.APPROVE_OPTION){
					File archivo = fc.getSelectedFile();
					JOptionPane.showMessageDialog(null,"Funcion guardar en construccion archivo: "+ archivo.getName());
				}
			}
		});
		for (int i=0;i<matrizBotones.length;i++){
			for(int j=0;j<matrizBotones[0].length;j++){
				matrizBotones[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){						
						JButton evento = (JButton)e.getSource();
						evento.setBackground(Color.BLACK);
					}
				});
			}
		}
		refrescar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				refresh();
			}
		});
		cambiarColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cambiarLosColores();
			}
		});
		cambiarDimension.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String filas = JOptionPane.showInputDialog(null,"Ingrese el numero de filas:","Cambio de dimension",JOptionPane.QUESTION_MESSAGE);
				String columnas = JOptionPane.showInputDialog(null,"Ingrese el numero de columnas:","Cambio de dimension",JOptionPane.QUESTION_MESSAGE);
				int numeroFilas,numeroColumnas;
				numeroFilas = Integer.parseInt(filas);
				numeroColumnas = Integer.parseInt(columnas);
				cambiarDimensionTablero(numeroFilas,numeroColumnas);
			}
		});
	}
	
	public void salga(){
			int valor=JOptionPane.showConfirmDialog(this,"¿Esta seguro de salir?","Advertencia",JOptionPane.YES_NO_OPTION);
			if(valor==JOptionPane.YES_OPTION){
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
	}
	
	/**Iniciar tablero */ 
	
	public JPanel prepareElementosTablero(int filas,int columnas){
		//principal = new JPanel();
		matrizBotones = new JButton[filas][columnas];
		setContentPane(principal);
		principal.setLayout(new BorderLayout());	
		//JPanel tablero = new JPanel();
		tablero.setLayout(new GridLayout(filas,columnas));		
		for(int i=0; i<matrizBotones.length;i++){
			for(int j=0;j<matrizBotones[0].length;j++){
				matrizBotones[i][j] = new JButton();
				matrizBotones[i][j].setBackground(Color.white);
				tablero.add(matrizBotones[i][j]);
			}
		}
		principal.add(tablero, BorderLayout.CENTER);
		JPanel botones = new JPanel();
		replicar = new JButton("Replicar");
		numeroReplicas = new JButton("Numero de Replicas");
		terminarReplica = new JButton("Terminar Replicar");
		cambiarColor = new JButton("Cambiar Color");
		cambiarDimension = new JButton("Cambiar Dimension");
		refrescar = new JButton("Refrescar");
		botones.setLayout(new GridLayout(2,3));
		botones.add(replicar);
		botones.add(numeroReplicas);
		botones.add(terminarReplica);
		botones.add(cambiarColor);
		botones.add(cambiarDimension);
		botones.add(refrescar);
		principal.add(botones, BorderLayout.SOUTH);		
		return principal;
	}
	
	public void refresh(){
		colorAnteriorM = Color.white;
		colorAnteriorR = Color.black;
		for(int i=0; i<matrizBotones.length;i++){
			for(int j=0;j<matrizBotones[0].length;j++){				
				tablero.remove(matrizBotones[i][j]);
				matrizBotones[i][j] = new JButton();
				matrizBotones[i][j].setBackground(colorAnteriorM);
				tablero.add(matrizBotones[i][j]);
			}
		}
		prepareAcciones();
	}
	
	public void cambiarLosColores(){
		Color colorNuevoM = JColorChooser.showDialog(null,"Seleccione color para la matriz",colorAnteriorM);
		Color colorNuevoR = JColorChooser.showDialog(null,"Seleccione color para los cuadros a replicar",colorAnteriorR);
		for(int i=0;i<matrizBotones.length;i++){
			for(int j=0; j<matrizBotones[0].length;j++){
				if(matrizBotones[i][j].getBackground() == colorAnteriorM){
					matrizBotones[i][j].setBackground(colorNuevoM);
				}else{
					matrizBotones[i][j].setBackground(colorNuevoR);
				}
			}
		}
		colorAnteriorM = colorNuevoM;
		colorAnteriorR = colorNuevoR;
		
	}
	
	public void cambiarDimensionTablero(int filas,int columnas){
		colorAnteriorM = Color.white;
		colorAnteriorR = Color.black;
		for(int i=0; i<matrizBotones.length;i++){
			for(int j=0;j<matrizBotones[0].length;j++){				
				tablero.remove(matrizBotones[i][j]);		
			}
		}
		prepareElementosTablero(filas,columnas);
		prepareAcciones();
	}


}