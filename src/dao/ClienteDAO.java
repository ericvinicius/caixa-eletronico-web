package dao;

import java.sql.SQLException;

import to.ClienteTO;

public class ClienteDAO extends MyDao {

	public void incluir(ClienteTO to) {
		String sqlInsert = "INSERT INTO cliente(nome, senha, status, codigoDeAcesso, admin, contaId) VALUES (?, ?, ?, ?, ?, ?)";
		criaConexao();
		prepareStatement(sqlInsert);
		boolean naoEnviaId = false;
		colocaAtributosDoClienteNoResultSet(to, naoEnviaId);
		execute();
		carregaId(to);
		fechaConexao();
	}

	public void carregaId(ClienteTO to) {
		String sqlGetId = "select * from Cliente where id = last_insert_id()";
		prepareStatement(sqlGetId);
		executeQuery();
		try {
			if(rs.next()){
				carregaUsuario(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void colocaAtributosDoClienteNoResultSet(ClienteTO to, boolean setId){
		try {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getSenha());
			stm.setInt(3, to.getStatus());
			stm.setString(4, to.getCodigoDeAcesso());
			stm.setBoolean(5, to.isAdmin());
			stm.setLong(6, to.getContaId());

			if(setId){
				stm.setLong(7, to.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao colocar atributos no usuario");
		}
	}

	public void atualizar(ClienteTO to) {
		String sqlUpdate = "UPDATE cliente SET nome=?, senha=?, status=?, codigoDeAcesso=?, admin=?, contaId=? WHERE id=?";
		criaConexao();
		prepareStatement(sqlUpdate);
		boolean enviaId = true;
		colocaAtributosDoClienteNoResultSet(to, enviaId);
		execute();
		fechaConexao();
	}

	public void excluir(ClienteTO to) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		criaConexao();
		prepareStatement(sqlDelete);
		try {
			stm.setLong(1, to.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		execute();
	}

	public ClienteTO carregar(Long id) {
		ClienteTO to = new ClienteTO();
		String sqlSelect = "SELECT * FROM cliente WHERE cliente.id = ?";
		criaConexao();
		prepareStatement(sqlSelect);
		try {
			stm.setLong(1, id);
			executeQuery();
			if (rs.next()) {
				carregaUsuario(to);
			}
		} catch (SQLException e1) {
			e1.getStackTrace();
		}
		return to;
	}

	private void carregaUsuario(ClienteTO to) throws SQLException {
		to.setNome(rs.getString("nome"));
		to.setStatus(rs.getInt("status"));
		to.setCodigoDeAcesso(rs.getString("codigoDeAcesso"));
		to.setSenha(rs.getString("senha"));
		to.setAdmin(rs.getBoolean("admin"));
		to.setContaId(rs.getLong("contaId"));
		to.setId(rs.getLong("id"));
	}
}
