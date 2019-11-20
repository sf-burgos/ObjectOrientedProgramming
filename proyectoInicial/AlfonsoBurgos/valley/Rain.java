package valley;

import java.util.ArrayList;
import java.util.Arrays;

import shapes.*;
import shapes.Rectangle;

public class Rain
{
    
    private boolean flagRain;
    private Rectangle rain;    
    public static int lluviaX;
    private int[][] lluviaCompleta;
    private int xInicial;
    public static  ArrayList<Gota> gotasDeLluvia;
    /**
     * Constructor for objects of class Rain
     */
     
    public Rain (int x, int y){        
        rain = new  Rectangle (1,1,x,y,"blue");
        rain.changeColor("blue");
        flagRain=true;
        rain.makeVisible();   
        xInicial=x;
        gotasDeLluvia = new ArrayList<Gota>();
    }

    public void startRain(int x,ArrayList<Tarp> listLonas,int realY){
        lluviaCompleta = new int[realY+1][1];
        int j=0; 
        for (int i=0; i< listLonas.size();i++){                   
            
                int[] punto = new int[2];
                punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;
                if (listLonas.get(i).verificarHueco(x,j)){
                    j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;gotasDeLluvia.add(lluvia);
                    System.out.println(i+" "+j);
                    break; 
                }else{
                    if (x <= listLonas.get(i).getPuntoDos()[0] && x >= listLonas.get(i).getPuntoUno()[0]){                   
                        float k= (listLonas.get(i).getPendiente()*x)+listLonas.get(i).getPuntoCorte();  
                        if (realY-j==(int) k){                                                                                                                                              
                            if ((float) listLonas.get(i).getPendiente()>0){
                                 x=x-1;j=j-1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;gotasDeLluvia.add(lluvia);System.out.println(i+" "+j);
                            
                            }else{
                                x=x+1; j=j-1;
                                Gota lluvia = new Gota (x,j); punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto; gotasDeLluvia.add(lluvia);
                                System.out.println(i+" "+j);
                        }
                        }else{
                            j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;gotasDeLluvia.add(lluvia);                    System.out.println(i+" "+j);
                        }                            
                    }else if(i<listLonas.size()-1 && (x<= listLonas.get(i+1).getPuntoDos()[0] && x >= listLonas.get(i+1).getPuntoUno()[0]) && !(listLonas.get(i+1).verificarHueco(x,j))){
                        break;
                    }else{
                        j=j+1;Gota lluvia = new Gota (x,j);punto[0]=x;punto[1]=j;lluviaCompleta[j]=punto;gotasDeLluvia.add(lluvia);                    System.out.println(i+" "+j);
                    }
                }                
            }            
       
        
        lluviaX=x;
    }
    public void stopRain(int position){

            for(Gota gotas: gotasDeLluvia){
                gotas.makeInvisible();
            }            

        
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
    
    public void makeInvisible(){
        for (Gota g: gotasDeLluvia ){
            g.makeInvisible();
        }
    }
}

