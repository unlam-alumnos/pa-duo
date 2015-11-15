package model;

public class Nodo implements Comparable<Nodo> {
	private int indice;
	private int color;
	private int grado;
	private Object data;
	
	public Nodo(){
	}
	
	public Nodo(int indice, int color, int grado, Object data) {
		this.indice = indice;
		this.color = color;
		this.grado = grado;
		this.data = data;
	}
	
	public Nodo(int indice){
		this(indice, 0, 0, null);
	}
	
	public Nodo(Nodo otro){
		this(otro.getIndice(), otro.getColor(), otro.getGrado(), otro.getData());
	}
	
	public void clean(){
		this.color = 0;
	}
	
	public void addGrado(){
		this.grado++;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getIndice() {
		return indice;
	}

	public int getGrado() {
		return grado;
	}

	public Object getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return "Nodo [indice=" + indice + ", color=" + color + ", grado="
				+ grado + ", data=" + data + "]";
	}

	@Override
	public int compareTo(Nodo otro) {
		if (this.grado > otro.getGrado()) {
			return 1;
		}else if (this.grado < otro.getGrado()) {
			return -1;
		}else{
			return 0;
		}
	}
}
