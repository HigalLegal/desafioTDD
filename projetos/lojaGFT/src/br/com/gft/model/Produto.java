package br.com.gft.model;

import java.math.BigDecimal;

public class Produto {
	
	private String nome;
	private BigDecimal preco;
	private int quantidade;
	
	// -------------------------------
	
	public Produto() {}

	public Produto(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = BigDecimal.valueOf(preco);
		this.quantidade = quantidade;
	}
	
	// -------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = BigDecimal.valueOf(preco);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
