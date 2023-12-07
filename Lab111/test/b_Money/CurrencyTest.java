package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;

	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}

	@Test
	public void testGetRate() {
		assertEquals(0.15, SEK.getRate(), 0.001);
		assertEquals(0.20, DKK.getRate(), 0.001);
		assertEquals(1.5, EUR.getRate(), 0.001);
	}

	@Test
	public void testSetRate() {
		SEK.setRate(0.2);
		assertEquals(0.2, SEK.getRate(), 0.001);
		SEK.setRate(0.15); // Resetting to original
	}

	@Test
	public void testGlobalValue() {
		assertEquals((Integer)15, SEK.universalValue(100));
		assertEquals((Integer)20, DKK.universalValue(100));
		assertEquals((Integer)150, EUR.universalValue(100));
	}

	@Test
	public void testValueInThisCurrency() {
		assertEquals((Integer)133, SEK.valueInThisCurrency(100, DKK));

		assertEquals((Integer)750, DKK.valueInThisCurrency(100, EUR));
	}
}