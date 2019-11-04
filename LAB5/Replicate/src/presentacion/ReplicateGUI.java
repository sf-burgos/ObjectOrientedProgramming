package presentacion;
import java.awt.*; 
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
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
	/**Botones */ 
	private JButton replicar;
	private JButton numeroReplicas;
	private JButton terminarReplica;
	private JButton cambiarColor;
	private JButton cambiarDimension;
	private JButton[][] matrizBotones = new JButton[10][10];
	
	/**Constructor */ 
	private ReplicateGUI(){		
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
		prepareElementosTablero();
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
		for (int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				matrizBotones[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JButton evento = (JButton)e.getSource();
						evento.setBackground(Color.BLACK);
					}
				});
			}
		}

	}
	
	public void salga(){
			int valor=JOptionPane.showConfirmDialog(this,"¿Esta seguro de salir?","Advertencia",JOptionPane.YES_NO_OPTION);
			if(valor==JOptionPane.YES_OPTION){
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
	}
	
	/**Iniciar tablero */ 
	
	public JPanel prepareElementosTablero(){
		principal = new JPanel();
		setContentPane(principal);
		principal.setLayout(new BorderLayout());	
		JPanel tablero = new JPanel();
		tablero.setLayout(new GridLayout(10,10));		
		for(int i=0; i<10;i++){
			for(int j=0;j<10;j++){
				matrizBotones[i][j] = new JButton();	
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
		botones.setLayout(new GridLayout(2,3));
		botones.add(replicar);
		botones.add(numeroReplicas);
		botones.add(terminarReplica);
		botones.add(cambiarColor);
		botones.add(cambiarDimension);
		principal.add(botones, BorderLayout.SOUTH);		
		return principal;
	}
	



}