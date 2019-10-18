import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a description of class Rain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rain
{
    boolean flagRain;
    Rectangle rain;    
    public static int lluviaX;
    int[][] lluviaCompleta;
    private int xInicial;
    /**
     * Constructor for objects of class Rain
     */
     //public Rectangle(int newHeight, int newWidth, int newXPosition, int newYPosition,String newColor ){
    public Rain (int x, int y){        
        rain = new  Rectangle (1,1,x,y,"blue");
        rain.changeColor("blue");
        flagRain=true;
        rain.makeVisible();   
        xInicial=x;
    }

    public void startRain(int x,ArrayList<Tarp> listLonas,int realY){
        lluviaCompleta = new int[realY+1][1];
        int j=0; 
        for (int i=0; i< listLonas.size();i++){                   
            while  (j!= realY ){ 
                int[] punto = new int[2];
                punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;
                if (listLonas.get(i).verificarHueco(x,j)){
                    j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;break;
                }else{
                    if (x <= listLonas.get(i).getPuntoDos()[0] && x >= listLonas.get(i).getPuntoUno()[0]){                   
                        float k= (listLonas.get(i).getPendiente()*x)+listLonas.get(i).getPuntoCorte();  
                        if (realY-j==(int) k){                                                                                                                                              
                            if ((float) listLonas.get(i).getPendiente()>0){
                                 x=x-1;j=j-1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;
                            
                            }else{
                                x=x+1; j=j-1;
                                Gota lluvia = new Gota (x,j); punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto; 
                        }
                        }else{
                            j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;
                        }                            
                    }else if(i<listLonas.size()-1 && (x<= listLonas.get(i+1).getPuntoDos()[0] && x >= listLonas.get(i+1).getPuntoUno()[0]) && !(listLonas.get(i+1).verificarHueco(x,j))){
                        break;
                    }else{
                        j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;
                    }
                }                
            }            
        }
        while  (j!= realY ){
            int[] punto = new int[2];j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;
        }
        lluviaX=x;
    }
    public void stopRain(int position){
    
    }
    
    public int getLluviaX(){
        return lluviaX;
    }
    public int[][] getCoordenadasLluvia(){
        return lluviaCompleta;
 
    }
    public int getXInicial(){
        return xInicial;
    }
}

