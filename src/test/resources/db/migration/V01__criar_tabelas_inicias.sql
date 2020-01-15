CREATE TABLE IF NOT EXISTS categoria(
idCategoria BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
categoria VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS produto(
idProduto BIGINT(20) PRIMARY KEY,
produto VARCHAR(30) NOT NULL,
preco DECIMAL(10,2) NOT NULL,
quantidade INT NOT NULL,
descricao VARCHAR(30) NOT NULL,
foto MEDIUMBLOB,
idCategoria BIGINT(20) NOT NULL, 
FOREIGN KEY(idCategoria) REFERENCES categoria(idCategoria)
);

CREATE TABLE IF NOT EXISTS cliente(
idCliente BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
senha VARCHAR(150) NOT NULL,
rua VARCHAR(30) NOT NULL,
cidade VARCHAR(30) NOT NULL,
bairro VARCHAR(30) NOT NULL,
cep VARCHAR(9) NOT NULL,
estado VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedido(
idPedido BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
data DATETIME NOT NULL,
idCliente BIGINT(20) NOT NULL, 
status VARCHAR(20) NOT NULL,
sessao VARCHAR(30) NOT NULL,
FOREIGN KEY(idCliente) REFERENCES cliente(idCliente)
);

CREATE TABLE IF NOT EXISTS pedidoItens(
idItem BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
produto VARCHAR(30) NOT NULL,
valor DECIMAL(10,2) NOT NULL,
subtotal DECIMAL(10,2) NOT NULL,
quantidade INT NOT NULL,
idPedido BIGINT(20) NOT NULL, 
idProduto BIGINT(20) NOT NULL, 
FOREIGN KEY(idPedido) REFERENCES pedido(idPedido),
FOREIGN KEY(idProduto) REFERENCES produto(idProduto)
);

CREATE TABLE IF NOT EXISTS users(
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
senha VARCHAR(150) NOT NULL
);

INSERT INTO users(nome, email, senha) values ('admin','admin@adm.com','$2a$10$gWZ0SdMFMVlAvw7oR6TxF.MwOKWThwbcm6APSBEU/pXyn4epkK0YW');

INSERT INTO categoria(categoria) VALUES('limpeza');

insert into produto(idProduto,produto,preco,quantidade,descricao,foto,idCategoria) values(1,'detergente',2.00,10,'Deterg. Ypê', null,1);

INSERT INTO cliente(nome, email, senha,rua,cidade,bairro,cep,estado) values('teste','teste@teste.com','123456','rua teste', 'sao paulo', 'teste','12345678','Sao Paulo');
