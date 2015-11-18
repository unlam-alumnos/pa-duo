package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Metro extends Ciudad {

	private int[] representantes;
	private int cantPuentes;

	public Metro(File in) {
		super(in);
		representantes = new int[islas.length];
		for (int i = 0; i < representantes.length; i++) {
			representantes[i] = i;
		}
		cantPuentes = 0;
	}

	private int find(int isla) {
		return representantes[isla];
	}

	private void union(int origen, int destino) {
		int repreOrigen = find(origen);
		int repreDestino = find(destino);
		
		if (repreOrigen < repreDestino) {
			replaceAll(repreDestino, repreOrigen);
		} else {
			replaceAll(repreOrigen, repreDestino);
		}
	}

	private void replaceAll(int repreOld, int repreNew) {
		for (int i = 0; i < islas.length; i++) {
			if (representantes[i] == repreOld) {
				representantes[i] = repreNew;
			}
		}
	}

	private void caminoMasCorto() {
		for (Conexion conexion : conexiones) {
			if (find(conexion.getOrigen()) != find(conexion.getDestino())) {
				union(conexion.getOrigen(), conexion.getDestino());
			} else {
				conexion.setActiva(false);
				matrizAdyacencia[conexion.getOrigen()][conexion.getDestino()] = false;
			}
		}
	}
	
	public void resolver(){
		caminoMasCorto();
		
		for (Conexion conexion : conexiones) {
			if (conexion.isActiva() && conexion.getTipo().equals("puente")) {
				cantPuentes++;
			}
		}
	}

	public void escrbirResultado(File out){
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(out);
			pw = new PrintWriter(fw);
			pw.println(this.cantPuentes);
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
