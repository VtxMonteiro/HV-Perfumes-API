package com.gvendas.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	private int id;
	
	@Column(name = "perfumes_masculinos")
	private String perfumeMasculino;
	
	@Column(name = "perfumes_femininos")
	private String perfumeFeminino;
	
	@Column(name = "perfumes_unissex")
	private String perfumeUnissex;
	
	@Column(name = "alta_perfumaria")
	private String altaPerfumaria;
	
	@Column (name = "status")
	private boolean status;
	
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerfumeMasculino() {
		return perfumeMasculino;
	}
	public void setPerfumeMasculino(String perfumeMasculino) {
		this.perfumeMasculino = perfumeMasculino;
	}
	public String getPerfumeFeminino() {
		return perfumeFeminino;
	}
	public void setPerfumeFeminino(String perfumeFeminino) {
		this.perfumeFeminino = perfumeFeminino;
	}
	public String getPerfumeUnissex() {
		return perfumeUnissex;
	}
	public void setPerfumeUnissex(String perfumeUnissex) {
		this.perfumeUnissex = perfumeUnissex;
	}
	public String getAltaPerfumaria() {
		return altaPerfumaria;
	}
	public void setAltaPerfumaria(String altaPerfumaria) {
		this.altaPerfumaria = altaPerfumaria;
	}
	@Override
	public int hashCode() {
		return Objects.hash(altaPerfumaria, id, perfumeFeminino, perfumeMasculino, perfumeUnissex, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) obj;
		return Objects.equals(altaPerfumaria, other.altaPerfumaria) && id == other.id
				&& Objects.equals(perfumeFeminino, other.perfumeFeminino)
				&& Objects.equals(perfumeMasculino, other.perfumeMasculino)
				&& Objects.equals(perfumeUnissex, other.perfumeUnissex) && status == other.status;
	}
	
}
