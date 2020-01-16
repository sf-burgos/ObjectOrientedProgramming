import java.util.ArrayList;
/**
 * @author ECI, 2019
 *
 */
public class Matriz{


    public static Matriz UNCERO= new Matriz(new int[][]{{0}});
    private int[][] alfaMatriz;
    public boolean r;
    int [][] matrizCero = {{0}};
    //
  


    /**
     * Retorna una matriz dados sus elementos. Si hay error en datos, retorna la matriz [0]
     */
    public Matriz (int  elementos[][]) {
        matrizElementos(elementos);

    }

    public int[][] getMatriz(){
        return alfaMatriz;
    }

    public int[][] getMatrizCero(){
        return matrizCero;
    }

    public int [][] matrizElementos(int elementos[][]){
        alfaMatriz = new int[elementos.length][elementos[0].length];
        int longitudColumna;
        for(int i=0; i<alfaMatriz.length;i++){
            longitudColumna=elementos[i].length;
            if(elementos[i].length != longitudColumna){
                return matrizCero;
            }
        }

        if(elementos.length == 0){

            return matrizCero;
        }
        for(int i=0; i<elementos.length; i++){
            for(int j=0; j<elementos[0].length;j++){
                alfaMatriz[i][j] = elementos[i][j];             
            }
        }

        return alfaMatriz;
        //correcto                   
    }

    
    /**
     * Retorna una matriz da su diagonal. Si hay error en datos, retorna la matriz [0]
     */    
    public Matriz (int d []){

        diagonalM(d);

    }    

    public int[][] diagonalM(int d[]){
        alfaMatriz = new int[d.length][d.length];
        for(int i=0;i<d.length;i++){
            for(int j=0;j<d.length;j++){
                if(i==j){
                    alfaMatriz[i][j] = d[i];
                }
                else{
                    alfaMatriz[i][j] = 0; 
                }      
            }   
        }
        return alfaMatriz; 

    }

    /**
     * Retorna una matriz de un numero repetido dada su dimension. Si hay error en datos, retorna la matriz [0]
     */
    public Matriz (int e, int f, int c) {
        matrizRepetido(e,f,c);
    }

    public int[][] matrizRepetido(int e, int f, int c){
        alfaMatriz= new int[f][c];
        if(f<=0 || c<=0){
            return matrizCero;
        }
        for(int i=0;i<alfaMatriz.length;i++){
            for(int j=0; j<alfaMatriz[0].length; j++){
                alfaMatriz[i][j] = e;
            }
        }
        return alfaMatriz;

    }
    /**
     * Retorna una matriz identidad dada su dimension. Si hay error en datos, retorna la matriz [0]
     */
    public Matriz (int n) {
        matrizIdentidad(n);
    }

