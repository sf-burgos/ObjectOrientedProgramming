package aplicacion;
public class ActividadExcepcion extends Exception{
   public static final String COMPUESTA_VACIA="Actividad compuesta vacia";
   public static final String SIMPLE_SIN_CREDITOS="Actividad simple sin creditos";
   public static final String NO_EXISTE_ACTIVIDAD="No existe actividad con esta descripcion";
   public static final String DOS_ACTIVIDADES_CON_DESCRIPCION="Dos actividades con esta misma descripcion";
   public static final String ACTIVIDAD_SIN_SIGLA="La actividad no tiene sigla";

    
    public ActividadExcepcion(String mensaje){
        super(mensaje);
    }
}
