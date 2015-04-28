drop table TEMPLATE_PEOPLE;
drop sequence TEMPLATE_PEOPLE_SEQUENCE;
---------------
create sequence TEMPLATE_PEOPLE_SEQUENCE start with 100 increment by 1;

create table TEMPLATE_PEOPLE (
  ID int primary key,
  FIRST_NAME varchar(40) not null,
  LAST_NAME varchar(40) not null,
  AGE int not null,
  EMAIL varchar(80) not null,
  PASSWORD varchar(32) null
  );
