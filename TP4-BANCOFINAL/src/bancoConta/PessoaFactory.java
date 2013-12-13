package bancoConta;

import conta.Pessoa;

public interface PessoaFactory {  
	public abstract Pessoa createPessoa(String nome,String CPF);
}