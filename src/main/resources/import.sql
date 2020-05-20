insert into cozinha (nome) values ('Tailandesa'), ('Indiana'), ('Japonesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Mangai', 7.5,1), ('San Paolo', 10.3, 1), ('Casa Palma', 5.7,2);

insert into forma_pagamento (descricao) values ('Cartão de Crédito'), ('Cartão de Débito'), ('Dinheiro'), ('Alelo Refeição');

insert into permissao (nome, descricao) values ('CONSULTA_RESTAURANTE','Permite consultar restaurantes'), ('CONSULTA_CLIENTE', 'Permite consultar clientes'), ('CONSULTA_PEDIDO', 'Permite consultar pedidos');

insert into estado (nome, sigla) values ('São Paulo', 'SP'), ('Paraíba', 'PB'), ('Rio Grande do Norte', 'RN'), ('Pernambuco', 'PE'), ('Ceará', 'CE');

insert into cidade (nome, estado_id) values ('São Paulo', 1), ('João Pessoa', 2), ('Natal', 3), ('Recife', 4), ('Fortaleza', 5);
