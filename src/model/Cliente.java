package model;

import to.ClienteTO;
import dao.ClienteDAO;

public class Cliente {

	private boolean admin;
	private int status;
	private Long id;
	private String nome;
	private String senha;
	private String codigoDeAcesso;
	private boolean novoCodigoDeAcesso = false;
	private Long contaId;

	public Cliente() {
	}

	public Cliente(String senha2, String codigoDeAcesso2, boolean novoCodigoDeAcesso2, boolean admin2, int status2, String nome2, Long contaId) {
		setSenha(senha2);
		setNome(nome2);
		setCodigoDeAcesso(codigoDeAcesso2);
		setAdmin(admin2);
		setStatus(status2);
		setContaId(contaId);
	}

	public Cliente(Long id) {
		setId(id);
	}

	public void criar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = new ClienteTO();
		to.setId(id);
		to.setNome(nome);
		to.setSenha(senha);
		to.setCodigoDeAcesso(codigoDeAcesso);
		to.setNovoCodigoDeAcesso(novoCodigoDeAcesso);
		to.setContaId(contaId);
		to.setAdmin(admin);
		to.setStatus(status);
		dao.incluir(to);
		id = to.getId();
	}

	public void atualizar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = new ClienteTO();
		to.setId(id);
		to.setNome(nome);
		to.setSenha(senha);
		to.setCodigoDeAcesso(codigoDeAcesso);
		to.setNovoCodigoDeAcesso(novoCodigoDeAcesso);
		to.setContaId(contaId);
		to.setAdmin(admin);
		to.setStatus(status);
		dao.atualizar(to);
	}

	public void excluir() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = new ClienteTO();
		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = dao.carregar(id);
		id = to.getId();
		nome = to.getNome();
		senha = to.getSenha();
		codigoDeAcesso = to.getCodigoDeAcesso();
		novoCodigoDeAcesso = to.isNovoCodigoDeAcesso();
		contaId = to.getContaId();
		admin = to.isAdmin();
		status = to.getStatus();
	}

	public Long getId() {
		return id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setId(Long id) {
		if (id != null && id >= 0) {
			this.id = id;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoDeAcesso() {
		return codigoDeAcesso;
	}

	public void setCodigoDeAcesso(String codigoDeAcesso) {
		this.codigoDeAcesso = codigoDeAcesso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isNovoCodigoDeAcesso() {
		return novoCodigoDeAcesso;
	}

	public void setNovoCodigoDeAcesso(boolean novoCodigoDeAcesso) {
		this.novoCodigoDeAcesso = novoCodigoDeAcesso;
	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	@Override
	public String toString() {
		return "Cliente [admin=" + admin + ", status=" + status + ", id=" + id + ", nome=" + nome
				+ ", senha=" + senha + ", codigoDeAcesso=" + codigoDeAcesso
				+ ", novoCodigoDeAcesso=" + novoCodigoDeAcesso + ", contaId=" + contaId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (admin != other.admin)
			return false;
		if (codigoDeAcesso == null) {
			if (other.codigoDeAcesso != null)
				return false;
		} else if (!codigoDeAcesso.equals(other.codigoDeAcesso))
			return false;
		if (contaId == null) {
			if (other.contaId != null)
				return false;
		} else if (!contaId.equals(other.contaId))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (novoCodigoDeAcesso != other.novoCodigoDeAcesso)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (status != other.status)
			return false;
		return true;
	}


}
