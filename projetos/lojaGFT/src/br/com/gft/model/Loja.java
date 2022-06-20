package br.com.gft.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Loja {

	private String nome;
	private String cnpj;
	private List<Livro> livros = new ArrayList<>();
	private List<VideoGame> videoGames = new ArrayList<>();

	// -------------------------------

	public Loja() {
	}

	public Loja(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	// -------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public List<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}

	public void adicionarVideoGame(VideoGame videoGame) {
		videoGames.add(videoGame);
	}

	// -------------------------------

	public void listaLivros() {

		if (!livros.isEmpty()) {

			System.out.println("A loja " + nome + " possui estes livros para a venda:");
			livros.forEach(System.out::println);
		} else {
			System.out.println("A loja não tem livros no seu estoque.");
		}

	}

	public void listaVideoGames() {

		if (!videoGames.isEmpty()) {

			System.out.println("A loja " + nome + " possui estes video-games para a venda:");
			videoGames.forEach(System.out::println);
		} else {
			System.out.println("A loja não tem video-games no seu estoque.");
		}
	}

	public BigDecimal patrimonio() {

		BigDecimal totalPatrimonio = patrimonioLivros().add(patrimonioVideoGames());

		return totalPatrimonio;
	}

	private BigDecimal patrimonioLivros() {
		
		List<BigDecimal> valoresPorLivro = livros.stream().map(livro -> {
			
			String numeroQuantidade = Integer.toString(livro.getQuantidade());
			
			return livro.getPreco().multiply(new BigDecimal(numeroQuantidade));
		}).collect(Collectors.toList());
		
		BigDecimal somatoriaDosPrecos = valoresPorLivro.stream().reduce(new BigDecimal("0"), (a, b) -> {
			return a.add(b);
		});

		return somatoriaDosPrecos;

	}

	private BigDecimal patrimonioVideoGames() {
		
		List<BigDecimal> valoresPorVideoGame = videoGames.stream().map(videoGame -> {
			
			String numeroQuantidade = Integer.toString(videoGame.getQuantidade());
			
			return videoGame.getPreco().multiply(new BigDecimal(numeroQuantidade));
		}).collect(Collectors.toList());
		
		BigDecimal somatoriaDosPrecos = valoresPorVideoGame.stream().reduce(new BigDecimal("0"), (a, b) -> {
			return a.add(b);
		});

		return somatoriaDosPrecos;

	}

}
