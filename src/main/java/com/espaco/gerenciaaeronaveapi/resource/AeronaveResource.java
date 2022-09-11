package com.espaco.gerenciaaeronaveapi.resource;

import java.util.List;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.espaco.gerenciaaeronaveapi.DTO.AeronaveDTO;
import com.espaco.gerenciaaeronaveapi.mapper.AeronaveMapper;
import com.espaco.gerenciaaeronaveapi.model.Aeronave;
import com.espaco.gerenciaaeronaveapi.model.AeronaveQtdeCadastradaPorFabricante;
import com.espaco.gerenciaaeronaveapi.service.AeronaveService;

@RestController
@RequestMapping("/aeronaves")
public class AeronaveResource {
	
	@Autowired
	AeronaveService aeronaveService;
	
	@GetMapping
	public ResponseEntity<List<AeronaveDTO>> listar() {
		return  ResponseEntity.ok().body(aeronaveService.listar());
	}
	
	@PostMapping
	public ResponseEntity<AeronaveDTO> criar(@RequestBody AeronaveDTO aeronaveDTO) {
		AeronaveDTO aeronaveCriada = aeronaveService.salvar(aeronaveDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(aeronaveCriada);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AeronaveDTO> buscarPeloCodigo(@PathVariable Long id) {
		 AeronaveDTO aeronaveDTO = aeronaveService.buscarPorId(id);
		return ResponseEntity.ok().body(aeronaveDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AeronaveDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AeronaveDTO aeronave) {
		AeronaveDTO aeronaveSalva = aeronaveService.atualizar(id, aeronave);
		return ResponseEntity.ok(aeronaveSalva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		 aeronaveService.deletar(id);
	}
	
	@GetMapping("/nao-vendida")
	public Integer quantidadeNaoVendida() {
		Integer quantidadeNaoVendida = aeronaveService.retornaQuantidadeAeronaveNaoVendida();
		return quantidadeNaoVendida;
	}
	
	@GetMapping("/quantidade-cadastrada-fabricante")
	public ResponseEntity<List<AeronaveQtdeCadastradaPorFabricante>> retornaQuantidadeAeronaveCadastradaPorFabricante() {
		List<AeronaveQtdeCadastradaPorFabricante> quantidadeCadastrada = aeronaveService.retornaQuantidadeAeronaveCadastradaPorFabricante();
		return ResponseEntity.ok().body(quantidadeCadastrada);
	}

}
