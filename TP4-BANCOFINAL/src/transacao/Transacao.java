package transacao; 
import java.util.Date;

public interface Transacao { 
	public abstract Date getData();
	public abstract void Executar(); 
	public abstract boolean foiExecutada();
	public TransacaoComposta getTransacaoComposta();

}