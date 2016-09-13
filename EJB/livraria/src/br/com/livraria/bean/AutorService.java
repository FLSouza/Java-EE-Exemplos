package br.com.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.livraria.dao.AutorDao;
import br.com.livraria.dao.LivrariaException;
import br.com.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	AutorDao dao;

	public void adiciona(Autor autor) throws LivrariaException {
		this.dao.salva(autor);
//		throw new LivrariaException();
	}

	public List<Autor> todosAutores() {
		return this.dao.todosAutores();
	}
}
