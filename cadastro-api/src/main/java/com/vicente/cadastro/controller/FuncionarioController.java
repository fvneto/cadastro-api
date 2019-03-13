package com.vicente.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vicente.cadastro.model.Funcionario;
import com.vicente.cadastro.repository.FuncionarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarios;
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarios.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		
		Optional<Funcionario> funcionario = funcionarios.findById(id);
		
		if (!funcionario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcionario.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario adicionar(@Valid @RequestBody Funcionario funcionario) {
		
		Optional<Funcionario> oportunidadeExistente = funcionarios
				.findByNome(funcionario.getNome());
		
		if (oportunidadeExistente.isPresent()) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"funcionario ja existente na base de dados");
		}
		
		return funcionarios.save(funcionario);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Funcionario funcionario) {
		
		Optional<Funcionario> existente = funcionarios.findById(id);
		
		if (existente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(funcionario, existente.get(), "id");
		
		funcionarios.save(existente.get());
		
		return ResponseEntity.ok(funcionario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		
		Optional<Funcionario> funcionario = funcionarios.findById(id);
		
		if (!funcionario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		funcionarios.delete(funcionario.get());
		
		return ResponseEntity.noContent().build();
	}

} // FuncionarioController