package conta; 
import seres.SerHumano;

 //Adapter 
public class PessoaImpl implements Pessoa { 
	private SerHumano pessoa;
	
	public PessoaImpl(String nome,String cpf){
    	   String nomesobre[]=this.TratarNome(nome); 
	       this.pessoa=new SerHumano(nomesobre[0],nomesobre[1],cpf);
    }

	
	public String getNome()  
	{   return pessoa.getPrimeiro_nome()+""+pessoa.getSobrenome();	}

	
	public void setNome(String nome) {
	    String nomes[]=this.TratarNome(nome);
	    this.pessoa.setPrimeiro_nome(nomes[0]);
	    this.pessoa.setSobrenome(nomes[1]);
	}
	
	public String getCpf() 
	{ return this.pessoa.getCpf();	}

	public void setCpf(String cpf)
	{ pessoa.setCpf(cpf); }
	
	private String[] TratarNome(String nome){
		String result[]=new String[2];
		 String nomesobre[]=nome.split(" "); 
	     String sobrenome="";
         nome=nomesobre[0];
         for(int i=1;i<nomesobre.length;i++){
         sobrenome=sobrenome+" "+nomesobre[i];
         }
	    result[0]=nome; 
	    result[1]=sobrenome; 
	    return result;
	}
	
	public String toString()
	{	return"NOME: "+this.getNome()+" - CPF: "+this.getCpf();	}
}
