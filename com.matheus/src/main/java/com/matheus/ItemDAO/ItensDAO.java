package com.matheus.ItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matheus.entidades.Itens;
import com.matheus.factory.ConnectionFactory;

public class ItensDAO {

	public void inserirItens(String id, String nome) {
		String sql = "INSERT INTO itens (id,nome)VALUES(?,?)";
		PreparedStatement pstatement = null;
		Connection connection = null;

		try {
			connection = new ConnectionFactory().getConnection();
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, id);
			pstatement.setString(2, nome);
			pstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstatement != null) {
					pstatement.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public ArrayList<Itens> listaItens() {
		String sql = "Select * from itens ";
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Itens> itens = null;

		try {
			conn = new ConnectionFactory().getConnection();
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs != null) {
				itens = new ArrayList<Itens>();
				while (rs.next()) {
					Itens item = new Itens();
					item.setCodigoItem(rs.getString("id"));
					item.setNome(rs.getString("nome"));
					itens.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return itens;
	}
	
	public ArrayList<Itens> listaItensNome(String nome) {
		String sql = "Select * from itens WHERE nome LIKE '%"+nome+"%'ORDER BY nome";
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Itens> itens = null;

		try {
			conn = new ConnectionFactory().getConnection();
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs != null) {
				itens = new ArrayList<Itens>();
				while (rs.next()) {
					Itens item = new Itens();
					item.setCodigoItem(rs.getString("id"));
					item.setNome(rs.getString("nome"));
					itens.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return itens;
	}
	

}
