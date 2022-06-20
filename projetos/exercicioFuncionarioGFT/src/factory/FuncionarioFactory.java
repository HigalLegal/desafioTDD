package factory;

import entities.Funcionario;
import entities.Gerente;
import entities.Supervisor;
import entities.Vendedor;

public class FuncionarioFactory {

	private FuncionarioFactory() {
	}

	// --------------------------------

	public static Funcionario funcionarioFactory(char tipoColaborador, String nome, Integer idade, Double salario) {
		
		if(tipoColaborador == 'G' || tipoColaborador == 'g') {
			return new Gerente(nome, idade, salario);
		}
		
		if(tipoColaborador == 'S' || tipoColaborador == 's') {
			return new Supervisor(nome, idade, salario);
		}
		
		if(tipoColaborador == 'V' || tipoColaborador == 'v') {
			return new Vendedor(nome, idade, salario);
		}
		
		return new Funcionario(nome, idade, salario);
	}

}
