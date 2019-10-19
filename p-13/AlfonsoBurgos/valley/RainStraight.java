package valley;
import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class RainStraight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RainStraight extends Rain
{
    public RainStraight (int x, int y){   
        
        super(x,y);
    }

    public void startRain(int x, ArrayList<Tarp> listLonas,int realY){
        x=cambiarX(x, listLonas);
        int j=0; 
        for (int i=0; i< listLonas.size();i++){                   
            while  (j!= realY ){ 
                int[] punto = new int[2];
                punto[0]=x;punto[1]=j;
                if (listLonas.get(i).verificarHueco(x,j)){
                    j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;gotasDeLluvia.add(lluvia) ;break; 
                }else{
                    if (x <= listLonas.get(i).getPuntoDos()[0] && x >= listLonas.get(i).getPuntoUno()[0]){                   
                        float k= (listLonas.get(i).getPendiente()*x)+listLonas.get(i).getPuntoCorte();  
                        if (realY-j==(int) k){                                                                                                                                              
                            if ((float) listLonas.get(i).getPendiente()>0){
                                 x=x-1;j=j-1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;;gotasDeLluvia.add(lluvia);
                            
                            }else{
                                x=x+1; j=j-1;
                                Gota lluvia = new Gota (x,j); punto[0]=x;punto[1]=j; gotasDeLluvia.add(lluvia);
                        }
                        }else{
                            j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;gotasDeLluvia.add(lluvia);
                        }                            
                    }else if(i<listLonas.size()-1 && (x<= listLonas.get(i+1).getPuntoDos()[0] && x >= listLonas.get(i+1).getPuntoUno()[0]) && !(listLonas.get(i+1).verificarHueco(x,j))){
                        break;
                    }else{
                        j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;gotasDeLluvia.add(lluvia);
                    }
                }                
            }            
        }
        while  (j!= realY ){
            int[] punto = new int[2];j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;gotasDeLluvia.add(lluvia);
        }
        lluviaX=x;
    }
    public void stopRain(int position){
        makeInvisible();
    }
    
    public int getLluviaX(){
        return lluviaX;
    }
    public int[][] getCoordenadasLluvia(){
        return null;
 
    }
    public int cambiarX(int x, ArrayList<Tarp> listLonas){
        ArrayList<Integer> salidasPosibles = new ArrayList<Integer>();
        for (Tarp lona: listLonas){
            
            int puntoUno = lona.getPuntoUno()[0];
            int puntoDos = lona.getPuntoDos()[0];
            if (puntoUno<x && x<puntoDos){
                if (x-puntoUno>puntoDos-x){
                    salidasPosibles.add(puntoDos+1);
                }
                else{
                    salidasPosibles.add(puntoUno-1);
                }
            
        
            }
    }
    
    Collections.sort(salidasPosibles);
    for(Integer str: salidasPosibles){
			System.out.println(str);
		}
    if (x-salidasPosibles.get(0)> salidasPosibles.get(salidasPosibles.size()-1)-x){
        return salidasPosibles.get(salidasPosibles.size()-1);
    }
    return salidasPosibles.get(0);
}
}       
    
    

    
 
    


