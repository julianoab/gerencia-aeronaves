package com.espaco.gerenciaaeronaveapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espaco.gerenciaaeronaveapi.DTO.AeronaveDTO;
import com.espaco.gerenciaaeronaveapi.mapper.AeronaveMapper;
import com.espaco.gerenciaaeronaveapi.model.Aeronave;
import com.espaco.gerenciaaeronaveapi.model.AeronaveQtdeCadastradaPorFabricante;
import com.espaco.gerenciaaeronaveapi.repository.AeronaveRespository;
import com.espaco.gerenciaaeronaveapi.service.exceptions.EntidadeNaoEncontradaException;

@Service
public class AeronaveService {

	@Autowired
	private AeronaveRespository aeronaveRespository;

	@Autowired
	AeronaveMapper aeronaveMapper;

	public AeronaveDTO salvar(AeronaveDTO aeronave) {
		Aeronave aeronaveEntity = aeronaveRespository.save(aeronaveMapper.converterDtoParaEntidade(aeronave));
		return aeronaveMapper.converteEntidadeParaDto(aeronaveEntity);
	}

	public List<AeronaveDTO> listar() {
		List<Aeronave> aeronaves = aeronaveRespository.findAll();
		return aeronaveMapper.converteListaEntidadeParaDTO(aeronaves);
	}

	public AeronaveDTO buscarPorId(Long id) {
		Aeronave aeronaveEntity = aeronaveRespository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Aeronave não encontrada " + id));
		return aeronaveMapper.converteEntidadeParaDto(aeronaveEntity);
	}

	public void deletar(Long id) {
		aeronaveRespository.deleteById(id);
	}

	public AeronaveDTO atualizar(Long id, AeronaveDTO aeronaveDTO) {
		Aeronave aeronaveAtualizar = aeronaveMapper.converterDtoParaEntidade(buscarPorId(id));

		aeronaveAtualizar.setAno(aeronaveDTO.getAno());
		aeronaveAtualizar.setDescricao(aeronaveDTO.getDescricao());
		aeronaveAtualizar.setFabricante(aeronaveDTO.getFabricante());
		aeronaveAtualizar.setNome(aeronaveDTO.getNome());
		aeronaveAtualizar.setVendido(aeronaveDTO.getVendido());

		return aeronaveMapper.converteEntidadeParaDto(aeronaveRespository.save(aeronaveAtualizar));
	}

	public Integer retornaQuantidadeAeronaveNaoVendida() {
		return aeronaveRespository.quantidadeAeronaveNaoVendidas();
	}

	public List<AeronaveQtdeCadastradaPorFabricante> retornaQuantidadeAeronaveCadastradaPorFabricante() {
		List<AeronaveQtdeCadastradaPorFabricante> aeronaves = new ArrayList<>();
		for (Object obj : aeronaveRespository.quantidadeAeronaveCadastrada()) {
			AeronaveQtdeCadastradaPorFabricante aeronaveCadastrada = new AeronaveQtdeCadastradaPorFabricante();
			Object[] obUnit = (Object[]) obj;
			aeronaveCadastrada.setFabricante(String.valueOf(obUnit[0]));
			aeronaveCadastrada.setQuantidadeCadastrada(Integer.parseInt(String.valueOf(obUnit[1])));

			aeronaves.add(aeronaveCadastrada);
		}
		return aeronaves;
	}
}
