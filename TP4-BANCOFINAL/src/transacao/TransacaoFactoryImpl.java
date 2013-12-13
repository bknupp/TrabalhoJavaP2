package transacao;

import java.util.Date;

public abstract class TransacaoFactoryImpl implements TransacaoFactory { 
	

	
	public TransacaoFactoryImpl(){
		
	} 
	
	public TransacaoComposta createTransComp(Date data,Log bridge){
		TransacaoComposta T= new TransacaoCompostaImpl(data,bridge);
	     return T;
       }  
	
	protected abstract Log getBridge();
	protected abstract void setBridge(Log bridge);
	
	

}


