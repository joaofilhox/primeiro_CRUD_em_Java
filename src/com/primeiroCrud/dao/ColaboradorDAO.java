package com.primeiroCrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.primeiroCrud.bean.Colaborador;
import com.primeiroCrud.conexao.ConexaoSql;

public class ColaboradorDAO {
	  
	  private Connection connection;

	  public void cadastrar(Colaborador colaborador) {
	    PreparedStatement stmt = null;

	    try {
	      connection = ConexaoSql.obterConexao();
	      String sql = "INSERT INTO TABELA_COLABORADOR(NOME, EMAIL, SALARIO, DATA_CONTRATACAO) VALUES (?, ?, ?, ?)";
	      stmt = connection.prepareStatement(sql);
	      stmt.setString(1, colaborador.getNome());
	      stmt.setString(2, colaborador.getEmail());
	      stmt.setDouble(3, colaborador.getSalario());
	      java.sql.Date data = new java.sql.Date(colaborador.getDataContratacao().getTimeInMillis());
	      stmt.setDate(4, data);

	      stmt.executeUpdate();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        stmt.close();
	        connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	}