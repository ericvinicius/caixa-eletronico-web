package test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import model.Movimentacao;
import model.TipoMovimentacao;
import model.TipoOperacao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import to.ContaTO;
import to.MovimentacaoTO;

public class MovimentacaoTest {

	private MovimentacaoTO mTO;
	private Movimentacao movimentacao;

	@Before
	public void setUp() throws Exception {
		mTO = new MovimentacaoTO(new ContaTO(10000), TipoOperacao.ENTRADA, "Movimentacao normal", new BigDecimal("100"), TipoMovimentacao.TRANSFERENCIA, new ContaTO(10001), LocalDateTime.now());
		movimentacao = new Movimentacao(mTO);
		movimentacao.salva();
	}
	
	@Test
	public void testeSalvar(){
		MovimentacaoTO mTO = new MovimentacaoTO(new ContaTO(10000), TipoOperacao.ENTRADA, "Movimentacao normal", new BigDecimal("100"), TipoMovimentacao.TRANSFERENCIA, new ContaTO(10001), LocalDateTime.now());
		Movimentacao mov = new Movimentacao(mTO);
		mov.salva();
		Assert.assertNotNull(mov.getId());
	}

}
