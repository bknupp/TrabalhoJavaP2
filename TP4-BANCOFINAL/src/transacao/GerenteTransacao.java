package transacao;
import java.util.List; 
import java.util.Iterator;
import java.util.Date;
import java.util.ArrayList;

public class GerenteTransacao { 
	private List<Transacao> aExecutar;
	private List<Transacao> executadas; 
	
	public GerenteTransacao(){ 
		this.aExecutar=new ArrayList<Transacao>();
		this.executadas=new ArrayList<Transacao>(); 	
	}
	 
	public void RegistraTransacao(Transacao T)
	{  this.aExecutar.add(T);         } 
		
		 
	public void ExecutarTransacoes(){
		Date d=new Date();
	    List<Transacao> lista_aux=new ArrayList<Transacao>();
		  
	    Iterator<Transacao>It=this.aExecutar.iterator();
		      for(int i=0;i<this.aExecutar.size();i++){
			     Transacao T=(Transacao)It.next();
			     if(T.getData().equals(d)||(T.getData().before(d))){
                  T.Executar(); 
			      lista_aux.add(T); }}
		      
	    Iterator<Transacao>It2=lista_aux.iterator();   
              for(int x=0;x<lista_aux.size();x++){
                 Transacao T2=(Transacao)It2.next();
                 if(T2.foiExecutada()==true){
            	    this.executadas.add(T2);
            	    this.aExecutar.remove(T2);
                    }}
                  }
		        
   public Iterator<Transacao> getTransacoesExecutadas()
   {  return this.executadas.iterator();	} 
	public Iterator<Transacao> getTransacoesAexecutar()
   { return this.aExecutar.iterator();  	}
	
	
	
}
