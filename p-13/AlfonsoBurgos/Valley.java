import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Stack;
public class Valley
{
    private boolean ok;
    private boolean isVisible;
    private ArrayList<VineYard> listVinedo;
    private ArrayList<Tarp> listLonas;
    private  Rectangle valleyconstructor ;
    private int realY;
    private ArrayList <String> coloresDisponibles;
    private int lluviaX;
    private Stack<String> historialAcciones; 

    /**
     * Contructor de type VineYard Objects 
     * Crea el vaye y lo hace visible a la medida 
     * @param x tamaño en esta dimension , y tamaño en esta dimension 
     */
    
    public Valley(int x, int y){
       coloresDisponibles= new ArrayList<String>();
       coloresDisponibles.add("yellow");coloresDisponibles.add("magenta");coloresDisponibles.add("blue");coloresDisponibles.add("red");coloresDisponibles.add("white");       
       realY=y;
       valleyconstructor = new  Rectangle (x,y);
       valleyconstructor.changeColor("green");
       valleyconstructor.makeVisible();
       listVinedo  = new ArrayList<VineYard>();  
       listLonas = new ArrayList<Tarp>();      
    }
    /**
     * Abre un nuevo VineYard teniendo en cuenta que no pueden estar uno encima del otro y ademas que tienen que tener nombre diferentes
     * crea un ArrayList de posiciones para el VineYard y uno para objetos de tipo VineYard
     * @param  name nombre del VineYard, xi posicion en X inicial , xf posicion en X final 
     */
    public void openVineyard(String name, int xi, int xf){  
        boolean flag;
        flag=true;
        int cont=0;int bandera=-1;
        for (String color:coloresDisponibles){
            if (color==name){
            bandera=coloresDisponibles.indexOf(color);
            cont+=1;    
            }          
        }
        if (bandera!=-1){
            coloresDisponibles.remove(bandera);
        }
        for (int i=0; i<listVinedo.size(); i++){
            if(((listVinedo.get(i).getInicio()<=xi) && xi<=listVinedo.get(i).getFin())||( (listVinedo.get(i).getFin()<=xf) && (xf<=listVinedo.get(i).getFin()))){
                System.out.println("Operacion invalida debido a existencia de un viñedo en esta posicion");
                flag=false; 
            }
        } 
        for (int j=0; j<listVinedo.size(); j++){
            if(listVinedo.get(j).getName().equals(name) && cont==0){
                System.out.println("No se puede crear el viñedo,Ya existe uno con este nombre");
                flag=false;
            }
        }        
        if (flag || listVinedo.size()==0 && cont==1) {
            VineYard vinedo = new VineYard(name,xi,xf,realY,true);
            listVinedo.add(vinedo);                           
        }      
    }

