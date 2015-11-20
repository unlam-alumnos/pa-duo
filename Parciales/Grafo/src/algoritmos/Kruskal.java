package algoritmos;

import java.util.Collections;

import model.Arista;
import model.Grafo;
import model.Nodo;

/**
 * Conectar todos los nodos del grafo, a traves del camino mas corto.
 * */
public class Kruskal extends Grafo{
	private int[] representantes;
		
	public Kruskal(int cantidadNodos) {
		super(cantidadNodos);
		representantes = new int[cantidadNodos];
	}
	
	public Kruskal(String in){
		super(in);
		representantes = new int[nodos.length];
		for (int i = 0; i < representantes.length; i++) {
			representantes[i] = i;
		}
	}
	
	private int find(Nodo nodo){
		return representantes[nodo.getIndice()];
	}
	
	private void replaceAll(int index, int value){
		for (int i = 0; i < representantes.length; i++) {
			if (representantes[i] == index) {
				representantes[i] = value;
			}
		}
	}
	
	private void union(Nodo origen, Nodo destino){
		int representanteOrigen = find(origen);
		int representanteDestino = find(destino);
		
		if (representanteOrigen < representanteDestino) {
			replaceAll(representanteDestino, representanteOrigen);
		}else{
			replaceAll(representanteOrigen, representanteDestino);
		}
	}
	
	public void resolver(){
		Collections.sort(aristas);
				
		for (Arista arista : aristas) {
			if ( find(arista.getOrigen()) != find(arista.getDestino())) {
				union(arista.getOrigen(), arista.getDestino());
			}else{
				matrizAdyacencia.removeNodo(arista.getOrigen().getIndice(), arista.getDestino().getIndice());
			}
		}
	}
	
	public static void main(String[] args) {
		Kruskal grafo = new Kruskal("kruskal.in");
		grafo.resolver();
		System.out.println(grafo.toString());
	}

}
