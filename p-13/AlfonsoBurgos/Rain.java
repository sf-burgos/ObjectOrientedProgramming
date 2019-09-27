
/**
 * Write a description of class Rain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rain
{
    boolean flagRain;
    Rectangle rain;       
    /**
     * Constructor for objects of class Rain
     */
     //public Rectangle(int newHeight, int newWidth, int newXPosition, int newYPosition,String newColor ){
    public Rain (int x, int y){
        
        rain = new  Rectangle (1,1,x,y,"blue");
        rain.changeColor("blue");
        flagRain=true;
        rain.makeVisible();
        
        
    
    }
    
}
