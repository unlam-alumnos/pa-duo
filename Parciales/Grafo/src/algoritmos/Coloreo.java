package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Grafo;
import model.Nodo;

/**
 * Define incompatibilidades entre Nodos, a traves del color que le asigna.
 * */
public class Coloreo extends Grafo{

	public Coloreo(int cantidadNodos) {
		super(cantidadNodos);
	}
	
	private void clean(){
		for (int i = 0; i < nodos.length; i++) {
			nodos[i].clean();
		}
	}
	
	private void shuffle(){
		List<Nodo> aux = new ArrayList<Nodo>();
		for (int i = 0; i < nodos.length; i++) {
			aux.add(nodos[i]);
		}
		Collections.shuffle(aux);
		nodos = (Nodo[]) aux.toArray();
	}
	
	private boolean puedoColorear(int indice, int color){
		if (nodos[indice].getColor() != 0) {
			return false;
		}
		
		for (int i = 0; i < nodos.length; i++) {
			if (i != indice && isAdyacentes(nodos[i], nodos[indice])) {
				if (nodos[i].getColor() == color) {
					return false;
				}
			}
		}
		
		return true;
	}

	public void resolver(){
		clean();
		shuffle();
		int nodosColoreados = 0;
		int color = 0;
		
		while (nodosColoreados < nodos.length) {
			color++;
			for (int indice = 0; indice < nodos.length; indice++) {
				if (puedoColorear(indice, color)) {
					nodos[indice].setColor(color);
					nodosColoreados++;
				}
			}
		}
		cantidadColores = color;
	}	
}
