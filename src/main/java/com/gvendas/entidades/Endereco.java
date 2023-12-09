package com.gvendas.entidades;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")

public class Endereco {

	@Id
	private int id;
	
	@Column (name = "Estado")
	private String estado;
	
	@Column (name = "Cidade")
	private String cidade;
	
	@Column (name = "Bairro")
	private String bairro;
	
	@Column (name = "Logradouro")
	private String logradouro;
	
	@Column (name = "Numero")
	private String numero;
	
	@Column (name = "Complemento")
	private String complemento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, complemento, estado, id, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(estado, other.estado)
				&& id == other.id && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}

	

}