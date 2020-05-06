package com.vicente.cadastro.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vicente.cadastro.model.Funcionario;
import com.vicente.cadastro.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionrioRepository;

	public Funcionario atualizar(Long id, Funcionario funcionario) {

	  Funcionario funcionarioSalva = this.funcionrioRepository.findById(id)
	      .orElseThrow(() -> new EmptyResultDataAccessException(1));

	  BeanUtils.copyProperties(funcionario, funcionarioSalva, "id");

	  return this.funcionrioRepository.save(funcionarioSalva);
		
	} // atualizar

} // FuncionarioService
