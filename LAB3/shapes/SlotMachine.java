
import java.util.Random; 
import java.util.ArrayList;
public class SlotMachine{
    // instance variables - replace the example below with your own
    ArrayList<String> colores = new ArrayList<>();
    private int primera;
    private int segunda;
    private int tercera;
    private int vecesGanadas;
    private int vecesJugadas;
    private boolean estado; 
    private Circle circulo1;
    private Circle circulo2;
    private Circle circulo3;
    private Rectangle rectangulo1;
    private String color1;
    private String color2;
    private String color3;
 
 
    


    /**
     * Constructor for objects of class SlotMachine
     */
    //Miniciclo 1 
    public SlotMachine()
    {
        // initialise instance variables
        primera = 0;
        segunda = 0;
        tercera = 0; 
        vecesGanadas = 0;
        vecesJugadas = 0; 
        estado = false; 
        circulo1 = new Circle();
        circulo1.moveHorizontal(60);
        circulo2 = new Circle();
        circulo2.moveHorizontal(100);
        circulo3 = new Circle(); 
        circulo3.moveHorizontal(140);
        rectangulo1 = new Rectangle(); 
        rectangulo1.changeSize(100,200);
        rectangulo1.moveHorizontal(-50);
        rectangulo1.moveVertical(50);
        rectangulo1.makeVisible();
        
        

        
    }
    
    public void pull(){
    
        
    
        colores.add("red"); 
        colores.add("black");
        colores.add("blue");
        colores.add("magenta");
        Random random = new Random(); 
        primera=random.nextInt(4);
        segunda=random.nextInt(4);
        tercera=random.nextInt(4);
        color1 = colores.get(primera);
        color2 = colores.get(segunda);
        color3 = colores.get(tercera);    
        circulo1.changeColor(color1);
        circulo2.changeColor(color2);
        circulo3.changeColor(color3);
        circulo1.makeVisible();
        circulo2.makeVisible();
        circulo3.makeVisible();
        isWinningState();
        
    }
    public void pullT(int times){
        for(int i = 0; i < times; i++){
            colores.add("red"); 
            colores.add("black");
            colores.add("blue");
            colores.add("magenta");
            Random random = new Random(); 
            primera=random.nextInt(4);
            segunda=random.nextInt(4);
            tercera=random.nextInt(4);
            color1 = colores.get(primera);
            color2 = colores.get(segunda);
            color3 = colores.get(tercera);    
            circulo1.changeColor(color1);
            circulo2.changeColor(color2);
            circulo3.changeColor(color3);
            circulo1.makeVisible();
            circulo2.makeVisible();
            circulo3.makeVisible();
            isWinningState();
            
        }
        
    }
    public boolean isWinningState(){
        if(primera == segunda && primera == tercera){
            estado = true;
            vecesGanadas++;
            vecesJugadas++;
        }else{
            estado = false;
            vecesJugadas++;
        }
        return estado; 
    }
    //Miniciclo 2 
    public void reset(){
        primera = 0;
        segunda = 0;
        tercera = 0; 
        vecesGanadas = 0; 
        vecesJugadas = 0;
        estado = false;
        circulo1.makeInvisible();
        circulo2.makeInvisible();
        circulo3.makeInvisible();
    }
    
    public double percentageOfWinningStages(){
        double porcentaje;
        porcentaje =(double)vecesGanadas/vecesJugadas*(100);
        return porcentaje; 
       
    }
    
    public void makeVisible(){
        rectangulo1.makeVisible();
        circulo1.makeVisible();
        circulo2.makeVisible();
        circulo3.makeVisible();
        
        
    }
    public void makeInvisible(){
        rectangulo1.makeInvisible();
        circulo1.makeInvisible();
        circulo2.makeInvisible();
        circulo3.makeInvisible();
    }
    public void move(int horizontal, int vertical){
        rectangulo1.moveHorizontal(horizontal);
        rectangulo1.moveVertical(vertical);
        circulo1.moveHorizontal(horizontal);
        circulo1.moveVertical(vertical);
        circulo2.moveHorizontal(horizontal);
        circulo2.moveVertical(vertical);
        circulo3.moveHorizontal(horizontal);
        circulo3.moveVertical(vertical);
        
    }
   
 


}
