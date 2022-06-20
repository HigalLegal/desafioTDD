package model.utils;

import br.com.gft.model.Livro;
import br.com.gft.model.VideoGame;

public class ProdutoBuilder {
	
	private Livro livro;
	private Livro livroEducativo;
	private VideoGame play5;
	private VideoGame play4Usado;
	
	// -----------------------------------------------
	
	public ProdutoBuilder() {
		livro = new Livro("Attack On Titan", 60, 30, "Isayama", "fantasia", 500);
		livroEducativo = new Livro("Java TDD", 20, 50, "GFT", "educativo", 500);
		play5 = new VideoGame("Play 5", 3200, 100, "Sony", "Digital", false);
		play4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
	}
	
	// -----------------------------------------------

	public Livro getLivro() {
		return livro;
	}

	public Livro getLivroEducativo() {
		return livroEducativo;
	}

	public VideoGame getPlay5() {
		return play5;
	}

	public VideoGame getPlay4Usado() {
		return play4Usado;
	}
	
	

}

