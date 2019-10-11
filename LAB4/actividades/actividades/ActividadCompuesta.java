import java.util.ArrayList;

public class ActividadCompuesta extends Actividad{
    private ArrayList<Actividad> actividades;
    
    public ActividadCompuesta(String id){
        super(id);
        actividades= new ArrayList<Actividad>();
    }
    
    public void actividad(Actividad a){
        actividades.add(a);
    }
    
    @Override
    public int creditos() throws ActividadExcepcion{
        int numeroCreditos = 0;
        if(actividades.size() == 0) throw new ActividadExcepcion(ActividadExcepcion.COMPUESTA_VACIA);
        for(Actividad act: actividades){            
            numeroCreditos += act.creditos();            
        }
        return numeroCreditos;
    }    
    public  int creditosDefinidos(){
        return 1;
    }
    public int creditos(String descripcion) throws ActividadExcepcion{
        return 1;
    }
    
}
