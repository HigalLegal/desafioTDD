package model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.utils.ProdutoBuilder;

public class ProdutoTest {
	
	private ProdutoBuilder produtoBuilder;
	
	// ----------------------------------------------------------------------
	
	@BeforeEach
	public void setup() {
		produtoBuilder = new ProdutoBuilder();
	}
	
	// ----------------------------------------------------------------------
	
	@Test
	public void calcularImpostoLivro() {
		assertEquals(6, produtoBuilder.getLivro().calcularImposto().doubleValue());
	}
	
	@Test
	public void calcularImpostoLivroEducativo() {
		assertEquals(0, produtoBuilder.getLivroEducativo().calcularImposto().doubleValue());
	}
	
	@Test
	public void calcularImpostoVideoGame() {
		assertEquals(1440, produtoBuilder.getPlay5().calcularImposto().doubleValue());
	}
	
	@Test
	public void calcularImpostoVideoGameUsado() {
		assertEquals(250, produtoBuilder.getPlay4Usado().calcularImposto().doubleValue());
	}
	
}
