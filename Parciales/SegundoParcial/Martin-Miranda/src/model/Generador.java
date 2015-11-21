package model;

import java.util.Random;

public class Generador {

	public static void generadorFatiga(int cantidadEsquinas) {
		if (cantidadEsquinas % 2 != 0 && cantidadEsquinas % 15 == 0) {
			int esquinasIntermedias = cantidadEsquinas / 2;
			int calles = esquinasIntermedias * 2;
			int INF = 1000000;

			int[][] matrizCostos = new int[calles + 1][calles + 1];

			for (int i = 0; i < matrizCostos.length; i++) {
				for (int j = 0; j < matrizCostos.length; j++) {
					matrizCostos[i][j] = INF;
				}
			}

			for (int i = 1; i <= esquinasIntermedias; i++) {
				int ia = i - 1;
				int ib = i * 2 - 1;
				int ic = i * 2;

				matrizCostos[ib][ia] = new Random().nextInt(40) + 1;
				matrizCostos[ic][ia] = new Random().nextInt(40) + 1;
			}

			System.out.println(cantidadEsquinas + " 1 " + cantidadEsquinas);
			System.out.println(calles);
			for (int i = 0; i < matrizCostos.length; i++) {
				for (int j = 0; j < matrizCostos.length; j++) {
					if (matrizCostos[i][j] != INF) {
						System.out.println((i + 1) + " " + (j + 1) + " " + matrizCostos[i][j]);
					}
				}
			}
		}else{
			throw new IllegalArgumentException("La cantidad de esquinas debe ser impar y multiplo de 15");
		}
	}

	public static void main(String[] args) {
		Generador.generadorFatiga(9015);
	}
}