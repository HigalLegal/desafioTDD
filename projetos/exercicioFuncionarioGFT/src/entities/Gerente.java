package entities;

import java.math.BigDecimal;

public class Gerente extends Funcionario {

	private final BigDecimal VALOR_BONIFICACAO = new BigDecimal("10000");

	public Gerente() {
	}

	public Gerente(String nome, Integer idade, Double salario) {
		super(nome, idade, salario);
	}

	// --------------------------------------

	@Override
	public BigDecimal bonificacao() {

		return this.getSalario().add(VALOR_BONIFICACAO);

	}

}
