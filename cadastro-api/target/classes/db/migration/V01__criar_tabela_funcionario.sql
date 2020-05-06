CREATE TABLE funcionario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	funcao VARCHAR(80) NOT NULL,
	salario DECIMAL(10,2),
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Pedro Bo',  "Pedreiro", 2000.00, 'Rua do Prado', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Renata Rita', "Pedreiro", 2000.00, 'Rua do Exame', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Joao Santos', "Pedreiro", 2000.00, 'Rua da 10 do Fort', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Fred Pereira', "Pedreiro", 2000.00, 'Rua do Sa', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Joaquin Mariano', "Pedreiro", 2000.00, 'Av Pedro Firmino', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Sebastiao Barbosa', "Pedreiro", 2000.00, 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Rafael Medeiros', "Pedreiro", 2000.00,'Rua da Andorinha', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Rodolfo Gomes', "Pedreiro", 2000.00, 'Rua do Samba', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Sandro Oliveira', "Pedreiro", 2000.00, 'Rua Professor Ada', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO funcionario (nome, funcao, salario, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Carlinhos Brauw', "Pedreiro", 2000.00, 'Rua da Aleluia', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);

