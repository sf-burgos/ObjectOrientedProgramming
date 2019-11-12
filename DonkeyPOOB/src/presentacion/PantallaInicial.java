package presentacion;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
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
	public static final String fondoInicial = "rsc/donkeyInicial.jpg";
	private BufferedImage fondo;
	protected JButton unPlayer,dosPlayer,playerVsCpu,cpuProtector,cpuMimo,cpuTemeroso,instrucciones,abrir,salir;
	private FlowLayout layout;
	
	public PantallaInicial(String imagen)  {
		super(null);
		prepareElementosInicio();
		setFondo(imagen);
		//setLayout(new FlowLayout(FlowLayout.LEFT, 8, 5));
	}
	
	private void setFondo(String root) {
		try {
			fondo = ImageIO.read(new File(root));
		}catch(IOException e){
			e.printStackTrace();
		}		
	}

	public void prepareElementosInicio(){
		removeAll();
		setFondo(PantallaInicial.fondoInicial);
		
		unPlayer = new JButton("1 player");
		add(unPlayer);
		
		dosPlayer = new  JButton("2 player");
		add(dosPlayer);
		
		playerVsCpu = new  JButton("player vs CPU");
		add(playerVsCpu);
		
		instrucciones = new  JButton("instrucciones");
		add(instrucciones);
	
		abrir = new  JButton("abrir");
		add(abrir);
		
		salir = new  JButton("salir");
		add(salir);
		
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this);
    }
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, this);
		
	}
}
