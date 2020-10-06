package eCommerce.entidades;

import java.util.ArrayList;
import java.util.List;

public class Sessao {
	private Cliente cliente;
	private List<Produto> carrinhoDeCompras;

	public Sessao(Cliente cliente) {
		this.cliente = cliente;
		this.carrinhoDeCompras = new ArrayList<>();

	}

	public void adicionarAoCarrinho(Produto produto) {
		carrinhoDeCompras.add(produto);

	}

	public void finalizarCompra() {
		Compra novaCompra = new Compra();
		novaCompra.getProdutos().addAll(carrinhoDeCompras);
		cliente.getCompras().add(novaCompra);

	}

	public double getValorTotalDoCarrinho() {
		double valorTotal = 0.0;
		for (Produto produto : carrinhoDeCompras) {
			valorTotal += produto.getValor();
		}
		return valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getCarrinhoDeCompras() {
		return carrinhoDeCompras;
	}

	public void setCarrinhoDeCompras(List<Produto> carrinhoDeCompras) {
		this.carrinhoDeCompras = carrinhoDeCompras;
	}

}
