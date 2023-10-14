package com.primeiroCrud.teste;

import java.util.Calendar;

import com.primeiroCrud.bean.Colaborador;
import com.primeiroCrud.dao.ColaboradorDAO;

public class TesteCadastro {

	public static void main(String[] args) {
		
		ColaboradorDAO dao = new ColaboradorDAO();

		Colaborador colaborador = new Colaborador();
		colaborador.setNome("João Filho");
		colaborador.setEmail("joaofilhomil@gmail.com.br");
		colaborador.setSalario(5000);
		colaborador.setDataContratacao(Calendar.getInstance());

		dao.cadastrar(colaborador);

		System.out.println("Cadastrado!");
	}

}
