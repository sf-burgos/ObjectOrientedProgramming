package valley;
import java.util.Arrays;
import java.lang.Math;

public class valleyContest
{
    private int xi,xf,lonas;
    private int valley[][][];
    private int solucion[][];
    private int max;
    public valleyContest(){
    }
    
    public int solve(int vineyard[],int tarp[][]){
        xi=vineyard[0];
        xf=vineyard[1];
        lonas=vineyard[2];
        solucion= new int[lonas][5];
        max=xf;
        
        for (int i=0; i<lonas; i++){
            int x1,x2,y1,y2;
            int m,maX,minX;
            x1=tarp[i][0];
            y1=tarp[i][1];
            x2=tarp[i][2];
            y2=tarp[i][3];
            double pendiente=(y2-y1)/(x2-x1);
            if(pendiente>0){m=-1;}else{m=1;}
            if (x1<x2){maX=x2;minX=x1;}else{maX=x1;minX=x2;}
            if (max<maX){max=maX;}
            int f[]={m,y1,y2,minX,maX};
            solucion[i]=f;                       
        }
        
        valley=matrizSolucion(solucion,vineyard,max+1);
        int g=(xf-xi)/2;
        int puntosNecesarios=posibleSolucion(xi,0);
        return puntosNecesarios;
    }           
    
    private int posibleSolucion(int x,int y){
        int t=0;
        if (x>max || x<0){ t=1000;
        }else if (valley[y][x][0]==-2){t=1000;
        }else if (valley[y][x][0]==0 && valley[y][x][1]==0){ 
            t=0;
        }else if(valley[y][x][1]==1){
            t=posibleSolucion(x,y+1);
        }else if(valley[y][x][0]==1 || valley[y][x][0]==-1){ 
            int min=Math.min(posibleSolucion(x,y+1)+1,posibleSolucion(x+valley[y][x][0],y));
            t=min;
        }
        return t;
    }

    private int[][][] matrizSolucion(int sol[][],int vineyard[],int n){
        int valley[][][]= new int[lonas+1][n][2];
        int inf[]={-2,0},b[]={0,1};
        for (int i=0;i<lonas+1;i++){
            for (int j=0;j<n;j++){
                valley[i][j]=b;
                if(i==lonas){valley[i][j]=inf;}
            }
        }
        
        for (int i=vineyard[0];i<=vineyard[1];i++){
           int f[]={0,0};
           valley[lonas][i]=f;
        }
        
        quicksort(sol,0,lonas-1);
        
        for (int i=0;i<lonas;i++){
            int temp[]={sol[i][0],0};
            for (int j=sol[i][3];j<=sol[i][4];j++){
                valley[i][j]=temp;
            }
        }
        
        return valley;
    }
    
    private static void quicksort(int A[][], int izq, int der) {    
      int pivote[]=A[izq]; 
      int i=izq; 
      int j=der; 
      int aux[];     
      while(i<j){            
         while(A[i][1]>=pivote[1]  && i<j) i++; 
         while(A[j][1]<pivote[1]) j--;         
         if (i<j) {                                         
             aux= A[i];                
             A[i]=A[j]; 
             A[j]=aux;
         }
      }
       A[izq]=A[j];
       A[j]=pivote; 
       if(izq<j-1)
          quicksort(A,izq,j-1); 
       if(j+1 <der)
          quicksort(A,j+1,der); 
    }
}