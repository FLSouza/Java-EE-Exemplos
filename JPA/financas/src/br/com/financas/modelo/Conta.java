package br.com.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Define a entidade
@Entity
public class Conta {

	// Annotations utilizadas para identificação da chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String banco;
	private String titular;
	private String agencia;
	private String numero;
	
	// Uma conta possui várias movimentações.
	// 'mappedBy' indica que essa relação é a mesma representada pelo atributo conta
	// na classe Movimentacao. Dessa maneira, não será criada um nova tabela.
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
