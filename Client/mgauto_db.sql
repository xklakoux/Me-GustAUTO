-- to get following script working on linux
-- mysql -u [username] -p[password] [database_name] < [this_script.sql]

SET FOREIGN_KEY_CHECKS=0;

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
    next_percent_discount INT default 0,
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
    months INT NOT NULL,
    valid boolean NOT NULL default 0,
    paid boolean NOT NULL default 0,
    PRIMARY KEY (ad_id),
    FOREIGN KEY (user_id) references users(user_id) ON DELETE CASCADE
) ENGINE=INNODB;

DROP TABLE IF EXISTS auto_ads;
    ad_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    brand VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
    engine VARCHAR (20) NOT NULL,
    registration_number VARCHAR(29) NOT NULL,
    years VARCHAR (4) NOT NULL,
    price DECIMAL(7,2),
    mileage INT,
    colour VARCHAR(20) NOT NULL,
    description TEXT,
    user_id INT,
    auto_moto ENUM('auto','moto'),
    add_date DATETIME,
    valid_to DATETIME,
    months INT NOT NULL,
    paid boolean NOT NULL default 0,
    valid boolean NOT NULL default 0,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    PRIMARY KEY (ad_id)
) ENGINE=INNODB;

DROP TABLE IF EXISTS prices;
CREATE TABLE prices(
    price_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    price DECIMAL(7,2),
    months INT,
    typ ENUM('Auto','General'),
    PRIMARY KEY (price_id)
);


DROP TABLE IF EXISTS promos;
CREATE TABLE promos(
    promo_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    valid boolean,
    perc INT NOT NULL,
    PRIMARY KEY (promo_id)
);


DROP TABLE IF EXISTS favs;
CREATE TABLE favs(
    fav_id INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    ad_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (ad_id) REFERENCES auto_ads(ad_id) ON DELETE CASCADE,
    PRIMARY KEY(fav_id)
);

DROP TABLE IF EXISTS comments;
CREATE TABLE comments(
    com_id INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    ad_id INT,
    content TEXT,
    date_added datetime,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (ad_id) REFERENCES auto_ads(ad_id) ON DELETE CASCADE,
    PRIMARY KEY(com_id)
);

DROP TABLE IF EXISTS messages;
CREATE TABLE messages(
    mes_id INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    ad_id INT,
    seller_id INT,
    content TEXT,
    date_added datetime,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (ad_id) REFERENCES auto_ads(ad_id) ON DELETE CASCADE,
    FOREIGN KEY (seller_id) REFERENCES users(user_id) ON DELETE CASCADE,
    PRIMARY KEY(mes_id)
);


DROP TABLE IF EXISTS confirmation_codes;
CREATE TABLE confirmation_codes(
    cc_id INT NOT NULL AUTO_INCREMENT,
    confirmation_code varchar(45) NOT NULL,
    user_id INT NOT NULL,
    ad_id INT,
    gen_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (ad_id) REFERENCES auto_ads(ad_id) ON DELETE CASCADE,
    FOREIGN KEY (gen_id) REFERENCES general_ads(ad_id) ON DELETE CASCADE,
    PRIMARY KEY(cc_id)
);

-- users passwords are following
--  admin -> admin1
--  xklakoux -> qweqwe
insert into users (username, full_name, hash, salt, email, phone, address, role) values('admin', 'Admin Adminov', '733b8fa4b833ca9d3baec9470d7f467614e85057', 'NLVBGCODGE', 'asdsa@dasdsa.dasda' ,'123131313', 'dasdada', 'admin');
insert into users (username, full_name, hash, salt, email, phone, address, role) values('xklakoux', 'Artur Staniec', 'e8e8921b196428ac5ef1f05265d360f2078910af', 'INAEBQWCKQ', 'adsad@dasdsa.ds', '123131313', 'dasdada', 'admin');

