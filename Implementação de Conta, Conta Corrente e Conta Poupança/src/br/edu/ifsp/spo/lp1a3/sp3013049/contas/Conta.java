package br.edu.ifsp.spo.lp1a3.sp3013049.contas;

public class Conta {
	
	private static int qtdContas;
	private int númeroConta;
	private String titular;
	private double saldo;
	
	public Conta(String titular) {
		this.titular = titular;
		this.saldo = 0;
		this.númeroConta = qtdContas +1;
		qtdContas +=1;
	}
	
	public static int getQtdContas() {
		return qtdContas;
	}
	public int getNúmeroConta() {
		return númeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void transferirPara(Conta outraConta, double valor) {
		this.sacar(valor);
		outraConta.depositar(valor);
	}
	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
	}
	public double sacar(double valor) {
		this.saldo = this.saldo - valor;
		return this.getSaldo();
	}
	
	@Override
	public String toString() { 
	    return "Titular: '" + this.titular + "', Número da Conta: '" + this.númeroConta + "', Saldo: '" + this.saldo + "'";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if(obj.getClass() == this.getClass()) {
			
			Conta other = (Conta)obj;
			
			resultado = this.getNúmeroConta() == other.getNúmeroConta();
			resultado = resultado && this.getTitular().equals(other.getTitular());
			resultado = resultado && this.getSaldo() == other.getSaldo();
		}
		return resultado;
	}
}