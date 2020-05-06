package com.vicente.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.vicente.cadastro.event.RecursoCriadoEvent;
import com.vicente.cadastro.model.Funcionario;
import com.vicente.cadastro.repository.FuncionarioRepository;
import com.vicente.cadastro.service.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarios;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Funcionario> listar() {
		
		return funcionarios.findAll();
		
	} // listar();

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		
	  return this.funcionarios.findById(id)
	      .map(funcionario -> ResponseEntity.ok(funcionario))
	      .orElse(ResponseEntity.notFound().build());
			
	} // buscar()
	
	@PostMapping
	public ResponseEntity<Funcionario> adicionar(@Valid @RequestBody Funcionario funcionario,
			HttpServletResponse  response) {
		
		//Verificar se ja existe no BD
		Optional<Funcionario> funcionarioExistente = funcionarios
				.findByNome(funcionario.getNome());
		
		//Tratamneto do retorno da exception
		if (funcionarioExistente.isPresent()) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"funcionario ja existente na base de dados"); 
		}
		
		//Adicionando no retorno o path juntamente com o id 
		Funcionario funcSalvo = funcionarios.save(funcionario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, funcSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(funcSalvo);
		
	} // adicionar()
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Funcionario funcionario) {
		
		Funcionario funcionarioSalva = funcionarioService.atualizar(id, funcionario);
		return ResponseEntity.ok(funcionarioSalva);
		
	} // atualizar

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		
		this.funcionarios.deleteById(id);
		
	} // remover

} // FuncionarioController