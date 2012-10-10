-- to get following script working on linux
-- mysql -u [username] -p[password] [database_name] < [this_script.sql]

SET FOREIGN_KEY_CHECKS=0; #temporary solution

DROP TABLE IF EXISTS users;
CREATE TABLE users(
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    full_name VARCHAR(70) NOT NULL,
    hash VARCHAR(100) NOT NULL,
    salt VARCHAR(10) NOT NULL,
    email VARCHAR(40) NOT NULL,
    phone VARCHAR(15),
    address VARCHAR(50),
    role INT,
    join_date DATETIME,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS general_ads ;
CREATE TABLE general_ads(
    ad_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    descr TEXT NOT NULL,
    add_date DATETIME,
    user_id INT NOT NULL,
    PRIMARY KEY (ad_id),
    FOREIGN KEY (user_id) references users(user_id) ON DELETE CASCADE
) ENGINE=INNODB;

DROP TABLE IF EXISTS auto_ads;
CREATE TABLE auto_ads(
    ad_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    brand VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
    engine VARCHAR (20) NOT NULL,
    registration_number VARCHAR(30) NOT NULL,
    years VARCHAR (4) NOT NULL,
    price DECIMAL(7,2),
    mileage INT,
    colour VARCHAR(20) NOT NULL,
    description TEXT,
    user_id INT,
    auto_moto ENUM('auto','moto'),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    PRIMARY KEY (ad_id)
) ENGINE=INNODB;

DROP TABLE IF EXISTS prices;
CREATE TABLE prices(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    price DECIMAL(3,2),
    descr TEXT,
    PRIMARY KEY (id)
);
