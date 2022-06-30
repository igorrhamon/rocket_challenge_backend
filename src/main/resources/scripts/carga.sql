

create table Person (id bigint not null, name varchar(255), primary key (id));



create table Place (id bigint not null, name varchar(255), slug varchar(255), city varchar(255), state varchar(255), created_at date, updated_at date, primary key (id));

create sequence hibernate_sequence start with 1 increment by 1;
