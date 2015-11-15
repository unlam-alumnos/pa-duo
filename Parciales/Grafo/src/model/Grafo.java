package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Grafo {

	protected Nodo[] nodos;
	protected List<Arista> aristas;
	protected MatrizSimetrica matrizAdyacencia;
	protected int cantidadColores;
	
	public Grafo(){
		
	}
	
	public Grafo(String in){
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(in);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			String[] data = line.split(" ");
			
			nodos = new Nodo[Integer.parseInt(data[0])];
			initNodos();
			aristas = new ArrayList<Arista>(Integer.parseInt(data[1]));
			matrizAdyacencia = new MatrizSimetrica(nodos.length);
			
			while((line = br.readLine()) != null){
				data = line.split(" ");
				int indiceOrigen = Integer.parseInt(data[0]) - 1;
				int indiceDestino = Integer.parseInt(data[1]) - 1;
				int costo = Integer.parseInt(data[2]);
				
				nodos[indiceOrigen].addGrado();
				nodos[indiceDestino].addGrado();
				aristas.add(new Arista(nodos[indiceOrigen], nodos[indiceDestino], costo));
				matrizAdyacencia.setNodo(indiceOrigen, indiceDestino);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public Grafo(int cantidadNodos){
		nodos = new Nodo[cantidadNodos];
		initNodos();
		matrizAdyacencia = new MatrizSimetrica(cantidadNodos);
	}
	
	protected void initNodos(){
		for (int i = 0; i < nodos.length; i++) {
			nodos[i] = new Nodo(i);
		}	
	}
	
	protected boolean isAdyacentes(Nodo origen, Nodo destino){
		return matrizAdyacencia.isAdyacentes(origen.getIndice(), destino.getIndice());
	}
	
	public Nodo[] getNodos() {
		return nodos;
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public int getCantidadColores() {
		return cantidadColores;
	}
	
	public int getGradoMaximo(){
		Nodo[] aux = nodos.clone();
		Arrays.sort(aux, Collections.reverseOrder());
		return aux[0].getGrado();
	}
	
	public int getGradoMinimo(){
		Nodo[] aux = nodos.clone();
		Arrays.sort(aux);
		return aux[0].getGrado();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nodos.length; i++)
			for (int j = i + 1; j < nodos.length; j++) {
				if (matrizAdyacencia.isAdyacentes(i, j)) {
					sb.append((i+1) + " " + (j+1) + "\n");
				}
			}
		return sb.toString();
	}	
}
