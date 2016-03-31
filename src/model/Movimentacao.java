package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import to.ContaTO;
import to.MovimentacaoTO;
import dao.MovimentacaoDAO;

public class Movimentacao {

	private Integer id;
	private ContaTO fromConta;
	private TipoOperacao tipoOperacao;
	private String descricao;
	private BigDecimal valor;
	private TipoMovimentacao tipoMovimentacao;
	private ContaTO toConta;
	private LocalDateTime date;
	private MovimentacaoDAO dao;
	
	public Movimentacao() {
	}
	
	public Movimentacao(MovimentacaoTO mTO) {
		colocaAtributos(mTO);
	}

	private void colocaAtributos(MovimentacaoTO mTO) {
		this.id = mTO.getId();
		this.fromConta = mTO.getFromConta();
		this.tipoMovimentacao = mTO.getTipoMovimentacao();
		this.descricao = mTO.getDescricao();
		this.tipoOperacao = mTO.getTipoOperacao();
		this.date = mTO.getDate();
	}

	public Integer getId() {
		return id;
	}

	public ContaTO getFromConta() {
		return fromConta;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public ContaTO getToConta() {
		return toConta;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Movimentacao setId(Integer id) {
		this.id = id;
		return this;
	}

	public Movimentacao setFromConta(ContaTO fromConta) {
		this.fromConta = fromConta;
		return this;
	}

	public Movimentacao setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		return this;
	}

	public Movimentacao setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Movimentacao setValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public Movimentacao setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
		return this;
	}

	public Movimentacao setToConta(ContaTO toConta) {
		this.toConta = toConta;
		return this;
	}
	
	public Movimentacao setDate(LocalDateTime date) {
		this.date = date;
		return this;
	}
	
	public void salva() {
		MovimentacaoTO mTO = new MovimentacaoTO(this);
		dao.salva(mTO);
		this.id = mTO.getId();
	}
	
	public List<MovimentacaoTO> getMovimentacoes(ContaTO cTO) {
		return dao.getMovimentacoes(cTO);
	}
}
