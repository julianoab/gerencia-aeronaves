package com.espaco.gerenciaaeronaveapi.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.espaco.gerenciaaeronaveapi.model.Aeronave;

public interface AeronaveRespository extends JpaRepository<Aeronave, Long> {
	
	@Query("SELECT COUNT(a) FROM Aeronave a WHERE a.vendido = false")
	Integer quantidadeAeronaveNaoVendidas();
	
//	@Query("SELECT a.fabricante, COUNT(a) FROM Aeronave a GROUP BY a.fabricante")
//	List<Aeronave> quantidadeAeronaveCadastrada();

}
