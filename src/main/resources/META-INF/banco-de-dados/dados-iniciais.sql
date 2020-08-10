use algaworks_ecommerce;
insert into product (id, product_name, product_value, product_description, creation_date) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.', date_sub(sysdate(), interval 1 day));
insert into product (id, product_name, product_value, product_description, creation_date) values (3, 'Nikon', 1500.0, 'Uma nova perspectiva para suas fotos.', date_sub(sysdate(), interval 1 day ));

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

insert into orders(id, client_id, creation_date, status, total) values (1, 1, date_sub(sysdate(), interval 5 day ) ,'WAITING', 998.0);
insert into orders(id, client_id, creation_date, status, total) values (2, 2, sysdate(), 'PAID', 499.0);

insert into order_item(order_id, product_id, product_price, quantity) values(1, 1, 499, 2);
insert into order_item(order_id, product_id, product_price, quantity) values(2, 1, 499, 1);

insert into invoice(order_id, emission_date, xml) values(1, sysdate(), '<xml/>');

insert into product_category(product_id, category_id) values(1, 1);

insert into payment_credit(order_id, status, card_number) values(1, 'PROCESSING', '123');
