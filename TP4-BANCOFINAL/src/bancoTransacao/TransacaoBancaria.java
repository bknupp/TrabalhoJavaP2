package bancoTransacao;  
import java.math.BigDecimal;
import transacao.Transacao;  
import conta.Conta;

public interface TransacaoBancaria extends Transacao { 
	public abstract BigDecimal getValor();
	public abstract Conta getOrigem();
	public abstract Conta getDestino();

}