package com.gvendas.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")

public class Cliente {
			
			@Id 
			private int id;
			
			@Column(name = "nome")
			private String nome;
			
			@Column(name = "cpf")
			private String cpf;
			
			@Column(name = "telefone")
			private String telefone;

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

			public String getCpf() {
				return cpf;
			}

			public void setCpf(String cpf) {
				this.cpf = cpf;
			}

			public String getTelefone() {
				return telefone;
			}

			public void setTelefone(String telefone) {
				this.telefone = telefone;
			}

			@Override
			public int hashCode() {
				return Objects.hash( cpf, id, nome, telefone);
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj) {
					return true;
				}
				if (!(obj instanceof Cliente)) {
					return false;
				}
				Cliente other = (Cliente) obj;
				return Objects.equals(cpf, other.cpf) && id == other.id
						&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
			}

			
	}


