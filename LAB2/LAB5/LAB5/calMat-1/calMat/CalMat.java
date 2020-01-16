
import java.util.Stack;

/** Calculadora.java
 * Representa una calculadora de matrices
 * @author ESCUELA 2019-02
 */
    
public class CalMat{

    private Stack<Matriz> operandos;
    //Consultar en el API Java la clase Stack
    
    public CalMat(){
        operandos = new Stack<Matriz>();      
    }
    public void empile(int [][] matriz){ 
        operandos.push(new Matriz(matriz));
    }
    
    //
    public void empile(int [] diagonal){ 
        operandos.push(new Matriz(diagonal));
    }
    
    //Todos los elementos son e
    public void empile(int e, int filas, int columnas){ 
        operandos.push(new Matriz(e,filas,columnas));
        
    }

    //Identidad de dimension d
    public void empile(int d){ 
        operandos.push(new Matriz(d));
    }
    

    public void desempile(){
        operandos.pop();
    }

    public String consulte(){
        String a;
        a=operandos.peek().toString();
        System.out.println(a);
        return a.toString();
        
    }
    

    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    public void opereMatrices(char operacion){
        Matriz m1;
        Matriz m2;
        Matriz m3;
        m1=operandos.pop();
        m2=operandos.pop();
        if (operacion=='+'){
            empile((m1.sume(m2)).getMatriz());
        }else if (operacion=='-'){
            empile((m1.reste(m2)).getMatriz());
        }else if (operacion=='.'){
            empile((m1.multipliqueElemento(m2)).getMatriz());
        }else if (operacion == '*'){
            empile((m1.multipliqueMatricial(m2)).getMatriz());
        }
        else{
            System.out.println("operacion no permitida");
        }
        
        
    }
        
        
     
        
     
    //Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo), d(dimensones)
    //Los operadores consideran todos los elementos de la matriz
    public void opereMatriz(char operacion){
        Matriz m1;
        m1=operandos.pop();
        if (operacion=='+'){
            System.out.println(m1.sumaMatriz());
        }else if (operacion=='-'){
            System.out.println(m1.promedio());
        }else if (operacion=='m'){
            System.out.println(m1.minimo());
        }else if (operacion == 'M'){
            System.out.println(m1.maximo());
        }else if (operacion == 'd'){
            int[] dimen = m1.dimensiones();
            System.out.println(Integer.toString(dimen[0])+" "+Integer.toString(dimen[1]));
        }
        else{
            System.out.println("operacion no permitida");
        }
        
    }
    //bb
    
    //Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo)
    //Las operaciones se realizan por filas    
    public void opereFilas(char operacion){
        Matriz m1;
        m1 = operandos.pop();
        if (operacion =='+'){
            int [] sumas = m1.sumaFila();
            for (int i= 0; i< sumas.length ; i++){
                System.out.println(sumas[i]);
            }
        }
        if (operacion == '-'){
            float [] promedios = m1.promedioFila();
            for (int i =0; i< promedios.length; i++){
                System.out.println(promedios[i]);
            }
            
        
        }
        if (operacion == 'm'){
            int [] minimos = m1.minimoFila();
            for (int i =0; i< minimos.length; i++){
                System.out.println(minimos[i]);
            }                    
        }
        if (operacion == 'M'){
            int [] maximos = m1.maximoFila();
            for (int i =0; i< maximos.length; i++){
                System.out.println(maximos[i]);
            }
        }
    }
    
    //Los operadores son: + (suma),  - (promedio), m (minimo), M (maximo)
    //Las operaciones se realizan por columnas
    
    //bb
    public void opereColumnas(char operacion){
        Matriz m1;
        m1 = operandos.pop();
        if (operacion =='+'){
            int [] sumas = m1.sumaColumna();
            for (int i= 0; i< sumas.length ; i++){
                System.out.println(sumas[i]);
            }
        }
        if (operacion == '-'){
            float [] promedios = m1.promedioColumna();
            for (int i =0; i< promedios.length; i++){
                System.out.println(promedios[i]);
            }
            
        
        }
        if (operacion == 'm'){
            int [] minimos = m1.minimoColumna();
            for (int i =0; i< minimos.length; i++){
                System.out.println(minimos[i]);
            }                    
        }
        if (operacion == 'M'){
            int [] maximos = m1.maximoColumna();
            for (int i =0; i< maximos.length; i++){
                System.out.println(maximos[i]);
            }
        }
    }    
    
    public void removerFila(){
        Matriz m1; 
        m1 = operandos.pop();
        int [][] matriz= m1.removerFila();
        for (int i = 0; i<matriz.length;i++){
            for (int j=0 ; j< matriz[0].length;j++){
                System.out.println(matriz[i][j]);
            }
            
        }
        
    }
    
    //Indica si se logro realizar la ultima accion
    public boolean ok(){
        return false;
    }
}
    



