package entities.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.interfaces.Funcoes;

public class ReprodutorMusical implements Funcoes {

	List<String> listMusica = new ArrayList<>();

	public void adicionarMusicaLista(String value) {
		listMusica.add(value);
	}

	/*@Override
	public boolean validarInternet(Scanner sc) {
		System.out.println("Ligar internet ? (s/n)");
		char resposta = sc.next().charAt(0);

		if (resposta == 's') {
			System.out.println("INTERNET LIGADA");
			return true;
		} 
		else {
			System.out.println("INTERNET DESLIGADA");
			return false;
		}
	}*/

	@Override
	public void abrirAplicativo(Scanner sc) {
		//boolean verificarInternet = validarInternet(sc);

		System.out.println("Escolher uma música[1], Abrir minha playlist[2]");
		int opcao = sc.nextInt();

		//if (verificarInternet == true) {
			if (opcao == 1) {
				escolherMusica(sc);
			} 
			else if (opcao == 2) {
				playList();
			} 
			else {
				System.out.println("Opção inválida");
			}

		} 
		/*else {
			System.out.println("Erro: conexão com internet não encontrada.");
		}
	}*/
	
	private void escolherMusica(Scanner sc) {
		System.out.print("Informe o nome da música: ");
		sc.nextLine();
		String nomeMusica = sc.nextLine();

		adicionarMusicaLista(nomeMusica);

		System.out.println("Tocando - " + nomeMusica);
		System.out.println("-----------------------");
		System.out.print("Pausar música: (s/n) ");
		char pausarMusica = sc.next().charAt(0);

		if (pausarMusica == 's') {
			System.out.println("Pausar");
			System.out.print("Play[1], Trocar música[2]");
			int opcao = sc.nextInt();
			if (opcao == 1) {
				System.out.println("Tocando - " + nomeMusica);
			}
			else if(opcao == 2) {
				System.out.print("Informe o nome da música: ");
				sc.nextLine();
				nomeMusica = sc.nextLine();
				adicionarMusicaLista(nomeMusica);
				System.out.println();
				System.out.println("Tocando - " + nomeMusica);
			}
			else {
				System.out.println("Opção inválida");
			}
		} 
		else {
			System.out.println("Tocando - " + nomeMusica);
		}
	}
	
	private void playList() {
		System.out.println("Abrindo playlist");
		if (listMusica.isEmpty()) {
			throw new IllegalStateException("Sua lista está vazia.");
		}
		else {
			System.out.print("[");
			for (String nomeMusica : listMusica) {
				System.out.print(nomeMusica + " | ");
			}
			System.out.print("]");
			
			System.out.println();
			System.out.println();
		}
	}

}
