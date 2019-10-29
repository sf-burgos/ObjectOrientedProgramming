package valley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

 
/**
 * Write a description of class Rain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RainArcoiris extends Rain
{
    String[] colores = new String[]{"red", "white","magenta","blue", "yellow"};
    Random r = new Random(4);  

    public RainArcoiris (int x, int y){        
        super(x,y);
      
    }

    public void startRain(int x,ArrayList<Tarp> listLonas,int realY){
        int j=0; 
        for (int i=0; i< listLonas.size();i++){                   
            while  (j!= realY ){
                if (listLonas.get(i).verificarHueco(x,j)){
                    j=j+1;Gota lluvia = new Gota (x,j);lluvia.changeColor(colores[r.nextInt(4)]);gotasDeLluvia.add(lluvia); break;
                }else{
                    if (x <= listLonas.get(i).getPuntoDos()[0] && x >= listLonas.get(i).getPuntoUno()[0]){                   
                        float k= (listLonas.get(i).getPendiente()*x)+listLonas.get(i).getPuntoCorte();  
                        if (realY-j==(int) k){                                                                                                                                              
                            if ((float) listLonas.get(i).getPendiente()>0){
                                 x=x-1;j=j-1;Gota lluvia = new Gota (x,j);lluvia.changeColor(colores[r.nextInt(4)]);gotasDeLluvia.add(lluvia);                           
                            }else{
                                x=x+1; j=j-1;
                                Gota lluvia = new Gota (x,j);lluvia.changeColor(colores[r.nextInt(4)]);gotasDeLluvia.add(lluvia);  
                        }
                        }else{
                            j=j+1;Gota lluvia = new Gota (x,j);lluvia.changeColor(colores[r.nextInt(4)]);gotasDeLluvia.add(lluvia);
                        }                            
                    }else if(i<listLonas.size()-1 && (x<= listLonas.get(i+1).getPuntoDos()[0] && x >= listLonas.get(i+1).getPuntoUno()[0]) && !(listLonas.get(i+1).verificarHueco(x,j))){
                        break;
                    }else{
                        j=j+1;Gota lluvia = new Gota (x,j);lluvia.changeColor(colores[r.nextInt(4)]);gotasDeLluvia.add(lluvia);
                    }
                }                
            }            
        }
        while  (j!= realY ){
                j=j+1;Gota lluvia = new Gota (x,j);lluvia.changeColor(colores[r.nextInt(4)]);gotasDeLluvia.add(lluvia);
        }
        lluviaX=x;
    }
    public void stopRain(int position){

            for(Gota gotas: gotasDeLluvia){
                gotas.makeInvisible();
            }            

        
    }
}
