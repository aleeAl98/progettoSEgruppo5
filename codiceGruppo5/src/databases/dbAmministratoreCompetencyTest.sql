--Database for test "AmministratoreCompetencyTest"
create user gruppo5 password 'sofen';
create table COMPETENZE (
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_COMPETENZE primary key (COMPETENZA)
);
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table COMPETENZE cascade;
drop user gruppo5;