package model;

/**
 * @author gmartin
 *
 */
public class Conexion implements Comparable<Conexion>{
	private int origen;
	private int destino;
	private String tipo;
	private int costo;
	private boolean activa;

	public Conexion(int origen, int destino, String tipo, int costo) {
		this.origen = origen;
		this.destino = destino;
		this.tipo = tipo;
		this.costo = costo;
		this.activa = true;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCosto() {
		return costo;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	@Override
	public String toString() {
		return "[ori=" + origen + ", des=" + destino + ", " + tipo + ", " + costo + ", " + activa + "]";
	}

	@Override
	public int compareTo(Conexion otro) {
		if (this.costo < otro.getCosto()) {
			return -1;
		} else if(this.costo > otro.getCosto()) {
			return 1;
		} else {
			return 0;
		}
	}		
}
