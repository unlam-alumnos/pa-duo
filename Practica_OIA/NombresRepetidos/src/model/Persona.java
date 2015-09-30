package model;

public class Persona implements Comparable<Persona>{

	private String nombre;
	private int cantidad;
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		this.cantidad = 1;
	}
	
	public void addOcurrence(){
		this.cantidad++;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	

	@Override
	public String toString() {
		return nombre + " " + cantidad;
	}

	@Override
	public int compareTo(Persona other) {

		if (this.cantidad == other.getCantidad()) {
			return 0;
		}else if(this.cantidad > other.getCantidad()){
			return 1;
		}else{
			return -1;
		}
	}
}
