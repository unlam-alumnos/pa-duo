package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Clase Procesador encargada de leer el archivo, resolver el ejercicio y escribir la salida.
 * 
 * @author Gonzalo Martin & Cristian Miranda
 */
public class Procesador {
	
	private String texto;
	private String prueba;
	private int combinaciones;
	
	public Procesador(File entrada){
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(entrada);
			br = new BufferedReader(fr);
			
			texto = br.readLine();
			prueba = br.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * Contructor solamente utilzado para los test unitarios
	 * @param texto
	 * @param prueba
	 */
	public Procesador(String texto, String prueba) {
		this.texto = texto;
		this.prueba = prueba;
	}

	/**
	 * Calcula la cantidad de combinaciones requeridas para pasar de 'prueba' a 'texto'.
	 * 
	 * @author Gonzalo Martin & Cristian Miranda
	 */
	public void procesar() {
		combinaciones = 0;
		
		StringBuffer buff = new StringBuffer();
		// Por cada caracter de la cadena correcta (texto)
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			buff.append(caracter);
			// La cantidad de permutaciones está dada por la posición del caracter en la cadena de prueba,
			// ya que se lo mueve al inicio de la misma.
			combinaciones += prueba.indexOf(caracter);
			// Rearmo la cadena 'prueba' con el caracter en la posición que le corresponde			
			prueba = prueba.replaceFirst(String.valueOf(caracter), "");
			// Si la cadena de prueba es correcta, dejo de analizar.
			String correcto = buff.toString() + prueba;
			if (correcto.equals(texto)) {
				break;
			}
		}
	}
	
	public void escribirResultado(File salida){
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);
			
			pw.println(combinaciones);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int getCombinaciones() {
		return combinaciones;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}
}
