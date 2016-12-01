package br.com.estoque.ws;

import javax.xml.ws.Endpoint;

// Publica o serviço para que o cliente consiga conectar
public class PublicaEstoqueWS {
	public static void main(String[] args) {
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("EstoqueWS rodando: " + URL);

		Endpoint.publish(URL, implementacaoWS);
	}
}
