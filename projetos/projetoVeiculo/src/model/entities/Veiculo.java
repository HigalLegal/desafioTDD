package model.entities;

import model.exceptions.CombustivelException;
import model.exceptions.VelocidadeException;

public class Veiculo {

	private String marca;
	private String modelo;
	private String cor;
	private float quilometros;
	private boolean isLigado;
	private int litrosCombustivel;
	private int velocidade;
	private Double preco;

	// -------------------------------------------

	public Veiculo() {
	}

	public Veiculo(String marca, String modelo, String cor, float quilometros, boolean isLigado, int litrosCombustivel,
			int velocidade, Double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor.toUpperCase();
		this.quilometros = quilometros;
		this.isLigado = isLigado;
		this.litrosCombustivel = litrosCombustivel;
		this.velocidade = velocidade;
		this.preco = preco;
	}

	// -------------------------------------------

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public float getQuilometros() {
		return quilometros;
	}

	public void setQuilometros(float quilometros) {
		this.quilometros = quilometros;
	}

	public boolean getIsLigado() {
		return isLigado;
	}

	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}

	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	// -------------------------------------------

	public void acelerar() {
		
		if(!isLigado) {
			throw new VelocidadeException("Veículo desligado.");
		}
		
		velocidade += 20;
	}

	public void abastecer(int combustivel) {

		if (combustivel + litrosCombustivel > 60) {
			throw new CombustivelException("Não permitido colocar mais de 60 litros.");
		}

		litrosCombustivel += combustivel;
	}

	public void frear() {

		if (velocidade <= 0) {
			throw new VelocidadeException("Veículo parado.");
		}

		velocidade -= 20;

		if (velocidade < 0) {
			velocidade = 0;
		}
	}

	public void pintar(String cor) {
		this.cor = cor.toUpperCase();
	}

	public void ligar() {
		if (!isLigado) {
			isLigado = true;
		}
	}

	public void desligar() {

		if (velocidade > 0) {
			throw new VelocidadeException("Veículo em movimento.");
		}

		if (isLigado) {
			isLigado = false;
		}
	}

	// -------------------------------------------

	@Override
	public String toString() {
		return "Marca: " + marca + " || Modelo: " + modelo + " || Km rodados:" + quilometros + " Preço: R$"
				+ String.format("%.2f", preco);
	}

}
