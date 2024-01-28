create table user (
	id varchar(20),
    password varchar(20),
   constraint pk_user primary key (id)
);

drop table user;

show databases;
use userinfo;
show tables;

select *
from user;