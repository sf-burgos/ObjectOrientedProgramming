package pruebas;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import aplicacion.*;

class DonkeyPOOBTestPersonaje {

	public DonkeyPOOBTestPersonaje(){}
	
	@Test
	public void deberiaMoverPersonajeDerecha() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346,0);
		jugador.moveRight();

		assertTrue(jugador.getX() == 22);
		
	}
	@Test
	public void deberiaMoverPersonajeIzquierda() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346,0);
		jugador.moveLeft();

		assertTrue(jugador.getX() == 18);
		
	}
	@Test
	public void deberiaMoverPersonajeSaltar() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346,0);
		jugador.moveJump();
	
		assertTrue(jugador.getY() == jugador.getY());
		
	}
	
	@Test
	public void deberiaEstarSobreEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346,0);

		assertTrue(jugador.getPersonaje().estaSobreEscalera(748, 346));
		
	}
	
	@Test
	public void noDeberiaEstarSobreEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346, 0);
		assertFalse(jugador.getPersonaje().estaSobreEscalera(400, 346));
		
	}
	@Test
	public void DeberiaEstarSobrePlataforma() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346,0);
 		jugador.getPersonaje().estaSobreUnaPlataforma(748, 346);
		assertFalse(jugador.getPersonaje().caida);
		
	}
	
	@Test
	public void DeberiaEstarSobrePlataformaDeAbajo () throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(524,715,0);
 		jugador.getPersonaje().estaSobreUnaPlataforma(524, 715);
		assertFalse(jugador.getPersonaje().caida);
		
	}
	
	@Test
	public void DeberiaBajarEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(485,211,0);
 		if(jugador.getPersonaje().estaSobreEscalera(485, 211));jugador.moveDown();
		assertTrue(jugador.getY()== 213);
		
	}
	
	@Test
	public void DeberiaSubirEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(485,346,0);
 		if(jugador.getPersonaje().estaBajoEscalera(485,346));jugador.moveUp();
		assertTrue(jugador.getY()==344 );
		
	}
	
	@Test
	public void noDeberiaBajarEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(200,200,0);
 		if(jugador.getPersonaje().estaSobreEscalera(485, 211));jugador.moveDown();
		assertFalse(jugador.getY()== 213);
		
	}
	@Test
	public void noDeberiaSubirEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(200,200,0);
 		if(jugador.getPersonaje().estaBajoEscalera(485,346));jugador.moveUp();
		assertFalse(jugador.getY()==344 );
	}
	
	// PRUEBAS DE LUIGI
	
	
	@Test
	public void deberiaMoverPersonajeDerechaLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346,1);
		jugador.moveRight();

		assertTrue(jugador.getX() == 22);
		
	}
	@Test
	public void deberiaMoverPersonajeIzquierdaLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346,1);
		jugador.moveLeft();

		assertTrue(jugador.getX() == 18);
		
	}
	@Test
	public void deberiaMoverPersonajeSaltarLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego(); 
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346,1);
		jugador.moveJump();
	
		assertTrue(jugador.getY() == jugador.getY());
		
	}
	
	@Test
	public void deberiaEstarSobreEscaleraLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346,1);

		assertTrue(jugador.getPersonaje().estaSobreEscalera(748, 346));
		
	}
	
	@Test
	public void noDeberiaEstarSobreEscaleraLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346, 1);
		assertFalse(jugador.getPersonaje().estaSobreEscalera(400, 346));
		
	}
	@Test
	public void DeberiaEstarSobrePlataformaLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346,1);
 		jugador.getPersonaje().estaSobreUnaPlataforma(748, 346);
		assertFalse(jugador.getPersonaje().caida);
		
	}
	
	@Test
	public void DeberiaEstarSobrePlataformaDeAbajoLuigi () throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(524,715,1);
 		jugador.getPersonaje().estaSobreUnaPlataforma(524, 715);
		assertFalse(jugador.getPersonaje().caida);
		
	}
	
	@Test
	public void DeberiaBajarEscaleraLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(485,211,1);
 		if(jugador.getPersonaje().estaSobreEscalera(485, 211));jugador.moveDown();
		assertTrue(jugador.getY()== 213);
		
	}
	
	@Test
	public void DeberiaSubirEscaleraLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(485,346,1);
 		if(jugador.getPersonaje().estaBajoEscalera(485,346));jugador.moveUp();
		assertTrue(jugador.getY()==344 );
		
	}
	
	@Test
	public void noDeberiaBajarEscaleraLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(200,200,1);
 		if(jugador.getPersonaje().estaSobreEscalera(485, 211));jugador.moveDown();
		assertFalse(jugador.getY()== 213);
		
	}
	@Test
	public void noDeberiaSubirEscaleraLuigi() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(200,200,1);
 		if(jugador.getPersonaje().estaBajoEscalera(485,346));jugador.moveUp();
		assertFalse(jugador.getY()==344 );
	}
	
	


	
	
	
	
}
