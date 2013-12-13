package transacao;

public class LogTXTDecorator extends TransacaoDecorator {
	public LogTXTDecorator(Transacao component)
	{	super(component);	}  
	
	
	public void Executar(){
		if(!this.foiExecutada())
	    {super.Executar(); }
		System.out.println("[LOG TXT]"+this.getComponente().toString());
	} 
	
	
    public String toString(){
		return"Sou um Decorator TXT! ";
	}

    
 
  }

