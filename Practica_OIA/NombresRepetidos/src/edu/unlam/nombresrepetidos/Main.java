package edu.unlam.nombresrepetidos;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File entrada = new File("nombres.in");
		File salida = new File("nombres.out");
		
		EjercicioNombres ejercicio = new EjercicioNombres(entrada, salida);
		
		ejercicio.resolver();
	}

}
