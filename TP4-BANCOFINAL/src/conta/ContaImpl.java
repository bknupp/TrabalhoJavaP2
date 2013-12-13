package conta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContaImpl implements Conta {
	private BigDecimal saldo=new BigDecimal(0);
	public List<Pessoa>dependentes;
	public Pessoa titular; 

	
	public ContaImpl(Pessoa titular)
	{ 
	  this.dependentes=new ArrayList<Pessoa>();
	  this.titular=titular;
	} 
	
	public void Debitar(BigDecimal valor)
	{ this.saldo=saldo.subtract(valor);	} 
	
	public void Creditar(BigDecimal valor)
	{ this.saldo=saldo.add(valor);	}
	
	
	public BigDecimal getSaldo()
	{ return saldo;	} 
	
	public Pessoa getTitular()
	{ return titular;}  
	
	public void addDependentes(Pessoa Dependente)
	{ 
		if(Dependente==null)
		 throw new RuntimeException("NÃO PODE SER NULO.");
		if(!this.dependentes.contains(Dependente))
		 this.dependentes.add(Dependente);
	} 
	
	public void removerDependente(Pessoa Dependente)
	{	this.dependentes.remove(Dependente);	}
	
	
	public Iterator<Pessoa> getDependentes()
	{   return this.dependentes.iterator();     }
		
	
	public String toString()
	{	return ""+this.titular+"- SALDO: R$"+this.saldo;} //Favorecido-Saldo

}
