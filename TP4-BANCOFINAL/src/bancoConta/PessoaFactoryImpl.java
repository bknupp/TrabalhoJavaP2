package bancoConta;

import conta.Pessoa;
import conta.PessoaImpl;

public class PessoaFactoryImpl implements PessoaFactory { 
	public Pessoa createPessoa(String nome,String cpf)
	{	return new PessoaImpl(nome,cpf); }

}
