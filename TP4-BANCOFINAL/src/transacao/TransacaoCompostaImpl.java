package transacao;
import java.util.Date; 
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TransacaoCompostaImpl extends TransacaoAbstrata implements TransacaoComposta  {  
	
	//private Date data; 
	private List<Transacao>filha;
	
	
   public TransacaoCompostaImpl(Date data,Log bridge){
	    super(data,bridge);
		this.filha=new ArrayList<Transacao>();
	} 
	
	public void adicionarTransacao(Transacao filha){  
	if(filha.getData().before(getData())||filha.getData().equals(getData())){
	    this.filha.add(filha); }
	    else 
	 throw new RuntimeException("A TRANSAÇÃO SIMPLES TEM QUE TER A MESMA DATA DA TRANSAÇÃO COMPOSTA! ");
		
	} 
	
	public void removerTransacao(Transacao filha){
		this.filha.remove(filha);
	}  
	

	protected void ExecutarEfetivamente() {
		Iterator<Transacao>it=this.filha.iterator(); 
		for(int i=0;i<this.filha.size();i++){ 
			Transacao t=(Transacao)it.next(); 
			t.Executar();
		 }
		}
	
	public TransacaoComposta getTransacaoComposta(){
		return this;
	}

     public Iterator<Transacao> getTransacoesFilhas() {
		return this.filha.iterator();
	    } 
   
    
     }
