--Database for test "AmministratoreMainCompetencyTest"
create user gruppo5 password 'sofen';
create table ACCESSO (
   USERNAMEAC           VARCHAR(20)          not null,
   NOMEPLANNER          VARCHAR(20),           
   NOMEAMMINISTRATORE   VARCHAR(20),          
   NOMEMAINTAINER       VARCHAR(20),           
   PASSWORDAC           VARCHAR(20)          not null,
   NUMEROACCESSI        INT                 default 0,
   constraint PK_ACCESSO primary key (USERNAMEAC)
);
create table COMPETENZE (
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_COMPETENZE primary key (COMPETENZA)
);
create table COMPETENZERICHIESTE (
   NOMEPROCEDURA        VARCHAR(20)          not null,
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_COMPETENZERICHIESTE primary key (NOMEPROCEDURA, COMPETENZA)
);
create table MAINTAINANCEPROCEDURE (
   NOMEPROCEDURA        VARCHAR(20)          not null,
   SMP                  VARCHAR(20)             not null,
   constraint PK_MAINTAINANCEPROCEDURE primary key (NOMEPROCEDURA)
);
create table MAINTAINER (
   NOMEMAINTAINER       VARCHAR(20)          not null,
   NOMEAMMINISTRATORE   VARCHAR(20)          not null,
   constraint PK_MAINTAINER primary key (NOMEMAINTAINER)
);
create table POSSESSO (
   NOMEMAINTAINER       VARCHAR(20)          not null,
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_POSSESSO primary key (NOMEMAINTAINER, COMPETENZA)
);
alter table ACCESSO
   add constraint FK_ACCESSO_ACCESSOM_MAINTAIN foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
alter table POSSESSO
   add constraint FK_POSSESSO_POSSESSO_COMPETEN foreign key (COMPETENZA)
      references COMPETENZE (COMPETENZA)
      on delete cascade on update cascade;
alter table POSSESSO
   add constraint FK_POSSESSO_POSSESSO2_MAINTAIN foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
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
drop table COMPETENZERICHIESTE cascade;
drop table MAINTAINANCEPROCEDURE cascade;
drop table MAINTAINER cascade;
drop table POSSESSO cascade;
drop table ACCESSO cascade;
drop user gruppo5;