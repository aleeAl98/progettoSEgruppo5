--Database for test "PlannerTestActivities"
create user gruppo5 password 'sofen';
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
create table MAINTAINANCEPROCEDURE (
   NOMEPROCEDURA        VARCHAR(20)          not null,
   SMP                  VARCHAR(20)             not null,
   constraint PK_MAINTAINANCEPROCEDURE primary key (NOMEPROCEDURA)
);
create table MATERIALI (
   NOMEMATERIALE        VARCHAR(20)          not null,
   constraint PK_MATERIALI primary key (NOMEMATERIALE)
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
create table POSSESSOM (
   ACTIVITYID           VARCHAR(10)          not null,
   NOMEMATERIALE        VARCHAR(20)          not null,
   constraint PK_POSSESSOM primary key (ACTIVITYID, NOMEMATERIALE)
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
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase1','base1.pdf');
insert into SITI(FACTORYSITE,AREA) values ('Fisciano','Molding');
insert into MAINTAINANCETYPE(TIPO) values ('Elettrica');
insert into PLANNER(NOMEPLANNER,NOMEAMMINISTRATORE) values ('planner','admin');
grant all privileges on all tables in schema public to gruppo5;
--At the end of test execute the following
drop table MAINTAINANCEPROCEDURE cascade;
drop table MAINTAINANCEACTIVITY cascade;
drop table MAINTAINANCETYPE cascade;
drop table MATERIALI cascade;
drop table PIANIFICAZIONE cascade;
drop table PLANNER cascade;
drop table POSSESSOM cascade;
drop table POSSESSOS cascade;
drop table SITI cascade;
drop user gruppo5;