package principal;

import java.util.Scanner;

import model.facade.FacadeGFT;

public class Programa {

	public static void main(String[] args) {

		var scan = new Scanner(System.in);

		FacadeGFT facadeGFT = new FacadeGFT();

		System.out.println("Digite 1 para o exercicio 1, 2 para o exercicio 2, 3 para o exercicio 3, 7 para o\n"
				+ "exercicio 7, e qualquer outro número para o exercício extra.");
		int numeroExercicio = scan.nextInt();
		
		if(numeroExercicio == 1) {
			facadeGFT.exercicio1();
		}
		
		else if(numeroExercicio == 2) {
			facadeGFT.exercicio2();
		}
		
		else if(numeroExercicio == 3) {
			facadeGFT.exercicio3();
		}
		
		else if(numeroExercicio == 7) {
			facadeGFT.exercicio7();
		}
		
		else {
			facadeGFT.exercicioExtra();
		}

//		switch (numeroExercicio) {
//		
//		case 1: facadeGFT.exercicio1();
//		case 2: facadeGFT.exercicio2();
//		case 3: facadeGFT.exercicio3();
//		default: facadeGFT.exercicioExtra();
//		
//		}

		scan.close();

	}

}
