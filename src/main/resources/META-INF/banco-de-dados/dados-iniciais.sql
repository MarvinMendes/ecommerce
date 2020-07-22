use algaworks_ecommerce;
insert into product (id, product_name, product_value, product_description, creation_date) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.', date_sub(sysdate(), interval 1 day));
insert into product (id, product_name, product_value, product_description, creation_date) values (3, 'Nikon', 1500.0, 'Uma nova perspectiva para suas fotos.', date_sub(sysdate(), interval 1 day ));
insert into client (id, client_name) values (1, 'Mario Jorge');
insert into client (id, client_name) values (2, 'Marcelo Mendes Lopes');

insert into orders(id, client_id, request_date, status, total) values (1, 1, sysdate() ,'WAITING', 998.0);
insert into orders(id, client_id, request_date, status, total) values (2, 2, sysdate(), 'PAID', 499.0);

insert into order_item(order_id, product_id, product_price, quantity) values(1, 1, 499, 2);
insert into order_item(order_id, product_id, product_price, quantity) values(2, 1, 499, 1);

insert into payment_credit(order_id, status, card_number) values(1, 'PROCESSING', '123');
