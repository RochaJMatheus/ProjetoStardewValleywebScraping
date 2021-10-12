package com.matheus.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public ConnectionFactory() {
	}

	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/stardewvalley?useSSL=false", "root", "1234");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return conn;

	}
}
