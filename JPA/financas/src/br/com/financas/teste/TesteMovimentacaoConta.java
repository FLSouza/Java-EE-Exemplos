package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		// Usando 'join fetch' o número de consultas ao servidor é reduzido.
		// Diferente 'join lazy', onde o banco é consultado 1 vez para pegar
		// todas as contas e para cada uma das contas é feita mais 1 consulta.

		// 'distinct' é utilizado para não ter valores repeditos na lista de
		// resultados.
		Query query = manager.createQuery("select distinct c from Conta c join fetch c.movimentacoes");

		List<Conta> contas = query.getResultList();

		for (Conta conta : contas) {
			System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
		}

	}
}
