package bancoTransacao;

import java.math.BigDecimal;
import java.util.Date;
import transacao.*;
import conta.Conta;

public interface TransacaoBancariaFactory extends TransacaoFactory {  
	public abstract Transacao createTransBanc(BigDecimal valor,Conta destino,Conta origem,
	              Date data,Log bridge,String tipoTransa);
	
   

}

