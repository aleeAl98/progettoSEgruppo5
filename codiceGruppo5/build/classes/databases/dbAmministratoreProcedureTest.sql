--Database for test "AmministratoreProcedureTest"
create user gruppo5 password 'sofen';
create table MAINTAINANCEPROCEDURE (
   NOMEPROCEDURA        VARCHAR(20)          not null,
   SMP                  VARCHAR(20)             not null,
   constraint PK_MAINTAINANCEPROCEDURE primary key (NOMEPROCEDURA)
);
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table MAINTAINANCEPROCEDURE cascade;
drop user gruppo5;