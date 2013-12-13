package bancoConta;

import conta.Conta;
import conta.Pessoa;

public interface ContaFactory { 
	 public abstract Conta createConta(Pessoa titular);
} 