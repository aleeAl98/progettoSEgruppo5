--Database for test "AmministratoreUsersTest"
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
create table AMMINISTRATORE (
   NOMEAMMINISTRATORE   VARCHAR(20)          not null,
   constraint PK_AMMINISTRATORE primary key (NOMEAMMINISTRATORE)
);
create table MAINTAINER (
   NOMEMAINTAINER       VARCHAR(20)          not null,
   NOMEAMMINISTRATORE   VARCHAR(20)          not null,
   constraint PK_MAINTAINER primary key (NOMEMAINTAINER)
);
create table PLANNER (
   NOMEPLANNER          VARCHAR(20)          not null,
   NOMEAMMINISTRATORE   VARCHAR(20)          not null,
   constraint PK_PLANNER primary key (NOMEPLANNER)
);
alter table ACCESSO
   add constraint FK_ACCESSO_ACCESSOA_AMMINIST foreign key (NOMEAMMINISTRATORE)
      references AMMINISTRATORE (NOMEAMMINISTRATORE)
      on delete cascade on update cascade;
alter table ACCESSO
   add constraint FK_ACCESSO_ACCESSOM_MAINTAIN foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
alter table ACCESSO
   add constraint FK_ACCESSO_ACCESSOP_PLANNER foreign key (NOMEPLANNER)
      references PLANNER (NOMEPLANNER)
      on delete cascade on update cascade;
alter table MAINTAINER
   add constraint FK_MAINTAIN_GESTIONEM_AMMINIST foreign key (NOMEAMMINISTRATORE)
      references AMMINISTRATORE (NOMEAMMINISTRATORE)
      on delete cascade on update cascade;
alter table PLANNER
   add constraint FK_PLANNER_GESTIONEP_AMMINIST foreign key (NOMEAMMINISTRATORE)
      references AMMINISTRATORE (NOMEAMMINISTRATORE)
      on delete cascade on update cascade;
insert into AMMINISTRATORE (NOMEAMMINISTRATORE) values ('admin');
insert into ACCESSO (USERNAMEAC,NOMEAMMINISTRATORE,PASSWORDAC) values ('admin','admin','admin');
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table ACCESSO cascade;
drop table AMMINISTRATORE cascade;
drop table MAINTAINER cascade;
drop table PLANNER cascade;
drop user gruppo5;