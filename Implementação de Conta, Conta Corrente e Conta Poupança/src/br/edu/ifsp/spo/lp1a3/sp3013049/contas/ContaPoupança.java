package br.edu.ifsp.spo.lp1a3.sp3013049.contas;

public class ContaPoupan�a extends Conta{
	
	public ContaPoupan�a(String titular) {
		super(titular);
	}

	private static double taxaRendimento = 0.085;

	public static double getTaxaRendimento() {
		return taxaRendimento;
	}

	public static void setTaxaRendimento(double taxaRendimento) {
		ContaPoupan�a.taxaRendimento = taxaRendimento;
	}
	
	public void aplicarRendimento() {
		double valor = this.getSaldo() * getTaxaRendimento();
		this.depositar(valor);
	}
}
