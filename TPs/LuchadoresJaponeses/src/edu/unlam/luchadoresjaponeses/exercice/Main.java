package edu.unlam.luchadoresjaponeses.exercice;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File entrada = new File("sumo.in");
		File salida = new File("sumo.out");
		EjercicioLuchadores ejercicio = new EjercicioLuchadores(entrada, salida);
		ejercicio.resolver();
	}
}
