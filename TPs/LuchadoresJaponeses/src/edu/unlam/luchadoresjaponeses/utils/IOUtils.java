package edu.unlam.luchadoresjaponeses.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import edu.unlam.luchadoresjaponeses.model.Luchador;

public class IOUtils {

	/**
	 * Procesa el archivo de entrada y devuelve un array de Luchadores
	 * 
	 * @param archivo
	 * @return
	 */
	public static Luchador[] readLuchadores(File archivo) {
		FileReader fr = null;
		BufferedReader br = null;
		Luchador[] luchadores = null;

		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			luchadores = new Luchador[cantidad];
			String line;

			int i = 0;
			while ((line = br.readLine()) != null) {
				// Creo al luchador
				String[] auxSumo = line.split(" ");
				luchadores[i] = new Luchador(Integer.parseInt(auxSumo[0]), Integer.parseInt(auxSumo[1]));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return luchadores;
	}

	/**
	 * Escribe los resultados en el archivo de salida
	 * 
	 * @param archivo
	 * @param resultados
	 */
	public static void writeResults(File archivo, Luchador[] luchadores) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(archivo);
			pw = new PrintWriter(fichero);

			for (Luchador luchador : luchadores) {
				pw.println(String.valueOf(luchador.getVictimas()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
