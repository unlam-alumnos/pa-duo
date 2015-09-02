package edu.unlam.luchadoresjaponeses.exercice;

import java.io.File;

import edu.unlam.luchadoresjaponeses.model.Luchador;
import edu.unlam.luchadoresjaponeses.tournament.Torneo;
import edu.unlam.luchadoresjaponeses.utils.IOUtils;

public class EjercicioLuchadores extends EjercicioOIA {
	public EjercicioLuchadores(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		Luchador[] luchadores = IOUtils.readLuchadores(entrada);
		new Torneo().comenzar(luchadores);
		IOUtils.writeResults(salida, luchadores);
	}
}
