package entities;

import java.math.BigDecimal;

public class Funcionario {

	private String nome;
	private Integer idade;
	private BigDecimal salario;

	// --------------------------------------

	public Funcionario() {
	}

	public Funcionario(String nome, Integer idade, Double salario) {

		this.nome = nome;
		this.idade = idade;
		this.salario = BigDecimal.valueOf(salario);
	}

	// --------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	// --------------------------------------

	public BigDecimal bonificacao() {
		return salario;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " || Idade: " + idade + " anos || Salário: " + String.format("%.2f", salario);

	}
}
