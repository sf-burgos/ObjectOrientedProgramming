package aplicacion;

public class DonkeyPOOBException extends Exception{
		public static final String SIN_BARRILES = "No puede jugar sin barriles seleccionados.";
		public static final String SIN_SORPRESAS = "No puede jugar sin sorpresas.";
		public static final String SIN_JUEGO = "Cree un juego antes de guardar.";
		public static final String NO_ABRIR = "Imposible abrir el juego. Asegúrse que es un archivo válido.";
		
		public DonkeyPOOBException(String message) {
			super(message);
		}

}
