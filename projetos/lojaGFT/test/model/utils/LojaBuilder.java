package model.utils;

import br.com.gft.model.Livro;
import br.com.gft.model.Loja;
import br.com.gft.model.VideoGame;

public class LojaBuilder {
	
	private Loja loja;
	
	// -----------------------------------------------------------------
	
	public LojaBuilder() {
		loja = new Loja("Magazine Luiza", "12345678");
		
		loja.adicionarLivro(new Livro("Attack On Titan", 60, 30, "Isayama", "fantasia", 500));
		loja.adicionarLivro(new Livro("Java TDD", 20.50, 50, "GFT", "educativo", 500));
		loja.adicionarVideoGame(new VideoGame("Play 5", 3200, 100, "Sony", "Digital", false));
		loja.adicionarVideoGame(new VideoGame("PS4", 1000, 7, "Sony", "Slim", true));
	}
	
	// -----------------------------------------------------------------
	
	public Loja getLoja() {
		return loja;
	}
	
}
