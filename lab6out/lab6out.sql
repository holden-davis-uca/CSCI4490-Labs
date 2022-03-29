/*
Holden Davis
Lab 6 Out
3/28/22
CSCI 4490
*/
/*Drop all tables*/
drop table messages;
drop table contact;
drop table user;

/*Create all tables*/
create table user(email varchar(50) not null, password varbinary(16) not null);
create table contact(email varchar(50) not null, contact varchar(50) not null);
create table messages(sender varchar(50) not null, receiver varchar(50) not null, message varchar(100) not null, date date not null);

/*Create primary key constraints*/
alter table user add constraint user_email_pk primary key(email);
alter table contact add constraint contact_emailcontact_pk primary key(email, contact);
alter table messages add constraint messages_senderreceiver_pk primary key(sender, receiver);

/*Create foreign key constraints*/
-- alter table user add constraint user_email_fk foreign key(email) references user(email);
alter table contact add constraint contact_email_fk foreign key(email) references user(email);
alter table contact add constraint contact_contact_fk foreign key(contact) references user(email);
alter table messages add constraint messages_sender_fk foreign key(sender) references user(email);
alter table messages add constraint messages_receiver_fk foreign key(receiver) references user(email);
