package br.com.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.estoque.modelo.item.Item;
import br.com.estoque.modelo.item.ItemDao;
import br.com.estoque.modelo.item.ItemValidador;
import br.com.estoque.modelo.usuario.TokenDao;
import br.com.estoque.modelo.usuario.TokenUsuario;

// Aqui são declarados os serviços que estaram disponíveis no contrato de soap. 
@WebService
public class EstoqueWS {
	private ItemDao dao = new ItemDao();

	// @WebMethod(operationName = "todosOsItens")
	// @WebResult(name = "itens")
	// @ResponseWrapper(localName="itens")
	// public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
	// System.out.println("Chamando getItens()");
	// List<Filtro> lista = filtros.getLista();
	// List<Item> itensResultado = dao.todosItens(lista);
	// return new ListaItens(itensResultado);
	// }

	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "item")
	@ResponseWrapper(localName = "itens")
	@RequestWrapper(localName = "listaItens")
	public List<Item> getItens() {
		System.out.println("Chamando getItens()");

		return dao.todosItens();
	}

	@WebMethod(operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		System.out.println("Cadastrando " + item + ", " + token);

		boolean valido = new TokenDao().ehValido(token);

		if (!valido) {
			throw new AutorizacaoException("Token invalido");
		}

		new ItemValidador(item).validate();

		this.dao.cadastrar(item);
		return item;

	}
}
