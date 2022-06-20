package model.factories;

import model.entities.Guerreiro;
import model.entities.Mago;
import model.entities.Personagem;

public final class PersonagemFactory {
	
	//deixando o construtor privado para ninguém instânciar.
	private PersonagemFactory() {}
	
	// ---------------------------------------------------

	public static Personagem personagemFactory(char tipo) {
		
		if (tipo == 'G') {
			return new Guerreiro();
		} else if (tipo == 'M') {
			return new Mago();
		}
		
		return null;
	}

	public static Personagem personagemFactory(char tipo, String nome, int vida, int mana, float xp, int inteligencia,
			int forca, int level) {

		if (tipo == 'G') {
			return new Guerreiro(nome, vida, mana, xp, inteligencia, forca, level);
		} else if (tipo == 'M') {
			return new Mago(nome, vida, mana, xp, inteligencia, forca, level);
		}

		return null;
	}

}
