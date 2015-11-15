package algoritmos;

import java.util.Arrays;

import model.Arista;
import model.Grafo;
import model.Nodo;
/**
 * Encontrar la distancia, mas corta, entre el nodo origen y todos los demas nodos.
 * */
public class Dijkstra extends Grafo{
	final static int INF = 1000000;
	final static int NONE = -2; 
	private int[] distancias;
	private int[] camino;
	private boolean[] vistos;
	private int[][] matrizCostos;
			
	public Dijkstra(String in) {
		super(in);
		distancias = new int[nodos.length];
		camino = new int[nodos.length];
		vistos = new boolean[nodos.length];
		matrizCostos = new int[nodos.length][nodos.length];
		Arrays.fill(distancias, INF);
		Arrays.fill(camino, NONE);
		Arrays.fill(vistos, false);
		
		for (int i = 0; i < matrizCostos.length; i++) {
			for (int j = 0; j < matrizCostos.length; j++) {
				matrizCostos[i][j] = INF;
			}
		}
		
		for (Arista arista : aristas) {
			int origen = arista.getOrigen().getIndice();
			int destino = arista.getDestino().getIndice();
			int costo = arista.getCosto();
			matrizCostos[origen][destino] = costo;
		}
	}
	
	// Modifico la validacion de adyacencia ya que suele utilizarse con Grafos Dirigidos
	// Es decir no es lo mismo 1->2 que 2->1
	@Override
	protected boolean isAdyacentes(Nodo origen, Nodo destino){
		return matrizCostos[origen.getIndice()][destino.getIndice()] != INF;
	}
		
	private void caminoMasCorto(Nodo origen){
		for (int i = 0; i < nodos.length; i++) {
			if (origen.getIndice() != i) {
				if (isAdyacentes(origen,nodos[i])) {
					if (!vistos[nodos[i].getIndice()]) {
						int acum = distancias[origen.getIndice()] + matrizCostos[origen.getIndice()][nodos[i].getIndice()];
						if(distancias[nodos[i].getIndice()] > acum){
							distancias[nodos[i].getIndice()] = acum;
							camino[nodos[i].getIndice()] = origen.getIndice();
						}
					}
				}				
			}
		}
	}
	
	private Nodo nextMenor(Nodo actual) {
		Nodo next = null;
		int costoMenor = INF+1;
		for (int i = 0; i < nodos.length; i++) {
			if (actual.getIndice() != i) {
				if (!vistos[i] && costoMenor >= distancias[i]) {
					next = nodos[i];
					costoMenor = distancias[i];
				}
			}
		}
		return next;
	}

	public void resolver(){
		Nodo origen = null;
		boolean first = true;
		int nodosVistos = 0;
		while (nodosVistos < nodos.length) {
			if (first) {
				origen = nodos[0];
				distancias[0] = 0;
				first = false;
			}else{
				origen = nextMenor(origen);
			}
			
			vistos[origen.getIndice()] = true;
			nodosVistos++;
			caminoMasCorto(origen);
		}	
	}

	public int[] getDistancias() {
		return distancias;
	}

	public int[] getCamino() {
		return camino;
	}

	public boolean[] getVistos() {
		return vistos;
	}

	public int[][] getMatrizCostos() {
		return matrizCostos;
	}
	
	public static void main(String[] args) {
		Dijkstra grafo = new Dijkstra("dijkstra.in");
		grafo.resolver();
		System.out.println(Arrays.toString(grafo.getDistancias()));
		System.out.println(Arrays.toString(grafo.getCamino()));
	}
}
