CREATE TABLE USERS (
    userid INT PRIMARY KEY AUTO_INCREMENT,
    usernickname VARCHAR(15) NOT NULL,
    userpassword VARCHAR(15) NOT NULL,
    usermail VARCHAR(20) NOT NULL,
    username VARCHAR(15) NOT NULL,
    usersurname VARCHAR(15) NOT NULL,
    country VARCHAR(15) NOT NULL,
    city VARCHAR(15) NOT NULL
);