package presentacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.io.File;
import aplicacion.TeatroColonException;

import aplicacion.*;


public class TeatroColonGUI extends JFrame{
    
    private Teatro teatro=null;
    
    private JPanel botones;
    private JScrollPane contenedor;
    private JButton botonAccion;
    private JButton botonCorten;
    private JButton botonDecision;  
	
	/**Barra menu */
	private JMenuBar menu;
	private JMenu archivo;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem importar;
	private JMenuItem exportar;
	private JMenuItem guardarComo;
	private JMenuItem salir;
    private File archivoPrueba;
   
    private FotoTeatro foto;
    
    
    private TeatroColonGUI() {
        super("Teatro Colón");
        try {
            teatro=Teatro.demeTeatro();     
            teatro.algunosEnEscena();
            elementos();
            acciones();
        } catch(Exception e) {
            e.printStackTrace();
        }
		 //File archivoPrueba = new File ("src/data/hola.dat");
    }
    
    private void elementos() throws TeatroColonException {
        
        setLayout(new BorderLayout());    
        contenedor = new JScrollPane();
        
        foto= new FotoTeatro();
        contenedor.getViewport().add(foto);
        
        botones=new JPanel(new GridLayout(1,3));
        botonAccion=new JButton("Actuen");
        botonCorten=new JButton("Corten");
        botonDecision=new JButton("Decidan"); 
        botones.add(botonAccion);
        botones.add(botonCorten);
        botones.add(botonDecision); 
        
        add(contenedor,BorderLayout.CENTER);
        add(botones,BorderLayout.SOUTH);
        
        pack();
        setSize(Teatro.MAXIMO+100,Teatro.MAXIMO+135);

        setResizable(false);
		prepareElementosMenu();
		
    }
    	public void prepareElementosMenu(){
		menu=new JMenuBar();
		archivo= new JMenu("Archivo");
		nuevo= new JMenuItem("Nuevo");
		abrir= new JMenuItem("Abrir");
		importar= new JMenuItem("Importar");
		exportar= new JMenuItem("Exportar");
		guardarComo= new JMenuItem("Guardar Como");
		salir= new JMenuItem("Salir");
		archivo.add(nuevo);
		archivo.add(abrir);
		archivo.add(importar);
		archivo.add(exportar);
		archivo.add(guardarComo);
		archivo.add(salir);
		menu.add(archivo);
		
		setJMenuBar(menu);
		
	}
    
