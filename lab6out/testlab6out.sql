/*
Holden Davis
Lab 6 Out
3/28/22
CSCI 4490
*/
/*Do all insertions*/
insert into user values('jsmith@uca.edu', aes_encrypt('hello123', 'key'));
insert into user values('msmith@uca.edu', aes_encrypt('pass123', 'key'));
insert into user values('tjones@yahoo.com', aes_encrypt('123456', 'key'));
insert into user values('jjones@yahoo.com', aes_encrypt('hello1234', 'key'));

insert into contact values('jsmith@uca.edu', 'msmith@uca.edu');
insert into contact values('jsmith@uca.edu', 'tjones@yahoo.com');
insert into contact values('msmith@uca.edu', 'tjones@yahoo.com');

insert into messages values('jsmith@uca.edu', 'msmith@uca.edu', 'Hello', SYSDATE());
insert into messages values('tjones@yahoo.com', 'msmith@uca.edu', 'How r u?', SYSDATE());
insert into messages values('tjones@yahoo.com', 'jsmith@uca.edu', 'Hello Joe', SYSDATE());

/*Do all queries*/
select email, password, aes_decrypt(password, 'key') from user;
select * from contact;
select * from messages;