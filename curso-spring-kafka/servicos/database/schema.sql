CREATE DATABASE bontempo_store_produtos;

CREATE TABLE produtos (
  codigo serial NOT NULL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  valor_unitario DECIMAL(16, 2) NOT NULL
);

CREATE DATABASE bontempo_store_clientes;

CREATE TABLE clientes (
  codigo serial NOT NULL PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  cpf CHAR(11) NOT NULL,
  logradouro VARCHAR(100),
  numero VARCHAR(100),
  bairro VARCHAR(100),
  email VARCHAR(150),
  telefone VARCHAR(20)
);

CREATE DATABASE bontempo_store_pedidos;

CREATE TABLE pedido (
  codigo serial NOT NULL PRIMARY KEY,
  codigo_cliente BIGINT NOT NULL,
  data_pedido TIMESTAMP NOT NULL DEFAULT now(),
  chave_pagamento TEXT,
  observacoes TEXT,
  status VARCHAR(20) CHECK (
    status IN (
      'REALIZADO',
      'PAGO',
      'FATURADO',
      'ENVIADO',
      'ERRO_PAGAMENTO',
      'PREPARANDO_ENVIO'
    )
  ),
  total DECIMAL(16, 2) NOT NULL,
  codigo_rastreio VARCHAR(255),
  url_nf TEXT
);

CREATE TABLE item_pedido (
  codigo serial NOT NULL PRIMARY KEY,
  codigo_pedido BIGINT NOT NULL REFERENCES pedido (codigo),
  codigo_produto BIGINT NOT NULL,
  quantidade INT NOT NULL,
  valor_unitario DECIMAL(16, 2) NOT NULL
);