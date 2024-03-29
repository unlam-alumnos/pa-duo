package edu.unlam.entradasalida;

import java.io.*;

public class LeerEnteros {
	public static void main(String[] arg) {
		int suma = 0;
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			f = new File("enteros.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null)

				suma = suma + Integer.parseInt(linea);
							
			System.out.println(suma);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(suma);
			
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
