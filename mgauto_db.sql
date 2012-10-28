-- to get following script working on linux
-- mysql -u [username] -p[password] [database_name] < [this_script.sql]

SET FOREIGN_KEY_CHECKS=0; -- temporary solution

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
    role ENUM('admin','user'),
    join_date DATETIME,
    PRIMARY KEY (user_id),
    UNIQUE(username)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS general_ads ;
CREATE TABLE general_ads(
    ad_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    descr TEXT NOT NULL,
    user_id INT NOT NULL,
    add_date DATETIME,
    valid_to DATETIME,
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
    add_date DATETIME,
    valid_to DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    PRIMARY KEY (ad_id)
) ENGINE=INNODB;

DROP TABLE IF EXISTS prices;
CREATE TABLE prices(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    price DECIMAL(7,2),
    descr TEXT,
    PRIMARY KEY (id)
);


-- users
insert into users (username, full_name, hash, salt, email, phone, address, role) values('admin', 'Admin Adminov', '733b8fa4b833ca9d3baec9470d7f467614e85057', 'NLVBGCODGE', 'asdsa@dasdsa.dasda' ,'123131313', 'dasdada', 'admin');
insert into users (username, full_name, hash, salt, email, phone, address, role) values('xklakoux', 'Artur Staniec', 'e8e8921b196428ac5ef1f05265d360f2078910af', 'INAEBQWCKQ', 'adsad@dasdsa.ds', '123131313', 'dasdada', 'admin');

insert into general_ads (title, descr, user_id) values("Garage for sale", "lot of space, super nice", 1);
insert into general_ads (title, descr, user_id) values("Viagra", "will get you up and running in seconds", 0);
insert into general_ads (title, descr, user_id) values("Rooms for students", "without furniture or anything, ideal for students!", 1);
insert into general_ads (title, descr, user_id) values("Lollipops", "sweet and stuff, for kids and everyone", 1);
insert into general_ads (title, descr, user_id) values("Computers", "used, new, for your grandma and grandpa too", 1);
insert into general_ads (title, descr, user_id) values("Cars", "other super site for cars, forget about this", 1);

insert into prices (name, price, descr) values ("1 month", 20, "normal price");
insert into prices (name, price, descr) values ("2 month", 16, "at least 2 months 10/month discount!");
insert into prices (name, price, descr) values ("3 month", 8, "at least 3 months ultra discount!");

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date)
values ('Brand-new offer', 'BMW', 'CLK', '500', '12345', '2006', 29000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now());
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date)
values ('Recent offer', 'Audi', 'R8', '800', '12345', '2012', 59000.5, 3000, 'Red', 'The car is in a perfect condition.', 1, 'auto', now());
