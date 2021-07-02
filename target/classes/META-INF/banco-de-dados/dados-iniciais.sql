use algaworks_ecommerce;
insert into product (id, product_name, product_value, product_description, creation_date) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.', date_sub(sysdate(), interval 1 day));
insert into product (id, product_name, product_value, product_description, creation_date) values (2, 'Nikon', 1500.0, 'Uma nova perspectiva para suas fotos.', date_sub(sysdate(), interval 1 day ));
insert into product(id, product_description, product_name, product_value, creation_date) values (3, 'Notebook Gamer de ultima geração', 'Acer Predator ', 20.000, date_sub(sysdate(), interval 1 day ));
insert into product(id, product_description, product_name, product_value, creation_date) values (4,'Cafeteira Francesa 8Cm Jarra De Vidro 61766080 Tramontina', 'Cafeteira tramontina ', 289.90, date_sub(sysdate(), interval 1 day ));
insert into product(id, product_description, product_name, product_value, creation_date) values (5,'Mesmo um código ruim pode funcionar. Mas se ele não for limpo, pode acabar com uma empresa de desenvolvimento.', 'Livro -Código limpo: Habilidades práticas do Agile Software Capa comum – 8 setembro 2009', 84.90, date_sub(sysdate(), interval 1 day ));
insert into product(id, product_description, product_name, product_value, creation_date) values (6,'Jogo de tabuleiro,  Com esse jogo a diversão é garantida ! ', 'Master', 76.90, date_sub(sysdate(), interval 1 day ));
insert into product(id, product_description, product_name, product_value, creation_date) values (7,'he bible of all fundamental algorithms and the work that taught many of today’s software developers most of what they know about computer programming. —Byte, September 1995', 'The Art of Computer Programming, Volumes 1-4a Boxed Set Capa dura – 13 março 2011 ', 1958.40, date_sub(sysdate(), interval 1 day ));
insert into product(id, product_description, product_name, product_value, creation_date) values (8,'Prefácio de Alice Cherki. Prefácio de Jean-Paul Sartre. Posfácio de Mohammed Harbi. Grande clássico do terceiromundismo, obra capital e testamento político de Frantz Fanon', 'Os condenados da Terra', 700.0, date_sub(sysdate(), interval 1 day ));


insert into client (id, client_name, client_cpf) values (1, 'Mario Jorge', '123456798');
insert into client (id, client_name, client_cpf) values (2, 'Marcelo Mendes Lopes', '456789123');

insert into category(category_name) values ('Eletrônicos');
insert into category(category_name) values ('Celulares');
insert into category(category_name) values ('Livros');
insert into category(category_name) values ('Jogos');
insert into category(category_name) values ('Eletrodomésticos');
insert into category(category_name) values ('Cozinha');
insert into category(category_name) values ('Esporte');
insert into category(category_name) values ('Utensílios para casa');

insert into orders(id, client_id, creation_date, status, total) values (1, 1, date_sub(sysdate(), interval 5 day ) ,'PAID', 998.0);
insert into orders(id, client_id, creation_date, status, total) values (2, 2, date_sub(sysdate(),interval 5 day), 'PAID', 499.0);
insert into orders(id, client_id, creation_date, status, total) values (3, 1, date_sub(sysdate(), interval 5 day ) ,'WAITING', 700.0);
insert into orders(id, client_id, creation_date, status, total) values (4, 1, date_sub(sysdate(), interval 5 day ) ,'WAITING', 1958.40);



insert into order_item(order_id, product_id, product_price, quantity) values(1, 1, 499, 2);
insert into order_item(order_id, product_id, product_price, quantity) values(2, 1, 499, 1);
insert into order_item(order_id, product_id, product_price, quantity) values(3, 8, 700.0, 1);
insert into order_item(order_id, product_id, product_price, quantity) values(4, 7, 1958.40, 1);


insert into invoice(order_id, emission_date, xml) values(1, sysdate(), '<xml/>');

insert into product_category(product_id, category_id) values(1, 1);

insert into payment_credit(order_id, status, card_number) values(1, 'RECEIVED', '123');
insert into payment_credit(order_id, status, card_number) values(3, 'PROCESSING', '456');
insert into payment_credit(order_id, status, card_number) values(4, 'PROCESSING', '789');