-- general_ads
insert into general_ads (title, descr, user_id, months) values("Garage for sale", "lot of space, super nice", 1, 3);
insert into general_ads (title, descr, user_id, months) values("Viagra", "will get you up and running in seconds", 0, 2);
insert into general_ads (title, descr, user_id, months) values("Rooms for students", "without furniture or anything, ideal for students!", 1, 3);
insert into general_ads (title, descr, user_id, months) values("Lollipops", "sweet and stuff, for kids and everyone", 1, 3);
insert into general_ads (title, descr, user_id, months) values("Computers", "used, new, for your grandma and grandpa too", 1, 3);
insert into general_ads (title, descr, user_id, months) values("Cars", "other super site for cars, forget about this", 1, 3);

-- prices
insert into prices (months, price, typ) values (1, 20, "Auto");
insert into prices (months, price, typ) values (2, 16, "Auto");
insert into prices (months, price, typ) values (3, 8, "Auto");

insert into prices (months, price, typ) values (1, 10, "General");
insert into prices (months, price, typ) values (2, 8, "General");
insert into prices (months, price, typ) values (3, 4, "General");
-- comments
insert into comments (com_id,user_id,ad_id,content,date_added)
VALUES('1','1','1','Do not buy from this guy he is a thief.','2012-11-10');
insert into comments (com_id,user_id,ad_id,content,date_added)
VALUES('2','2','1','Very nice offer, I will ask my mom to buy it.','2012-09-01');

-- auto_ads
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Mercedes', 'CLK', '500', '12345', '2006', 29000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 2);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Audi', 'R8', '800', '12345', '2012', 59000.5, 3000, 'Red', 'The car is in a perfect condition.', 1, 'auto', now(), 3);

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Mercedes', 'CLK', '200', '1q2w3e4r', '1999', 9000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 1);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Audi', 'R7', '700', '12345', '2000', 9000.5, 23000, 'Blue', 'The car is in a perfect condition.', 1, 'auto', now(), 1);

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Mercedes', 'CLK', '500', '12345', '2006', 29000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 3);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Opel', 'Corsa', '800', '12345', '2012', 59000.5, 3000, 'Red', 'The car is in a perfect condition.', 1, 'auto', now(), 2);

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Mercedes', 'CLK', '500', '12345', '2006', 29000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 1);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Brand-new offer', 'Opel', 'Corsa', '800', '12345', '2012', 59000.5, 3000, 'Red', 'The car is in a perfect condition.', 1, 'auto', now(), 2);

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Mercedes', 'CLK', '500', '12345', '2006', 29000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 2);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Audi', 'R8', '800', '12345', '2012', 59000.5, 3000, 'Red', 'The car is in a perfect condition.', 1, 'auto', now(), 2);

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Mercedes', 'CLK', '200', '1q2w3e4r', '1999', 9000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 2);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Audi', 'R7', '700', '12345', '2000', 9000.5, 23000, 'Blue', 'The car is in a perfect condition.', 1, 'auto', now(),1);

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Mercedes', 'CLK', '500', '12345', '2006', 29000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 2);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Opel', 'Corsa', '800', '12345', '2012', 59000.5, 3000, 'Gray', 'The car is in a perfect condition.', 1, 'auto', now(),2);

insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Mercedes', 'CLK', '500', '12345', '2006', 29000.5, 15000, 'Black', 'The car is in a perfect condition.', 1, 'auto', now(), 2);
insert into auto_ads (title, brand, model, engine, registration_number, years, price, mileage, colour, description, user_id, auto_moto, add_date, months)
values ('Recent offer', 'Opel', 'Corsa', '800', '12345', '2012', 59000.5, 3000, 'Gray', 'The car is in a perfect condition.', 1, 'auto', now(), 2);

-- messages
insert into messages (user_id,ad_id,seller_id,content,date_added)
VALUES('2','1',1,'Do not buy from this guy he is a thief.','2012-11-10');
insert into messages (user_id,ad_id,seller_id,content,date_added)
VALUES('2','1',1,'Do not buy from this guy he is a thief.','2012-11-10');


insert into promos (name, perc, valid) values("Next with discount", 50, true);

SET FOREIGN_KEY_CHECKS=1; -- has to be on the very end
