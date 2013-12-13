package bancoTransacaoImpl;
import java.math.BigDecimal; 
import java.util.Date;

import transacao.Log;
import conta.Conta;
import conta.ContaImpl;
import bancoTransacao.TransacaoBancariaAbstrata;
  

 public class Transferencia extends TransacaoBancariaAbstrata {

	 public Transferencia(BigDecimal valor,Conta destino,Conta origem,Date data,Log bridge)
	 {	    super(valor,destino,origem,data,bridge);		  } 
	   
	   public void ExecutarEfetivamente(){ 
		   this.getOrigem().Debitar(this.getValor());
		   this.getDestino().Creditar(this.getValor());
	   }
	   
	   public BigDecimal getValor()
	   {  return super.getValor();	   }
	   
	   public Conta getOrigem()
	   {  return super.getOrigem();	   }
	   
	   public Conta getDestino()
	   {  return super.getDestino();   }
	   
	   public Date getData()
	   {  return super.getData();	   } 
	
	   
	   public String toString(){
		   return"[TRANSFERENCIA] ORIGEM: "+this.getOrigem()+"  - DESTINO :"+this.getDestino()+" VALOR:"+this.getValor();
	   }
	   
	

}
