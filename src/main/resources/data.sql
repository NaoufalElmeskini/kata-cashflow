CREATE TABLE IF NOT EXISTS account (
    id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    balance float,
    PRIMARY KEY (id)
);

insert into account(id, name, balance)
values(1,'Naoufal',1000);
insert into account(id, name, balance)
values(2,'Omar',1000);
insert into account(id, name, balance)
values(3,'Arnaud',1000);
insert into account(id, name, balance)
values(4,'Sami',1000);
insert into account(id, name, balance)
values(5,'Myriam',1000);