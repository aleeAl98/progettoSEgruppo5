--Database for test "AmministratoreSiteTest"
create user gruppo5 password 'sofen';
create table SITI (
   FACTORYSITE          VARCHAR(20)          not null,
   AREA                 VARCHAR(20)          not null,
   constraint PK_SITI primary key (FACTORYSITE, AREA)
);
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table SITI cascade;
drop user gruppo5;