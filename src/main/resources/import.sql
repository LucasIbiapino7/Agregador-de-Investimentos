INSERT INTO tb_user (username, email, password) VALUES ('lucas', 'lucas@gmail.com', '1234567')
INSERT INTO tb_user (username, email, password) VALUES ('maria', 'maria@gmail.com', '1234567')

INSERT INTO tb_account (description, user_id) VALUES ('conta do lucas', 1)
INSERT INTO tb_account (description, user_id) VALUES ('conta do lucas 2', 1)
INSERT INTO tb_account (description, user_id) VALUES ('conta do maria', 2)

INSERT INTO tb_billing_address (account_id, street, number) VALUES (1, 'raposa', 150)

INSERT INTO tb_stock (stock_id, description) VALUES ('AMZN', 'ação da Amazon')

INSERT INTO tb_account_stock (account_id, stock_id, quantity) VALUES (1, 'AMZN', 20)


