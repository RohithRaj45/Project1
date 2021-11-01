create DATABASE IF NOT EXISTS ProductDB;

use ProductDB;
drop table IF EXISTS Product;

create table Product(
prodid INTEGER,
productname VARCHAR(30),
price INTEGER,
stock INTEGER,
description VARCHAR(60),
sellerid INTEGER,
category VARCHAR(20),
subcategory VARCHAR(20),
productrating INTEGER
);

INSERT INTO Product values(1,'Days Gone',30,25,'Days gone is an adventure survival horror game', 10,'Software','Games',4.5);
INSERT INTO Product values(2,'Equaliser',40,22,'Equaliser is an adventure survival horror game', 11,'FILMS','Movie',5);
INSERT INTO Product values(3,'Man on Fire',50,33,'Man on Fire is an adventure survival Film', 12,'FILMS','Movie',3.5);