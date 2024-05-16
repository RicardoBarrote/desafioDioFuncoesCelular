package entities.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import entities.interfaces.Funcoes;

public class AparelhoTelefonico implements Funcoes {
	
	private double creditoConta = 0.0;
	private String nome;
	private String numero;
	
	Map<String, String> mapContato = new HashMap<>();
	
	/*@Override
	public boolean validarInternet(Scanner sc) {
		System.out.println("Ligar internet ? (s/n)");
		char resposta = sc.next().charAt(0);

		if (resposta == 's') {
			System.out.println("INTERNET LIGADA");
			return true;
		} else {
			System.out.println("INTERNET DESLIGADA");
			return false;
		}
	}*/

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public void abrirAplicativo(Scanner sc) {

		//boolean verificarSaldoCredito = creditoConta(sc);
		
		//if (verificarSaldoCredito == true) {
			System.out.println("Ligação[1], Correio de voz[2], Verificar saldo[3], Contatos[4]");
			int opcao = sc.nextInt();
			
			if(opcao == 1) {
				efetuarLigacao(sc);
			}
			else if(opcao == 2) {
				System.out.println("Correio de voz");
			}
			else if(opcao == 3) {
				System.out.println("Crédito conta: " + creditoConta);
			}
			else if(opcao == 4) {
				mapContatos();
			}
			else {
				atenderLigacao(sc);
			}
		}
		/*else {
			System.out.println("Erro: crédito insuficiente. ");
		}
		
	}*/
	public void adicionarContato(String nome, String numero) {
		mapContato.put(nome, numero);
	}
	
	private void mapContatos() {
		if(mapContato.isEmpty()) {
			throw new IllegalStateException("Erro: lista vazia");
		}
		else {
		System.out.print("[");
		
		for(String key : mapContato.keySet()) {
			System.out.print("Nome: " + key + ", Número: " + mapContato.get(key) + " | ");
		}
		
		System.out.print("]");
		System.out.println();
		}
	}
	
	private void efetuarLigacao(Scanner sc) {
		
		if (creditoConta <=0 ) {
			System.out.println("Saldo insuficiente - " + creditoConta);
			System.out.println();
			System.out.print("Deseja colocar crédito ? (s/n)");
			char respostaCredito = sc.next().charAt(0);
			
			if (respostaCredito == 's') {
				System.out.print("Valor para crédito: ");
				double valorCredito = sc.nextDouble();
				creditoConta += valorCredito;
				
				System.out.println("Crédito efetuado com sucesso.");
				System.out.println("Saldo atual: " + creditoConta);
			}
			
		}
		else {
			System.out.print("Digite o número: ");
			String numeroLigacao = sc.next();
			
			System.out.print("Deseja salvar o contato ?(s/n)");
			char respostaNumero = sc.next().charAt(0);
				
			if(respostaNumero == 's') {
				if (mapContato.containsValue(numeroLigacao) == true) {
					System.out.println("Número já existente");
					System.out.println("Efetuando ligação");
					creditoConta --;
				}
				else {
				System.out.print("Nome do contato: ");
				sc.nextLine();
				String nomeContato = sc.nextLine();
					
				adicionarContato(nomeContato, numeroLigacao);
				System.out.println("Ligando para " + nomeContato);
				creditoConta --;
				}
			}
		}
	}
		
	public void atenderLigacao(Scanner sc) {
		System.out.println("Celular tocando");
		System.out.println("---------------");
		System.out.println("Atender: (s/n)");
		char atender = sc.next().charAt(0);
		
		if(atender == 's') {
			System.out.println("Chamada em curso");
			System.out.print("Desligar[1], Modo espera[2]");
			int opcaoChamada = sc.nextInt();
			if(opcaoChamada == 1) {
				System.out.println("Chamada desligada");
			}
			else {
				System.out.println("Chamada em espera.");
			}
		}
		else{
			System.out.println("Chamada desligada");
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AparelhoTelefonico other = (AparelhoTelefonico) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(numero, other.numero);
	}
	
	
	
}
