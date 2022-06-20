package model.utils;

import static factory.FuncionarioFactory.funcionarioFactory;

import entities.Funcionario;

public class FuncionarioBuilder {
	
	private Funcionario funcionarioComum;
	private Funcionario vendedor;
	private Funcionario supervisor;
	private Funcionario gerente;
	
	// ------------------------------------------------------------------
	
	public FuncionarioBuilder() {
		
		funcionarioComum = funcionarioFactory('N', "Thiago", 23, 1300.0);
		vendedor = funcionarioFactory('V', "Marcelo", 25, 1500.0);
		supervisor = funcionarioFactory('S', "Victor", 30, 2500.0);
		gerente = funcionarioFactory('G', "Pedro", 35, 3000.0);
		
	}
	
	// ------------------------------------------------------------------

	public Funcionario getFuncionarioComum() {
		return funcionarioComum;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public Funcionario getSupervisor() {
		return supervisor;
	}

	public Funcionario getGerente() {
		return gerente;
	}
	
	

}
