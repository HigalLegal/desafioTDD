package model.entities;

import static model.factories.PersonagemFactory.personagemFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuerreiroTest {

	private Personagem guerreiro;

	// ------------------------------------------------------------------------

	@BeforeEach
	public void setup() {
		guerreiro = personagemFactory('G', "Bode", 7, 4, 10, 2, 8, 3);
	}
	
	// ------------------------------------------------------------------------
	
	@Test
	public void criandoObjetoGuerreiro() {
		var guerreiro = personagemFactory('G', "Bode", 7, 4, 10, 2, 8, 3);
	}
	
	@Test
	public void testarLevelUp() {
		guerreiro.levelUp();
		
		assertEquals(personagemFactory('G', "Bode", 7+5, 4+2, 10, 2+2, 8+5, 3), guerreiro);
		
	}
	
	@Test
	public void testarAtaque() {
		int valorMaior = (guerreiro.getForca() * guerreiro.getLevel()) + 300;
		
		int esperado = 7 * 8 + 1;
		
		assertEquals(esperado, guerreiro.attack(), valorMaior);
		
	}

}
