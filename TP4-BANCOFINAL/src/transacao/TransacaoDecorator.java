package transacao; 
import java.util.Date;

public abstract class TransacaoDecorator implements Transacao { 
	 
	private Transacao component;
	
    public TransacaoDecorator(Transacao component){
    	this.component=component;
    } 
    
    public void Executar(){
    	this.component.Executar(); 
    	
    }  
	public boolean foiExecutada() {
	  return component.foiExecutada();
	    }

	
	public Date getData() {
		return component.getData(); 
	} 
		
    protected Transacao getComponente(){
    	return component;
    }

    public TransacaoComposta getTransacaoComposta() {
			return null;
		} 
  

}
