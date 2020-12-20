DROP DATABASE IF EXISTS mygroupwere;
CREATE DATABASE mygroupwere;
GRANT ALL ON mygroupwere.* TO test;
USE mygroupwere;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
role TEXT NOT NULL,
updated_at datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)DEFAULT CHARACTER SET=utf8;