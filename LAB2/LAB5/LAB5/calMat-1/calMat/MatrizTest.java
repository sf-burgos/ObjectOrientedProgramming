import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * @author   ECI
 * @version 2019-2
 */
public class MatrizTest
{
    private ArrayList<Integer> arrayError;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        
    }
 
    @Test    
    public void deberiaPasar(){
    }
    
    @Test
    public void deberiaFallar(){
    }

    @Test    
    public void deberiaErrar(){
 
    }

    
    @Test
    public void deberiaCrearMatricesDadosLosElementos(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9}};        
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        assertTrue(A.equals(B));
    }
    
    
    @Test
    public void deberiaProtegerLosDatos(){
        int [][] dA={{1,2,3},{4,5,6},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9}};        
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(dB);
        dA[0][0]=-1;
        assertTrue(A.equals(B));
    }


    @Test
    public void deberiaCrearMatricesDadoValor(){
        int [][] dA={{0,0,0},{0,0,0},{0,0,0}};
        Matriz A=new Matriz(dA);
        Matriz B=new Matriz(0,3,3);
        assertTrue(A.equals(B));
    }
    
    @Test
    public void deberiaCrearMatricesDiagonales(){
        int [] d={1,2,3,4};
        int [][] dD={{1,0,0,0},{0,2,0,0},{0,0,3,0},{0,0,0,4}};
        Matriz A=new Matriz(d);
        Matriz B=new Matriz(dD);
        assertTrue(A.equals(B));
    }    
    
    
    
    public void deberiaCrearMatricesIdentidad(){
        int [][] dI={{1,0,0},{0,1,0},{0,0,1}};     
        Matriz A=new Matriz(3);
        Matriz I=new Matriz(dI);
        assertTrue(A.equals(I));
    }
    
     @Test
    public void noDeberiaCrearMatricesInValidas(){
        
        int [][] dA={{1,2,3},{4,5},{7,8,9}};
        int [][] dB={{1,2,3},{4,5,6},{7,8,9,7}};
        Matriz A =new Matriz(dA);
        Matriz B =new Matriz(dB);        
        assertTrue(A.equals(Matriz.UNCERO));
        assertTrue(B.equals(Matriz.UNCERO));
        
        //int [] d={};
        //assertTrue(new Matriz(d).equals(Matriz.UNCERO));


        //assertTrue(new Matriz(10,-1,2).equals(Matriz.UNCERO));
        //assertTrue(new Matriz(10,1,-2).equals(Matriz.UNCERO));  
        
        //assertTrue(new Matriz(0).equals(Matriz.UNCERO));
        //assertTrue(new Matriz(-1).equals(Matriz.UNCERO));       

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
}
