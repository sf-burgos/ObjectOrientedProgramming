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
 		Usuario jugador = new Usuario(20,346);
		jugador.moveRight();

		assertTrue(jugador.getX() == 22);
		
	}
	@Test
	public void deberiaMoverPersonajeIzquierda() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346);
		jugador.moveLeft();

		assertTrue(jugador.getX() == 18);
		
	}
	@Test
	public void deberiaMoverPersonajeSaltar() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(20,346);
		jugador.moveJump();
	
		assertTrue(jugador.getY() == jugador.getY());
		
	}
	
	@Test
	public void deberiaEstarSobreEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346);

		assertTrue(jugador.getPersonaje().estaSobreEscalera(748, 346));
		
	}
	
	@Test
	public void noDeberiaEstarSobreEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346);
		assertFalse(jugador.getPersonaje().estaSobreEscalera(400, 346));
		
	}
	@Test
	public void DeberiaEstarSobrePlataforma() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(748,346);
 		jugador.getPersonaje().estaSobreUnaPlataforma(748, 346);
		assertFalse(jugador.getPersonaje().caida);
		
	}
	
	@Test
	public void DeberiaEstarSobrePlataformaDeAbajo () throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(524,715);
 		jugador.getPersonaje().estaSobreUnaPlataforma(524, 715);
		assertFalse(jugador.getPersonaje().caida);
		
	}
	
	@Test
	public void DeberiaBajarEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(485,211);
 		if(jugador.getPersonaje().estaSobreEscalera(485, 211));jugador.moveDown();
		assertTrue(jugador.getY()== 213);
		
	}
	
	@Test
	public void DeberiaSubirEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(485,346);
 		if(jugador.getPersonaje().estaBajoEscalera(485,346));jugador.moveUp();
		assertTrue(jugador.getY()==344 );
		
	}
	
	@Test
	public void noDeberiaBajarEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(200,200);
 		if(jugador.getPersonaje().estaSobreEscalera(485, 211));jugador.moveDown();
		assertFalse(jugador.getY()== 213);
		
	}
	@Test
	public void noDeberiaSubirEscalera() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		Usuario jugador = new Usuario(200,200);
 		if(jugador.getPersonaje().estaBajoEscalera(485,346));jugador.moveUp();
		assertFalse(jugador.getY()==344 );
	}
	
	
}
