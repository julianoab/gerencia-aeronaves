package com.espaco.gerenciaaeronaveapi.resource;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.espaco.gerenciaaeronaveapi.model.Aeronave;
import com.espaco.gerenciaaeronaveapi.service.AeronaveService;

@RestController
@RequestMapping("/aeronaves")
public class AeronaveResource {
	
	@Autowired
	AeronaveService aeronaveService;
	
	@GetMapping
	public List<Aeronave> listar() {
		return aeronaveService.listar();
	}
	
	@PostMapping
	public ResponseEntity<Aeronave> criar(@RequestBody Aeronave aeronave) {
		Aeronave aeronaveCriada = aeronaveService.salvar(aeronave);
		return ResponseEntity.status(HttpStatus.CREATED).body(aeronaveCriada);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aeronave> buscarPeloCodigo(@PathVariable Long id) {
		 Aeronave aeronave = aeronaveService.buscarPorId(id);
		return ResponseEntity.ok().body(aeronave);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Aeronave> atualizar(@Valid @RequestBody Aeronave aeronave) {
		Aeronave aeronaveSalva = aeronaveService.atualizar(aeronave);
		return ResponseEntity.ok(aeronaveSalva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		 aeronaveService.deletar(id);
	}

}
