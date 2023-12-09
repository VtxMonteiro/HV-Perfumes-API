package com.gvendas.entidades;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {

	@Id
	private int id;
	
	@Column (name = "Data")
	private String data;
	
	@Column (name = "hora")
	private String hora;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, hora, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Venda)) {
			return false;
		}
		Venda other = (Venda) obj;
		return Objects.equals(data, other.data) && Objects.equals(hora, other.hora) && id == other.id;
	}
	
	
	
	
}
