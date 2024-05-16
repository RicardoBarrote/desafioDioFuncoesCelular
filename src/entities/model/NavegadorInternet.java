package entities.model;

import java.util.Scanner;

import entities.interfaces.Funcoes;

public class NavegadorInternet  implements Funcoes {
	

	private int paginasAbertas = 0;
	
	//@Override
	/*public boolean validarInternet(Scanner sc) {
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
	
		//if (verificarInternet == true) {
			System.out.println("Exibir página[1], Adicionar página[2], Fechar página[3], Atualizar página[4]");
			int opcao = sc.nextInt();
			
			if(opcao == 1) {
				exibirPagina();
			}
			else if(opcao == 2) {
				adicionarPagina();
			}
			else if(opcao == 3) {
				fecharPaginas();
			}
			else if(opcao == 4) {
				atualizarPagina();	
			}
			else {
				System.out.println("Opção inválida");
			}
		}
		/*else {
			System.out.println("Erro: conexão com internet não encontrada.");
		}
		
	}*/
	
	private void exibirPagina() {
		System.out.println("Exibindo página");
	}
	
	private void paginasAbertas() {
		paginasAbertas ++;
		System.out.println("Páginas abertas: " +  paginasAbertas);
	} 
	
	private void fecharPaginas() {
		if (paginasAbertas == 0) {
			throw new IllegalStateException("Não existe páginas abertas.");
		}
		else {
			paginasAbertas --;
			System.out.println("Páginas abertas: " + paginasAbertas);
		}
	}
	
	private void adicionarPagina() {
		System.out.println("Adicionando página");
		System.out.println();
		paginasAbertas();
	}

	private void atualizarPagina() {
		if(paginasAbertas == 0) {
		throw new IllegalStateException("Não existe páginas abertas");
		}
		else {
		System.out.println("Atualizando página");
		}
	}

}
