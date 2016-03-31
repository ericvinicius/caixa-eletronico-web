drop database caixaEletronico;
CREATE DATABASE caixaEletronico;
USE caixaEletronico;
CREATE TABLE
conta(
	banco VARCHAR(45) NOT NULL,
	numero INTEGER(6) NOT NULL auto_increment,
	agencia INTEGER(6) NOT NULL,
	senha INTEGER(4) NOT NULL,
	codAcesso INTEGER(4),
	titular VARCHAR(45) NOT NULL,
	saldo DECIMAL(19,2) NOT NULL,
	bloqueio INTEGER(1) DEFAULT 1,
	PRIMARY KEY (numero)
);

alter table conta auto_increment = 100000;

CREATE TABLE
movimentacao(
	id INTEGER(4) UNIQUE AUTO_INCREMENT,
	fromNumero INTEGER(6) NOT NULL,
	tipoOperacao VARCHAR(20) NOT NULL,
	descricao  VARCHAR(45),
	valor DECIMAL(19,2) NOT NULL,
	tipoMovimentacao VARCHAR(20) NOT NULL,
	toNumero INTEGER(6),
	date TIMESTAMP
);