    /**
     * Elimina un VineYard completamente, de su lista de VineYards y su lista de cordenadas ademas lo vuelve invisible
     */
    public void closeVineyard(String name){        
        for (int i=0; i < listVinedo.size(); i++ ){
            if(listVinedo.get(i).getName().equals(name)){
                listVinedo.get(i).makeInvisible(); 
                listVinedo.remove(i);
                coloresDisponibles.add(name);
            }
        }      
    }
    /**
     * Crea una lona o Tarp 
     * @param lowerEnd coordenadas X1, Y1, higherEnd coordenadas X2, Y2 
     */
    public void addTrap(int[] lowerEnd, int[] higherEnd){
       boolean sePuede = true;
       Tarp lona; 
       for(Tarp lonas: listLonas){
           if((lonas.getPuntoUno()[0] == lowerEnd[0] && lonas.getPuntoUno()[1] == lowerEnd[1])||(lonas.getPuntoUno()[0] == higherEnd[0] &&lonas.getPuntoUno()[1] == higherEnd[1])){
                System.out.println("No se puede añadir una lona en esta posicion ya existe en este punto"); 
                sePuede = false;               
           }
       }
       String col=verificarColorLona(lowerEnd,higherEnd);
       if(sePuede || listLonas.size() == 0){
           lona = new Tarp(lowerEnd, higherEnd,realY,true,col);
           listLonas.add(lona);
       }
       listLonas = ordenarLonas(listLonas);
    }
    /**
     * @param ArrayList<Tarp> lonas arreglo de lonas en el valle 
     * organiza las lonas de un valle en un arrayList
     * return ArrayList<Tarp> lonasOrdenadas 
     */  
    public ArrayList<Tarp> ordenarLonas(ArrayList<Tarp> lonas){
        ArrayList<Tarp> lonasOrdenadas = new ArrayList<Tarp>();
        while(lonas.size()!= 0){
            int maximo = 0;
            for(int i=0; i<lonas.size(); i++){
                if(maximo < lonas.get(i).puntoMinimoY()){
                    maximo = lonas.get(i).puntoMinimoY();
                }
            }
            for(int j=0;j<lonas.size(); j++){
                if (maximo == lonas.get(j).puntoMinimoY()){
                    lonasOrdenadas.add(lonas.get(j));
                    lonas.remove(j);
                }
            }
        }
        return lonasOrdenadas;
    }
    /**
     * @param int[] lowerEnd, int[] higherEnd coordenadas punto1 y punto2
     * verifica el color de una lona y respecto a su posicion con los viñedos 
     * @return String color color del que deberia ser la lona 
     */
    public String verificarColorLona(int[] lowerEnd, int[] higherEnd){
        int cont=0;
        int z= lowerEnd[0]; 
        int s = higherEnd[0];
        String color = "black";        
        for (int i=0; i < listVinedo.size(); i++){            
            if (listVinedo.get(i).getInicio()<=z && z<=s && s<=listVinedo.get(i).getFin()){
                cont+=1;
                color= listVinedo.get(i).getName();                
            }
            if (cont==1){
                return color;
            }
        }
        return color;        
    }
      /**
     * Elimina una trampa en orden de creacion o posicion en arreglo 
     * @param int position a borrar 
     */
    public void removeTrap(int position){
        listLonas.get(position-1).makeInvisible(); 
        listLonas.remove(position-1);
    }
    /**
     * Realiza un hueco en una posicion Y dada y en un numero de lona dado 
     * @param trap o lona, x coordenada o distancia 
     */
    public void makePuncture(int trap, int x){
        Puncture hueco;
        Tarp lona=listLonas.get(trap-1);
        lona.hacerHueco(x,realY);
    }
    /**
     * Elimina o parcha un hueco realizado dada una lona y una coordeanda lona 
     * @param trap o lona, position, coordeanda x 
     */
    public void patchPuncture(int trap, int position){
        Tarp lona = listLonas.get(trap);
        lona.parcharHueco(position);                
    }
    /**
     * Cuando se ejecuta este metodo empieza a llover 
     */
    public void startRain(int x){
        int j=0; 
        for (int i=0; i< listLonas.size();i++){                   
            while  (j!= realY ){                 
                if (VerificarHuecos(listLonas.get(i),x,j)){
                    j=j+1;
                    Rain lluvia = new Rain (x,j);
                    break;
                }else{
                    if (x <= listLonas.get(i).getPuntoDos()[0] && x >= listLonas.get(i).getPuntoUno()[0]){                   
                        float k= (listLonas.get(i).getPendiente()*x)+listLonas.get(i).getPuntoCorte();                       
                        if (realY-j==(int) k){                                                                                                                                              
                            if ((int) listLonas.get(i).getPendiente()>0){
                                 x=x-1;j=j-1;                 
                                 Rain lluvia = new Rain (x,j);
                            }
                            else{
                                x=x+1; j=j-1;
                                Rain lluvia = new Rain (x,j);  
                        }
                        }                        
                        else{
                            j=j+1;
                            Rain lluvia = new Rain (x,j);
                        }                            
                    }                             
                    else if(i<listLonas.size()-1 && (x<= listLonas.get(i+1).getPuntoDos()[0] && x >= listLonas.get(i+1).getPuntoUno()[0]) && !(VerificarHuecos(listLonas.get(i+1),x,j))){
                        break;
                    }
                    else{
                        j=j+1;
                        Rain lluvia = new Rain (x,j);
                    }
                }                
            }            
        }
        while  (j!= realY ){
                j=j+1;
                Rain lluvia = new Rain (x,j);
        }
        lluviaX=x;
    }
    /**
     * Cuando se invoca este metodo para la lluvia 
     */ 
    public void stopRain(int position){      
    
    }
    /**
     * Esta funcion indica los viñedos que han sido regados 
     * @return vinedosRegados arreglo con los nombres de los viñedos regados 
     */
    public String[] rainFalls(){
        ArrayList<String> listVinedosRegados = new ArrayList<String>();
        for(int i=0;i<listVinedo.size();i++){
            if(lluviaX >= listVinedo.get(i).getInicio() && lluviaX <= listVinedo.get(i).getFin()){
                listVinedosRegados.add(listVinedo.get(i).getName());
            }
        }
        String[] vinedosRegados = listVinedosRegados.toArray(new String[listVinedosRegados.size()]);
        return vinedosRegados;
    }
    /**
     * @param char d 
     * Ingresa un caracter que indica que accion se quiere hacer, deshacer U o rehacer D 
     */
    
