package bancoConta; 


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Date;
 


import java.util.List;





//importando os pacotes
import transacao.GerenteTransacao;
import transacao.LogTXTDecorator;
import transacao.Transacao;
import conta.Conta;
import conta.ContaImpl;
import conta.Pessoa;
import conta.PessoaImpl;
import bancoTransacao.*;
import bancoTransacaoImpl.*; 
import transacao.*;

public class testaBanco {
	
		
	
   
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		Log BridgeXML= new LogXML();
	    Log BridgeTXT = new LogTXT();
		
	System.out.println("--------------- BANCO TP4 ---------------");	
    Pessoa p=new PessoaImpl("Barbara Knupp","456.321.123-55");
    Pessoa p2=new PessoaImpl("Tirica","987.456.658-80");
    Pessoa p3=new PessoaImpl("Romario","159.357.456-46");
    Pessoa p4=new PessoaImpl("Dilma Rousseff","753.456.987-31");
    Conta c=new ContaImpl(p);
    Conta c2=new ContaImpl(p2);  
   
    //Conta c = titular:BARBARA | dependentes: Tiririca Romario Dilma
    c.addDependentes(p2); 
    c.addDependentes(p3);
    c.addDependentes(p4); 
    
    //Mostra o titular    
    System.out.println("[ TITULAR ] - "+c.getTitular()+" - SALDO: R$"+c.getSaldo());
    
    //Iterator percorrerá lista dos dependentes...
    Iterator<Pessoa> it=c.getDependentes();
    System.out.println("\n [DEPENDENTES] ");
    while(it.hasNext()){
    	  Pessoa p0=(Pessoa)it.next(); 
    	  System.out.println(p0);
        }
    
    //dilma é retirada da lista dos dependentes
    c.removerDependente(p4);
    
    System.out.println(" ");
    
    //Iterator percorrerá a nova lista,
    Iterator<Pessoa> it2=c.getDependentes();
    System.out.println("[DEPENDENTE RESTANTES] ");
    while(it2.hasNext()){
    	Pessoa pz=(Pessoa)it2.next();
    	System.out.println(pz);
    	
    }  
    
     
   ContaFactoryImpl cfactory= new ContaFactoryImpl(); 
   PessoaFactory pfactory=new PessoaFactoryImpl();
   TransacaoBancariaFactory tfactory=new TransacaoBancariaFactoryImpl(); 
    
   Conta CF=cfactory.createConta(pfactory.createPessoa("Maria (Factory)","234.456.789-45"));
   Transacao tf=tfactory.createTransBanc(new BigDecimal(200.00),null,CF,new Date(),BridgeXML,"Deposito");
 
   Conta CF2=cfactory.createConta(pfactory.createPessoa("Maria (Factory)","234.456.789-45"));
   Transacao tf2=tfactory.createTransBanc(new BigDecimal(300.00),null,CF,new Date(),BridgeXML,"Deposito");
 
   

    /*
    Transacao d1=new Deposito(new BigDecimal(1000.00),c2,new Date(),BridgeXML); 
    Transacao d2=new Deposito(new BigDecimal(1000.00),c2,new Date(),BridgeXML); 
    Transacao d10=new Deposito(new BigDecimal(20.00),c2,new Date(),BridgeXML);
    */

   Transacao T1=new Transferencia(new BigDecimal(500),c,c2,new Date("2014/09/08"),BridgeXML);
    //Essa transação só será executada em 08.09.2014
    
    
    
    Pessoa p5=new PessoaImpl("HIRO NAKASHIMA","456.789.456-12");
    Conta c3=new ContaImpl(p5);
    Transacao d3=new Deposito(new BigDecimal(10000.00),c3,new Date(),BridgeXML);
    Transacao d4=new Deposito(new BigDecimal(20000.00),c3,new Date(),BridgeXML);
    
    TransacaoComposta Tx=new TransacaoCompostaImpl(new Date(),BridgeXML); 
    Tx.adicionarTransacao(d3);
    Tx.adicionarTransacao(d4);  
    
    TransacaoDecorator TD=new LogTXTDecorator(d3); 
    TransacaoDecorator TD2=new LogXMLDecorator(d4);
    
    
    Pessoa p6 = new PessoaImpl("CAZUZA","789.123.456-12");
    Conta c4 = new ContaImpl(p6);
    Transacao d5 = new Deposito(new BigDecimal(100.00),c4,new Date(),BridgeTXT);
    Transacao d6 = new Transferencia(new BigDecimal(55.25),c3,c4,new Date("2012/09/08"),BridgeTXT);
    
    TransacaoDecorator TD3 = new LogTXTDecorator(d5);
    TransacaoDecorator TD4 = new LogXMLDecorator(d6);
    
    
    
    GerenteTransacao GT=new GerenteTransacao();
  
   GT.RegistraTransacao(tf); //Maria receberá 200 reais
   GT.RegistraTransacao(T1); // Transação que será feita no futuro
   GT.RegistraTransacao(Tx); // Transação composta
 
    GT.RegistraTransacao(d3); //DEPOSITO - HIRO 
    GT.RegistraTransacao(d4); // DEPOSITO - HIRO
       
    GT.RegistraTransacao(d5); // DEPOSITO - CAZUZA
    GT.RegistraTransacao(d6); // TRANSFERENCIA DE CAZUZA PARA HIRO    
   
    GT.RegistraTransacao(TD); // Hiro deposito - LOG TXT
    GT.RegistraTransacao(TD2); // HIRO DEPOSITO - LOG XML  
    
    GT.RegistraTransacao(TD3); // CAZUZA - DEPOSITO - LOG TXT
    GT.RegistraTransacao(TD4); // CAZUZA - TRANSFERENCIA - LOG XML
    
    GT.ExecutarTransacoes();  
 
    

    System.out.println("\n[CLIENTES X SALDOS]");
    System.out.println("Cliente:"+c2.getTitular()+"- Saldo: R$"+c2.getSaldo());
    System.out.println("Cliente:"+c.getTitular()+" - Saldo: R$"+c.getSaldo());
    System.out.println("Cliente:"+CF.getTitular()+" - Saldo: R$"+CF.getSaldo());
    System.out.println("Cliente:"+c3.getTitular()+"- Saldo: R$"+c3.getSaldo());
    System.out.println("Cliente:"+c4.getTitular()+"- Saldo: R$"+c4.getSaldo());
    System.out.println("");
    

   
    System.out.println("\n [RELATÓRIO GERENCIAL] \n"); //parte nova do gerente 
    Iterator<Transacao> itx=GT.getTransacoesAexecutar(); 
      while(itx.hasNext()){
    	Transacao tr=(Transacao)itx.next(); 
    	  System.out.println(" TRANSACOES A EXECUTAR: "+tr);
    } 
      
      System.out.println("-------------------------------------");
      
    Iterator<Transacao> itz=GT.getTransacoesExecutadas();
     while(itz.hasNext()){
    	Transacao trz=(Transacao)itz.next(); 
    	System.out.println(" TRANSACOES JÁ EXECUTADAS "+trz);
    } 
     
     System.out.println("\n ---FIND-BY-DATA--------------------------------");

     
   tfactory.findByData(new Date("2013/05/22"), new Date("2014/12/10"));
   
      
  }
}
