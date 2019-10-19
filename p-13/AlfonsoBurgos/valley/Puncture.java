package valley;
import shapes.*;
public class Puncture
{
    // instance variables - replace the example below with your own
    private Rectangle hueco;
    private int xPosition; 
    private int yPosition;
    private boolean isVisible;
    private int lona;
    /**
     * Constructor for objects of class Puncture
     * @param xPos posicion en X, yPos  posicion en Y, visible visibilidad del objeto 
     */
    public Puncture(int xPos,int yPos,boolean visible)
    {
        xPosition = xPos;
        yPosition = yPos;
        hueco = new Rectangle(5,5,xPosition,yPosition,"yellow");
        if(visible){
            hueco.makeVisible();
        }
        
       
    }
    /**
     * Vuelve invisible el objeto de tipo Puncture 
     */
    public void makeInvisible(){
        hueco.makeInvisible();
    }
    /**
     * Vuelve visible el objeto de tipo Pucture 
     */
    public void makeVisible(){
        hueco.makeVisible();
    }
    
    public int getXPos(){
        return xPosition;
    }
    
    public int getYPos(){
        return yPosition;
    }
    public void darLona(int tarp){
        lona = tarp;
    }
    public String toStringCrear(){
        return "CPuncture"+","+ lona + "," + xPosition + "," + yPosition;
    }
        public String toStringBorrar(){
        return "BPuncture" +","+ lona+ "," + xPosition + "," + yPosition;
    }
}       