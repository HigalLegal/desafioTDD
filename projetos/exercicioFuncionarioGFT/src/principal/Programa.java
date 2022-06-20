package principal;

import static factory.FuncionarioFactory.funcionarioFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class Programa {

	public static void main(String[] args) {

		var scan = new Scanner(System.in);

		System.out.println("FUNCIONARIO 1");
		System.out.println();

		System.out.print("Tipo (G para Gerente, S para Surpervisor e V para Vendedor, e qualquer letra para normal): ");
		char tipoFuncionario = scan.next().charAt(0);

		System.out.print("Nome: ");
		scan.nextLine();
		String nome = scan.nextLine();

		System.out.print("Idade: ");
		Integer idade = scan.nextInt();

		System.out.print("Salário: ");
		Double salario = scan.nextDouble();

		Funcionario funcionario1 = funcionarioFactory(tipoFuncionario, nome, idade, salario);

		// ----------------------------------------------------------------------------------------------------------

		System.out.println();

		System.out.println("FUNCIONARIO 2");
		System.out.println();

		System.out.print("Tipo (G para Gerente, S para Surpervisor e V para Vendedor, e qualquer letra para normal): ");
		tipoFuncionario = scan.next().charAt(0);

		System.out.print("Nome: ");
		scan.nextLine();
		nome = scan.nextLine();

		System.out.print("Idade: ");
		idade = scan.nextInt();

		System.out.print("Salário: ");
		salario = scan.nextDouble();

		Funcionario funcionario2 = funcionarioFactory(tipoFuncionario, nome, idade, salario);

		// ----------------------------------------------------------------------------------------------------------

		System.out.println();

		System.out.println("FUNCIONARIO 3");
		System.out.println();

		System.out.print("Tipo (G para Gerente, S para Surpervisor e V para Vendedor, e qualquer letra para normal): ");
		tipoFuncionario = scan.next().charAt(0);

		System.out.print("Nome: ");
		scan.nextLine();
		nome = scan.nextLine();

		System.out.print("Idade: ");
		idade = scan.nextInt();

		System.out.print("Salário: ");
		salario = scan.nextDouble();

		Funcionario funcionario3 = funcionarioFactory(tipoFuncionario, nome, idade, salario);

		// ----------------------------------------------------------------------------------------------------------
		
		System.out.println();

		System.out.println("FUNCIONARIO 4");
		System.out.println();

		System.out.print("Tipo (G para Gerente, S para Surpervisor e V para Vendedor, e qualquer letra para normal): ");
		tipoFuncionario = scan.next().charAt(0);

		System.out.print("Nome: ");
		scan.nextLine();
		nome = scan.nextLine();

		System.out.print("Idade: ");
		idade = scan.nextInt();

		System.out.print("Salário: ");
		salario = scan.nextDouble();

		Funcionario funcionario4 = funcionarioFactory(tipoFuncionario, nome, idade, salario);

		// ----------------------------------------------------------------------------------------------------------

		List<Funcionario> funcionarios = new ArrayList<>();
		
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		funcionarios.add(funcionario3);
		funcionarios.add(funcionario4);
		
		funcionarios.forEach((funcionario) -> {
			
			int i = 1;
			
			System.out.println();
			System.out.println("Informações do Funcionário " + i + ":");
			System.out.println(funcionario);
			System.out.println("Valor de sua bonificação: " + String.format("%.2f", funcionario.bonificacao()));
			
			i++;
			
		});

		scan.close();

	}

}
