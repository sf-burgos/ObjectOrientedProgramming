

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
    public void segunIRLluviaLLegaAVieñedoGreen(){
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
}


