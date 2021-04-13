DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS QUESTION;

CREATE TABLE USERS (
    userId INT AUTO_INCREMENT PRIMARY KEY, 
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    userscore INT
);

INSERT INTO USERS (username, password, userscore) VALUES
    ('user1', '1234', 150),
    ('user2', '1234', 0),
    ('user3', '1234', 10);