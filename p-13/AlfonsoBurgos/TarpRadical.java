
/**
 * Write a description of class TarpRadical here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TarpRadical extends Tarp{
        /**
         * Constructor for objects of class TarpHard
         */
        public TarpRadical(int[] lowerEnd ,int[] higherEnd,int h, boolean isVisible,String col){
            super(lowerEnd,higherEnd,h,isVisible,col);                                         
        }
        public void hacerHueco(int x,int h){
        super.hacerHueco(x,h);
        this.makeInvisible();
        }
        
}


