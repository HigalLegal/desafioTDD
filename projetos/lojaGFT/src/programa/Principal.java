package programa;

import br.com.gft.model.Livro;
import br.com.gft.model.Loja;
import br.com.gft.model.VideoGame;

public class Principal {

	public static void main(String[] args) {
		
		Livro l1 = new Livro("Harry Potter", 40, 50, "J. K. Rowling", "fantasia", 300);
		Livro l2 = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		Livro l3 = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);
		
		VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
		VideoGame xbox = new VideoGame("XBOX", 1500, 500, "Microsoft", "One", false);
		
		Loja americanas = new Loja("Americanas", "12345678");
		
		americanas.adicionarLivro(l1);
		americanas.adicionarLivro(l2);
		americanas.adicionarLivro(l3);
		
		americanas.adicionarVideoGame(ps4);
		americanas.adicionarVideoGame(ps4Usado);
		americanas.adicionarVideoGame(xbox);
		
		l2.calcularImposto();
		l3.calcularImposto();

		ps4Usado.calcularImposto();
		ps4.calcularImposto();
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		americanas.listaLivros();
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		americanas.listaVideoGames();
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		System.out.println("Patrimônio da loja " + americanas.getNome() + ": R$" + americanas.patrimonio());
		

	}

}
