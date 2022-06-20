package programa;

import java.util.Scanner;

import model.entities.Veiculo;
import model.exceptions.CombustivelException;
import model.exceptions.VelocidadeException;

public class App {
	public static void main(String[] args) {

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

			if(isLigado) {
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
			
			if(resposta == 'A' || resposta == 'a') {
				veiculo.acelerar();
			} else if(resposta == 'F' || resposta == 'f') {
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
}
