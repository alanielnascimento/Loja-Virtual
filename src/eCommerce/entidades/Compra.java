package eCommerce.entidades;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private List<Produto> produtos;

	public Compra() {
		this.produtos = new ArrayList<>();
	}

	public double getValorTotal() {
		double valorTotal = 0.0;
		for (Produto produto : produtos) {
			valorTotal += produto.getValor();
		}
		return valorTotal;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
