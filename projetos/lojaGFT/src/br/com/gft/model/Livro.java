package br.com.gft.model;

import java.math.BigDecimal;

import br.com.gft.interfaces.Imposto;

public class Livro extends Produto implements Imposto {
	
	private String autor;
	private String tema;
	private int quantidaDePaginas;
	
	private final BigDecimal VALOR_IMPOSTO = new BigDecimal("0.1");
	
	// -------------------------------
	
	public Livro() {}

	public Livro(String nome, double preco, int quantidade, String autor, String tema, int quantidaDePaginas) {
		super(nome, preco, quantidade);
		this.autor = autor;
		this.tema = tema;
		this.quantidaDePaginas = quantidaDePaginas;
		
	}

	// -------------------------------
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQuantidaDePaginas() {
		return quantidaDePaginas;
	}

	public void setQuantidaDePaginas(int quantidaDePaginas) {
		this.quantidaDePaginas = quantidaDePaginas;
	}
	
	// -------------------------------


	@Override
	public BigDecimal calcularImposto() {
		if(tema == "educativo") {
			System.out.println("Livro educativo não tem imposto: " + this.getNome());
			return new BigDecimal("0");
		}
		
		//double imposto = this.getPreco() * 0.1;
		BigDecimal imposto = this.getPreco().multiply(VALOR_IMPOSTO);
		
		System.out.println("Imposto " + this.getNome() + " , " + imposto);
		
		return imposto;
		
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.getNome() + " , preço: " +  this.getPreco() + " , quantidade: " + this.getQuantidade()
				+ " em estoque.";
	}

}
