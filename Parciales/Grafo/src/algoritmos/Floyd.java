package algoritmos;

import model.Arista;
import model.Grafo;

public class Floyd extends Grafo{
	final static int INF = 1000000;
	private int[][] camino;
	private int[][] distancias;
	private int[][] matrizCostos;
	
	public Floyd(String in) {
		super(in);
		this.camino = new int[nodos.length][nodos.length];
		this.distancias = new int[nodos.length][nodos.length];
		this.matrizCostos = new int[nodos.length][nodos.length];
		
		for (int i = 0; i < nodos.length; i++) {
			for (int j = 0; j < nodos.length; j++) {
				matrizCostos[i][j] = INF;
				distancias[i][j] = INF;
			}
		}
		
		for (Arista arista : aristas) {
			int origen = arista.getOrigen().getIndice();
			int destino = arista.getDestino().getIndice();
			int costo = arista.getCosto();
			matrizCostos[origen][destino] = costo;
		}
	}
	
	public void resolver(){
		
		for (int i = 0; i < nodos.length; i++) {
			for (int j = 0; j < nodos.length; j++) {
				distancias[i][j] = matrizCostos[i][j];
			}
		}
		
		for (int i = 0; i < nodos.length; i++) {
			camino[i][i] = i;
			distancias[i][i] = 0;
		}
		
		for (int k = 0; k < nodos.length; k++) {
			for (int i = 0; i < nodos.length; i++) {
				for (int j = 0; j < nodos.length; j++) {
					int acum = distancias[i][k] + distancias[k][j];
					if (distancias[i][j] > acum) {
						distancias[i][j] = acum;
					}
				}
			}
		}
	}
	
	public int[][] getCamino() {
		return camino;
	}

	public int[][] getDistancias() {
		return distancias;
	}

	public int[][] getMatrizCostos() {
		return matrizCostos;
	}

	public void mostrarDistancias(){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nodos.length; i++) {
			for (int j = 0; j < nodos.length; j++) {
				sb.append(distancias[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		Floyd grafo = new Floyd("floyd.in");
		grafo.resolver();
		grafo.mostrarDistancias();
	}
	
	
}
