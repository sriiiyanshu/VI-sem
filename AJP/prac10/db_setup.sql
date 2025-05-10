
CREATE DATABASE IF NOT EXISTS userdb;


USE userdb;


CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    fullname VARCHAR(100),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO users (username, password, fullname, email) VALUES 
('admin', 'admin123', 'Administrator', 'admin@example.com'),
('user1', 'password1', 'Sample User', 'user1@example.com');


SELECT * FROM users;