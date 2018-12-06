package estruturas;

public class Instrumento {
	
	public String nome;
	
	//Apontador, para outro objeto
	public Instrumento proximo;
	
	public int quantidade;
	
	public double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
