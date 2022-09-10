package com.espaco.gerenciaaeronaveapi.mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;

import com.espaco.gerenciaaeronaveapi.DTO.AeronaveDTO;
import com.espaco.gerenciaaeronaveapi.model.Aeronave;

@Configuration
public class AeronaveMapper {
	
	public List<AeronaveDTO> converteListaEntidadeParaDTO(List<Aeronave> aeronaves) {
		return aeronaves.stream().map(this::converteEntidadeParaDto).collect(Collectors.toList());
	}

	public Aeronave converterDtoParaEntidade(AeronaveDTO aeronaveDTO) {
		Aeronave aeronave = new Aeronave();
		aeronave.setId(aeronaveDTO.getId());
		aeronave.setNome(aeronaveDTO.getNome());
		aeronave.setFabricante(aeronaveDTO.getFabricante());
		aeronave.setAno(aeronaveDTO.getAno());
		aeronave.setDescricao(aeronaveDTO.getDescricao());
		aeronave.setVendido(aeronaveDTO.getVendido());

		return aeronave;
	}

	public AeronaveDTO converteEntidadeParaDto(Aeronave aeronave) {
		AeronaveDTO aeronaveDTO = new AeronaveDTO();
		aeronaveDTO.setId(aeronave.getId());
		aeronaveDTO.setAno(aeronave.getAno());
		aeronaveDTO.setDescricao(aeronave.getDescricao());
		aeronaveDTO.setFabricante(aeronave.getFabricante());
		aeronaveDTO.setNome(aeronave.getNome());
		aeronaveDTO.setVendido(aeronave.getVendido());
		
		return aeronaveDTO;
	}

}
