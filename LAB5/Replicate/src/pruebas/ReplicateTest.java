package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ReplicateTest{
	

    @Test
    public void deberiaReplicarMatriz(){
		int [][] matrizUno =  {{0,0,0,0,0},{0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		Replicate matrizInicial  = new Replicate(matrizUno);		
        int[][] matriz  = {{0,0,0,0,0},{0,1,1,1,0},{0,1,1,1,0},{0,1,1,1,0},{0,0,0,0,0}};
		assertEquals(matriz,matrizInicial.replicarMatriz());
	}
	
	@Test
    public void deberiaReplicarMatrizGrande(){
		int [][] matrizUno =  {{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,1,0,0,0,0,0,0,0},
								{0,0,0,0,0,1,1,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
								
								
		Replicate matrizInicial  = new Replicate(matrizUno);		
        int[][] matriz  =   {{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,1,1,1,0,0,0,0,0,0},
							{0,0,0,0,1,1,1,0,0,0,0,0,0,0},
							{0,0,0,0,1,1,1,0,0,0,0,0,0,0},
							{0,0,0,0,1,0,0,1,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		assertEquals(matriz,matrizInicial.replicarMatriz());
	
}

}
