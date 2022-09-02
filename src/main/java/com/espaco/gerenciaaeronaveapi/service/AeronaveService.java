package com.espaco.gerenciaaeronaveapi.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espaco.gerenciaaeronaveapi.model.Aeronave;
import com.espaco.gerenciaaeronaveapi.repository.AeronaveRespository;
import com.espaco.gerenciaaeronaveapi.service.exceptions.EntidadeNaoEncontradaException;

@Service
public class AeronaveService {

	@Autowired
	private AeronaveRespository aeronaveRespository;
	
	public Aeronave salvar(Aeronave aeronave) {
		return aeronaveRespository.save(aeronave);
	}
	
	public List<Aeronave> listar() {
		return aeronaveRespository.findAll();
	}
	
	public Aeronave buscarPorId(Long id) {
		return aeronaveRespository.findById(id).orElseThrow(
				() -> new EntidadeNaoEncontradaException("Aeronave não encontrada " + id));
	}
	 
	public void deletar(Long id) {
		aeronaveRespository.deleteById(id);
	}

	public Aeronave atualizar(@Valid Aeronave aeronave) {
		Aeronave aeronaveAtualizar =  buscarPorId(aeronave.getId());
		
		if(aeronaveAtualizar == null) {
			
		}
		
		aeronaveAtualizar.setAno(aeronave.getAno());
		aeronaveAtualizar.setDescricao(aeronave.getDescricao());
		aeronaveAtualizar.setFabricante(aeronave.getFabricante());
		aeronaveAtualizar.setNome(aeronave.getNome());
		aeronaveAtualizar.setVendido(aeronave.getVendido());
		
		return aeronaveRespository.save(aeronave);
	}
}
