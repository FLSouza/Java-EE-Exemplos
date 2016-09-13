package br.com.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria.interceptador.LogInterceptador;
import br.com.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) // Opcional
//@Interceptors({ LogInterceptador.class })
public class AutorDao {

	// @Inject
	// UserTransaction tx;

	@PersistenceContext
	private EntityManager manager;
	// @Inject
	// private Banco banco;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Autor autor) {
		// System.out.println("Começou a salvar!");
		// banco.save(autor);
		// try {
		// tx.begin();
		manager.persist(autor);
		// throw new RuntimeException("Serviço externo deu erro!");
		// tx.commit();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// try {
		// Thread.sleep(20000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("Terminou de salvar!");
	}

	public List<Autor> todosAutores() {
		// return banco.listaAutores();
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		// Autor autor = this.banco.buscaPelaId(autorId);
		Autor autor = manager.find(Autor.class, autorId);
		return autor;
	}

	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

}
