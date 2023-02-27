DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS login_user;
DROP TABLE IF EXISTS user_role;

-- 書籍
CREATE TABLE book (
	id IDENTITY NOT NULL PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(100) NOT NULL
);

-- お問い合わせ
CREATE TABLE contact (
	id IDENTITY NOT NULL PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	email VARCHAR(100) NOT NULL,
	message VARCHAR(255) NOT NULL
);


-- ロール
CREATE TABLE roles (
	id INTEGER PRIMARY KEY,		-- ロールのID
	name VARCHAR(32) NOT NULL	-- ロールの名前
);

-- ユーザー
CREATE TABLE login_user (
	id INTEGER PRIMARY KEY,			-- ユーザーのID
	name VARCHAR(128) NOT NULL,		-- ユーザーの表示名
	email VARCHAR(256) NOT NULL,	-- メールアドレス（ログイン時に利用）
	password VARCHAR(128) NOT NULL	-- ハッシュ化済みのパスワード
);

-- ユーザーとロールの対応付け
CREATE TABLE user_role (
	user_id INTEGER,		-- ユーザーのID
	role_id INTEGER,		-- ロールのID
	CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id),
	CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES login_user(id),
	CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES roles(id)
);