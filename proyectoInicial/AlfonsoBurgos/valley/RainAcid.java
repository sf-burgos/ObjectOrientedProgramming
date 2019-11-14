package valley;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;

public class RainAcid extends Rain
{
    /**
     * Constructor for objects of class RainAcid
     */
    public RainAcid (int x, int y)
    {
        super(x,y);     
    }
    public void startRain(int x,ArrayList<Tarp> listLonas,int realY){
        int j=0; 
        for (int i=0; i< listLonas.size();i++){                   
            while  (j!= realY ){
                if (listLonas.get(i).verificarHueco(x,j)){
                    j=j+1;Gota lluvia = new Gota (x,j);break;
                }else{
                    if (x <= listLonas.get(i).getPuntoDos()[0] && x >= listLonas.get(i).getPuntoUno()[0]){                   
                        float k= (listLonas.get(i).getPendiente()*x)+listLonas.get(i).getPuntoCorte();  
                        if (realY-j==(int) k){
                            listLonas.get(i).hacerHueco(i,x,realY);
                            j=j+1; 
                            break;
                        }else{
                            j=j+1;Gota lluvia = new Gota (x,j);
                        }                            
                    }else if(i<listLonas.size()-1 && (x<= listLonas.get(i+1).getPuntoDos()[0] && x >= listLonas.get(i+1).getPuntoUno()[0]) && !(listLonas.get(i+1).verificarHueco(x,j))){
                        break;
                    }else{   
                        j=j+1;Gota lluvia = new Gota (x,j);
                    }
                }                
            }            
        }
        while  (j!= realY ){
                j=j+1;Gota lluvia = new Gota (x,j);
        }
        lluviaX=x;
    }
    public void stopRain(int position){

            JOptionPane.showMessageDialog(null, "La lluvia acida no para"); 

        
    }
    
    
}
