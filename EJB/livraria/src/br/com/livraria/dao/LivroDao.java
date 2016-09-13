package br.com.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	// @Inject
	// private Banco banco;
	@PersistenceContext
	private EntityManager manager;

	public void salva(Livro livro) {
		// banco.save(livro);
		manager.persist(livro);
	}

	public List<Livro> todosLivros() {
		// return banco.listaLivros();

		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> livrosPeloNome(String nome) {

		TypedQuery<Livro> query = this.manager.createQuery("select l from Livro l " + "where l.titulo like :pTitulo",
				Livro.class);
		query.setParameter("pTitulo", "%" + nome + "%");

		return query.getResultList();
	}

}
