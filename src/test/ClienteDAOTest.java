package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import to.ClienteTO;
import dao.ClienteDAO;

public class ClienteDAOTest {
	ClienteDAO dao;
	ClienteTO to;
	
	@Before
	public void setUp() throws Exception {
		dao = new ClienteDAO();
		to = new ClienteTO();
		to.setCodigoDeAcesso("12 34 56 78");
		to.setNome("Mega Man");
		to.setAdmin(false);
		to.setContaId(2L);
		to.setNovoCodigoDeAcesso(false);
		to.setSenha("1234");
		to.setStatus(1);
		dao.incluir(to);
	}
	
	@Test
	public void testCarregar() {
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void testInserir() {
		dao.incluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void testAtualizar() {
		to.setNome("bla");
		dao.atualizar(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa atualizar", novo, to);
	}
	
	@Test
	public void testExcluir() {
		to.setAdmin(false);
		to.setCodigoDeAcesso(null);
		to.setContaId(null);
		to.setNome(null);
		to.setNovoCodigoDeAcesso(false);
		to.setSenha(null);
		to.setStatus(0);
		dao.excluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa excluir", novo, to);
	}
}
