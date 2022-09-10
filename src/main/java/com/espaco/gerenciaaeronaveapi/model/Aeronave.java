package com.espaco.gerenciaaeronaveapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aeronave")
public class Aeronave implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String fabricante;
	
	@NotNull
	private Integer ano;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Boolean vendido;
//	private LocalDateTime created;
//	private LocalDateTime updated;
	
	public Aeronave() {}

	
	public Aeronave(Long id, String nome, String marca, Integer ano, String descricao, Boolean vendido) {
	this.id = id;
	this.nome = nome; // modelo
	this.fabricante = marca;
	this.ano = ano;
	this.descricao = descricao;
	this.vendido = vendido;
}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String marca) {
		this.fabricante = marca;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Boolean getVendido() {
		return vendido;
	}
	
	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	
//	public LocalDateTime getCreated() {
//		return created;
//	}
//	
//	public void setCreated(LocalDateTime created) {
//		this.created = created;
//	}
//	
//	public LocalDateTime getUpdated() {
//		return updated;
//	}
//	
//	public void setUpdated(LocalDateTime updated) {
//		this.updated = updated;
//	}
}
