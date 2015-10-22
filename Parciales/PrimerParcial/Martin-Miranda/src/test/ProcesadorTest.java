package test;

import model.Procesador;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test unitarios. Cada uno corresponde a los generados en archivos .in y .out excluyendo los de fatiga.
 * 
 * @author Gonzalo Martin & Cristian Miranda
 */
public class ProcesadorTest {
	
	@Test
	public void enunciado() {
		String texto = "Estamos pintando!";
		String prueba = "ostant!Em inpados";
		assertCombinaciones(texto, prueba, 40);	
	}

	@Test
	public void esteDeporte() {
		String texto = "Este deporte";
		String prueba = "estE deporte";
		assertCombinaciones(texto, prueba, 5);	
	}
	
	@Test
	public void unicaPalabra() {
		String texto = "ola";
		String prueba = "oal";
		assertCombinaciones(texto, prueba, 1);	
	}
	
	@Test
	public void correcta() {
		String texto = "Correcta, no debería tener cambios";
		String prueba = "Correcta, no debería tener cambios";
		assertCombinaciones(texto, prueba, 0);	
	}
	
	@Test
	public void signosInveridos() {
		String texto = "¡Hola!, ¿Como estás?";
		String prueba = "!Hola¡, ?Como estás¿";
		assertCombinaciones(texto, prueba, 30);	
	}
	
	@Test
	public void espacioAlInicio() {
		String texto = "Estamos pintando!";
		String prueba = " Estamospintando!";
		assertCombinaciones(texto, prueba, 7);	
	}
	
	/**
	 * Procesa la entrada, devuelve las combinaciones y realiza el assert con el parametro {esperadas}.
	 * 
	 * @author Gonzalo Martin & Cristian Miranda
	 */
	private void assertCombinaciones(String texto, String prueba, int esperadas) {
		Procesador procesador = new Procesador(texto,prueba);
		procesador.procesar();
		int combinaciones = procesador.getCombinaciones();
		Assert.assertEquals(esperadas, combinaciones);
	}
}
