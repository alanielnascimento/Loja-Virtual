package eCommerce.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String email;
	private String senha;
	private String endereco;
	private List<Compra> compras;

	public Cliente(String nome, String email, String senha, String endereco) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.compras = new ArrayList<>();
	}

	public double getValorGastoTotal() {
		double gastoTotal = 0.0;
		for (Compra compra : compras) {
			gastoTotal += compra.getValorTotal();
		}
		return gastoTotal;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
