package edu.unlam.complejo;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		String[] linesFile = IOUtils.readLines("complejos.in");
		Complejo[] complejos = new Complejo[linesFile.length];
		
		int i = 0;
		
		for (String line : linesFile) {
			
			String[] auxComplejo = line.split(" ");
			
			complejos[i] = new Complejo(Double.parseDouble(auxComplejo[0]), Double.parseDouble(auxComplejo[1]));
			i++;
		}
		
		Arrays.sort(complejos);
		String[] linesOut = new String[complejos.length+1];
		i = 0;
		linesOut[i] = String.valueOf(complejos.length);
		
		for (Complejo complejo : complejos) {
			
			i++;
			linesOut[i] = complejo.getReal() + " " + complejo.getImaginario();
			
		}
		
		IOUtils.writeLines("complejos.out", linesOut);
	}

}
