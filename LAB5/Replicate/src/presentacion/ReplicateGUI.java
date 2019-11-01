package presentacion;
import java.awt.*; 
import javax.swing.*;


public class ReplicateGUI extends JFrame{	
	private Dimension dim;
	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	private ReplicateGUI(){		
		this.setTitle("Replicate");		
		prepareElementos();		
		prepareAcciones();
		
	}
	
	public static void main(String[] args){
		ReplicateGUI gui=new ReplicateGUI();
		gui.setVisible(true);		
	}
	
	public void prepareElementos(){		
		dim=super.getToolkit().getScreenSize();
		this.setMinimumSize(new Dimension(dim.width/2, dim.height/2));
	}
	public void prepareAcciones(){
		/*Close JFrame*/
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int siNo=JOptionPane.showConfirmDialog(this,"¿Desea cerrar esta ventana?",JOptionPane.YES_NO_OPTION);
				if(siNo==JOptionPane.YES_OPTION){
					e.getWindow().dispose();
				}
			}
		});
		
		
	
			
			
		
		
	}
	private void windowClosing(java.awt.event.WindowEvent e){
			
			if (siNo==JOptionPane.YES_OPTION){
				dispose();
			}
		}

}