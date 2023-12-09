	
	Create table endereco (
	
	id int PRIMARY KEY NOT NULL,
	Estado VARCHAR(20) not null,
	Cidade VARCHAR(20) not null,
	Bairro VARCHAR(20) not null,
	Logradouro VARCHAR(30) not null,
	Numero VARCHAR(10) not null,
	Complemento VARCHAR(10) not null
	);
	
	CREATE TABLE cliente(
	
	id int PRIMARY KEY NOT NULL,
	nome varchar(50) NOT NULL,
	cpf VARCHAR (30) NOT NULL,
	telefone VARCHAR(20) NOT NULL
	);
