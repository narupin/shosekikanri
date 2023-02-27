INSERT INTO book(title,author) VALUES('ハリーポッターと賢者の石','J.K.ローリング');
INSERT INTO book(title,author) VALUES('容疑者Xの献身','東野圭吾');
INSERT INTO book(title,author) VALUES('星の王子様','サン＝テグジュペリ');

INSERT INTO contact(name,email,message) VALUES('太郎','admin@example.com'
	,'こちらはお問い合わせフォームです');

INSERT INTO roles(id, name) VALUES(1, 'ROLE_GENERAL');
INSERT INTO roles(id, name) VALUES(2, 'ROLE_ADMIN');

-- password = "general"
INSERT INTO login_user(id, name, email, password) VALUES(1, '一般ユーザー',
	'general@example.com', '$2a$10$6fPXYK.C9rCWUBifuqBIB.GRNU.nQtBpdzkkKis8ETaKVKxNo/ltO');

-- password = "admin"
INSERT INTO login_user(id, name, email, password) VALUES(2, '管理ユーザー',
	'admin@example.com', '$2a$10$SJTWvNl16fCU7DaXtWC0DeN/A8IOakpCkWWNZ/FKRV2CHvWElQwMS');

INSERT INTO user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 2);