
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
        int[] coorInicialTarpA = {40,200};
        int[] coorFinalTarpA = {120,180};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        int[] coorInicialTarpB = {65,140};
        int[] coorFinalTarpB = {160,160};
        valley1.addTarp(coorInicialTarpB , coorFinalTarpB);
        int[] coorInicialTarpC = {40,80};
        int[] coorFinalTarpC = {100,120};
        valley1.addTarp(coorInicialTarpC , coorFinalTarpC);
        int[] coorInicialTarpD = {60,60};
        int[] coorFinalTarpD = {140,40};
        valley1.addTarp(coorInicialTarpD , coorFinalTarpD);
        valley1.makePuncture(3, 60);
        valley1.makePuncture(4, 100);
        valley1.startRain(60);
        String[] resp = {"red"};
        assertEquals(resp, valley1.rainFalls());
    }
    @Test
    public void noDeberiaHaceHueco(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 60, 120);
        int[] coorInicialTarpA = {40,200};
        int[] coorFinalTarpA = {120,180};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        valley1.makePuncture(1,20);   
        assertEquals(0,valley1.tarps()[0][2].length);
    }
    @Test
    public void deberiaObtenerElnumeroHuecos(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 100, 200);
        int[] coorInicialTarpA = {100,100};
        int[] coorFinalTarpA = {200,200};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        valley1.makePuncture(1,120);
        valley1.makePuncture(1,150);
        valley1.makePuncture(1,180);
        assertEquals(3,valley1.tarps()[0][2].length);
        
    
    }
    @Test
    public void noDeberiaLloverSobreViñedoRed(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 101, 200);
        int[] coorInicialTarpA = {100,100};
        int[] coorFinalTarpA = {200,200};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        int[] coorInicialTarpB = {150,350};
        int[] coorFinalTarpB = {200,400};
        valley1.addTarp(coorInicialTarpB , coorFinalTarpB);
        valley1.startRain(180);
        assertEquals(0, (valley1.rainFalls()).length);
    }
    @Test
    public void deberiaLloverAcidoSobreViñedo(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("black",90,200);
        int[] coorInicialTarpA = {100,100};
        int[] coorFinalTarpA = {200,200};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        int[] coorInicialTarpB = {150,350};
        int[] coorFinalTarpB = {200,400};
        valley1.addTarp(coorInicialTarpB , coorFinalTarpB);
        int[] coorInicialTarpC = {120,250};
        int[] coorFinalTarpC = {170,190};
        valley1.addTarp(coorInicialTarpC , coorFinalTarpC);
        valley1.startRain("acid",170);
        String[] resp={"black"};
        assertEquals(resp,valley1.rainFalls());

    }
    @Test
    public void deberiaLloverArcoiris(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("magenta", 0, 200);
        int[] coorInicialTarpA = {50,230};
        int[] coorFinalTarpA = {100,200};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        int[] coorInicialTarpB = {45,150};
        int[] coorFinalTarpB = {170,120};
        valley1.addTarp(coorInicialTarpB , coorFinalTarpB);
        int[] coorInicialTarpC = {20,70};
        int[] coorFinalTarpC = {90,100};
        valley1.addTarp(coorInicialTarpC , coorFinalTarpC);
        int[] coorInicialTarpD = {40,70};
        int[] coorFinalTarpD = {100,50};
        valley1.addTarp(coorInicialTarpD , coorFinalTarpD);
        valley1.makePuncture(3, 60);
        valley1.makePuncture(4, 90);
        valley1.makePuncture(2,150);
        valley1.startRain("arcoiris",60);
        String[] resp = {"magenta"};
        assertEquals(resp, valley1.rainFalls());
    }
    @Test
    public void deberiaDeSolucionarElcasoDePruebaNumeroUno(){
        Valley valley1 = new Valley(100 , 100);
        valley1.openVineyard("magenta", 10, 20);
        int[] coorInicialTarpA = {32,50};
        int[] coorFinalTarpA = {12,60};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        int[] coorInicialTarpB = {30,60};
        int[] coorFinalTarpB = {8,70};
        valley1.addTarp(coorInicialTarpB , coorFinalTarpB);
        int[] coorInicialTarpC = {25,70};
        int[] coorFinalTarpC = {0,80};
        valley1.addTarp(coorInicialTarpC , coorFinalTarpC);
        int[] coorInicialTarpD = {15,30};
        int[] coorFinalTarpD = {28,40};
        valley1.addTarp(coorInicialTarpD , coorFinalTarpD);
        int[] coorInicialTarpE = {5,20};
        int[] coorFinalTarpE = {14,25};
        valley1.addTarp(coorInicialTarpE , coorFinalTarpE);
        
        //for (int i=0; i<=5; i++){
          //  valley1.zoom("+");
        //}
        
        valley1.makePuncture(2, 26);
        valley1.makePuncture(3, 26);
        valley1.startRain(10);
        String[] resp = {"magenta"};
        assertEquals(resp, valley1.rainFalls());
    }
    @Test
    public void deberiaDeSolucionarElcasoDePruebaNumeroDos(){
        Valley valley1 = new Valley(20*20, 20*20);
        valley1.openVineyard("magenta", 2*20, 4*20);
      
        
    
        int[] coorInicialTarpA = {3*20,2*20};
        int[] coorFinalTarpA = {0*20,3*20};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        int[] coorInicialTarpB = {5*20,2*20};
        int[] coorFinalTarpB = {1*20,5*20};
        valley1.addTarp(coorInicialTarpB , coorFinalTarpB);
       
        
        
        
        valley1.makePuncture(2,25);
        
        valley1.startRain(25);
        String[] resp = {"magenta"};
        assertEquals(resp, valley1.rainFalls());
        
       
        
    }
        
    @Test
    public void deberiaObtenerUnHuecoPorSerLonaFlexible(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("magenta", 100, 200);
        int[] coorInicialTarpA = {150,150};
        int[] coorFinalTarpA = {200,200};
        valley1.addTarp("flexible",coorInicialTarpA , coorFinalTarpA);
        valley1.makePuncture(1,160);
        valley1.makePuncture(1,150);
        valley1.makePuncture(1,180);
        assertEquals(1,valley1.tarps()[0][2].length);
        
    
    }
    @Test
    public void noDeberiaObtenerUnHuecoPorSerLonaHard(){
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("magenta", 100, 200);
        int[] coorInicialTarpA = {150,150};
        int[] coorFinalTarpA = {200,200};
        valley1.addTarp("hard",coorInicialTarpA , coorFinalTarpA);
        valley1.makePuncture(1,160);
        valley1.makePuncture(1,150);
        valley1.makePuncture(1,180);
        assertEquals(0,valley1.tarps()[0][2].length);
        
    
    }
    @Test
    public void laLluviaStraightDebeCambiarRecorridoInicial(){
        
        Valley valley1 = new Valley(500, 500);
        valley1.openVineyard("red", 60, 120);
        int[] coorInicialTarpA = {40,200};
        int[] coorFinalTarpA = {120,180};
        valley1.addTarp(coorInicialTarpA , coorFinalTarpA);
        int[] coorInicialTarpB = {65,140};
        int[] coorFinalTarpB = {160,160};
        valley1.addTarp(coorInicialTarpB , coorFinalTarpB);
        int[] coorInicialTarpC = {40,80};
        int[] coorFinalTarpC = {100,120};
        valley1.addTarp(coorInicialTarpC , coorFinalTarpC);
        int[] coorInicialTarpD = {60,60};
        int[] coorFinalTarpD = {140,40};
        valley1.addTarp(coorInicialTarpD , coorFinalTarpD);
        valley1.makePuncture(2, 60);
        valley1.makePuncture(3, 100);
        valley1.startRain("straight",150);
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



