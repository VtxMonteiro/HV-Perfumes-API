package com.gvendas.entidades;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	private int id;
	
	
	@Column(name = "nome")
	private String nome;
	
	@Column (name = "valor")
	private int valor;
	private String imagem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, valor);
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
		return id == other.id && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	
	
}
