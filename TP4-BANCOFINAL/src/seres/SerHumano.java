package seres;

//Adaptee(adaptado)
public class SerHumano { 
	
	private String Primeiro_nome; 
	private String cpf;
	private String Sobrenome;
	
	public SerHumano(String primeironome, String sobrenome, String cpf){
		this.Primeiro_nome = primeironome;
		this.Sobrenome = sobrenome;
		this.cpf = cpf;
	}
	
	public String getPrimeiro_nome() {
		return Primeiro_nome;
	}
	public void setPrimeiro_nome(String primeiroNome) {
		Primeiro_nome = primeiroNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	

}
