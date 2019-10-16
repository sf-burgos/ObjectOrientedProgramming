import java.util.ArrayList;

public class TarpFlex extends Tarp{
        /**
         * Constructor for objects of class TarpHard
         */
        public TarpFlex(int[] lowerEnd ,int[] higherEnd,int h, boolean isVisible,String col){
            super(lowerEnd,higherEnd,h,isVisible,col);                                         
        }
        public void hacerHueco(int x,int h){
            int [] huecosFlex = super.posXHuecos();
            if(huecosFlex.length >= 1){                
                int huecoAnterior = huecosFlex[0];
                super.hacerHueco(x,h);
                super.parcharHueco(huecoAnterior); 

            }else{
                super.hacerHueco(x,h);
            }

            
        }
        
}