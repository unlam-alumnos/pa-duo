package edu.unlam.oia;

import java.io.File;

import model.Metro;

public class Ejercicio extends OIA{

	public Ejercicio(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Metro metro = new Metro(entrada);
		metro.resolver();
		metro.escrbirResultado(salida);
	}

}
