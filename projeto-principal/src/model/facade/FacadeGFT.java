package model.facade;

import static factory.FuncionarioFactory.funcionarioFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.gft.model.Livro;
import br.com.gft.model.Loja;
import br.com.gft.model.VideoGame;
import entities.Funcionario;
import model.entities.Emissor;
import model.entities.Mensagem;
import model.entities.Personagem;
import model.entities.Pombo;
import model.entities.Receptor;
import model.entities.Veiculo;
import model.exceptions.CombustivelException;
import model.exceptions.VelocidadeException;
import model.factories.PersonagemFactory;

public class FacadeGFT {

	public void exercicio1() {
		var scan = new Scanner(System.in);

		try {

			System.out.print("Digite a marca do carro: ");
			String marca = scan.nextLine();

			System.out.print("Modelo: ");
			String modelo = scan.nextLine();

			System.out.print("Cor: ");
			String cor = scan.nextLine();

			System.out.print("Quilometros rodados: ");
			int quilometros = scan.nextInt();

			System.out.print("Está ligado (S/N)? ");
			char ligado = scan.next().charAt(0);
			boolean isLigado = false;
			int velocidade = 0;

			if (ligado == 'S') {
				isLigado = true;
			}

			System.out.print("Litros no combustível: ");
			int litrosCombustivel = scan.nextInt();

			if (isLigado) {
				System.out.print("Velocidade em quilometros: ");
				velocidade = scan.nextInt();
			}

			System.out.print("Preço: ");
			Double preco = scan.nextDouble();

			Veiculo veiculo = new Veiculo(marca, modelo, cor, quilometros, isLigado, litrosCombustivel, velocidade,
					preco);

			System.out.println(veiculo);

			// ------------------------------------

			System.out.println("--------------------------------------------");

			System.out.println("TROCANDO DE COR!");
			System.out.print("Digite a cor nova: ");
			cor = scan.next();
			veiculo.pintar(cor);
			System.out.println("COR NOVA: " + veiculo.getCor());

			System.out.println();

			System.out.println("Ligando o veículo:");
			veiculo.ligar();
			System.out.println("O veículo está ligado? " + veiculo.getIsLigado());

			System.out.println("Desligando o veículo:");
			veiculo.desligar();
			System.out.println("O veículo está ligado? " + veiculo.getIsLigado());

			System.out.print("Digite a quantidade de litros para abastecer: ");
			litrosCombustivel = scan.nextInt();
			veiculo.abastecer(litrosCombustivel);

			System.out.print("Digite A para acelerar, e F para frear. Digite outra coisa para caso querer encerrar: ");
			char resposta = scan.next().charAt(0);

			if (resposta == 'A' || resposta == 'a') {
				veiculo.acelerar();
			} else if (resposta == 'F' || resposta == 'f') {
				veiculo.frear();
			}

			System.out.println("Velocidade atual: " + veiculo.getVelocidade());

		} catch (VelocidadeException e) {
			System.out.println(e.getMessage());
		} catch (CombustivelException e) {
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}
	}

	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------

	public void exercicio2() {
		Livro l1 = new Livro("Harry Potter", 40, 50, "J. K. Rowling", "fantasia", 300);
		Livro l2 = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		Livro l3 = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);

		VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
		VideoGame xbox = new VideoGame("XBOX", 1500, 500, "Microsoft", "One", false);

		Loja americanas = new Loja("Americanas", "12345678");

		americanas.adicionarLivro(l1);
		americanas.adicionarLivro(l2);
		americanas.adicionarLivro(l3);

		americanas.adicionarVideoGame(ps4);
		americanas.adicionarVideoGame(ps4Usado);
		americanas.adicionarVideoGame(xbox);

		l2.calcularImposto();
		l3.calcularImposto();

		ps4Usado.calcularImposto();
		ps4.calcularImposto();

		System.out.println("--------------------------------------------------------------------------------------");

		americanas.listaLivros();

		System.out.println("--------------------------------------------------------------------------------------");

		americanas.listaVideoGames();

		System.out.println("--------------------------------------------------------------------------------------");

