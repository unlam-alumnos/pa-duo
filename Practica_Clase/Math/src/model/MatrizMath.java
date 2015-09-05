package model;

import java.util.Arrays;

import exception.DistDimException;

public class MatrizMath {
	
	private int filas;
	private int columnas;
	private double[][] matriz;
	
	public MatrizMath(int filas, int columnas) {
		super();
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new double[filas][columnas];
	}
	
	public void add(int fila, int columna, double valor){
		this.matriz[fila][columna] = valor;
	}
	
	public MatrizMath sumar(MatrizMath mat) throws DistDimException{
		if(this.filas != mat.filas || this.columnas != mat.columnas){
			throw new DistDimException("Distintas dimensiones");
		}
		
		MatrizMath aux = new MatrizMath(this.filas,this.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			
			for (int c = 0; c < this.columnas; c++) {
				aux.matriz[f][c] = this.matriz[f][c] + mat.matriz[f][c];
			}
		}
		return aux;
	}
	
	public MatrizMath restar(MatrizMath mat) throws DistDimException{
		if(this.filas != mat.filas || this.columnas != mat.columnas){
			throw new DistDimException("Distintas dimensiones");
		}
		
		MatrizMath aux = new MatrizMath(this.filas,this.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			
			for (int c = 0; c < this.columnas; c++) {
				aux.matriz[f][c] = this.matriz[f][c] - mat.matriz[f][c];
			}
		}
		return aux;
	}

	public MatrizMath multiplicar(MatrizMath mat) throws DistDimException{
		if(this.filas != mat.columnas || this.columnas != mat.filas){
			throw new DistDimException("Distintas dimensiones");
		}
		
		MatrizMath aux = new MatrizMath(this.filas,mat.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			for (int c = 0; c < mat.columnas; c++) {
				for (int i = 0; i < this.columnas; i++) {
					aux.matriz[f][c] += this.matriz[f][i] * mat.matriz[i][c];
				}
			}
		}
		return aux;
	}
	
	public MatrizMath multiplicar(float flotante) throws DistDimException{
		
		MatrizMath aux = new MatrizMath(this.filas,this.columnas);
		
		for (int f = 0; f < this.filas; f++) {
			
			for (int c = 0; c < this.columnas; c++) {
				aux.matriz[f][c] = this.matriz[f][c] * flotante;
			}
		}
		return aux;
	}

	public double getDeterminante(){
		if(this.filas != this.columnas){
			throw new DistDimException("Debe ser una matriz cuadrada");
		}
		
		double determinante = 0;
		
		// TODO desarrollo del calculo del determinante
		
		return determinante;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columnas;
		result = prime * result + filas;
		result = prime * result + Arrays.hashCode(matriz);
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
		MatrizMath other = (MatrizMath) obj;
		if (columnas != other.columnas)
			return false;
		if (filas != other.filas)
			return false;
		if (!Arrays.deepEquals(matriz, other.matriz))
			return false;
		for (int f = 0; f < this.filas; f++) {
			for (int c = 0; c < this.columnas; c++) {
				double diff = this.matriz[f][c] = other.matriz[f][c];
				if (Math.abs(diff) >= Math.pow(10, -12))
					return false;
			}
		}
		return true;
	}
	
	
}
