package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Torneo {
	private int cantCompetidores;
	private int cantCategoriasFem;
	private int cantCategoriasMas;
	private int cantCompetidoresMeta;
	
	private Categoria[] categoriasFem;
	private Categoria[] categoriasMas;
	
	private Corredor[] corredores;
	private Integer[] idGanadores;
	
	public Torneo(File entrada){
		FileReader fr = null;
		BufferedReader br = null;
		String[] data;
		
		try {
			fr = new FileReader(entrada);
			br = new BufferedReader(fr);
			data = br.readLine().split(" ");
			
			cantCompetidores = Integer.parseInt(data[0]);
			cantCategoriasFem = Integer.parseInt(data[1]);
			cantCategoriasMas = Integer.parseInt(data[2]);
			cantCompetidoresMeta = Integer.parseInt(data[3]);
			categoriasFem = new Categoria[cantCategoriasFem];
			categoriasMas = new Categoria[cantCategoriasMas];
			corredores = new Corredor[cantCompetidores];
			idGanadores = new Integer[cantCompetidoresMeta];
			
			for (int i = 0; i < cantCategoriasFem; i++) {
				data = br.readLine().split(" ");
				categoriasFem[i] = new Categoria(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
			}
			for (int i = 0; i < cantCategoriasMas; i++) {
				data = br.readLine().split(" ");
				categoriasMas[i] = new Categoria(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
			}
			for (int i = 0; i < cantCompetidores; i++) {
				data = br.readLine().split(" ");
				Corredor aux;
				
				if (data[1].contains("F")) {
					for (int j = 0; j < cantCategoriasFem; j++) {
						if (categoriasFem[j].pertenece(Integer.parseInt(data[0]))) {
							aux = new Corredor('F',Integer.parseInt(data[0]),j);
							corredores[i] = aux;
							break;
						}
					}
				}else{
					for (int j = 0; j < cantCategoriasMas; j++) {
						if (categoriasMas[j].pertenece(Integer.parseInt(data[0]))) {
							aux = new Corredor('M',Integer.parseInt(data[0]),j);
							corredores[i] = aux;
							break;
						}
					}
				}								
			}
			for (int i = 0; i < cantCompetidoresMeta; i++) {
				data = br.readLine().split(" ");
				idGanadores[i] = Integer.parseInt(data[0]);
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

	public void armarPodio() {
		
		for (int id : idGanadores) {
			int idCategoria = corredores[id-1].getCategoria();
			if (corredores[id-1].getGenero() == 'F') {
				categoriasFem[idCategoria].addMedalla(id);
			}else if (corredores[id-1].getGenero() == 'M') {
				categoriasMas[idCategoria].addMedalla(id);
			}			
		}
	}

	public void escribirResultado(File salida) {
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);
			
			for (int i = 0; i < categoriasFem.length; i++) {
				int idCategoria = i+1;
				pw.println(idCategoria + " " + categoriasFem[i].getPodio().getOro() + " " + categoriasFem[i].getPodio().getPlata() + " " + categoriasFem[i].getPodio().getBronce());
			}
			for (int i = 0; i < categoriasMas.length; i++) {
				int idCategoria = i+1;
				pw.println(idCategoria + " " + categoriasMas[i].getPodio().getOro() + " " + categoriasMas[i].getPodio().getPlata() + " " + categoriasMas[i].getPodio().getBronce());
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
