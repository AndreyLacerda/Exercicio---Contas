package br.edu.ifsp.spo.lp1a3.sp3013049.contas;

public class Conta {
	
	private static int qtdContas;
	private int n�meroConta;
	private String titular;
	private double saldo;
	
	public Conta(String titular) {
		this.titular = titular;
		this.saldo = 0;
		this.n�meroConta = qtdContas +1;
		qtdContas +=1;
	}
	
	public static int getQtdContas() {
		return qtdContas;
	}
	public int getN�meroConta() {
		return n�meroConta;
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
	    return "Titular: '" + this.titular + "', N�mero da Conta: '" + this.n�meroConta + "', Saldo: '" + this.saldo + "'";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if(obj.getClass() == this.getClass()) {
			
			Conta other = (Conta)obj;
			
			resultado = this.getN�meroConta() == other.getN�meroConta();
			resultado = resultado && this.getTitular().equals(other.getTitular());
			resultado = resultado && this.getSaldo() == other.getSaldo();
		}
		return resultado;
	}
}