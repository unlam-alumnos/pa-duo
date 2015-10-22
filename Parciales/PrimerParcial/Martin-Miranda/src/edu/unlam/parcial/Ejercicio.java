package edu.unlam.parcial;

import java.io.File;

import model.Procesador;

/**
 * Clase principal para resolver el ejercicio
 * 
 * @author Gonzalo Martin & Cristian Miranda
 */
public class Ejercicio extends EjercicioOIA{

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Procesador procesador = new Procesador(entrada);
		procesador.procesar();
		procesador.escribirResultado(salida);
	}

}
