DROP TABLE IF EXISTS employee;
create table employee
(
    id          UUID DEFAULT random_uuid() NOT NULL ,
    address     VARCHAR (255),
    city        VARCHAR(255),
    email       VARCHAR(255),
    create_date TIMESTAMP ,
    name        VARCHAR(255),
    state       VARCHAR(255),
    PRIMARY KEY (id)
);
