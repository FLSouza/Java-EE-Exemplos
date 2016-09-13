package br.com.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.livraria.dao.LivroDao;
import br.com.livraria.modelo.Livro;

@WebService
@Stateless
public class LivrariaWS {

	@Inject
	LivroDao dao;

	@WebResult(name = "livros")
	public List<Livro> getLivrosPeloNome(@WebParam(name = "titulo") String nome) {

		System.out.println("LivrariaWS: procurando pelo nome " + nome);

		// aqui usaremos o DAO para executar a pesquisa

		return dao.livrosPeloNome(nome);
	}
}
