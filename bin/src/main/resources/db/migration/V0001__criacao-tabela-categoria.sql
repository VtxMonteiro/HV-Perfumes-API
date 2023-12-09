

create table categoria (

	id int auto_increment PRIMARY KEY Not NULL,
	perfumes_masculinos VARCHAR(20) Not null,
	perfumes_femininos VARCHAR(20) NOT NULL,
	perfumes_unissex VARCHAR(20) NOT NULL,	
	alta_perfumaria VARCHAR(20) NOT NULL,
	status TINYINT DEFAULT 1
);