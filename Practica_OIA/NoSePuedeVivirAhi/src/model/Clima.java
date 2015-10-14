package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Clima {

	private int cantLugares;
	private LugarGeografico[] lugares;
	private int masHostil;
	
	public Clima(File entrada) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(entrada);
			br = new BufferedReader(fr);
			String[] data;
			cantLugares = Integer.parseInt(br.readLine());
			lugares = new LugarGeografico[cantLugares];
			
			for (int i = 0; i < lugares.length; i++) {
				int mediciones = Integer.parseInt(br.readLine());
				boolean primerMedicion = true;
				
				for (int j = 0; j < mediciones; j++) {
					
					data = br.readLine().split(" ");
					double min = Integer.parseInt(data[0]);
					double max = Integer.parseInt(data[1]);
					
					if (primerMedicion) {
						lugares[i] = new LugarGeografico(i+1,min,max);
						primerMedicion = false;
					}else{
						lugares[i].addMedicion(min, max);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void comparar(){
		LugarGeografico[] auxLugares = lugares.clone();
		boolean primero = true;
		
		for (int i = 0; i < lugares.length; i++) {
			for (int j = 0; j < auxLugares.length; j++) {
				if (i!=j) {
					if (!lugares[i].equals(auxLugares[j])) {
						if (lugares[i].noComparable(auxLugares[j])) {
							lugares[i].addNoComparable();
						}else{
							lugares[i].addMenosHostil();
						}
					}
				}
			}
		}
		
		for (int i = 0; i < lugares.length; i++) {
			if (primero) {
				masHostil = lugares[i].getMenosHostiles();
				primero = false;
			}else{
				if (masHostil < lugares[i].getMenosHostiles()) {
					masHostil = lugares[i].getMenosHostiles();
				}
			}
		}
		
	}
	
	public void escribirResultado(File salida){
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);
			
			for (int i = 0; i < lugares.length; i++) {
				if (lugares[i].getMenosHostiles() == masHostil) {
					pw.println(lugares[i].toString());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fw) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
