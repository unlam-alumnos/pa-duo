package edu.unlam.nombresrepetidos;

import java.io.File;

import model.Nombres;
import oia.EjercicioOIA;

public class EjercicioNombres extends EjercicioOIA {

	private Nombres nombres;
	
	public EjercicioNombres(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {

		nombres = new Nombres(entrada);
		nombres.sort();
		nombres.writeResult(salida);
	}
	
}
