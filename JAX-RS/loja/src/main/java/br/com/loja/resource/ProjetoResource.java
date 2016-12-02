package br.com.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thoughtworks.xstream.XStream;

import br.com.loja.dao.ProjetoDAO;
import br.com.loja.modelo.Projeto;

// Disponibiliza o recurso para ser acessado pelo path: http://localhost:8080/projetos
@Path("projetos")
public class ProjetoResource {

	// Devolve no formato Xml
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") long id) {
		Projeto projeto = new ProjetoDAO().busca(id);
		return projeto.toXML();
	}
	
	// Devolve no formato Json
//	@Path("{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String busca(@PathParam("id") long id) {
//		Projeto projeto = new ProjetoDAO().busca(id);
//		return projeto.toJson();
//	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String adiciona(String conteudo) {
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		new ProjetoDAO().adiciona(projeto);
		return "<status>sucesso</status>";
	}

}
