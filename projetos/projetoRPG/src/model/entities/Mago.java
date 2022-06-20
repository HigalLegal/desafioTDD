package model.entities;

import java.util.Random;

public class Mago extends Personagem {

	private final static int AUMENTO_MENOR = 2;
	private final static int AUMENTO_MAIOR = 5;

	private final static Random NUMERO_RANDOMICO = new Random();

	// ------------------------------------------------------------------

	public Mago() {
	}

	public Mago(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
	}

	// ------------------------------------------------------------------

	@Override
	public void levelUp() {

		this.setForca(this.getForca() + AUMENTO_MENOR);
		this.setVida(this.getVida() + AUMENTO_MENOR);

		this.setInteligencia(this.getInteligencia() + AUMENTO_MAIOR);
		this.setMana(this.getMana() + AUMENTO_MAIOR);

	}

	@Override
	public int attack() {
		return (this.getInteligencia() * this.getLevel()) + NUMERO_RANDOMICO.nextInt(300);
	}

}
