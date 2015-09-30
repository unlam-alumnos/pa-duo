package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Nombres {
	
	private Map<String, Persona> nombres;
	private Persona[] resultado;
	private int cantToSearch;

	public Nombres(File archivo) {
		super();

		nombres = new HashMap<String, Persona>();
		
		FileReader fr = null;
		BufferedReader br = null;
		String name;
		
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String[] firstLine = br.readLine().split(" ");
			int cantNames = Integer.parseInt(firstLine[0]);
			cantToSearch = Integer.parseInt(firstLine[1]);
			
			for (int i = 0; i < cantNames; i++) {
				name = br.readLine().trim();
				Persona aux;
				if (nombres.get(name) == null) {
					aux = new Persona(name);
				}else{
					aux = nombres.get(name);
					aux.addOcurrence();
				}
				nombres.put(name, aux);
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
	
	public void sort(){
		resultado = new Persona[nombres.size()];
		Collection<Persona> collectionAux = nombres.values();
		Iterator itePersona = collectionAux.iterator();
		
		int i = 0;
		while (itePersona.hasNext()) {
			resultado[i] = (Persona)itePersona.next();
			i++;
		}
		
		Arrays.sort(resultado, Collections.reverseOrder());
	}
	
	public void writeResult(File salida){
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter(salida);
			pw = new PrintWriter(fichero);
			
			for (int i = 0; i < cantToSearch; i++) {
				pw.println(resultado[i].toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
