package br.edu.ifsp.spo.lp1a3.sp3013049.contas;

public class ContaPoupança extends Conta{
	
	public ContaPoupança(String titular) {
		super(titular);
	}

	private static double taxaRendimento = 0.085;

	public static double getTaxaRendimento() {
		return taxaRendimento;
	}

	public static void setTaxaRendimento(double taxaRendimento) {
		ContaPoupança.taxaRendimento = taxaRendimento;
	}
	
	public void aplicarRendimento() {
		double valor = this.getSaldo() * getTaxaRendimento();
		this.depositar(valor);
	}
	
	@Override
	public String toString() { 
	    return "Titular: '" + this.getTitular() 
	    + "', Número da Conta: '" + this.getNúmeroConta() 
	    + "', Saldo: '" + this.getSaldo() 
	    + "', Taxa de Rendimento: '" + this.getTaxaRendimento() + "'";
	}	
}