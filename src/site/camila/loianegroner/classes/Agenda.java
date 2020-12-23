package site.camila.loianegroner.classes;

import site.camila.loianegroner.exceptions.AgendaCheiaException;
import site.camila.loianegroner.exceptions.ContatoNaoExisteException;

public class Agenda {
	private Contato[] contatos;
	
	public Agenda() {
		contatos = new Contato[5];
	}
	
	public void adicionarContato(Contato c) throws AgendaCheiaException {

		boolean cheia = true;
		
		for (int i =0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				contatos[i] = c;
				cheia = false;
			}
		if (cheia) throw new AgendaCheiaException();
		}
		
	}
	
	public int consultaContadoPorNome(String Nome) throws ContatoNaoExisteException {
		
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i].getNome().equalsIgnoreCase(Nome)) return i;
		}
		throw new ContatoNaoExisteException(Nome);
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Contato contato : contatos) {
			s += contato.toString() + "\n";
		}
		return s;
	}
}