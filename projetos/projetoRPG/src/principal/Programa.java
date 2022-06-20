package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Personagem;
import model.factories.PersonagemFactory;

public class Programa {

	public static void main(String[] args) {
		
		var scan = new Scanner(System.in);
		
		boolean auxiliar = true;
		int i = 0;
		
		List<Personagem> personagens = new ArrayList<>();
		
		while(auxiliar) {
			
			System.out.println("Personagem " + (i+1) + "\n");
			
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
			
			Personagem personagem = PersonagemFactory.personagemFactory(tipo, nome, vida, mana, xp, inteligencia, força, level);
			
			personagens.add(personagem);
			
			System.out.print("Para continuar, digite C ou para parar aqui digite qualquer outra tecla: ");
			char continuacao = scan.next().charAt(0);
			
			if(continuacao != 'C' && continuacao != 'c') {
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

}
