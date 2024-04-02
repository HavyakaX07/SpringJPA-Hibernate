-- course table have id, name, author columns with id as pk
CREATE table COURSE (

id bigint not null,
name varchar(255) not null,
author varchar(255),
primary key(id)
);
