package com.primeiroCrud.teste;

import java.util.List;

import com.primeiroCrud.bean.Colaborador;
import com.primeiroCrud.dao.ColaboradorDAO;


public class TesteListagem {

	public static void main(String[] args) {

		ColaboradorDAO dao = new ColaboradorDAO();
		
		List<Colaborador> lista = dao.listar();
		for (Colaborador item : lista) {
			System.out.println(item.getCodigo() + " " + item.getNome() + " " + item.getEmail() + " " + item.getSalario() + " " + item.getDataContratacao().getTime());
		}
	}
	
}