    private void acciones(){
        ActionListener oyenteBotonAccion=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                accion();
            }   
        };  
        botonAccion.addActionListener(oyenteBotonAccion);
        
        ActionListener oyenteBotonCorten=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                corten();
            }   
        };  
        botonCorten.addActionListener(oyenteBotonCorten);
        
        ActionListener oyenteBotonDecision=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                decidan();
            }   
        }; 
        
        botonDecision.addActionListener(oyenteBotonDecision);
        
        WindowListener w = new WindowAdapter() { 
            public void windowClosing(WindowEvent e) {
                salga();
            }
        };  
        
        this.addWindowListener(w);
        
		prepareAccionesMenu();
	}
	public void prepareAccionesMenu(){
		nuevo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//elementos();
				teatro.nuevoTeatro();
				teatro.demeTeatro();
				teatro.algunosEnEscena();
				acciones();
				repaint();
			
			}
			
		});
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				salir();
			}
			
		});
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
					try{
					Teatro.abrir(f);
					teatro  = Teatro.getTeatro();
					//detenerSonidos();
					elementos();
				//actualizar();
				}catch(TeatroColonException ec) {
				JOptionPane.showMessageDialog(null, ec.getMessage(), "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
				}
			}
			}
		});
		
		guardarComo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = chooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File f = new File("./"+chooser.getSelectedFile().getName()+".dat");
					try {
					teatro.salvar(f);
					}catch(TeatroColonException ec) {
						JOptionPane.showMessageDialog(null, ec.getMessage(), "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
					}
				
				}
			}
				});
		
				
    }
    private void accion(){
         teatro.accion();
         
         actualice();
    }
    
    
    private void corten(){       
        teatro.corten();
        
        actualice();
    }       
    
    private void decidan(){       
        teatro.decidan();
        actualice();
	
    }   
    
    private void actualice(){
        foto.actualice();
    }
    
    
    
    private void salir(){
        dispose();
        System.exit(0);
    }   
    
    
    
    public static void main(String[] args) {
        TeatroColonGUI gui=new TeatroColonGUI();
        gui.setVisible(true);
    }   
    
    class FotoTeatro extends JComponent {
        private int x,y;
        
        private static final int MAX=Teatro.MAXIMO;
        
        
        
        public void actualice(){
            teatro=Teatro.demeTeatro();
            repaint();
        }
        
        public void paintComponent(Graphics g){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
            
            for (int i=1; i<=teatro.numeroEnEscena(); i++) {
                
                EnEscena e=teatro.demeEnEscena(i);
                int x=e.getPosicionX();
                int y=MAX-e.getPosicionY();  
                
                g.setColor(e.getColor()); 
                g.drawString(e.mensaje(),x+20,y+10);   
                
                if (e.forma().equals("Persona")){
                    humano(g,(Persona)e,x,y);
                } else  if (e.forma().equals("Circulo")){
                    g.fillOval(x+10,y+0,20,20);
                } else  if (e.forma().equals("Cuadrado")){
                    g.fillRect(x,y,20,20);
                }
            }
            super.paintComponent(g);
        }
        
        
        public void humano(Graphics g, Persona e,int x, int y){
            int pos;
            g.setColor(Color.PINK);
            g.fillOval(x+10,y+0,10,10);/*cabeza*/
            g.setColor(e.getColor()); 
            g.drawLine(x+10+5,y+10,x+10+5,y+10+20);
            
            pos=e.getPosicionBrazo('I');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10);/*brazo izq arriba*/
            } else if (pos==Persona.FRENTE){
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10+5);/*brazo izq al frente*/
            } else {
                g.drawLine(x+10+5,y+10+5,x+10+15,y+10+10);/*brazo izq abajo*/
            }
            
            pos=e.getPosicionBrazo('D');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+5,y+10+5,x+5,y+10);/*brazo der arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+10+5,y+10+5,x+5,y+10+5);/*brazo der al frente*/
            } else{
                g.drawLine(x+10+5,y+10+5,x+5,y+10+10);/*brazo der abajo*/
            }
            
            g.drawLine(x+10+5,(y+15)+10+5,x+10+15,(y+15)+10+15);
            g.drawLine(x+10+5,(y+15)+10+5,x+5,(y+15)+10+15);
            
           pos=e.getPosicionPierna('D');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+5,(y+15)+10+15,x+5+10,(y+15)+10+15);/*pierna der arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+5,(y+15)+10+15,x+5-10,(y+15)+10+15+5);/*pierna der al frente*/
            } else{
                g.drawLine(x+5,(y+15)+10+15,x+5,(y+15)+10+15+10);/*pierna der abajo*/
            }
            
            pos=e.getPosicionPierna('I');
            if (pos==Persona.ARRIBA){
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15-10,(y+15)+10+15);/*pierna izq arriba*/
            } else if  (pos==Persona.FRENTE){
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15+10,(y+15)+10+15+5);/*pierna izq al frente*/
            }else {
                g.drawLine(x+10+15,(y+15)+10+15,x+10+15,(y+15)+10+15+10);/*piernaizqabajo*/
            }
        }
    }
		public void salga(){
			
			int valor=JOptionPane.showConfirmDialog(this,"Esta seguro de salir?","Advertencia",JOptionPane.YES_NO_OPTION);
			if(valor==JOptionPane.YES_OPTION){
				System.exit(0);
			}
			else{
				this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
			}
		}
		
	
	
}






