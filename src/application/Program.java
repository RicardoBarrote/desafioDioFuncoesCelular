package application;

import java.util.Locale;
import java.util.Scanner;

import entities.model.AparelhoTelefonico;
import entities.model.NavegadorInternet;
import entities.model.ReprodutorMusical;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		NavegadorInternet navegadorinternet = new NavegadorInternet();
		ReprodutorMusical reprodutormusical = new ReprodutorMusical();
		AparelhoTelefonico aparelhotelefonico = new AparelhoTelefonico();

		try {
			System.out.println(
					"Abrir navegador [1], Abrir reprodutor musical [2], Efetuar ligação[3], Desligar celular[0]");
			int opcao = sc.nextInt();

			while (opcao != 0) {
				if (opcao == 1) {
					navegadorinternet.abrirAplicativo(sc);
				} else if (opcao == 2) {
					reprodutormusical.abrirAplicativo(sc);
				} else if (opcao == 3) {
					aparelhotelefonico.abrirAplicativo(sc);

				} else if (opcao == 0) {
					return;
				} else {
					System.out.println();
					System.out.println("Opção inválida.");
					System.out.println("---------------");

				}

				System.out.println(
						"Abrir navegador [1], Abrir reprodutor musical [2], Efetuar ligação[3], Bloquear tela[0]");
				opcao = sc.nextInt();
			}
		} 
		catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Erro inesperado : " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
