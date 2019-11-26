package aplicacion;

public class TeatroColonException extends Exception{
		public static final String EN_CONSTRUCCION = "OPCION EN CONSTRUCCION";
		public static final String NO_VALIDO = "Archivo a importar no valido.";
		public static final String SIN_TEATRO = "Cree un teatro antes de guardar.";
		public static final String NO_ABRIR = "Imposible abrir el teatro. Asegurese que es un archivo valido.";
		
		public TeatroColonException(String message) {
			super(message);
		}

}
