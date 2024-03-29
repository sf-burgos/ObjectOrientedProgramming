package aplicacion;
import java.util.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
/**
 * @author ECI 2014
 * 
 */
/**
 * @author ECI
 * Constructor de Teatro
 */
public  class Teatro implements Serializable{
    public static final int MAXIMO = 500;
    private static Teatro teatro = null;
    public static Actor romeo  = null;
    public static Actor julieta  = null;
    public static ActorNecio homero  = null;
    public static ActorNecio bart  = null;
    public static ActorPerezoso eduard = null;
    public static ActorPerezoso bella = null;
    public static Luz centralIzquierda = null;
    public static Luz centralDerecha = null;
    public static ActorEnojon brayan = null;
    public static ActorEnojon alfonso = null;
    public static Armario armario = null;
    
    /**
     * Da el teatro que usan los actores 
     * @return Teatro teatro
     */
    public static Teatro demeTeatro() {
        if (teatro==null){
            teatro=new Teatro();
        }
        return teatro;
    }
    /**
     * Crea un nuevo Teatro 
     */
    public static void nuevoTeatro() {
        teatro=new Teatro();
    }   
    /**
     * @param Teatro d
     * cambia el teatros por el que se da por parametro 
     */
    public static void cambieTeatro(Teatro d) {
        teatro=d;
    }       


    private ArrayList<EnEscena> elementos;
    /**
     * Constructor de teatro, añadimos un arreglo de en escena que guardara
     * actores y luces 
     */
    private Teatro() {
        elementos= new ArrayList<EnEscena>();
        
    }
    /**
     * Se crean los actores y se añaden al ArrayList EnEscena 
     */
    public void algunosEnEscena(){
        //romeo = new Actor(this.teatro,"Romeo",50,10);
        julieta = new Actor(this.teatro,"Julieta",100,10);
        homero = new ActorNecio(this.teatro,"Homer",150,10);
        bart = new ActorNecio(this.teatro,"Homer",200,10);
        eduard = new ActorPerezoso(this.teatro,"Eduard",250,10);
        bella = new ActorPerezoso(this.teatro,"Bella",300,10);
        alfonso = new ActorEnojon(this.teatro,"Alfonso",350,10);
        brayan = new ActorEnojon(this.teatro,"Brayan",400,10);
        centralIzquierda = new Luz(0,250);
        centralDerecha = new Luz(500,250);
        armario = new Armario(0,500);
        
        //elementos.add(romeo);
        elementos.add(julieta);
        //ActoresNecios
        elementos.add(homero);
        elementos.add(bart);
        //ActoresPerezosos 
        elementos.add(eduard);
        elementos.add(bella);
        //luces
        elementos.add(centralIzquierda);
        elementos.add(centralDerecha);
        //ActoresEnojones
        elementos.add(brayan);
        elementos.add(alfonso);
        //Armarios 
        elementos.add(armario);
    
        
        

    }  
    
    /**
     * @param int n 
     * Devuelve un objeto del arreglo EnEscena ya sea un actor o una luz 
     * @return EnEscena h
     */
    public EnEscena demeEnEscena(int n){
        EnEscena h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    /**
     * @param EnEscena e 
     * Agrega los elementos de tipo EnEscena al ArrayList
     */
    public void adicione(EnEscena e){
        elementos.add(e);
    }
    
    /**
     * Numero de elementos que existen en EnEscena 
     */
    public int numeroEnEscena(){
        return elementos.size();
    }
    
    
    /**
     * Recorre los elementos EnEscena y los pone a actuar
     */
    public void accion(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).actue();
        }
    }
    /**
     * Recorre los elementos EnEscena y ejecuta corte 
     */
    
	
    public void corten(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).corte();
        }
    }    
    /**
     * Recorre los elementos EnEscena y ejecuta decida 
     */
    public void decidan(){
        for (int i=0;i<elementos.size();i++){
            elementos.get(i).decida();
        }
    }
	public static void abrir(File archivo) throws TeatroColonException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			cambieTeatro((Teatro)ois.readObject() );
		} catch (Exception e) {
			throw new TeatroColonException(TeatroColonException.NO_ABRIR);
		}
	
	}	
	
	public void salvar (File archivo) throws TeatroColonException {
		if (teatro == null) {
			throw new TeatroColonException(TeatroColonException.SIN_TEATRO);
		}
		try{
			ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(archivo));
			out.writeObject(teatro);
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void importe(File archivo)  throws TeatroColonException{	
		String texto = archivo.getAbsolutePath();
		try{
			FileReader leer = new FileReader(archivo);
			BufferedReader contenido = new BufferedReader(leer);
			while((texto=contenido.readLine())!=null){
				String[] s = (texto.split(" "));
				if(s[0].equals("Actor")){
					adicione(new Actor(this.teatro,s[3],Integer.parseInt(s[1]),Integer.parseInt(s[2])));
				}else if(s[0].equals("ActorNecio")){
					adicione(new ActorNecio(this.teatro,s[3],Integer.parseInt(s[1]),Integer.parseInt(s[2])));
				}else if(s[0].equals("ActorEnojon")){
					adicione(new ActorEnojon(this.teatro,s[3],Integer.parseInt(s[1]),Integer.parseInt(s[2])));
				}else if(s[0].equals("ActorPerezoso")){
					adicione(new ActorPerezoso(this.teatro,s[3],Integer.parseInt(s[1]),Integer.parseInt(s[2])));
				}else if(s[0].equals("Luz")){
					adicione(new Luz(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
				}else if(s[0].equals("Armario")){
					adicione(new Armario(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void exporte(File archivo)  throws TeatroColonException{	
		try{
			File arc = new File(archivo.getAbsolutePath());
			FileWriter escribir = new FileWriter(arc,false);
			for (EnEscena ele: elementos){
				escribir.write(ele.toString());
			}
			escribir.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static Teatro getTeatro(){
		return teatro;
	}
}
