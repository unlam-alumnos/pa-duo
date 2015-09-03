package edu.unlam.luchadoresjaponeses.tournament;

import edu.unlam.luchadoresjaponeses.model.Luchador;

public class Torneo {
	public void comenzar(Luchador[] luchadores) {
		for (int i = 0; i < luchadores.length; i++) {
			Luchador sumo = luchadores[i];
			for (int j = 0; j < luchadores.length; j++) {
				Luchador rival = luchadores[j];
				if(!sumo.equals(rival)){
					if(sumo.domina(rival) == 1){
						sumo.addVictima();
					}
				}
			}
		}
	}
}
