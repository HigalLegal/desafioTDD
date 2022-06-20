package model.entities;

import java.util.Random;

public class Guerreiro extends Personagem {
	
	private final static int AUMENTO_MENOR = 2;
	private final static int AUMENTO_MAIOR = 5;
	
	private final static Random NUMERO_RANDOMICO = new Random();
	
	// ------------------------------------------------------------------
	
	public Guerreiro() {
	}

	public Guerreiro(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
	}
	
	// ------------------------------------------------------------------

	@Override
	public void levelUp() {
		this.setInteligencia(this.getInteligencia() + AUMENTO_MENOR);
		this.setMana(this.getMana() + AUMENTO_MENOR);
		
		this.setForca(this.getForca() + AUMENTO_MAIOR);
		this.setVida(this.getVida() + AUMENTO_MAIOR);
	}

	@Override
	public int attack() {
		return (this.getForca() * this.getLevel()) + NUMERO_RANDOMICO.nextInt(300);
	}

}
