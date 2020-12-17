--Database for test "AmministratoreMaintainanceTypeTest"
create user gruppo5 password 'sofen';
create table MAINTAINANCETYPE (
   TIPO           VARCHAR(20)          not null,
   constraint PK_MAINTAINANCETYPE primary key (TIPO)
);
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table MAINTAINANCETYPE cascade;
drop user gruppo5;