package edu.unlam.oia;

import java.io.File;

import model.Torneo;

public class Ejercicio extends OIA{
	
	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Torneo torneo = new Torneo(entrada);
		torneo.armarPodio();
		torneo.escribirResultado(salida);		
	}

}
