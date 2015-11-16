package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Camino extends Dijkstra{
	private List<Arista> galerias;
	private int obstruidas;
	private int largoTotal;
	
	public Camino(File in) {
		super(in);
		galerias = new ArrayList<Arista>();
		obstruidas = 0;
		largoTotal = 0;
	}
	
	private void obtenerGalerias(int origen, int destino) {
		if (destino < nodos.length && camino[destino] != destino){
			obtenerGalerias(origen, camino[destino]);
		}
		Arista aux = getArista(camino[destino], destino);
		if (aux != null) {
			galerias.add(aux);
			System.out.println(aux.getId() + 1 + " ; " + (aux.getNodoOrigen()+1) + " " + (aux.getNodoDestino()+1));
		}
	}
	
	public void analizarCamino() {
		resolver();
		obtenerGalerias(puertaEntrada, puertaSalida);

		for (Arista galeria : galerias) {
			if (!galeria.isLibre()) {
				obstruidas++;
			}
			largoTotal += galeria.getCosto();
		}
	}
	
	public void escribirResultado(File out){
		FileWriter fw = null;
		PrintWriter pw = null;
		StringBuffer sb = null;
		
		try {
			fw = new FileWriter(out);
			pw = new PrintWriter(fw);
			sb = new StringBuffer();
			
			sb.append((obstruidas + 1) + " ");
			if (obstruidas > 0) {
				for (Arista galeria : galerias) {
					if (!galeria.isLibre()) {
						sb.append((galeria.getId() + 1) + " ");
					}
				}
			}
			sb.append(largoTotal);
			pw.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
