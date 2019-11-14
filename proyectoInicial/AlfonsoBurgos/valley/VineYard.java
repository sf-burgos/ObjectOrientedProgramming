
package valley;
import shapes.*;
import shapes.Rectangle;
public class VineYard
{
    private String name;
    private int inicio;
    private int fin;
    private Rectangle rectangle;
    private int altura;
    private boolean isVisible;

   
    /**
     * Contructor Objects type VineYard 
     * @param name nombre del viñero, xi posicion inicial, xf posicion final, visible vibilidad del objeto 
     */
    public VineYard(String name,int xi,int xf,int y,boolean visible)
    {
        inicio = xi;
        fin = xf;
        this.name = name;
        this.altura = y;
        rectangle = new Rectangle(3, xf-xi,xi,y, name);
        if(visible){
            rectangle.makeVisible();
        }
        
    }
    /**
     * Obtener coordenada de inicio del viñedo
     * @return inicio medida inicial en x 
     */
    public int getInicio(){
        return inicio;
    }
    /**
     * Obtener coordenada de fin del viñedo 
     * @return fin medida final en x
     */
    public int getFin(){
        return fin;
    }
    /**
     * Vuelve visible el objeto de tipo VineYard
     */
    public void makeVisible(){
        rectangle.makeVisible();
    }
    /**
     * Vuelve Invisible el objeto de tipo VineYard 
     */
    public void makeInvisible(){
        rectangle.makeInvisible(); 
    }
    /**
     * Obtener nombre de un VineYard
     * @return nombre del viñedo 
     */
    public String getName(){
        return name;
    }
    public String toStringCrear(){
        return "Cvinedo"+","+name+","+inicio+","+fin;
    }

    public String toStringBorrar(){
        return "Bvinedo"+","+name+","+inicio+","+fin;
    }
}