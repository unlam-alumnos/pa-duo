package model;

import java.util.Arrays;

public class MatrizSimetrica {
	private int cantidadNodos;
	private boolean vector[];

	public MatrizSimetrica(int cantNodos) {
		int tam = (int) (Math.pow(cantNodos, 2) - cantNodos) / 2;
		this.cantidadNodos = cantNodos;
		this.vector = new boolean[tam];
		Arrays.fill(vector, false);
	}

	public void setNodo(int nodoOrigen, int nodoDestino) {
		if (nodoOrigen != nodoDestino) {
			int pos = getPosicionVector(nodoOrigen, nodoDestino);
			vector[pos] = true;
		}
	}
	
	public void removeNodo(int nodoOrigen, int nodoDestino) {
		if (nodoOrigen != nodoDestino) {
			int pos = getPosicionVector(nodoOrigen, nodoDestino);
			vector[pos] = false;
		}
	}

	public boolean getNodo(int nodoOrigen, int nodoDestino) {
		int pos = getPosicionVector(nodoOrigen, nodoDestino);
		return vector[pos];
	}

	public int getPosicionVector(int nodoOrigen, int nodoDestino) {
		if (nodoOrigen > nodoDestino) {
			int aux = nodoOrigen;
			nodoOrigen = nodoDestino;
			nodoDestino = aux;
		}
		return (int) (nodoOrigen * cantidadNodos + nodoDestino - (Math.pow(
				nodoOrigen, 2) + 3 * nodoOrigen + 2) / 2);
	}

	public boolean isAdyacentes(int nodoOrigen, int nodoDestino) {
		return this.vector[this.getPosicionVector(nodoOrigen, nodoDestino)];
	}
}