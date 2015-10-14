package model;

public class LugarGeografico implements Comparable<LugarGeografico>{
	private int id;
	private double minimo;
	private double maximo;
	private int noComparables;
	private int menosHostiles;

	public LugarGeografico(int id, double minimo, double maximo) {
		this.id = id;
		this.minimo = minimo;
		this.maximo = maximo;
		this.noComparables = 0;
	}
	
	public void addMedicion(double min, double max){
		if (minimo > min) {
			minimo = min;
		}
		if (maximo < max) {
			maximo = max;
		}
	}
	
	public void addNoComparable(){
		this.noComparables++;
	}
	
	public void addMenosHostil(){
		this.menosHostiles++;
	}
	
	@Override
	public String toString() {
		return "" + id + " " + noComparables +"";
	}
	
	public boolean noComparable(LugarGeografico otro){
		if (this.minimo < otro.getMinimo() && this.maximo > otro.getMaximo()) {
			return false;
		}else if(this.minimo == otro.getMinimo() && this.maximo > otro.getMaximo()){
			return false;
		}else if(this.minimo < otro.getMinimo() && this.maximo == otro.getMaximo()){
			return false;
		}else{
			return true;	
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LugarGeografico other = (LugarGeografico) obj;
		if (Double.doubleToLongBits(maximo) != Double.doubleToLongBits(other.maximo))
			return false;
		if (Double.doubleToLongBits(minimo) != Double.doubleToLongBits(other.minimo))
			return false;
		return true;
	}

	@Override
	public int compareTo(LugarGeografico otro) {
		if (this.id < otro.getId()) {
			return -1;
		}else if (this.id > otro.getId()) {
			return 1;
		}else {
			return 0;
		}
	}

	public int getId() {
		return id;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public int getNoComparables() {
		return noComparables;
	}

	public int getMenosHostiles() {
		return menosHostiles;
	}
}
