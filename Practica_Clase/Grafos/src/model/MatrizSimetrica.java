package model;

public class MatrizSimetrica {
	private boolean vector[];
	
	public MatrizSimetrica(int nodos) {
		this.vector = new boolean[nodos * 2];
	}
	
	public void setNodo(int nodo1, int nodo2){
		if (nodo1 != nodo2) {
			int pos = getPosicionVector(nodo1, nodo2);
			vector[pos] = true;
		}		
	}
	
	public int getPosicionVector(int nodo1, int nodo2){
		return (int) (nodo1 * vector.length/2 + nodo2 - ( Math.pow(nodo1, 2) + 3 * nodo1 + 2) / 2);
	}
	
	public boolean getValor(int pos){
		return this.vector[pos];
	}
	
	public static void main(String[] args) {
		MatrizSimetrica vec = new MatrizSimetrica(5);

		vec.setNodo(0, 1);
		vec.setNodo(0, 2);
		vec.setNodo(1, 3);
		vec.setNodo(2, 3);
		vec.setNodo(3, 4);
		
		System.out.println(vec.getValor(vec.getPosicionVector(0,1)));
		System.out.println(vec.getValor(vec.getPosicionVector(0,2)));
		System.out.println(vec.getValor(vec.getPosicionVector(1,3)));
		System.out.println(vec.getValor(vec.getPosicionVector(2,3)));
		System.out.println(vec.getValor(vec.getPosicionVector(3,4)));
		
		System.out.println(vec.getValor(vec.getPosicionVector(0,3)));
		System.out.println(vec.getValor(vec.getPosicionVector(0,4)));
		System.out.println(vec.getValor(vec.getPosicionVector(1,0)));
		System.out.println(vec.getValor(vec.getPosicionVector(1,2)));
		System.out.println(vec.getValor(vec.getPosicionVector(1,4)));
		System.out.println(vec.getValor(vec.getPosicionVector(2,1)));
		System.out.println(vec.getValor(vec.getPosicionVector(2,4)));
		System.out.println(vec.getValor(vec.getPosicionVector(3,1)));
		System.out.println(vec.getValor(vec.getPosicionVector(3,2)));
		
	}

}
