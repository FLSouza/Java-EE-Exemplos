package br.com.estoque.ws;

import java.util.Date;

import javax.xml.ws.WebFault;

// Exception criada para tratar exceções adequadamente no xml do soap.
@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String msg) {
		super(msg);
	}

	public InfoFault getFaultInfo() {
		return new InfoFault("Token invalido", new Date());
	}
}
