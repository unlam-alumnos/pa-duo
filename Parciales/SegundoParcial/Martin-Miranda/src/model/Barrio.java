<<<<<<< HEAD
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Barrio {
	final static int INF = 1000000;

	private int[] esquinas;
	private List<Calle> calles;
	private boolean[][] matrizAdyacencia;
	private int[][] matrizCostos;

	private int[] distancias;
	private int[] camino;
	private boolean[] vistos;
	private List<Integer> cambios;
	
	private int inicio;
	private int fin;

	public Barrio(File in) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(in);
			br = new BufferedReader(fr);

			String linea;
			String[] data;
			int cantidadCalles;

			linea = br.readLine();
			data = linea.split(" ");

			esquinas = new int[Integer.parseInt(data[0])];
			for (int i = 0; i < esquinas.length; i++) {
				esquinas[i] = i;
			}

			matrizAdyacencia = new boolean[esquinas.length][esquinas.length];
			matrizCostos = new int[esquinas.length][esquinas.length];
			for (int i = 0; i < esquinas.length; i++) {
				for (int j = 0; j < esquinas.length; j++) {
					matrizCostos[i][j] = INF;
				}
			}

			distancias = new int[esquinas.length];
			Arrays.fill(distancias, INF);

			camino = new int[esquinas.length];
			for (int i = 0; i < camino.length; i++) {
				camino[i] = 0;
			}

			vistos = new boolean[esquinas.length];
			Arrays.fill(vistos, false);

			inicio = Integer.parseInt(data[1]) - 1;
			fin = Integer.parseInt(data[2]) - 1;

			linea = br.readLine();
			data = linea.split(" ");
			cantidadCalles = Integer.parseInt(data[0]);
			calles = new ArrayList<Calle>();
			cambios = new ArrayList<Integer>();
			
			for (int i = 0; i < cantidadCalles; i++) {
				linea = br.readLine();
				data = linea.split(" ");
				int origen = Integer.parseInt(data[0]) - 1;
				int destino = Integer.parseInt(data[1]) - 1;
				int costo = Integer.parseInt(data[2]);

				calles.add(new Calle(i, origen, destino, costo));

				matrizAdyacencia[origen][destino] = true;

				// despues comparo adyacencia con costos para ver las que uso
				// con cambio de sentido
				matrizCostos[origen][destino] = costo;
				matrizCostos[destino][origen] = costo;
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

	public void resolver() {
		int esquinasRelevadas = 0;
		boolean first = true;
		int actual = inicio;
		distancias[inicio] = 0;

		while (esquinasRelevadas < esquinas.length) {
			if (first) {
				first = false;
			} else {
				actual = menorSiguiente(actual);
				caminoMasCorto(actual);
			}
			esquinasRelevadas++;
			vistos[actual] = true;
			caminoMasCorto(actual);
		}
		
		calcularCambios(inicio, fin);
	}

	private void caminoMasCorto(int actual) {
		for (int i = 0; i < esquinas.length; i++) {
			if (i != actual) {
				if (isAdyacente(actual, i)) {
					int acum = distancias[actual] + matrizCostos[actual][i];
					if (distancias[i] > acum) {
						distancias[i] = acum;
						camino[i] = actual;
					}
				}
			}
		}
	}

	private boolean isAdyacente(int origen, int destino) {
		return matrizCostos[origen][destino] != INF;
	}

	private int menorSiguiente(int origen) {
		int next = -1;

		int costoMenor = INF + 1;
		for (int i = 0; i < esquinas.length; i++) {
			if (origen != i) {
				if (!vistos[i] && costoMenor > distancias[i]) {
					next = i;
					costoMenor = distancias[i];
				}
			}
		}

		return next;
	}

	private int getIdArista(int origen, int destino) {
		for (Calle calle : calles) {
			if ((origen == calle.getOrigen() && destino == calle.getDestino())
					|| (destino == calle.getOrigen() && origen == calle.getDestino())) {
				return calle.getId();
			}
		}

		return -1;
	}

	public void calcularCambios(int origen, int destino) {
		if (origen != destino) {
			int b = camino[destino];
			int a = getIdArista(b, destino);
			if (matrizCostos[b][destino] != INF && !matrizAdyacencia[b][destino]) {
				cambios.add(a);
			}
			calcularCambios(origen, b);
		}
	}

	public void escribirResultado(File out){
		FileWriter fw = null;
		PrintWriter pw = null;
		StringBuffer sb = null;
		
		try {
			fw = new FileWriter(out);
			pw = new PrintWriter(fw);
			sb = new StringBuffer();
			pw.println(distancias[fin]);
			Collections.sort(cambios);
			for (Integer cambio : cambios) {
				sb.append(cambio + 1);
				sb.append(" ");
			}
			String idsCambios = sb.toString().trim();
			pw.println(idsCambios);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
=======
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Barrio {
	final static int INF = 1000000;

	private int[] esquinas;
	private List<Calle> calles;
	private boolean[][] matrizAdyacencia;
	private int[][] matrizCostos;

	private int[] distancias;
	private int[] camino;
	private boolean[] vistos;
	private List<Integer> cambios;
	
	private int inicio;
	private int fin;

	public Barrio(File in) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(in);
			br = new BufferedReader(fr);

			String linea;
			String[] data;
			int cantidadCalles;

			linea = br.readLine();
			data = linea.split(" ");

			esquinas = new int[Integer.parseInt(data[0])];
			for (int i = 0; i < esquinas.length; i++) {
				esquinas[i] = i;
			}

			matrizAdyacencia = new boolean[esquinas.length][esquinas.length];
			matrizCostos = new int[esquinas.length][esquinas.length];
			for (int i = 0; i < esquinas.length; i++) {
				for (int j = 0; j < esquinas.length; j++) {
					matrizCostos[i][j] = INF;
				}
			}

			distancias = new int[esquinas.length];
			Arrays.fill(distancias, INF);

			camino = new int[esquinas.length];
			for (int i = 0; i < camino.length; i++) {
				camino[i] = 0;
			}

			vistos = new boolean[esquinas.length];
			Arrays.fill(vistos, false);

			inicio = Integer.parseInt(data[1]) - 1;
			fin = Integer.parseInt(data[2]) - 1;

			linea = br.readLine();
			data = linea.split(" ");
			cantidadCalles = Integer.parseInt(data[0]);
			calles = new ArrayList<Calle>();
			cambios = new ArrayList<Integer>();
			
			for (int i = 0; i < cantidadCalles; i++) {
				linea = br.readLine();
				data = linea.split(" ");
				int origen = Integer.parseInt(data[0]) - 1;
				int destino = Integer.parseInt(data[1]) - 1;
				int costo = Integer.parseInt(data[2]);

				calles.add(new Calle(i, origen, destino, costo));

				matrizAdyacencia[origen][destino] = true;

				// despues comparo adyacencia con costos para ver las que uso
				// con cambio de sentido
				matrizCostos[origen][destino] = costo;
				matrizCostos[destino][origen] = costo;
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

	public void resolver() {
		int esquinasRelevadas = 0;
		boolean first = true;
		int actual = inicio;
		distancias[inicio] = 0;

		while (esquinasRelevadas < esquinas.length) {
			if (first) {
				first = false;
			} else {
				actual = menorSiguiente(actual);
				caminoMasCorto(actual);
			}
			esquinasRelevadas++;
			vistos[actual] = true;
			caminoMasCorto(actual);
		}
		
		calcularCambios(inicio, fin);
	}

	private void caminoMasCorto(int actual) {
		for (int i = 0; i < esquinas.length; i++) {
			if (i != actual) {
				if (isAdyacente(actual, i)) {
					int acum = distancias[actual] + matrizCostos[actual][i];
					if (distancias[i] > acum) {
						distancias[i] = acum;
						camino[i] = actual;
					}
				}
			}
		}
	}

	private boolean isAdyacente(int origen, int destino) {
		return matrizCostos[origen][destino] != INF;
	}

	private int menorSiguiente(int origen) {
		int next = -1;

		int costoMenor = INF + 1;
		for (int i = 0; i < esquinas.length; i++) {
			if (origen != i) {
				if (!vistos[i] && costoMenor > distancias[i]) {
					next = i;
					costoMenor = distancias[i];
				}
			}
		}

		return next;
	}

	private int getIdArista(int origen, int destino) {
		for (Calle calle : calles) {
			if ((origen == calle.getOrigen() && destino == calle.getDestino())
					|| (destino == calle.getOrigen() && origen == calle.getDestino())) {
				return calle.getId();
			}
		}

		return -1;
	}

	public void calcularCambios(int origen, int destino) {
		if (origen != destino) {
			int b = camino[destino];
			int a = getIdArista(b, destino);
			if (matrizCostos[b][destino] != INF && !matrizAdyacencia[b][destino]) {
				cambios.add(a);
			}
			calcularCambios(origen, b);
		}
	}

	public void escribirResultado(File out){
		FileWriter fw = null;
		PrintWriter pw = null;
		StringBuffer sb = null;
		
		try {
			fw = new FileWriter(out);
			pw = new PrintWriter(fw);
			sb = new StringBuffer();
			pw.println(distancias[fin]);
			Collections.sort(cambios);
			for (Integer cambio : cambios) {
				sb.append(cambio + 1);
				sb.append(" ");
			}
			String idsCambios = sb.toString().trim();
			pw.println(idsCambios);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
>>>>>>> c71b9c6f0184c40c0ed80a1813f7278fee57968b
