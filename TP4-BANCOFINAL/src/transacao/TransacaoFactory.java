package transacao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface TransacaoFactory {
 
	public abstract TransacaoComposta createTransComp(Date data,Log bridge);
	public List<Transacao> findByData(Date inicio, Date fim);
}


