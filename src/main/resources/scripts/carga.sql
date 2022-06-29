
create table Person (id bigint not null, name varchar(255), primary key (id));



create table Place (id bigint not null, name varchar(255), slug varchar(255), city varchar(255), state varchar(255), created_at timestamp, updated_at timestamp, primary key (id));

create sequence hibernate_sequence start with 1 increment by 1;

INSERT INTO Place (id, name, slug, city, state, created_at, updated_at) VALUES (nextval('hibernate_sequence'), 'São Paulo', 'sao-paulo', 'São Paulo', 'SP', '2018-01-01 00:00:00', '2018-01-01 00:00:00');