package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

// Consultas feitas com JPQL(Java Persistence Query Language)
// É uma linguagem de consulta, assim como o SQL, porém orientada a objetos
public class TestaConsulta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		// Named Parameter Notation - Método utilizado
		// O resultado da pesquisa é ordenado de forma decrescente
		Query query = manager.
				createQuery("select m from Movimentacao m where m.conta= :pConta "
				+ " and m.tipoMovimentacao = :pTipo" 
				+ " order by m.valor desc");
		
		// Usamos 'Named Parameter Notation', damos nomes aos parâmetros da query
		// Facilita a identificação dos parâmetros, diminuindo a probabilidade de cometer erros
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao ..: " + m.getDescricao());
			System.out.println("Valor ......: R$ " + m.getValor());
		}
	}
}
