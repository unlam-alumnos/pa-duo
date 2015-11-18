package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ciudad {
	protected int[] islas; // nodos
	protected Conexion[] conexiones; // aristas
	protected boolean[][] matrizAdyacencia;

	public Ciudad(File in) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(in);
			br = new BufferedReader(fr);
			String linea;
			String[] data;
			int tuneles;
			int puentes;

			linea = br.readLine();
			data = linea.split(" ");

			islas = new int[Integer.parseInt(data[0])];
			tuneles = Integer.parseInt(data[1]);
			puentes = Integer.parseInt(data[2]);
			conexiones = new Conexion[(tuneles + puentes)];
			matrizAdyacencia = new boolean[Integer.parseInt(data[0])][Integer
					.parseInt(data[0])];

			for (int i = 0; i < islas.length; i++) {
				for (int j = 0; j < islas.length; j++) {
					matrizAdyacencia[i][j] = false;
				}
			}

			for (int t = 0; t < tuneles; t++) {
				linea = br.readLine();
				data = linea.split(" ");
				int origen = Integer.parseInt(data[0]) - 1;
				int destino = Integer.parseInt(data[1]) - 1;

				matrizAdyacencia[origen][destino] = true;
				conexiones[t] = new Conexion(origen, destino, "tunel", 0);
			}
			for (int p = tuneles; p < (puentes + tuneles); p++) {
				linea = br.readLine();
				data = linea.split(" ");
				int origen = Integer.parseInt(data[0]) - 1;
				int destino = Integer.parseInt(data[1]) - 1;

				matrizAdyacencia[origen][destino] = true;
				conexiones[p] = new Conexion(origen, destino, "puente", 1);
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

}
