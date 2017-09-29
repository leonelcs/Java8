package test.examples;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import main.examples.ConversorDeNumeroRomano;

public class TDDTest {

	@Test
	public void deveEntenderOSimboloI() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("I");
		assertThat(numero, is(1));
	}
	
	@Test
	public void deveEntenderOSimboloII() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("II");
		assertThat(numero, is(2));
	}
	
	@Test
	public void deveEntenderOSimboloIII() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("III");
		assertThat(numero, is(3));
	}
	
	@Test
	public void deveEntenderOSimboloIV() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("IV");
		assertThat(numero, is(4));
	}
	
	@Test
	public void deveEntenderOSimboloV() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("V");
		assertThat(numero, is(5));
	}
	
	@Test
	public void deveEntenderOSimboloIX() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("IX");
		assertThat(numero, is(9));
	}
	
	@Test
	public void deveEntenderOSimboloXCIV() {
		ConversorDeNumeroRomano romano = new ConversorDeNumeroRomano();
		int numero = romano.converte("XCIV");
		assertThat(numero, is(94));
	}

}
