 package valley;
 import java.awt.*;
 import javax.swing.*;
public class TarpHard extends Tarp
{
    /**
     * Constructor for objects of class TarpHard
     */
    public TarpHard(int[] lowerEnd ,int[] higherEnd,int h, boolean isVisible,String col){
        super(lowerEnd,higherEnd,h,isVisible,col);                                         
    }
    public void hacerHueco(int tarp,int x,int h){
        JOptionPane.showMessageDialog(null, "No se puede hacer hueco, es una lona hard"); 
    }
    
}
