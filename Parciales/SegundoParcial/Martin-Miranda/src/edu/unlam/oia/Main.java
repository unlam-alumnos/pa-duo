package edu.unlam.oia;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File entrada = new File("in.in");
		File salida = new File("in.out");
		
		Ejercicio ejercicio = new Ejercicio(entrada, salida);
		
		ejercicio.resolver();
	}

}
