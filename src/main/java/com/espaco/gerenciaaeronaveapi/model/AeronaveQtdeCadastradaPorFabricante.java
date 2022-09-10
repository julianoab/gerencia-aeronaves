package com.espaco.gerenciaaeronaveapi.model;

import javax.persistence.Entity;

public class AeronaveQtdeCadastradaPorFabricante {
	String fabricante;
	Integer quantidadeCadastrada;
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Integer getQuantidadeCadastrada() {
		return quantidadeCadastrada;
	}
	public void setQuantidadeCadastrada(Integer quantidadeCadastrada) {
		this.quantidadeCadastrada = quantidadeCadastrada;
	}
	
}
