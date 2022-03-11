/*
Holden Davis
Lab 6 in
3/10/22
CSCI 4490
*/

/*1. drop all tables (in correct order)*/
drop table workerskill;
drop table skill;
drop table worker;
drop table lodging;
/*2. create all tables with only not null constraints*/
CREATE TABLE worker
(name varchar (25) NOT NULL,
age numeric(3) ,
lodging varchar (25));
CREATE TABLE skill
(skill varchar (25),
description varchar (50))
;
CREATE TABLE lodging
(lodging varchar (25),
longname varchar (50),
manager varchar (25),
address varchar (25))
;
CREATE TABLE workerskill
(name varchar (25),
skill varchar (25),
ability varchar (25))
;
/*3. create all primary key/foreign key constraints*/
alter table worker
add constraint worker_name_pk primary key(name);
alter table skill
add constraint skill_skill_pk primary key(skill);
alter table lodging
add constraint lodging_lodging_pk primary key(lodging);
alter table workerskill
add constraint workerskill_name_skill_pk primary key(name,skill);

alter table workerskill
add constraint workerskill_name_fk foreign key(name)
references worker(name);
alter table workerskill
add constraint workerskill_skill_fk foreign key(skill)
references skill(skill);
alter table worker
add constraint worker_lodging_fk foreign key(lodging)
references lodging(lodging);