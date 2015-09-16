package test;

import org.junit.Assert;
import org.junit.Test;
import edu.unlam.luchadoresjaponeses.model.Luchador;

public class LuchadorTest {

	@Test
	public void gordoAltoDominaFlacoBajo(){
		Luchador gordoAlto = new Luchador(210,150);
		Luchador flaquitoBajo = new Luchador(110,75);
		Assert.assertEquals(1, gordoAlto.domina(flaquitoBajo));
	}
	
	@Test
	public void flacoBajoPierdeConGordoAlto(){
		Luchador gordoAlto = new Luchador(210,150);
		Luchador flaquitoBajo = new Luchador(110,75);
		Assert.assertEquals(-1, flaquitoBajo.domina(gordoAlto));
	}

}