    public void Do(char d){
        if (d == 'U'){
        
        }else if (d =='R'){
        
        }                        
    }
    /**
     * Vuelve Visible el objeto de tipo valle y sus componentes 
     */
    public void makeVisible(){
        for (int i=0; i < listVinedo.size(); i++ ){
            listVinedo.get(i).makeVisible();
        }
        for (int i=0; i < listLonas.size(); i++ ){
            listLonas.get(i).makeVisible();       
            ArrayList<Puncture> huecos=listLonas.get(i).getHuecos();
            for(int j=0;j<huecos.size();j++){
                huecos.get(j).makeVisible();
            }
        }
    }
    /**
     * Vuelve invisible el objeto de tipo valle y sus componentes 
     */
    public void makeInvisible(){
        for (int i=0; i < listVinedo.size(); i++ ){
            listVinedo.get(i).makeInvisible();
        }
        for (int i=0; i < listLonas.size(); i++ ){
            listLonas.get(i).makeInvisible();
            ArrayList<Puncture> huecos=listLonas.get(i).getHuecos();
            for(int j=0;j<huecos.size();j++){
                huecos.get(j).makeInvisible();
            }
        }
    
    }
    /** 
     * Finaliza la ejecucion de una simulacion 
     */
    public void finish(){
        System.exit(0);
    }
    public void ok(){
    }

    /**
     * @param String simbolo
     * recibe un simbolo que sera + o - dependiendo la accion que se quiera hacer, acercar o alejar el valle y sus componentes 
     */
    public void zoom (String simbolo){
        Canvas canvas= Canvas.getCanvas();
        canvas.zoom(simbolo);
    }
    /**
     * @param Tarp lona, int x, int y 
     * recibe una lona y un punto x y y y esta determina si en esta posicion existe un hueco 
     * @return boolean 
     */
    public boolean VerificarHuecos(Tarp lona, int x, int y){
        ArrayList<Puncture> huecos = new ArrayList <Puncture>();
        huecos=lona.getHuecos();
        for (int i=0; i<huecos.size(); i++){
            if (x==huecos.get(i).getXPos() && y==huecos.get(i).getYPos()){
                return true;
             
            }         
        }
        return false; 
    }
    /**
     * Esta funcion retorna los viñedos existentes sus coordenadas de inicio y fin 
     * @return int vinedos
     */
    public int[][] vineyards(){
        int[][] vinedos = new int[listVinedo.size()][1];
        for (int i = 0; i<listVinedo.size(); i++){
            int inicio = listVinedo.get(i).getInicio(); int fin= listVinedo.get(i).getFin();
            int [] coordenada = new int[2]; 
            coordenada[0] = inicio;
            coordenada[1] = fin; 
            vinedos[i] = coordenada;                      
        }
        return vinedos;
    }
    /**
     * retorna las lonas existentes sus coordenadas del punto uno(X1,Y1), punto dos(X2,Y2) y los huecos existentes en esta lona(Posicion en x) 
     * @return int[][][] tarps
     */
    public int[][][] tarps(){
        int[][][] tarps = new int[listLonas.size()][listLonas.size()][listLonas.size()];
        int[] puntoI = new int[2];
        int[] puntoF = new int[2];
        for (int i = 0; i<tarps.length; i++){
            puntoI = listLonas.get(i).getPuntoUno();
            puntoF = listLonas.get(i).getPuntoDos();
            int[] huecos = listLonas.get(i).posXHuecos();   
            int mat[][] = new int[3][3];
            for (int j= 0; j<tarps[i].length;j++){
                if(j==0){
                    mat[j] = puntoI;
                }else if(j==1){
                    mat[j] = puntoF;

                }else{
                    mat[j] = huecos;
                }
                for(int k=0; k<tarps[i][j].length;k++){
                    tarps[i] = mat;
                    
                }
            }
        }
            return tarps;
    }      
    /**
     * Retorna las coordenadas de la lluvia su posicion en X y en Y de cada punto de lluvia
     * @return int[][][] rain
     */    
    public int [][][] rains(){
    
    return null;
    }
}


 