package transacao; 
import java.util.Iterator;

public interface TransacaoComposta extends Transacao { 
	public abstract void adicionarTransacao(Transacao filha);
	public abstract void removerTransacao(Transacao filha); 
	public abstract Iterator<Transacao> getTransacoesFilhas();
}
