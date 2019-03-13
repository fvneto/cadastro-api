package com.vicente.funcionarios;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.vicente.cadastro.model.Funcionario;
import com.vicente.cadastro.repository.FuncionarioRepository;


/*
 * @RunWith (SpringRunner.class) é usado para fornecer uma ponte entre os 
 * recursos de teste do Spring Boot e o JUnit. Sempre que estivermos usando
 * os recursos de teste do Spring Boot nos testes JUnit, essa anotação será 
 * necessária.
 * 
 * 
 * @DataJpaTest fornece alguma configuração padrão necessária para testar a camada de persistência:
 *	- configurando H2, um banco de dados na memória
 *	- configurando o Hibernate, Spring Data e o DataSource
 *	- executando um @EntityScan
 *	- ativando o registro em log do SQL
 */

/**
 * @author Vicente
 * Date: 13/03/2019
 */
@Sql(value = "/inserirFuncionario.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database.sql", executionPhase= Sql.ExecutionPhase.AFTER_TEST_METHOD ) 
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
public class FuncionarioRepositoryTest{
	
	@Autowired
	//@Autowired(required=true)
	private FuncionarioRepository funcionarioRepository;
	
	Funcionario funcionario = new Funcionario("Roberio Felismino Brito", "Médico", new BigDecimal(70000.00));
	
	@Test
	public void testeTrueFindByName() throws Exception {

		
		Optional<Funcionario> found = funcionarioRepository.findByNome(funcionario.getNome());
		assertThat(found.isPresent()).isTrue();
		
		Funcionario pessoaFound = found.get();
		assertThat(pessoaFound.getNome()).isEqualTo(funcionario.getNome());
		assertThat(pessoaFound.getFuncao()).isEqualTo(funcionario.getFuncao());
		assertThat(pessoaFound.getSalario()).isEqualTo(funcionario.getSalario());
	}
	
	public void testeFailFindByNameNotExist() throws Exception {

		Optional<Funcionario> found = funcionarioRepository.findByNome("Ramiro Bernadino");
		assertThat(found.isPresent()).isTrue();
		assertThat(found.isPresent()).isFalse();
	}
	
}
