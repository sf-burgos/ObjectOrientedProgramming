package presentacion;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
	
	public DonkeyPOOBGUI() {
		prepareElementosInicial();
	}
	
	public static void main(String args[]) {
		DonkeyPOOBGUI juego = new DonkeyPOOBGUI();
		juego.setVisible(true);
		
	}

	public void prepareElementosInicial() {
		layout = new CardLayout();
		setSize(new Dimension(900, 590));
		principal = new JPanel(layout);
		menuInicial = new PantallaInicial(PantallaInicial.fondoInicial);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}



	

}
