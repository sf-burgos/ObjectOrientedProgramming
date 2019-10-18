 
public class TarpHard extends Tarp
{
    /**
     * Constructor for objects of class TarpHard
     */
    public TarpHard(int[] lowerEnd ,int[] higherEnd,int h, boolean isVisible,String col){
        super(lowerEnd,higherEnd,h,isVisible,col);                                         
    }
    public void hacerHueco(int x,int h){
        System.out.println("No se puede hacer hueco, es una lona hard"); 
    }
    
}
