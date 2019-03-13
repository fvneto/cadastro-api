CREATE TABLE funcionario (
	id bigint auto_increment not null,
	nome_funcionario varchar(80) not null,
	funcao_funcionario varchar(200) not null,
	salario_funcionario decimal(10,2),
	
	primary key (id)
);