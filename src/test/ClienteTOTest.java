package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import to.ClienteTO;

public class ClienteTOTest {
	ClienteTO to;
	@Before
	public void setUp() throws Exception {
		to = new ClienteTO("12345", "12 34 56 78", false, false, 1, "Eric Vinicius", 1L);
	}

	@Test
	public void testGets() {
		assertEquals(to.getSenha(), "12345");
		assertEquals(to.getCodigoDeAcesso(), "12 34 56 78");
		assertFalse(to.isAdmin());
		assertFalse(to.isNovoCodigoDeAcesso());
		assertEquals(to.getStatus(), 1);
		assertEquals(to.getNome(), "Eric Vinicius");
	}
	
	@Test
	public void testEquals(){
		ClienteTO copia = new ClienteTO("12345", "12 34 56 78", false, false, 1, "Eric Vinicius", 1L);
		assertEquals("teste to igual a copia", to, copia);
	}

}
