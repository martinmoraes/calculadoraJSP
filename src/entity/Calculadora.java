package entity;

public class Calculadora {
	
	private float valorUm;
	private float valorDois;
	private String operacao;

	
	public String resultado() {
		float resultado = 0;
		switch (operacao) {
		case "SOMAR":
			resultado = adicao();
			break;
		case "DIMINUIR":
			resultado = subtracao();
			break;
		case "MULTIPLICAR":
			resultado = multiplicacao();
			break;
		case "DIVIDIR":
			resultado = divisao();
			break;
		}
		return String.valueOf(resultado);
	}
	
	
	
	private float adicao() {
		return valorUm + valorDois;
	}

	private float subtracao() {
		return valorUm - valorDois;
	}

	private float multiplicacao() {
		return valorUm * valorDois;
	}

	private float divisao() {
		return valorUm / valorDois;
	}
	
	
	
	
	

	public float getValorUm() {
		return valorUm;
	}

	public void setValorUm(float valorUm) {
		this.valorUm = valorUm;
	}

	public float getValorDois() {
		return valorDois;
	}

	public void setValorDois(float valorDois) {
		this.valorDois = valorDois;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	
	
}
