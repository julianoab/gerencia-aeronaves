package com.espaco.gerenciaaeronaveapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espaco.gerenciaaeronaveapi.model.Aeronave;

public interface AeronaveRespository extends JpaRepository<Aeronave, Long> {

}
