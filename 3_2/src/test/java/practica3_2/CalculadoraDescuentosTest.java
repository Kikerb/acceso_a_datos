package practica3_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraDescuentosTest {
	private CalculadoraDescuentos calculadoraDescuentos;
	
	@BeforeEach
	public void setUP() {
		calculadoraDescuentos = new CalculadoraDescuentos();
	}
	
	@Test
	public void testAplicarDescuento_precioNegativo_seLanzaExcepcion() {
		assertThrows(IllegalArgumentException.class,()-> calculadoraDescuentos.aplicarDescuento(-100, 20));
	}
	@Test
	public void testAplicarDescuento_descuentoNegativo_seLanzaExcepcion() {
		assertThrows(IllegalArgumentException.class,()-> calculadoraDescuentos.aplicarDescuento(100, -20));
	}
	@Test
	public void testAplicarDescuento_descuentomayor100_seLanzaExcepcion() {
		assertThrows(IllegalArgumentException.class,()-> calculadoraDescuentos.aplicarDescuento(100, 120));
	}
	@Test
	public void testAplicarDescuento_20Porcientode100_devuelve80() {
		assertEquals(80, calculadoraDescuentos.aplicarDescuento(100, 20));
	}
	@Test
	public void testAplicarDescuento_100Descuento_devuelve0() {
		assertEquals(0, calculadoraDescuentos.aplicarDescuento(100, 100));
	}
	@Test
	public void testAplicarDescuento_0Descuento_devuelve100() {
		assertEquals(100, calculadoraDescuentos.aplicarDescuento(100, 0));
	}
	@Test
	public void testAplicarDescuento_precioEs0_devuelve0() {
		assertEquals(0, calculadoraDescuentos.aplicarDescuento(0, 100));
	}
}
