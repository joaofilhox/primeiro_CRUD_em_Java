package com.primeiroCrud.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoSql {

	public static Connection obterConexao() {
		Connection connection = null;

		try {

			String jdbcUrl = "jdbc:mysql://localhost:3306/TAB_COLABORADOR";
			String user = "root";
			String password = "1milgrau";

			connection = DriverManager.getConnection(jdbcUrl, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
