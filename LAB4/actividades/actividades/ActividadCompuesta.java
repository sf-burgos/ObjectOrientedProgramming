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
        int numeroCreditos =0; 
        if (actividades.size()==0){
            return numeroCreditos;
        }else{
            for(Actividad act: actividades){
                numeroCreditos += act.creditosDefinidos();
            }
        }
        return numeroCreditos;
        
    }
    public int creditos(String descripcion) throws ActividadExcepcion{
        int creditos=0;
        int numeroVeces=0;
        for(Actividad act: actividades){
            if(descripcion.equals(act.getDescripcion())){
                numeroVeces++;
            }
            if(numeroVeces==1) creditos = 1;
        }if(numeroVeces>1) throw new ActividadExcepcion(ActividadExcepcion.DOS_ACTIVIDADES_CON_DESCRIPCION);                
     return 1;
    }
    
    
}
