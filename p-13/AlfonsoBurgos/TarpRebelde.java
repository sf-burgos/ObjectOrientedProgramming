import java.util.ArrayList;
import java.util.Random;
 

public class TarpRebelde extends Tarp{
        /**
         * Constructor for objects of class TarpHard
         */
        Random r = new Random(1);        
        public TarpRebelde(int[] lowerEnd ,int[] higherEnd,int h, boolean isVisible,String col){
            super(lowerEnd,higherEnd,h,isVisible,col);
        }
        public void hacerHueco(int tarp,int x,int h){
           super.hacerHueco(tarp,x,h);
           if (r.nextBoolean()){
               this.makeInvisible();
           }else{
               this.makeVisible(); 
           }
          

            
        }
        
}