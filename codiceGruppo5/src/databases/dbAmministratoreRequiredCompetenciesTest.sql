--Database for test "AmministratoreRequiredCompetenciesTest"
create user gruppo5 password 'sofen';
create table COMPETENZE (
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_COMPETENZE primary key (COMPETENZA)
);
create table MAINTAINANCEPROCEDURE (
   NOMEPROCEDURA        VARCHAR(20)          not null,
   SMP                  VARCHAR(20)             not null,
   constraint PK_MAINTAINANCEPROCEDURE primary key (NOMEPROCEDURA)
);
create table COMPETENZERICHIESTE (
   NOMEPROCEDURA        VARCHAR(20)          not null,
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_COMPETENZERICHIESTE primary key (NOMEPROCEDURA, COMPETENZA)
);
alter table COMPETENZERICHIESTE
   add constraint FK_COMPETEN_COMPETENZ_COMPETEN foreign key (COMPETENZA)
      references COMPETENZE (COMPETENZA)
      on delete cascade on update cascade;
alter table COMPETENZERICHIESTE
   add constraint FK_COMPETEN_COMPETENZ_MAINTAIN foreign key (NOMEPROCEDURA)
      references MAINTAINANCEPROCEDURE (NOMEPROCEDURA)
      on delete cascade on update cascade;
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table COMPETENZE cascade;
drop table MAINTAINANCEPROCEDURE cascade;
drop table COMPETENZERICHIESTE cascade;
drop user gruppo5;