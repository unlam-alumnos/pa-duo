package edu.unlam.oia;

import java.io.File;

import model.Clima;

public class Ejercicio extends OIA{

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Clima climas = new Clima(entrada);
		climas.comparar();
		climas.escribirResultado(salida);
	}

}
