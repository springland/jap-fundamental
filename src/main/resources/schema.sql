create schema simple ;

create table  simple.tbl_product_identity_id (
    id BIGINT auto_increment ,
    name varchar(100)
);


create table  simple.tbl_product_sequence_id (
    id BIGINT  ,
    name varchar(100)
);


create table  simple.tbl_person_sequence_id (
    id BIGINT  ,
    name varchar(100)
);

CREATE SEQUENCE product_sequence
  START WITH 1
  INCREMENT BY 100
  MINVALUE 1;


CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1;


create schema embedded ;

create table embedded.tbl_company (
    id BIGINT auto_increment ,
    name varchar(100) ,
    street varchar(100),
    city  varchar(100),
    state  varchar(100),
    zip_code varchar(100)
);


create table embedded.tbl_customer (
    id BIGINT auto_increment ,
    name varchar(100),
    street varchar(100),
    city  varchar(100),
    state_name  varchar(100),
    zipcode varchar(100)

);


create schema onetoone ;

create table onetoone.tbl_capital
(
    id BIGINT auto_increment ,
    name varchar(100)

);


create table onetoone.tbl_country
(
    id BIGINT auto_increment ,
    name varchar(100) ,
    capital_id BIGINT,
    foreign key (capital_id) references  tbl_capital(id)

);

create table onetoone.tbl_person (
    id BIGINT auto_increment ,
    name varchar(100)
);

create table onetoone.tbl_finger_print (
    id BIGINT auto_increment ,
    data varchar(100) ,
    person_id BIGINT ,
    foreign key ( person_id) references tbl_person(id)

)


