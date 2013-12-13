package bancoTransacao;  

import java.math.BigDecimal; 

import transacao.Log;
import transacao.Transacao;
import transacao.TransacaoAbstrata;
import conta.Conta; 

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public abstract class TransacaoBancariaAbstrata extends TransacaoAbstrata implements TransacaoBancaria {
 
	  private BigDecimal valor=new BigDecimal(0) ;
	  private Conta origem;
	  private Conta destino;
	
	
 
public TransacaoBancariaAbstrata(BigDecimal valor,Conta destino,Conta origem,Date data, Log bridge){
		super(data,bridge);
	    this.valor=valor; 
		this.destino=destino;
		this.origem=origem;
	} 
	
	public BigDecimal getValor(){ 
		return valor;
	} 
	public Conta getOrigem(){
		return origem;
	} 
	
	public Conta getDestino(){
		return destino;
	}  
		
	

}
	