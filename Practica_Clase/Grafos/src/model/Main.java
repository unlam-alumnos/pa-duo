package model;

public class Main {

	public static void main(String[] args) {
		
		int dim = 62700;
		
		boolean grafo[][] = new boolean[dim][dim];
		
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo.length; j++) {
				grafo[i][j] = true;
			}
		}
		
		System.out.println(grafo);
	}

}
