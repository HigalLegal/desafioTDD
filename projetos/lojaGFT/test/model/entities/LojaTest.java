package model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.utils.LojaBuilder;

public class LojaTest {

	private LojaBuilder lojaBuilder;

	// ----------------------------------------------------

	@BeforeEach
	public void setup() {
		lojaBuilder = new LojaBuilder();
	}

	// ----------------------------------------------------

	@Test
	public void testarListagemDeLivros() {
		int numeroDeLivros = lojaBuilder.getLoja().getLivros().size();

		assertEquals(2, numeroDeLivros);
	}

	@Test
	public void testarListagemDeVideoGames() {
		int numeroDeVideoGames = lojaBuilder.getLoja().getVideoGames().size();

		assertEquals(2, numeroDeVideoGames);
	}

	@Test
	public void testarPatrimonioDaLoja() {
		assertEquals(329825, lojaBuilder.getLoja().patrimonio().doubleValue());
	}

}
