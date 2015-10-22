package edu.unlam.parcial;

import java.io.File;

/**
 * Main. Se especifica archivos de entrada y salida y se resuelve el ejercicio.
 * 
 * @author Gonzalo Martin & Cristian Miranda
 */
public class Main {

	public static void main(String[] args) {
		
		File entrada = new File("texto.in");
		File salida = new File("combinaciones.out");
		
		Ejercicio ejercicio = new Ejercicio(entrada,salida);
		
		ejercicio.resolver();
	}
}
