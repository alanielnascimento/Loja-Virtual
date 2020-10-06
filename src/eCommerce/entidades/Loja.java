package eCommerce.entidades;

import java.util.ArrayList;
import java.util.List;

public class Loja {
	private List<Cliente> clientes;
	private List<Produto> produtos;

	public Loja() {
		super();
		this.clientes = new ArrayList<>();
		this.produtos = new ArrayList<>();
	}

	public void cadastrarCliente(Cliente cliente) {
		clientes.add(cliente);

	}

	public Sessao fazerLogin(String email, String senha) throws UsuarioDesconhecidoException, SenhaIncorretaException {
		for (Cliente cliente : clientes) {
			if (cliente.getEmail().equals(email)) {
				// Achei o cliente
				if (cliente.getSenha().equals(senha)) {
					// A senha é correta
					return new Sessao(cliente);
				} else {
					throw new SenhaIncorretaException(senha);
				}
			}
		}
		throw new UsuarioDesconhecidoException(email);

	}

	public void cadastrarProduto(Produto produto) {
		produtos.add(produto);

	}

	public List<Produto> getProduto() {
		return produtos;

	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getQuantasUnidadesVendidas(Produto produto) {
		int quant = 0;
		for (Cliente cliente : clientes) {
			for (Compra compra : cliente.getCompras()) {
				for (Produto p : compra.getProdutos()) {
					if (p.equals(produto)) {
						quant++;
					}

				}
			}
		}
		return quant;

	}

	public Produto getProdutoMaisVendido() {
		Produto maisVendido = produtos.get(0);
		int maxVezesVendido = getQuantasUnidadesVendidas(maisVendido);
		for (Produto p : produtos) {
			int quant = getQuantasUnidadesVendidas(p);
			if (quant > maxVezesVendido) {
				maxVezesVendido = quant;
				maisVendido = p;
			}

		}
		return maisVendido;

	}

	public double getValorVendidoTotal() {
		double valorVendido = 0;
		for (Produto compra : produtos) {
			valorVendido += compra.getValor();
		}

		return valorVendido;

	}

	public static void main(String[] args) {
		Loja lojinha = new Loja();
		Cliente c1 = new Cliente("Alaniel", "alaniel@gmail.com", "123", "Rua Borborema");
		Cliente c2 = new Cliente("Maria", "maria@gmail.com", "000", "Rua Peroba");
		Produto p1 = new Produto("Mouse", 20.00);
		Produto p2 = new Produto("Teclado", 100.00);
		Produto p3 = new Produto("Monitor", 200.00);

		lojinha.cadastrarCliente(c1);
		lojinha.cadastrarCliente(c2);
		lojinha.cadastrarProduto(p1);
		lojinha.cadastrarProduto(p2);
		lojinha.cadastrarProduto(p3);

		try {
			Sessao s1 = lojinha.fazerLogin("alaniel@gmail.com", "123");
			Sessao s2 = lojinha.fazerLogin("maria@gmail.com", "000");
			s1.adicionarAoCarrinho(p1);
			s1.adicionarAoCarrinho(p2);
			s1.finalizarCompra();
			s2.adicionarAoCarrinho(p1);
			s2.finalizarCompra();
		} catch (UsuarioDesconhecidoException ex) {
			System.err.println("Não foi possivel fazer login - Usuário Desconhecido");

		} catch (SenhaIncorretaException ex) {
			System.err.println("Não foi possivel fazer login - Senha Incorreta");

		}

		System.out.println("Compras que " + c1.getNome() + " fez: ");
		int numCompras = 1;
		for (Compra compra : c1.getCompras()) {
			System.out.println("\tCompra #" + numCompras + ":");
			numCompras++;
			for (Produto produto : compra.getProdutos()) {
				System.out.println("\t\t" + produto.getNome());
			}
			System.out.println("\tTotal: R$ " + compra.getValorTotal());
		}

	}

}
