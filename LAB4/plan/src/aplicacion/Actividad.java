package aplicacion;
public abstract class Actividad{
    private String id;
    private String descripcion;
    
    public Actividad(String id){
        this.id=id;
        this.descripcion="Por definir";
    }
    
    public Actividad(String id, String descripcion){
        this.id=id;
        this.descripcion=descripcion;
    }
    /**
     * Calcula el numero de creditos dependiendo de la actividad
     * @return numero de creditos
     */
    public abstract int creditos() throws ActividadExcepcion;
    
    /**Calcular el numero de creditos considerando las actividades bien definidas
     * @return 
     * */
    public abstract int creditosDefinidos();
    

    public abstract int creditos(String descripcion) throws ActividadExcepcion;

    public String getDescripcion(){
        return descripcion;
    }
    public String getId() {
	return id;
    }

}
