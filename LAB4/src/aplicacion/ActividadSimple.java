

public class ActividadSimple extends Actividad{
    private Integer creditos;
    
    public ActividadSimple(String id, Integer creditos){
        super(id);
        this.creditos=creditos;
    }
    public ActividadSimple(String id, Integer creditos,String descripcion){  
        super(id,descripcion);
        this.creditos=creditos;
    }
    
    @Override
    public int creditos() throws ActividadExcepcion{
        if(creditos == null) throw new ActividadExcepcion(ActividadExcepcion.SIMPLE_SIN_CREDITOS);        
        return creditos;                        
    }
    public int creditosDefinidos(){
        if(creditos==null){
            return 0;
        }
        return creditos;       
    }
    public int creditos(String descripcion) throws ActividadExcepcion{
        if(!(descripcion.equals(super.getDescripcion()))) throw new ActividadExcepcion(ActividadExcepcion.NO_EXISTE_ACTIVIDAD);
        return creditos;
   }
   public int getCreditos(){
       return creditos;
    }
}
