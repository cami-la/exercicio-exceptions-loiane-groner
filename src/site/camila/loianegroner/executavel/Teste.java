package site.camila.loianegroner.executavel;

import java.util.Scanner;

import site.camila.loianegroner.classes.Agenda;
import site.camila.loianegroner.classes.Contato;
import site.camila.loianegroner.exceptions.AgendaCheiaException;
import site.camila.loianegroner.exceptions.ContatoNaoExisteException;

public class Teste {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcao = 1;

		Agenda agenda = new Agenda();

		while(opcao != 3 ) {
			opcao = obterOpcaoMenu(scan);
			if (opcao == 1) { // Consultar contato;
				consultarContato(scan, agenda);
			} else if (opcao == 2) {
				adicionarContato(scan, agenda); //adiciona
			} else //termina o programa - opcional
				System.exit(0);
		}		
	}

	public static void adicionarContato(Scanner scan, Agenda agenda) {
		try {
			System.out.println("Criando contato, entre com as informações: ");

			String nome = lerInformacaoString(scan, "nome");
			String telefone = lerInformacaoString(scan, "telefone");
			String email = lerInformacaoString(scan, "email");

			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setTelefone(telefone);
			contato.setEmail(email);
			
			System.out.println("Contato a ser criado\n" + contato);
			
			agenda.adicionarContato(contato);
		} catch (AgendaCheiaException e) {
			System.out.println(e.getMessage());
			System.out.println("Contatos da agenda");
			System.out.println(agenda);
		}
	}

	public static void consultarContato(Scanner scan, Agenda agenda) {
		String nomeContato = lerInformacaoString(scan, "Entre com o nome do contato: ");
		try {
			if (agenda.consultaContadoPorNome(nomeContato) >= 0) {
				System.out.println("Contato existe");
			}
		} catch (ContatoNaoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String lerInformacaoString(Scanner scan, String mensagem) {
		System.out.print(mensagem);
		String entrada = scan.nextLine();
		return entrada;
	}

	public static int obterOpcaoMenu(Scanner scan) {
		boolean entradaValida = false;
		int opcao = 3;

		while (!entradaValida) {
			System.out.println("Digite a opção desejada: ");
			System.out.println("1: Consultar contato");
			System.out.println("2: Adicionar Contato");
			System.out.println("3: Sair");

			try {
				String entrada = scan.nextLine();
				opcao = Integer.parseInt(entrada);
				if (opcao >= 1 && opcao <= 3) {
					entradaValida = true;
				} else {
					throw new Exception("Entrada Inválida");
				}
			} catch (Exception e) {
				System.out.println("Entrada Inválida, digite novamente!\n");
			}
		}
		return opcao;

	}

}