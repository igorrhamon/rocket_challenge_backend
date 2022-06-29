create sequence hibernate_sequence start with 1 increment by 1;

create table Person (id bigint not null, name varchar(255), primary key (id));

insert into Person (id, name) values (nextval('hibernate_sequence'), 'John');