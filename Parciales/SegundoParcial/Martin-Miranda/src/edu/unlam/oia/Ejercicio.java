package edu.unlam.oia;

import java.io.File;
import model.Barrio;

public class Ejercicio extends OIA{

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Barrio barrio = new Barrio(entrada);
		barrio.resolver();
		barrio.escribirResultado(salida);
	}

}