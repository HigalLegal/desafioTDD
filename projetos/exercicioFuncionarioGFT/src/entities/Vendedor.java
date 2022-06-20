package entities;

import java.math.BigDecimal;

public class Vendedor extends Funcionario {
	
	private final BigDecimal VALOR_BONIFICACAO = new BigDecimal("3000");
	
	public Vendedor() {
	}

	public Vendedor(String nome, Integer idade, Double salario) {
		super(nome, idade, salario);
	}

	// --------------------------------------

	@Override
	public BigDecimal bonificacao() {

		return this.getSalario().add(VALOR_BONIFICACAO);

	}

}
