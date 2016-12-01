package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta();
		conta.setAgencia("111");
		conta.setBanco("Itau");
		conta.setNumero("54321");
		conta.setTitular("Ana Maria");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));
		movimentacao.setConta(conta);

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		manager.persist(conta);
		manager.persist(movimentacao);
		manager.getTransaction().commit();

		manager.close();

		double fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");
	}
}
