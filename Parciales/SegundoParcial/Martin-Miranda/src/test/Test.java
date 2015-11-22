package test;

import java.io.File;

import edu.unlam.oia.Ejercicio;

public class Test {
	final static String IN = "../LoteDePruebas/IN/";
	final static String OUT = "../LoteDePruebas/";
	final static String FILE_NAME = "06_fatiga_9015esquinas";
	public static void main(String[] args) {
		File entrada = new File(IN + FILE_NAME + ".in");
		File salida = new File(OUT + FILE_NAME + ".out");
		
		Ejercicio ejercicio = new Ejercicio(entrada, salida);
		
		ejercicio.resolver();
	}
}