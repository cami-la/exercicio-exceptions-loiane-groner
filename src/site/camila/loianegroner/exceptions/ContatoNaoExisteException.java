package site.camila.loianegroner.exceptions;

public class ContatoNaoExisteException extends Exception{

	private String nome;
	
	public ContatoNaoExisteException(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String getMessage() {
		return this.nome + " não foi encontrado na agenda!";
	}
}