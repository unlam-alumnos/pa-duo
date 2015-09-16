package test;

import org.junit.Assert;
import model.Rango;

import org.junit.Test;

public class RangoTest {
	
	@Test
	public void numeroIncluidoEnElRango(){
		Rango rango = new Rango(2,5);
		
		Assert.assertTrue(rango.contiene(2));
		Assert.assertTrue(rango.contiene(3));
		Assert.assertTrue(rango.contiene(4));
		Assert.assertTrue(rango.contiene(5));
		Assert.assertFalse(rango.contiene(6));
		Assert.assertFalse(rango.contiene(1));
	}
}
