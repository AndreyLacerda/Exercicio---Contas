package br.edu.ifsp.spo.lp1a3.sp3013049.contas;

public class ContaCorrente extends Conta{

	private double limiteChequeEspecial;
	private static double taxaJurosChequeEspecial = 0.13;
	
	public ContaCorrente(String titular, double limite) {
		super(titular);
		this.limiteChequeEspecial = limite;
	}
	
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}
	public static double getTaxaJurosChequeEspecia() {
		return taxaJurosChequeEspecial;
	}
	public static void setTaxaJurosChequeEspecia(double taxaJurosChequeEspecial) {
		ContaCorrente.taxaJurosChequeEspecial = taxaJurosChequeEspecial;
	}
	
	public void debitarJuros() {
		double juros = this.getSaldo() * getTaxaJurosChequeEspecia();
		this.sacar(juros);
	}
	
	@Override
	public double sacar(double valor) {
		valor = valor + (valor * 0.01);
		super.sacar(valor);
		return this.getSaldo();
	}
	
	@Override
	public String toString() { 
	    return "Titular: '" + this.getTitular() 
	    + "', Número da Conta: '" + this.getNúmeroConta() 
	    + "', Saldo: '" + this.getSaldo() 
	    + "', Limite do Cheque Especial: '" + this.getLimiteChequeEspecial() 
	    + "', Taxa de Juros do Cheque Especial: '" + this.getTaxaJurosChequeEspecia() + "'";
	}
	@Override
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if(obj.getClass() == this.getClass()) {
			
			ContaCorrente other = (ContaCorrente)obj;
			
			resultado = this.getNúmeroConta() == other.getNúmeroConta();
			resultado = resultado && this.getTitular().equals(other.getTitular());
			resultado = resultado && this.getSaldo() == other.getSaldo();
			resultado = resultado && this.getLimiteChequeEspecial() == other.getLimiteChequeEspecial();
		}
		return resultado;
	}
}