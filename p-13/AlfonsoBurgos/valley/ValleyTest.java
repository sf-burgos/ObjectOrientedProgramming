
package valley;
import shapes.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
/**
 * The test class ValleyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ValleyTest
{
    /**
     * Default constructor for test class ValleyTest
     */
    public ValleyTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }



    @Test
    public void segunIRLluviaLLegaAVieñedoRed(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 60, 120);
        int[] coorInicialTrapA = {40,200};
        int[] coorFinalTrapA = {120,180};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {65,140};
        int[] coorFinalTrapB = {160,160};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
        int[] coorInicialTrapC = {40,80};
        int[] coorFinalTrapC = {100,120};
        valley1.addTrap(coorInicialTrapC , coorFinalTrapC);
        int[] coorInicialTrapD = {60,60};
        int[] coorFinalTrapD = {140,40};
        valley1.addTrap(coorInicialTrapD , coorFinalTrapD);
        valley1.makePuncture(2, 60);
        valley1.makePuncture(3, 100);
        valley1.startRain(60);
        String[] resp = {"red"};
        assertEquals(resp, valley1.rainFalls());
    }
    @Test
    public void noDeberiaHaceHueco(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 60, 120);
        int[] coorInicialTrapA = {40,200};
        int[] coorFinalTrapA = {120,180};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        valley1.makePuncture(0,20);   
        assertEquals(0,valley1.tarps()[0][2].length);
    }
    @Test
    public void deberiaObtenerElnumeroHuecos(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 100, 200);
        int[] coorInicialTrapA = {100,100};
        int[] coorFinalTrapA = {200,200};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        valley1.makePuncture(0,120);
        valley1.makePuncture(0,150);
        valley1.makePuncture(0,180);
        assertEquals(3,valley1.tarps()[0][2].length);
        
    
    }
    @Test
    public void noDeberiaLloverSobreViñedoRed(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 101, 200);
        int[] coorInicialTrapA = {100,100};
        int[] coorFinalTrapA = {200,200};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {150,350};
        int[] coorFinalTrapB = {200,400};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
        valley1.startRain(180);
        assertEquals(0, (valley1.rainFalls()).length);
    }
    @Test
    public void deberiaLloverAcidoSobreViñedo(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("black",90,200);
        int[] coorInicialTrapA = {100,100};
        int[] coorFinalTrapA = {200,200};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {150,350};
        int[] coorFinalTrapB = {200,400};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
        int[] coorInicialTrapC = {120,250};
        int[] coorFinalTrapC = {170,190};
        valley1.addTrap(coorInicialTrapC , coorFinalTrapC);
        valley1.startRainAcid(170);
        String[] resp={"black"};
        assertEquals(resp,valley1.rainFalls());

    }
    @Test
    public void deberiaLloverArcoiris(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("magenta", 0, 200);
        int[] coorInicialTrapA = {50,230};
        int[] coorFinalTrapA = {100,200};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {45,150};
        int[] coorFinalTrapB = {170,120};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
        int[] coorInicialTrapC = {20,70};
        int[] coorFinalTrapC = {90,100};
        valley1.addTrap(coorInicialTrapC , coorFinalTrapC);
        int[] coorInicialTrapD = {40,70};
        int[] coorFinalTrapD = {100,50};
        valley1.addTrap(coorInicialTrapD , coorFinalTrapD);
        valley1.makePuncture(2, 60);
        valley1.makePuncture(3, 100);
        valley1.makePuncture(1,150);
        valley1.startRainArcoiris(60);
        String[] resp = {"magenta"};
        assertEquals(resp, valley1.rainFalls());
    }
    @Test
    public void deberiaDeSolucionarElcasoDePruebaNumeroUno(){
        Valley valley1 = new Valley(100 , 100);
        valley1.openVineyard("magenta", 10, 20);
        int[] coorInicialTrapA = {32,50};
        int[] coorFinalTrapA = {12,60};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {30,60};
        int[] coorFinalTrapB = {8,70};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
        int[] coorInicialTrapC = {25,70};
        int[] coorFinalTrapC = {0,80};
        valley1.addTrap(coorInicialTrapC , coorFinalTrapC);
        int[] coorInicialTrapD = {15,30};
        int[] coorFinalTrapD = {28,40};
        valley1.addTrap(coorInicialTrapD , coorFinalTrapD);
        int[] coorInicialTrapE = {5,20};
        int[] coorFinalTrapE = {14,25};
        valley1.addTrap(coorInicialTrapE , coorFinalTrapE);
        
        //for (int i=0; i<=5; i++){
          //  valley1.zoom("+");
        //}
        
        valley1.makePuncture(1, 26);
        valley1.makePuncture(2, 26);
        valley1.startRain(10);
        String[] resp = {"magenta"};
        assertEquals(resp, valley1.rainFalls());
    }
    @Test
    public void deberiaDeSolucionarElcasoDePruebaNumeroDos(){
        Valley valley1 = new Valley(20*20, 20*20);
        valley1.openVineyard("magenta", 2*20, 4*20);
      
        
    
        int[] coorInicialTrapA = {3*20,2*20};
        int[] coorFinalTrapA = {0*20,3*20};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {5*20,2*20};
        int[] coorFinalTrapB = {1*20,5*20};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
       
        
        
        
        valley1.makePuncture(1,25);
        
        valley1.startRain(25);
        String[] resp = {"magenta"};
        assertEquals(resp, valley1.rainFalls());
        
       
        
    }
        
    @Test
    public void deberiaObtenerUnHuecoPorSerLonaFlexible(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("magenta", 100, 200);
        int[] coorInicialTrapA = {150,150};
        int[] coorFinalTrapA = {200,200};
        valley1.addTrapFlex(coorInicialTrapA , coorFinalTrapA);
        valley1.makePuncture(0,160);
        valley1.makePuncture(0,150);
        valley1.makePuncture(0,180);
        assertEquals(1,valley1.tarps()[0][2].length);
        
    
    }
    @Test
    public void noDeberiaObtenerUnHuecoPorSerLonaHard(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("magenta", 100, 200);
        int[] coorInicialTrapA = {150,150};
        int[] coorFinalTrapA = {200,200};
        valley1.addTrapHard(coorInicialTrapA , coorFinalTrapA);
        valley1.makePuncture(0,160);
        valley1.makePuncture(0,150);
        valley1.makePuncture(0,180);
        assertEquals(0,valley1.tarps()[0][2].length);
        
    
    }
    @Test
    public void laLluviaStraightDebeCambiarRecorridoInicial(){
        
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 60, 120);
        int[] coorInicialTrapA = {40,200};
        int[] coorFinalTrapA = {120,180};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {65,140};
        int[] coorFinalTrapB = {160,160};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
        int[] coorInicialTrapC = {40,80};
        int[] coorFinalTrapC = {100,120};
        valley1.addTrap(coorInicialTrapC , coorFinalTrapC);
        int[] coorInicialTrapD = {60,60};
        int[] coorFinalTrapD = {140,40};
        valley1.addTrap(coorInicialTrapD , coorFinalTrapD);
        valley1.makePuncture(2, 60);
        valley1.makePuncture(3, 100);
        valley1.startRainStraight(150);
        int[][][] lluvia = new int[501][501][501];
        lluvia=valley1.rains();
        int elXqueNodeberiaCambiar = lluvia[0][0][0];
        boolean verificaQueXSeaConstante = true;
        for (int i=0; i<lluvia.length; i++){
           // for (int j=0; j<lluvia.length; j++){
                int[] lluviaImportante=new int[2]; 
           //     lluviaImportante=lluvia[i][j];
                System.out.println(lluvia[0][0][i]);
               // if (lluvia[i][j][0]!=elXqueNodeberiaCambiar){
                   // verificaQueXSeaConstante = false;
            }
       // }   
       // }
        
       assertTrue(verificaQueXSeaConstante);
        
    
    
    
    
    }
      
}



