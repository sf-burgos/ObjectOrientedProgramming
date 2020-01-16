

import java.util.Random; 
import java.util.ArrayList;
public class SquareSlotMachine
{
    // instance variables - replace the example below with your own
    private Rectangle MyDraw[];
    private Circle MyDraw2[];
    ArrayList<String> col = new ArrayList<>();
    
    private int vecesGanadas;
    private int vecesJugadas;
    private boolean estado;
    private String[][] colores; 
    private Circle[][] circulos;
    private int longitud;
    private int z;

    /**
     * Constructor for objects of class SquareSlotMachine
     */
    public SquareSlotMachine(int x)
    {
        // initialise instance variables
        vecesGanadas = 0; 
        vecesJugadas = 0; 
        estado = false; 
        colores = new String[x][x];
        circulos = new Circle[x][x];
     
        
         
    }
    public void pull(){
        col.add("red");
        col.add("blue");
        col.add("black");
        col.add("magenta");
        col.add("yellow");
        Random random = new Random();
        longitud = circulos.length;
        for(int i=0;i<longitud;i++){
            for(int j=0;j<longitud;j++){
                z =random.nextInt(4);
                colores[i][j] = col.get(z);
                System.out.println(z);
            }
        }
        
        
        
        
    }
    public void imprimirC(){
  
        for(int i=0;i<longitud;i++){
            for(int j=0;i<longitud;j++){
                System.out.println(colores);
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

}
