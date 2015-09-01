package edu.unlam.luchadoresjaponeses;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		File entrada = new File("sumo.in");
		File salida = new File("sumo.out");
		Luchadores luchadores = new Luchadores(entrada, salida);
		luchadores.resolver();
	}
}
