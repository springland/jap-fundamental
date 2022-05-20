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
