package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Emissor;
import model.entities.Mensagem;
import model.entities.Pombo;
import model.entities.Receptor;

public class Programa {

	public static void main(String[] args) {

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

/*
 * Observação: Repliquei o mesmo objeto Mensagem 20 vezes para facilitar a correção. Ia ficar um pouco complicado
 * digitar o título e conteúdo da mensagem 20 vezes.
 * */
