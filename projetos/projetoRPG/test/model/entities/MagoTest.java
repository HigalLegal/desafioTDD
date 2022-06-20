package model.entities;

import static model.factories.PersonagemFactory.personagemFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MagoTest {

	private Personagem mago;

	// ------------------------------------------------------------------------

	@BeforeEach
	public void setup() {
		mago = personagemFactory('M', "Kaik", 5, 8, 11, 9, 4, 5);
	}
	
	// ------------------------------------------------------------------------
	
	@Test
	public void criandoObjetoMago() {
		var mago = personagemFactory('M', "Kaik", 5, 8, 11, 9, 4, 5);
	}
	
	@Test
	public void testarLevelUp() {
		mago.levelUp();
		
		assertEquals(personagemFactory('M', "Kaik", 5+2, 8+5, 11, 9+5, 4+2, 5), mago);
		
	}
	
	@Test
	public void testarAtaque() {
		int valorMaior = (mago.getForca() * mago.getLevel()) + 300;
		
		int esperado = 9 * 5 + 1;
		
		assertEquals(esperado, mago.attack(), valorMaior);
		
	}
	
}
