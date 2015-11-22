<<<<<<< HEAD
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
=======
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
>>>>>>> c71b9c6f0184c40c0ed80a1813f7278fee57968b
