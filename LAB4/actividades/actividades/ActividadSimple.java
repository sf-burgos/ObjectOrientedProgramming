

public class ActividadSimple extends Actividad{
    private Integer creditos;
    
    public ActividadSimple(String id, Integer creditos){
        super(id);
        this.creditos=creditos;
    }
    
    @Override
    public int creditos() throws ActividadExcepcion{
        if(creditos == null) throw new ActividadExcepcion(ActividadExcepcion.SIMPLE_SIN_CREDITOS);        
        return creditos;                        
    }
    public int creditosDefinidos(){
        return 1;
    }
    public int creditos(String descripcion) throws ActividadExcepcion{
        return 1;
    }
}
