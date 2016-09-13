package br.com.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.livraria.dao.LivrariaException;
import br.com.livraria.modelo.Autor;

@Model
public class AutorBean {

	private Autor autor = new Autor();
	// @Inject
	// private AutorDao dao;
	@Inject
	AutorService service;

	public Autor getAutor() {
		return autor;
	}

	public void cadastra() throws LivrariaException {
		// this.dao.salva(autor);
		this.service.adiciona(autor);
		this.autor = new Autor();
	}

	public List<Autor> getAutores() {
		// return this.dao.todosAutores();
		return this.service.todosAutores();
	}
}