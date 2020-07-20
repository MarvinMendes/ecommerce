use algaworks_ecommerce;
insert into product (id, product_name, product_value, product_description, creation_date) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.', date_sub(sysdate(), interval 1 day));
insert into product (id, product_name, product_value, product_description, creation_date) values (3, 'Nikon', 1500.0, 'Uma nova perspectiva para suas fotos.', date_sub(sysdate(), interval 1 day ));
insert into client (id, client_name) values (2, 'Mario Jorge');
insert into client (id, client_name) values (3, 'Marcelo Mendes Lopes');

insert into orders(id, client_id, status, total) values (1, 2, 'WAITING', 2300);

insert into order_item(order_id, product_id, product_price, quantity) values (1, 1, 5.0, 2);