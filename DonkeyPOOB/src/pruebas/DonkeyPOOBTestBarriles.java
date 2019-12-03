package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import aplicacion.*;
import aplicacion.DonkeyPOOB;
import aplicacion.Usuario;

class DonkeyPOOBTestBarriles {

	@Test
	public void DeberiaEstarSobrePlataformaBarrilAmarillo() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilAmarillo barril = new BarrilAmarillo(20,346);
 		barril.estaSobreUnaPlataforma(barril.getX(), barril.getY());
 		assertFalse(barril.caida);
	}
	
	@Test
	public void noDeberiaEstarSobrePlataformaBarrilAmarillo() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilAmarillo barril = new BarrilAmarillo(20,200);
 		barril.estaSobreUnaPlataforma(barril.getX(), barril.getY());
 		assertTrue(barril.caida);
	}
	
	@Test
	public void DeberiaEstarSobrePlataformaBarrilVerde() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilVerde barril = new BarrilVerde(20,346);
 		barril.estaSobreUnaPlataforma(barril.getX(), barril.getY());
 		assertFalse(barril.caida);
	}
	
	@Test
	public void noDeberiaEstarSobrePlataformaBarrilVerde() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilVerde barril = new BarrilVerde(20,200);
 		barril.estaSobreUnaPlataforma(barril.getX(), barril.getY());
 		assertTrue(barril.caida);
	}
	
	@Test
	public void DeberiaEstarSobrePlataformaBarrilAzul() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilAzul barril = new BarrilAzul(20,346);
 		barril.estaSobreUnaPlataforma(barril.getX(), barril.getY());
 		assertFalse(barril.caida);
	}
	
	@Test
	public void noDeberiaEstarSobrePlataformaBarrilAzul() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilAmarillo barril = new BarrilAmarillo(20,200);
 		barril.estaSobreUnaPlataforma(barril.getX(), barril.getY());
 		assertTrue(barril.caida);
	}
	@Test
	public void deberiaEstarSobreEscaleraBarrilAzul() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilAzul barril = new BarrilAzul(748,346);
		assertTrue(barril.estaSobreEscalera(748, 346));		
	}
	@Test
	public void noDeberiaEstarSobreEscaleraBarrilAzul() throws InterruptedException {
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilAzul barril = new BarrilAzul(780,346);
		assertFalse(barril.estaSobreEscalera(780, 346));		
	}
	@Test
	public void deberiaCaerBarrilRojo() throws InterruptedException{
		DonkeyPOOB.nuevoJuego();
		DonkeyPOOB juego= DonkeyPOOB.getJuego();
		juego.addPlataformas();
		juego.addEscaleras();
 		BarrilRojo barril = new BarrilRojo(748,200);
 		while(barril.getY() < 804) { 
 			barril.moverHastaUnaPlataforma();
 		}
 		assertTrue((barril.getY() == 804));		
	}
	


}
