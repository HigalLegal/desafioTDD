package entities;

import java.math.BigDecimal;

public class Supervisor extends Funcionario {

	private final BigDecimal VALOR_BONIFICACAO = new BigDecimal("5000");

	public Supervisor() {
	}

	public Supervisor(String nome, Integer idade, Double salario) {
		super(nome, idade, salario);
	}

	// --------------------------------------

	@Override
	public BigDecimal bonificacao() {

		return this.getSalario().add(VALOR_BONIFICACAO);

	}


}
