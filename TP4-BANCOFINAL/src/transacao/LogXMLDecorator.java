package transacao;

public class LogXMLDecorator extends TransacaoDecorator{  
	
	public LogXMLDecorator(Transacao component){
		super(component);
	}
	
	public void Executar(){
		if(!this.foiExecutada())
		{  super.Executar(); }
	    System.out.println("[LOG XML]"+this.getComponente().toString());
	} 

	public String toString()
	{	return "Sou um Decorator XML !";	}

	public TransacaoComposta getTransacaoComposta() 
	{		return null;	} 
}
