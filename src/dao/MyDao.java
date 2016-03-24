package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class MyDao {

	protected Connection connection = null;
	protected PreparedStatement stm = null;
	protected ResultSet rs = null;

	protected void criaConexao(){
		this.connection = ConnectionFactory.getConnection();
	}

	protected void fechaConexao(){
		try {
			if(rs != null ){
				rs.close();
			}
			if(stm != null){
				stm.close();
			}
			if(connection != null){
				connection.close();
			}
		} catch (SQLException se) {
			throw new RuntimeException(se);
		}
	}

	protected void prepareStatement(String sql) {
		try {
			stm = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void executeQuery() {
		try {
			rs = stm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		try {
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