		System.out.println("Patrimônio da loja " + americanas.getNome() + ": R$" + americanas.patrimonio());
	}

	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------

	public void exercicio3() {
		var scan = new Scanner(System.in);

		boolean auxiliar = true;
		int i = 0;

		List<Personagem> personagens = new ArrayList<>();

		while (auxiliar) {

			System.out.println("Personagem " + (i + 1) + "\n");

			System.out.print("Coloque o nome do seu personagem: ");
			String nome = scan.next();

			System.out.print("Vida: ");
			int vida = scan.nextInt();

			System.out.print("Mana: ");
			int mana = scan.nextInt();

			System.out.print("XP: ");
			float xp = scan.nextFloat();

			System.out.print("Inteligencia: ");
			int inteligencia = scan.nextInt();

			System.out.print("Força: ");
			int força = scan.nextInt();

			System.out.print("Level: ");
			int level = scan.nextInt();

			System.out.print("Tipo do personagem (G para Guerreiro, M para Mago): ");
			char tipo = scan.next().charAt(0);

			Personagem personagem = PersonagemFactory.personagemFactory(tipo, nome, vida, mana, xp, inteligencia, força,
					level);

			personagens.add(personagem);

			System.out.print("Para continuar, digite C ou para parar aqui digite qualquer outra tecla: ");
			char continuacao = scan.next().charAt(0);

			if (continuacao != 'C' && continuacao != 'c') {
				auxiliar = false;
			}

			i++;

		}

		personagens.forEach((personagem) -> {
			System.out.println();

			System.out.println(personagem);
			System.out.println("Poder de ataque: " + personagem.attack());

			System.out.println("Dando um upgrade neste personagem.");
			personagem.levelUp();

			System.out.println("Personagem após upgrade: ");
			System.out.println(personagem);
			System.out.println("Poder de ataque: " + personagem.attack());
		});

		int numeroPersonagens = Personagem.TotalPersonagens.total(personagens);

		System.out.println("Total de personagens criados: " + numeroPersonagens);

		scan.close();
	}

	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------

	public void exercicio7() {
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
	
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------
	
	public void exercicioExtra() {
		var scan = new Scanner(System.in);
		List<Mensagem> mensagens = new ArrayList<>();

		System.out.print("Digite o id do Receptor: ");
		Integer id = scan.nextInt();

		System.out.print("Nome: ");
		scan.nextLine();
		String nome = scan.nextLine();

		System.out.print("Idade: ");
		Integer idade = scan.nextInt();

		Receptor receptor = new Receptor(id, nome, idade);
		
		// ------------------------------------------------------
		
		System.out.println();

		System.out.print("Digite o id do pombo: ");
		id = scan.nextInt();

		System.out.print("Nome: ");
		scan.nextLine();
		nome = scan.nextLine();
		
		Pombo pombo = new Pombo(idade, nome, receptor);
		
		// ------------------------------------------------------
		
		System.out.println();
		
		System.out.print("Digite o id do Emissor: ");
		id = scan.nextInt();

		System.out.print("Nome: ");
		scan.nextLine();
		nome = scan.nextLine();

		System.out.print("Idade: ");
		idade = scan.nextInt();
		
		Emissor emissor = new Emissor(id, nome, idade, pombo);
		
		// ------------------------------------------------------
		
		System.out.println();
		
		System.out.println("Digite uma mensagem que será replicada 20 vintes.");
		
		System.out.print("Título: ");
		scan.nextLine();
		String titulo = scan.nextLine();
		
		System.out.print("Conteúdo: ");
		String conteudo = scan.nextLine();
				
		for(int i = 0; i < 20; i++) {
			mensagens.add(new Mensagem(titulo, conteudo));
		}
		
		System.out.println();
				
		emissor.postIt(mensagens.toArray(new Mensagem[0]));
		System.out.println("Mensagem enviada para o pombo com sucesso!");
		
		System.out.println("O " + emissor.getPombo().getNome() + " está enviando sua mensagem...");
		emissor.getPombo().enviarMensagem();
		System.out.println("Mensagem enviada com sucesso!");
		
		System.out.println("CONFIRA: " + emissor.getPombo().getReceptor().getMensagens().get(0));
		
		scan.close();
	}

}
