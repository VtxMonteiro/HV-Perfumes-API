package com.gvendas.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id 
	private int id;
	
	@Column(name = "produto")
	private String produto;
	
	@Column(name = "quant_produto")
	private String qtdProduto;
	
	@Column(name = "subtotal")
	private int subtotal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(String qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public int getSub() {
		return subtotal;
	}
	public void setSub(int sub) {
		this.subtotal = sub;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, produto, qtdProduto, subtotal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		return id == other.id && Objects.equals(produto, other.produto) && Objects.equals(qtdProduto, other.qtdProduto)
				&& subtotal == other.subtotal;
	}
	
	
}
