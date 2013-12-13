package bancoTransacaoImpl;
import java.math.BigDecimal;
import java.util.Date;

import transacao.Log;

import conta.Conta;
import conta.ContaImpl;
import bancoTransacao.TransacaoBancariaAbstrata;
 
 public class Deposito extends TransacaoBancariaAbstrata{ 
	 
	 
	 public Deposito(BigDecimal valor,Conta destino,Date data,Log bridge){
		 super(valor,destino,null,data, bridge); 
	 } 
	
	
	   public void ExecutarEfetivamente(){ 
		  
		   this.getDestino().Creditar(super.getValor());
	   }
	    public BigDecimal getValor(){
		   return super.getValor();
	   } 
	  public Conta getDestino(){
		  return super.getDestino();
	   }  
	  
	  public Date getData(){
		  return super.getData();
	  }
	  
	 public String toString(){
		  return "\n [DEPOSITO]  R$"+super.getValor()+" - FAVORECIDO:"+super.getDestino();
	  } 
  }

