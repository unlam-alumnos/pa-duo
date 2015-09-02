package edu.unlam.luchadoresjaponeses.model;

public class Luchador {
	private int peso;
	private int altura;
	private int victimas;

	public Luchador(int peso, int altura) {
		super();
		this.peso = peso;
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getVictimas() {
		return victimas;
	}

	public void setVictimas(int victimas) {
		this.victimas = victimas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + altura;
		result = prime * result + peso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Luchador other = (Luchador) obj;
		if (altura != other.altura)
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}

	public int domina(Luchador sumo) {
		boolean superaEnAltura = this.altura > sumo.altura;
		boolean superaEnPeso = this.peso > sumo.peso;
		boolean igualaEnAltura = this.altura == sumo.altura;
		boolean igualaEnPeso = this.peso == sumo.peso;

		if (superaEnPeso && superaEnAltura) {
			return 1;
		} else if (superaEnPeso && igualaEnAltura) {
			return 1;
		} else if (superaEnAltura && igualaEnPeso) {
			return 1;
		} else if ((superaEnAltura && !superaEnPeso)
				|| (superaEnPeso && !superaEnAltura)) {
			return 0;
		} else {
			return -1;
		}
	}

	public void addVictima() {
		this.victimas++;
	}
}
