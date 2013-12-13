package transacao; 
import java.util.Date; 


public abstract class TransacaoAbstrata implements Transacao {
 
	private boolean executada=false; 
	private Date data;  
	private Log bridge;
	
	public TransacaoAbstrata(Date data,Log bridge)
	{
		this.data=data;  
		this.bridge=bridge;
	}
	
	protected  abstract void ExecutarEfetivamente();
  
	public Date getData()
	{ return data;  } 
	
	  public TransacaoComposta getTransacaoComposta()
	  {  return null;  }
	 
	
	public final void Executar(){
		if(!foiExecutada());
		  this.ExecutarEfetivamente(); 
		  this.executada=true; 
		  this.bridge.Registrar(this.toString());  
		 
		  
		  }
		  
   public boolean foiExecutada(){
		return executada;
     } 
    public String toString(){
    	String retorno="";
    	retorno="\n DATA DA TRANSAÇÃO: "+this.data+"\n "; 
    	return retorno;
    	
    }
  
   
}

