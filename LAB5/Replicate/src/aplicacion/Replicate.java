package aplicacion;

public class Replicate{
	private int [][] matriz; 
	private int [][] replica; 
	public Replicate(int[][] matriz){
		this.matriz = matriz;
			
	}
	
	public void imprimirMatriz(){
		for (int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++){
				//System.out.println("i="+i+" "+"j="+j+" "+matriz[i][j]);
				System.out.println("i="+i+" "+"j="+j+" "+replica[i][j]);
			}
		}
	}
	
	public void inicializarReplica(){
		replica = new int[matriz.length][matriz[0].length];
		for(int i=0;i<replica.length;i++){
			for(int j=0;j<replica[0].length;j++){
				replica[i][j] = 0;
			}
		}
	}
	
	public int[][] replicarMatriz(){
		this.inicializarReplica();
		for (int i=1;i<matriz.length-1;i++){
			for(int j=1;j<matriz[0].length-1;j++){
				int contador = 0;
				if(i!=0 && i!=matriz.length-1 && j != 0 && j!= matriz[0].length-1){
					if(matriz[i][j] == 1){
						contador+=1;
					}
					if(matriz[i][j+1]==1){
						contador+=1 ;
					}if(matriz[i-1][j]==1){
						contador+=1 ;
					}if(matriz[i][j-1]==1){
						contador+=1; 
					}if(matriz[i+1][j]==1){
						contador+=1; 
					}if(matriz[i-1][j+1]==1){
						contador+=1; 
					}if(matriz[i+1][j+1]==1){
						contador+=1 ;
					}if(matriz[i-1][j-1]==1){
						contador+=1 ;
					}if(matriz[i+1][j-1]==1){
						contador+=1 ;
					}
			
					if (contador % 2 != 0){
						replica[i][j] = 1;
					}else if (contador % 2==0){
						replica[i][j] = 0;
					}
					contador=0;
				}
				

			}
		}
		return replica;
		
	}
	
	public int[][] getMatriz(){
		return matriz;
	}

}
