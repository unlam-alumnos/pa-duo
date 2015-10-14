package model;

public class Categoria {
	private int minimo;
	private int maximo;
	private Podio podio;
	
	public Categoria(int minimo, int maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
		this.podio = new Podio(0,0,0);
	}
	
	public void addMedalla(int idCorredor){
		if (podio.getOro() == 0) {
			podio.setOro(idCorredor);
		}else if (podio.getPlata() == 0) {
			podio.setPlata(idCorredor);
		}else if (podio.getBronce() == 0) {
			podio.setBronce(idCorredor);
		}
	}
	
	public boolean pertenece(int edad){
		return edad >= minimo && edad <= maximo;
	}

	public int getMinimo() {
		return minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public Podio getPodio() {
		return podio;
	}

	@Override
	public String toString() {
		return "Categoria [minimo=" + minimo + ", maximo=" + maximo + ", podio=" + podio + "]";
	}
}
