--Database for test "AmministratoreMaterialTest"
create user gruppo5 password 'sofen';
create table MATERIALI (
   NOMEMATERIALE        VARCHAR(20)          not null,
   constraint PK_MATERIALI primary key (NOMEMATERIALE)
);
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table MATERIALI cascade;
drop user gruppo5;