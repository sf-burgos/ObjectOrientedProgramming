

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
    public void sadf()
    {
        Valley valley4 = new Valley(600, 600);
        int [] brayan= {150,350};
        int [] fonso= {200,400};
        valley4.addTrap(brayan, fonso);
        valley4.openVineyard("red", 100, 200);
    }
}

