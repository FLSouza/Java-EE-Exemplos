package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteEstadosJPA {
	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		// Testes do capitulo
		Conta conta = manager.find(Conta.class, 5);
		conta.setTitular("Pedro Ferreira");
		manager.getTransaction().commit();

		manager.close();
		System.out.println(conta.getTitular());

	}
}