    public int[][] matrizIdentidad(int n){
        alfaMatriz = new int[n][n];
        if(n <= 0){
            return matrizCero;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    alfaMatriz[i][j] = 1;
                }else{
                    alfaMatriz[i][j] = 0;
                }
            }
        }
        return alfaMatriz;
    }

    public Matriz dimension(){
        return null;
    }

    public int get(int f, int c){
        return 0;
    }

    /**
     * Compara esta matriz con otra
     */
    public boolean equals(Matriz otra) {
        r=true;
        int[][] alphaMatriz=getMatriz();
        int[][] otraMatriz=otra.getMatriz();  
        r = (otraMatriz.length == alphaMatriz.length )? true : false;
        if(r){
            for (int i=0;i<alphaMatriz.length;i++){
                r = r&&(alphaMatriz[i].length == otraMatriz[i].length);
                if(r){
                    for (int j=0;j<alphaMatriz[0].length;j++){
                        if (otraMatriz[i][j]!=alphaMatriz[i][j]){
                            r = false;
                            break;          
                        }                                    
                    }
                }
            }                     
        }
        return r;
    }

    public void imprimirMatriz(int[][] matriz){
        int[][] mat = matriz;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.println(mat[i][j]);            
            }
        }
    }

    /** 
     * Compara esta matriz con otra
     */
    @Override
    public boolean equals(Object otra) {
        boolean flag = true;
        if(otra instanceof Matriz){
            Matriz alfa = (Matriz) otra;
            int[][] comparar= this.alfaMatriz; 
            flag = comparar.equals(alfa.alfaMatriz);
        }
        return flag;
    }

    /** 
     * Retorna una cadena con los datos de la matriz alineado por columna
     * 
     */
    @Override
    public String toString () {
        String resu="";
        for (int i = 0; i< alfaMatriz.length; i++){
            for (int j=0; j< alfaMatriz.length; j++){
                resu+= Integer.toString(alfaMatriz[i][j])+" ";
            }
            resu+="\n";
        }
        return resu;
    }   

    //Retorna la matriz con el numero de filas o columnas
    public Matriz sume(Matriz m){
        int[][] operar=m.getMatriz();
        int[][] matrizT =new int[m.getMatriz().length][m.getMatriz().length];
        if (operar.length==alfaMatriz.length && operar[0].length==alfaMatriz[0].length){

            for (int i=0;i<m.getMatriz().length;i++){
                for (int j=0; j<m.getMatriz()[i].length;j++){
                    matrizT[i][j]=alfaMatriz[i][j]+operar[i][j];
                }
            }
            Matriz resultado=new Matriz(matrizT);
            
            return resultado;
        }
        else{
            return UNCERO;
        }
        
        
         
        
    }
          
    public Matriz reste(Matriz m){
        int[][] operar=m.getMatriz();
        int[][] matrizT =new int[m.getMatriz().length][m.getMatriz().length];
        if (operar.length==alfaMatriz.length && operar[0].length==alfaMatriz[0].length){

            for (int i=0;i<m.getMatriz().length;i++){
                for (int j=0; j<m.getMatriz()[i].length;j++){
                    matrizT[i][j]=alfaMatriz[i][j]-operar[i][j];
                }
            }
            Matriz resultado=new Matriz(matrizT);
            
            return resultado;
        }
        else{
            return UNCERO;
        }
        
        
         
        
    }
         
  public Matriz multipliqueElemento(Matriz m){
        int[][] operar=m.getMatriz();
        int[][] matrizT =new int[m.getMatriz().length][m.getMatriz()[0].length];
        if (operar.length==alfaMatriz.length){

            for (int i=0;i<m.getMatriz().length;i++){
                for (int j=0; j<m.getMatriz()[i].length;j++){
                    matrizT[i][j]=alfaMatriz[i][j]*operar[i][j];
                }
            }
            Matriz resultado=new Matriz(matrizT);
            
            return resultado;
        }
        else{
            return UNCERO;
        }
        
        
         
        
    }
    public Matriz multipliqueMatricial(Matriz m){
        int[][] operar=m.getMatriz();
        int[][] matrizT =new int[alfaMatriz.length][operar[0].length];
        System.out.println(matrizT.length);
        System.out.println(matrizT[0].length);
        if (operar.length==alfaMatriz[0].length){
            for (int i=0;i<alfaMatriz.length;i++){
                for (int j=0; j<operar[0].length;j++){
                    for(int k=0; k<alfaMatriz[0].length;k++){
                        matrizT[i][j]+=alfaMatriz[i][k]*operar[k][j];
                        
                    }
                }
            }
            Matriz resultado=new Matriz(matrizT);
            
            return resultado;
        }
        else{
            return UNCERO;
        }
    
    }
    
    public int sumaMatriz(){
        int sumatoria = 0;
        int[][] operar=alfaMatriz;
        for (int i=0;i<operar.length;i++){
            for (int j=0; j<operar[i].length;j++){
                sumatoria +=operar[i][j];
            }
        }
        return sumatoria;  
    }
    
    public float promedio(){
        return (float) sumaMatriz()/(alfaMatriz[0].length*alfaMatriz.length);
    }
    
    public int minimo(){
        int minimo = 10000;
        for (int i=0; i<alfaMatriz.length; i++){
            for(int j=0 ; j <alfaMatriz[0].length;j++){
                if (alfaMatriz[i][j] < minimo){
                    minimo = alfaMatriz[i][j];
                }
            }
        }
        return minimo;
    }
    
    public int maximo(){
        int maximo = -10000;
        for (int i=0; i<alfaMatriz.length; i++){
            for(int j=0 ; j <alfaMatriz[0].length;j++){
                if (alfaMatriz[i][j] > maximo){
                    maximo = alfaMatriz[i][j];
                }
            }
        }
        return maximo;
        
    }
    public int[] dimensiones(){
        int filas;
        int columnas; 
        int[] dimension = new int[5]; 
        filas = alfaMatriz.length; 
        columnas = alfaMatriz[0].length;
        dimension[0] = filas;
        dimension[1] = columnas; 
        return dimension; 
      
    }
    
    public int[] sumaFila(){
        int [] sumas = new int[alfaMatriz.length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                sumas[i] += alfaMatriz[i][j];
            }
        }
        return sumas;
    
    }
    
    public float[]promedioFila(){            
        float [] sumas = new float[alfaMatriz.length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                sumas[i] += alfaMatriz[i][j];
            }
            sumas[i] = (float) (sumas[i] / alfaMatriz.length);
        }
        return sumas;
    }
    public int[] minimoFila(){
        int [] minimo = new int[alfaMatriz.length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            int min = 10000; 
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                if(min > alfaMatriz[i][j]){
                    min = alfaMatriz[i][j];
                }
            }
            minimo[i] = min; 
        }
        return minimo;
    
    }
    
    public int[] maximoFila(){
        int [] maximo = new int[alfaMatriz.length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            int max = -10000; 
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                if(max < alfaMatriz[i][j]){
                    max = alfaMatriz[i][j];
                }
            }
            maximo[i] = max; 
        }
        return maximo;
    
    }
    public int[] sumaColumna(){
        int [] sumas = new int[alfaMatriz.length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                sumas[i] += alfaMatriz[j][i];
            }
        }
        return sumas;
    
    }
    
    public float[]promedioColumna(){            
        float [] sumas = new float[alfaMatriz[0].length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                sumas[i] += alfaMatriz[j][i];
                
            }
            sumas[i] = (float) (sumas[i] / alfaMatriz[0].length);
        }
        return sumas;
    }
    public int[] minimoColumna(){
        int [] minimo = new int[alfaMatriz[0].length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            int min = 10000; 
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                if(min > alfaMatriz[j][i]){
                    min = alfaMatriz[j][i];
                }
            }
            minimo[i] = min; 
        }
        return minimo;
    
    }
    public int[] maximoColumna(){
        int [] maximo = new int[alfaMatriz[0].length];
        for(int i=0 ; i < alfaMatriz.length ; i++){
            int max = -10000; 
            for(int j=0 ; j < alfaMatriz[0].length ; j++){
                if(max < alfaMatriz[j][i]){
                    max = alfaMatriz[j][i];
                }
            }
            maximo[i] = max; 
        }
        return maximo;
    
    }
    public int[][] removerFila(){
        int[][] nuevaMatriz= new int[alfaMatriz.length-1][alfaMatriz[0].length];
        for (int i = 0; i < alfaMatriz.length-1; i++){
            for(int j=0; j < alfaMatriz[0].length; j++){
                nuevaMatriz[i][j] = alfaMatriz[i][j];
            }
        }
        return nuevaMatriz;
    }
    
    
        
    
    //Retorna una matriz de un elemento
    public Matriz sume(){
        return null;
    }    

    //foc: indica si la suma es por filas('f') o por columnas('c')
    public Matriz sume(char foc){
        return null;
    }
    
    
    
    
}
