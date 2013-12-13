package bancoConta;

import conta.Conta;
import conta.ContaImpl;
import conta.Pessoa;

public class ContaFactoryImpl {
	 public Conta createConta(Pessoa titular) 
	 {	return new ContaImpl(titular);	}
}
