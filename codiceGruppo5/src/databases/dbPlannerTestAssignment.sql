--Database for test "PlannerTestAssignment"
create user gruppo5 password 'sofen';
create table ASSEGNAZIONEATTIVITA (
   ACTIVITYID           VARCHAR(10)          not null,
   NOMEMAINTAINER       VARCHAR(20)          not null,
   STATOMAINTAINER       VARCHAR(20)          null,
   constraint PK_ASSEGNAZIONEATTIVITA primary key (ACTIVITYID, NOMEMAINTAINER)
);
create table ACCESSO (
   USERNAMEAC           VARCHAR(20)          not null,
   NOMEPLANNER          VARCHAR(20),           
   NOMEAMMINISTRATORE   VARCHAR(20),          
   NOMEMAINTAINER       VARCHAR(20),           
   PASSWORDAC           VARCHAR(20)          not null,
   NUMEROACCESSI        INT                 default 0,
   constraint PK_ACCESSO primary key (USERNAMEAC)
);
create table MAINTAINER (
   NOMEMAINTAINER       VARCHAR(20)          not null,
   NOMEAMMINISTRATORE   VARCHAR(20)          not null,
   constraint PK_MAINTAINER primary key (NOMEMAINTAINER)
);
create table AVAILABILITY (
   GIORNO               DATE                 not null,
   NOMEMAINTAINER       VARCHAR(20)          not null,
   MIN                  INT4                 not null,
   constraint PK_AVAILABILITY primary key (GIORNO, NOMEMAINTAINER)
);
create table MAINTAINANCEPROCEDURE (
   NOMEPROCEDURA        VARCHAR(20)          not null,
   SMP                  VARCHAR(20)             not null,
   constraint PK_MAINTAINANCEPROCEDURE primary key (NOMEPROCEDURA)
);
create table MAINTAINANCEACTIVITY (
   ACTIVITYID           VARCHAR(10)          not null,
   NOMEPROCEDURA        VARCHAR(20)          null,
   TIPOLOGIA            VARCHAR(20)          not null,
   DESCRIZIONE          VARCHAR(20)          not null,
   TEMPO                INT4                 not null,
   INTERROMPIBILE       BOOL                 not null,
   SETTIMANA            INT4                 not null,
   TIPO                 VARCHAR(20)          not null,
   DATA                 DATE                 null,
   GENERALSTATE         VARCHAR(20)          null,
   constraint PK_MAINTAINANCEACTIVITY primary key (ACTIVITYID)
);
create table MAINTAINANCETYPE (
   TIPO           VARCHAR(20)          not null,
   constraint PK_MAINTAINANCETYPE primary key (TIPO)
);
create table PIANIFICAZIONE (
   NOMEPLANNER          VARCHAR(20)          not null,
   ACTIVITYID           VARCHAR(10)          not null,
   constraint PK_PIANIFICAZIONE primary key (NOMEPLANNER, ACTIVITYID)
);
create table PLANNER (
   NOMEPLANNER          VARCHAR(20)          not null,
   NOMEAMMINISTRATORE   VARCHAR(20)          not null,
   constraint PK_PLANNER primary key (NOMEPLANNER)
);
create table POSSESSOS (
   ACTIVITYID           VARCHAR(10)          not null,
   FACTORYSITE          VARCHAR(20)          not null,
   AREA                 VARCHAR(20)          not null,
   TICKETSTATEFORAREA   VARCHAR(20)          null,
   constraint PK_POSSESSOS primary key (ACTIVITYID, FACTORYSITE, AREA)
);
create table SITI (
   FACTORYSITE          VARCHAR(20)          not null,
   AREA                 VARCHAR(20)          not null,
   constraint PK_SITI primary key (FACTORYSITE, AREA)
);
create table NOTIFICHE (
   NOMEMAINTAINER          VARCHAR(20)          not null,
   NOTIFICA                 VARCHAR(500)          not null,
   constraint PK_NOME_MAINTAINER primary key (NOMEMAINTAINER, NOTIFICA)
);
alter table ACCESSO
   add constraint FK_ACCESSO_ACCESSOM_MAINTAIN foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
alter table ACCESSO
   add constraint FK_ACCESSO_ACCESSOP_PLANNER foreign key (NOMEPLANNER)
      references PLANNER (NOMEPLANNER)
      on delete cascade on update cascade;
alter table ASSEGNAZIONEATTIVITA
   add constraint FK_ASSEGNAZ_ASSEGNAZI_MAINTAIN foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
alter table ASSEGNAZIONEATTIVITA
   add constraint FK_ASSEGNAZ_ASSEGNAZI_MAINTANA foreign key (ACTIVITYID)
      references MAINTAINANCEACTIVITY (ACTIVITYID)
      on delete cascade on update cascade;
alter table AVAILABILITY
   add constraint FK_AVAILABI_DISPONIBI_MAINTAIN foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
alter table MAINTAINANCEACTIVITY
   add constraint FK_MAINTANA_PROCEDIME_MAINTAIN foreign key (NOMEPROCEDURA)
      references MAINTAINANCEPROCEDURE (NOMEPROCEDURA)
      on delete cascade on update cascade;	  
alter table MAINTAINANCEACTIVITY
   add constraint FK_ACT_TYPE foreign key (TIPO)
      references MAINTAINANCETYPE (TIPO)
      on delete cascade on update cascade;
alter table PIANIFICAZIONE
   add constraint FK_PIANIFIC_PIANIFICA_MAINTANA foreign key (ACTIVITYID)
      references MAINTAINANCEACTIVITY (ACTIVITYID)
      on delete cascade on update cascade;
alter table PIANIFICAZIONE
   add constraint FK_PIANIFIC_PIANIFICA_PLANNER foreign key (NOMEPLANNER)
      references PLANNER (NOMEPLANNER)
      on delete cascade on update cascade;
alter table POSSESSOS
   add constraint FK_POSSESSO_POSSESSOS_SITI foreign key (FACTORYSITE, AREA)
      references SITI (FACTORYSITE, AREA)
      on delete cascade on update cascade;
alter table POSSESSOS
   add constraint FK_POSSESSO_POSSESSOS_MAINTANA foreign key (ACTIVITYID)
      references MAINTAINANCEACTIVITY (ACTIVITYID)
      on delete cascade on update cascade;	  
alter table NOTIFICHE
   add constraint FK_NOMEMAINTAINER foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
grant all privileges on all tables in schema public to gruppo5;
insert into SITI(FACTORYSITE,AREA) values ('Fisciano','Molding');
insert into MAINTAINANCETYPE(TIPO) values ('Elettrica');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase1','base1.pdf');
insert into PLANNER(NOMEPLANNER,NOMEAMMINISTRATORE) values ('planner','admin');
--At the end of test execute the following
drop table ACCESSO cascade;
drop table ASSEGNAZIONEATTIVITA cascade;
drop table AVAILABILITY cascade;
drop table MAINTAINANCEPROCEDURE cascade;
drop table MAINTAINER cascade;
drop table MAINTAINANCEACTIVITY cascade;
drop table MAINTAINANCETYPE cascade;
drop table PIANIFICAZIONE cascade;
drop table PLANNER cascade;
drop table POSSESSOS cascade;
drop table SITI cascade;
drop table NOTIFICHE cascade;
drop user gruppo5;