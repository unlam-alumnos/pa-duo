package edu.unlam.parcial;

import java.io.File;

/**
 * Clase abstracta con metodo resolver() definido.
 * 
 * @author Gonzalo Martin & Cristian Miranda
 */
public abstract class EjercicioOIA {
	protected File entrada;
	protected File salida;
	
	public EjercicioOIA(File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public abstract void resolver();
	
}
