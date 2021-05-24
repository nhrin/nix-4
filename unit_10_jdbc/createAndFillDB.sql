create database db_unit_10_jdbc;

CREATE TABLE Location
(
    id serial primary key,
    name varchar(80) unique not null
);

create table Route
(
    id serial primary key,
    from_id integer,
    to_id integer,
    cost integer
);

create table Problem
(
    id serial primary key,
    from_id integer,
    to_id integer
);

create table Solution
(
    problem_id integer,
    cost integer
);



insert into Location values (default, 'gdansk');
insert into Location values (default, 'bydgoszcz');
insert into Location values (default, 'torun');
insert into Location values (default, 'warszawa');

insert into Route values (default, 1, 2, 1);
insert into Route values (default, 1, 3, 3);
insert into Route values (default, 2, 1, 1);
insert into Route values (default, 2, 3, 1);
insert into Route values (default, 2, 4, 4);
insert into Route values (default, 3, 1, 3);
insert into Route values (default, 3, 2, 1);
insert into Route values (default, 3, 4, 1);
insert into Route values (default, 4, 2, 4);
insert into Route values (default, 4, 3, 1);
