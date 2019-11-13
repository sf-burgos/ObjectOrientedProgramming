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
	public static final String fondoInicial = "rsc/donkeyInicial.png";
	protected JButton unPlayer,dosPlayer,playerVsCpu,cpuProtector,cpuMimo,cpuTemeroso,instrucciones,abrir,salir;
	private Image imagenFondo;
	
	public PantallaInicial(String imagen)  {
	
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
		//JPanel botones = new JPanel();
		//botones.setLayout(new FlowLayout(FlowLayout.LEFT, getWidth(), 650));
		
		unPlayer = new JButton("1 player");
		unPlayer.setBackground(Color.gray);
		unPlayer.setBounds(100, 100, 100, 100);
		add(unPlayer);
		
		//botones.add(unPlayer);
		
		dosPlayer = new  JButton("2 player");
		//botones.add(dosPlayer);
		
		playerVsCpu = new  JButton("player vs CPU");
		//botones.add(playerVsCpu);
		
		instrucciones = new  JButton("instrucciones");
		//botones.add(instrucciones);
	
		abrir = new  JButton("abrir");
		//botones.add(abrir);
		
		salir = new  JButton("salir");
		//botones.add(salir);
		
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
	
    }
	

}
