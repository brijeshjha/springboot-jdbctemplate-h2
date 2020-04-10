create table persons
(
  id integer primary key,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp
);

insert into persons values (100,'raj','mumbai',sysdate),
(101,'jack','new york',sysdate),
(102,'sam','canada',sysdate);