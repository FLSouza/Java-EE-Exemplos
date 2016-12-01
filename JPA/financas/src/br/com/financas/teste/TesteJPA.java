package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteJPA {
	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta();
		conta.setAgencia("132");
		conta.setBanco("Bradesco");
		conta.setNumero("12435");
		conta.setTitular("André Mantovani");

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();

		manager.close();

		double fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");
	}
}
