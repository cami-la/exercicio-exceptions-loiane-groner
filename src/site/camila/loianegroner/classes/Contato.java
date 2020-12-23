package site.camila.loianegroner.classes;

public class Contato {
	//atributos
	private static int cont = 0;
	
	private String nome;
	private String telefone;
	private String email;
	private int id;
	
	public Contato() {
		cont++;
		this.id = cont;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String s = "[";
		s += "ID: " + this.getId();
		s += ", Nome: " + this.getNome();
		s += ", Telefone: " + this.getTelefone();
		s += ", Email: " + this.getEmail() + "]";
		return s;
	}
	
}