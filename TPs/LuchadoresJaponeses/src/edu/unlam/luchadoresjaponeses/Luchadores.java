package edu.unlam.luchadoresjaponeses;

import java.io.File;

import edu.unlam.luchadoresjaponeses.model.Sumo;

public class Luchadores extends EjercicioOIA {
	public Luchadores(File entrada, File salida) {
		super(entrada, salida);
	}

	@Override
	public void resolver() {
		String[] linesFile = IOUtils.readLines(entrada);
		Sumo[] sumos = buildSumos(linesFile);
		countVictimas(sumos);
		
		String[] linesOut = new String[sumos.length];
		int i = 0;

		for (Sumo sumo : sumos) {
			linesOut[i] = String.valueOf(sumo.getVictimas());
			i++;
		}
		
		IOUtils.writeLines(salida, linesOut);
	}
	
	private static void countVictimas(Sumo[] sumos) {
		for (int i = 0; i < sumos.length; i++) {
			Sumo sumo = sumos[i];
			for (int j = 0; j < sumos.length; j++) {
				Sumo aux = sumos[j];
				if(!sumo.equals(aux)){
					if(sumo.compareTo(aux) == 1){
						sumo.addVictima();
					}
				}
			}
		}
	}

	private static Sumo[] buildSumos(String[] linesFile) {
		Sumo[] sumos = new Sumo[linesFile.length];
		int i = 0;
		for (String line : linesFile) {
			String[] auxSumo = line.split(" ");
			sumos[i] = new Sumo(Integer.parseInt(auxSumo[0]), Integer.parseInt(auxSumo[1]));
			i++;
		}
		return sumos;
	}
}
