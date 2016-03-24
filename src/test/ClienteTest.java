package test;

import static org.junit.Assert.assertEquals;
import model.Cliente;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {
	Cliente cliente, copia;

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("12345", "12 34 56 78", false, false, 1, "Eric Vinicius", 1L);
		copia = new Cliente("12345", "12 34 56 78", false, false, 1, "Eric Vinicius", 1L);
		cliente.criar();
	}
	
	@Test
	public void test00Carregar() {
		Cliente novo = new Cliente(cliente.getId());
		novo.carregar();
		assertEquals("testa carregar", cliente, novo);
	}

	@Test
	public void test01Criar() {
		cliente.criar();
		cliente.carregar();
		assertEquals("testa criacao", cliente, copia);
	}

	@Test
	public void test02Atualizar() {
		cliente.setSenha("999999");
		copia.setSenha("999999");		
		cliente.atualizar();
		assertEquals("testa atualizar", cliente, copia);
	}

	@Test
	public void test03Excluir() {
		cliente.setAdmin(false);
		cliente.setCodigoDeAcesso(null);
		cliente.setContaId(null);
		cliente.setNome(null);
		cliente.setNovoCodigoDeAcesso(false);
		cliente.setSenha(null);
		cliente.setStatus(0);
		copia.setAdmin(false);
		copia.setCodigoDeAcesso(null);
		copia.setContaId(null);
		copia.setNome(null);
		copia.setNovoCodigoDeAcesso(false);
		copia.setSenha(null);
		copia.setStatus(0);
		cliente.excluir();
		assertEquals("testa excluir", cliente, copia);
	}
}