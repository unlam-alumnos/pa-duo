package model;

public class Arista implements Comparable<Arista>{
	private Nodo origen;
	private Nodo destino;
	private int costo;
	
	public Arista(Nodo origen, Nodo destino, int costo) {
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}
	
	public Arista(Arista otro){
		this(otro.getOrigen(), otro.getDestino(), otro.getCosto());
	}

	public Nodo getOrigen() {
		return origen;
	}

	public Nodo getDestino() {
		return destino;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public String toString() {
		return "Arista [origen=" + origen.getIndice() + ", destino=" + destino.getIndice() + ", costo="
				+ costo + "]";
	}

	@Override
	public int compareTo(Arista otro) {
		if (this.costo > otro.getCosto()) {
			return 1;
		}else if (this.costo < otro.getCosto()) {
			return -1;
		}else if (this.costo == otro.getCosto()) {
			if(this.origen.getIndice() < otro.getOrigen().getIndice()){
				return -1;
			}
			return 0;
		}else{
			return 0;
		}
	}
}
