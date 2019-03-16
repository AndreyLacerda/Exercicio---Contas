package br.edu.ifsp.spo.lp1a3.sp3013049.contas;

public class ContaCorrente extends Conta{
	
	public ContaCorrente(String titular, double limite) {
		super(titular);
		setLimiteChequeEspecial(limite);
	}

	private double limiteChequeEspecial;
	private static double taxaJurosChequeEspecia = 0.13;
	
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}
	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}
	public static double getTaxaJurosChequeEspecia() {
		return taxaJurosChequeEspecia;
	}
	public static void setTaxaJurosChequeEspecia(double taxaJurosChequeEspecia) {
		ContaCorrente.taxaJurosChequeEspecia = taxaJurosChequeEspecia;
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
}
