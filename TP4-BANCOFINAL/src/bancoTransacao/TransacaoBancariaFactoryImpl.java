package bancoTransacao;

import java.math.BigDecimal;
import java.util.Date;

import bancoTransacaoImpl.*;
import transacao.*;
import bancoConta.*;

import java.util.List; 
import java.util.ArrayList;
import java.util.Iterator;

import conta.Conta;

public class TransacaoBancariaFactoryImpl extends TransacaoFactoryImpl  implements TransacaoBancariaFactory   { 
	
	List<Transacao> TransactionList = new ArrayList<Transacao>();
	private Log bridge;	
	
	
	public TransacaoBancaria createTransBanc(BigDecimal valor, Conta destino,
			Conta origem, Date data,Log bridge,String tipoTransa) {
	  
		TransacaoBancaria t = null;
		
		if(tipoTransa=="Transferencia"){
	       t=new Transferencia(valor,destino,origem,data,bridge);
	
		}
		
	    if(tipoTransa=="Deposito"){
	       t=new Deposito(valor,origem,data,bridge);
	      
	    } 
	    
	    TransactionList.add(t);
	    return t;
	    
		} 
	


	public TransacaoComposta createTransComp(Date data, Log bridge) {
		return null; 
		
	}



	@Override
	protected Log getBridge() {
		return this.bridge;
	}



	@Override
	protected void setBridge(Log bridge) {
		this.bridge = bridge;		
	}  
	
  public List<Transacao> findByData(Date inicio,Date fim){
	  
		 Iterator<Transacao>it=this.TransactionList.iterator();
	      for(int i=0;i<TransactionList.size();i++){
		     Transacao T=(Transacao)it.next();
		     if(T.getData().equals(inicio)||(T.getData().before(fim))){
		    	 System.out.println(T.toString());

		     }else{
		    	 System.out.println("Não há transações dentro desse período.");
		      }
		     
	      }
	
	      return null;	   
	
	}	
 

	
}


