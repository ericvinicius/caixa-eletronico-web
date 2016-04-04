package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.TipoMovimentacao;
import model.TipoOperacao;
import to.ContaTO;
import to.MovimentacaoTO;

public class MovimentacaoDAO extends MyDao {

	public void salva(MovimentacaoTO mTO) {
		criaConexao();
		String SQL = "INSERT INTO movimentacao "
				+ "(fromNumero, tipoOperacao, descricao, valor, tipoMovimentacao, toNumero, date) "
				+ "VALUES (:fromNumero, :tipoOperacao, :descricao, :valor, :tipoMovimentacao, :toNumero, :date);";
		p.prepareNamedParameterStatement(SQL);
		try {
			p.setInt("fromNumero", mTO.getFromConta().getNumero());
			p.setString("tipoOperacao", mTO.getTipoOperacao().toString());
			p.setString("descricao", mTO.getDescricao());
			p.setBigDecimal("valor", mTO.getValor());
			p.setString("tipoMovimentacao", mTO.getTipoMovimentacao().toString());
			p.setInt("toNumero", mTO.getToConta().getNumero());
			p.setTimestamp("date", Timestamp.valueOf(LocalDateTime.now()));
			p.execute();
			
			getId(mTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechaConexao();
	}

	private void getId(MovimentacaoTO mTO) throws SQLException {
		String getId = "SELECT id FROM movimentacao ORDER BY id DESC LIMIT 1;";
		p.prepareNamedParameterStatement(getId);
		rs = p.executeQuery();
		while (rs.next()) {
			mTO.setId(rs.getInt("id"));
		}
	}

	public List<MovimentacaoTO> getMovimentacoes(ContaTO contaTo) {
		criaConexao();
		List<MovimentacaoTO> list = new ArrayList<>();
		String SQL = "SELECT * FROM movimentacao WHERE fromNumero=:numero OR toNumero=:numero;";
		p.prepareNamedParameterStatement(SQL);
		try{
			p.setInt("numero", contaTo.getNumero());
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				TipoOperacao tipoOperacao = TipoOperacao.valueOf(rs.getString("tipoOperacao"));
				TipoMovimentacao tipoMovimentacao = TipoMovimentacao.valueOf(rs.getString("tipoMovimentacao"));
				LocalDateTime data = rs.getTimestamp("date").toLocalDateTime();
				list.add(new MovimentacaoTO(rs.getInt("fromNumero"), tipoOperacao, rs.getString("descricao"), 
						rs.getBigDecimal("valor"), tipoMovimentacao, rs.getInt("toNumero"), data));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
