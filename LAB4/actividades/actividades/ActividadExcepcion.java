
public class ActividadExcepcion extends Exception{
   public static final String COMPUESTA_VACIA="Actividad compuesta vacia";
   public static final String SIMPLE_SIN_CREDITOS="Actividad simple sin creditos";
    
    public ActividadExcepcion(String mensaje){
        super(mensaje);
    }
}
