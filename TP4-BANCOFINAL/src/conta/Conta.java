package conta;
import java.math.BigDecimal;
import java.util.Iterator; 
import java.util.List;

public interface Conta {
		public abstract void Debitar(BigDecimal valor);
		public abstract void Creditar(BigDecimal valor);
		public abstract BigDecimal getSaldo();
		public abstract Pessoa getTitular();
		public abstract void addDependentes(Pessoa Dependente);
		public abstract void removerDependente(Pessoa Dependente);
		public abstract Iterator<Pessoa> getDependentes();
		public abstract String toString();

}

