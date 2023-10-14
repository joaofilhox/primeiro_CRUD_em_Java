package com.primeiroCrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


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
	  
	  public List<Colaborador> listar() {
		  //Cria uma lista de colaboradores
		  List<Colaborador> lista = new ArrayList<Colaborador>();
		  PreparedStatement stmt = null;
		  ResultSet rs = null;
		  try {
		    connection = ConexaoSql.obterConexao();
		    stmt = connection.prepareStatement("SELECT * FROM TABELA_COLABORADOR");
		    rs = stmt.executeQuery();

		    //Percorre todos os registros encontrados
		    while (rs.next()) {
		      int codigo = rs.getInt(1);
		      String nome = rs.getString("NOME");
		      String email = rs.getString("EMAIL");
		      double salario = rs.getDouble("SALARIO");
		      java.sql.Date data = rs.getDate("DATA_CONTRATACAO");
		      Calendar dataContratacao = Calendar.getInstance();
		      dataContratacao.setTimeInMillis(data.getTime());
		      //Cria um objeto Colaborador com as informações encontradas
		      Colaborador colaborador = new Colaborador(codigo, nome, email, salario, dataContratacao);
		      //Adiciona o colaborador na lista
		      lista.add(colaborador);
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }finally {
		    try {
		      stmt.close();
		      rs.close();
		      connection.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
		  return lista;
		}
	  
	  public void remover(int codigo){
		  PreparedStatement stmt = null;

		  try {
		    connection = ConexaoSql.obterConexao();
		    String sql = "DELETE FROM TABELA_COLABORADOR WHERE CODIGO_COLABORADOR = ?";
		    stmt = connection.prepareStatement(sql);
		    stmt.setInt(1, codigo);
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
	  
	  public Colaborador buscarPorId(int codigoBusca) {
		    Colaborador colaborador = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;

		    try {
		        connection = ConexaoSql.obterConexao();
		        String sql = "SELECT * FROM TABELA_COLABORADOR WHERE CODIGO_COLABORADOR = ?";
		        stmt = connection.prepareStatement(sql);
		        stmt.setInt(1, codigoBusca);
		        rs = stmt.executeQuery();

		        if (rs.next()) {
		            int codigo = rs.getInt("CODIGO_COLABORADOR");
		            String nome = rs.getString("NOME");
		            String email = rs.getString("EMAIL");
		            double salario = rs.getDouble("SALARIO");
		            java.sql.Date data = rs.getDate("DATA_CONTRATACAO");
		            Calendar dataContratacao = Calendar.getInstance();
		            dataContratacao.setTimeInMillis(data.getTime());
		            colaborador = new Colaborador(codigo, nome, email, salario, dataContratacao);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null) {
		                rs.close();
		            }
		            if (stmt != null) {
		                stmt.close();
		            }
		            if (connection != null) {
		                connection.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return colaborador;
		}


public void atualizar(Colaborador colaborador){
	  PreparedStatement stmt = null;

	  try {
	    connection = ConexaoSql.obterConexao();
	    String sql = "UPDATE TABELA_COLABORADOR SET NOME = ?, EMAIL = ?, SALARIO = ?, DATA_CONTRATACAO = ? WHERE CODIGO_COLABORADOR = ?";
	    stmt = connection.prepareStatement(sql);
	    stmt.setString(1, colaborador.getNome());
	    stmt.setString(2, colaborador.getEmail());
	    stmt.setDouble(3, colaborador.getSalario());
	    java.sql.Date data = new java.sql.Date(colaborador.getDataContratacao().getTimeInMillis());
	    stmt.setDate(4, data);
	    stmt.setInt(5, colaborador.getCodigo());

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