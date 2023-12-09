CREATE TABLE item (
		id int PRIMARY KEY not null,
		produto VARCHAR(20) not null,
		quant_produto VARCHAR(100) not null,
		subtotal INT not null
	);

CREATE TABLE venda(
	id int PRIMARY KEY not null,
	Data VARCHAR (20) not null,
	hora VARCHAR (20) not null
	);

