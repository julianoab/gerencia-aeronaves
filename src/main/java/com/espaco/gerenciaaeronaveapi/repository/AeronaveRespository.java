package com.espaco.gerenciaaeronaveapi.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.espaco.gerenciaaeronaveapi.model.Aeronave;
import com.espaco.gerenciaaeronaveapi.model.AeronaveQtdeCadastradaPorFabricante;
import com.espaco.gerenciaaeronaveapi.model.QuantidadeCadastradaPorFabricante;

public interface AeronaveRespository extends JpaRepository<Aeronave, Long> {
	
	
//	EntityManager entityManger = fac;
	
	@Query("SELECT COUNT(a) FROM Aeronave a WHERE a.vendido = false")
	Integer quantidadeAeronaveNaoVendidas();
	
	@Query("SELECT a.fabricante AS nomeFabricante, COUNT(a.fabricante) AS quantidadeFabricante FROM Aeronave AS a GROUP BY a.fabricante")
    List<Object[]> quantidadeAeronaveCadastrada();

}
