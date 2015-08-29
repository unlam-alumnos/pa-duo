package edu.unlam.complejo;

import java.io.*;

public class IOUtils {

	public static String[] readLines(String pathFile) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] lines = null;

		try {
			archivo = new File(pathFile);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());

			lines = new String[cantidad];
			String line;

			int i = 0;

			while ((line = br.readLine()) != null) {

				lines[i] = line;
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

		return lines;
	}

	public static void writeLines(String pathFile, String[] array) {
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(pathFile);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < array.length; i++) {
				pw.println(array[i]);
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
