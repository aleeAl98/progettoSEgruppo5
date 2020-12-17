/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     21/11/2020                                   */
/*==============================================================*/
drop user gruppo5; 
create user gruppo5 password 'sofen';
/* Drop all tables */
drop table ACCESSO cascade;
drop table AMMINISTRATORE cascade;
drop table ASSEGNAZIONEATTIVITA cascade;
drop table AVAILABILITY cascade;
drop table COMPETENZE cascade;
drop table COMPETENZERICHIESTE cascade;
drop table MAINTAINANCEPROCEDURE cascade;
drop table MAINTAINER cascade;
drop table MAINTAINANCEACTIVITY cascade;
drop table MAINTAINANCETYPE cascade;
drop table MATERIALI cascade;
drop table MODIFICA cascade;
drop table PIANIFICAZIONE cascade;
drop table PLANNER cascade;
drop table POSSESSO cascade;
drop table POSSESSOC cascade;
drop table POSSESSOM cascade;
drop table POSSESSOS cascade;
drop table SITI cascade;
drop table NOTIFICHE cascade;
/* Create all tables */
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
create table ASSEGNAZIONEATTIVITA (
   ACTIVITYID           VARCHAR(10)          not null,
   NOMEMAINTAINER       VARCHAR(20)          not null,
   STATOMAINTAINER       VARCHAR(20)          null,
   constraint PK_ASSEGNAZIONEATTIVITA primary key (ACTIVITYID, NOMEMAINTAINER)
);
create table AVAILABILITY (
   GIORNO               DATE                 not null,
   NOMEMAINTAINER       VARCHAR(20)          not null,
   MIN                  INT4                 not null,
   constraint PK_AVAILABILITY primary key (GIORNO, NOMEMAINTAINER)
);
create table COMPETENZE (
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_COMPETENZE primary key (COMPETENZA)
);
create table MAINTAINANCETYPE (
   TIPO           VARCHAR(20)          not null,
   constraint PK_MAINTAINANCETYPE primary key (TIPO)
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
create table MATERIALI (
   NOMEMATERIALE        VARCHAR(20)          not null,
   constraint PK_MATERIALI primary key (NOMEMATERIALE)
);
create table MODIFICA (
   NOMEPLANNER          VARCHAR(20)          not null,
   NOMEMATERIALE        VARCHAR(20)          not null,
   constraint PK_MODIFICA primary key (NOMEPLANNER, NOMEMATERIALE)
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
create table POSSESSO (
   NOMEMAINTAINER       VARCHAR(20)          not null,
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_POSSESSO primary key (NOMEMAINTAINER, COMPETENZA)
);
create table POSSESSOC (
   ACTIVITYID           VARCHAR(10)          not null,
   COMPETENZA           VARCHAR(50)          not null,
   constraint PK_POSSESSOC primary key (ACTIVITYID, COMPETENZA)
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
create table NOTIFICHE (
   NOMEMAINTAINER          VARCHAR(20)          not null,
   NOTIFICA                 VARCHAR(500)          not null,
   constraint PK_NOME_MAINTAINER primary key (NOMEMAINTAINER, NOTIFICA)
);
/* Alter all tables */
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
alter table COMPETENZERICHIESTE
   add constraint FK_COMPETEN_COMPETENZ_COMPETEN foreign key (COMPETENZA)
      references COMPETENZE (COMPETENZA)
      on delete cascade on update cascade;
alter table COMPETENZERICHIESTE
   add constraint FK_COMPETEN_COMPETENZ_MAINTAIN foreign key (NOMEPROCEDURA)
      references MAINTAINANCEPROCEDURE (NOMEPROCEDURA)
      on delete cascade on update cascade;
alter table MAINTAINER
   add constraint FK_MAINTAIN_GESTIONEM_AMMINIST foreign key (NOMEAMMINISTRATORE)
      references AMMINISTRATORE (NOMEAMMINISTRATORE)
      on delete cascade on update cascade;
alter table MAINTAINANCEACTIVITY
   add constraint FK_MAINTANA_PROCEDIME_MAINTAIN foreign key (NOMEPROCEDURA)
      references MAINTAINANCEPROCEDURE (NOMEPROCEDURA)
      on delete cascade on update cascade;	  
alter table MAINTAINANCEACTIVITY
   add constraint FK_ACT_TYPE foreign key (TIPO)
      references MAINTAINANCETYPE (TIPO)
      on delete cascade on update cascade;
alter table MODIFICA
   add constraint FK_MODIFICA_MODIFICA_MATERIAL foreign key (NOMEMATERIALE)
      references MATERIALI (NOMEMATERIALE)
      on delete cascade on update cascade;
alter table MODIFICA
   add constraint FK_MODIFICA_MODIFICA2_PLANNER foreign key (NOMEPLANNER)
      references PLANNER (NOMEPLANNER)
      on delete cascade on update cascade;
alter table PIANIFICAZIONE
   add constraint FK_PIANIFIC_PIANIFICA_MAINTANA foreign key (ACTIVITYID)
      references MAINTAINANCEACTIVITY (ACTIVITYID)
      on delete cascade on update cascade;
alter table PIANIFICAZIONE
   add constraint FK_PIANIFIC_PIANIFICA_PLANNER foreign key (NOMEPLANNER)
      references PLANNER (NOMEPLANNER)
      on delete cascade on update cascade;
alter table PLANNER
   add constraint FK_PLANNER_GESTIONEP_AMMINIST foreign key (NOMEAMMINISTRATORE)
      references AMMINISTRATORE (NOMEAMMINISTRATORE)
      on delete cascade on update cascade;
alter table POSSESSO
   add constraint FK_POSSESSO_POSSESSO_COMPETEN foreign key (COMPETENZA)
      references COMPETENZE (COMPETENZA)
      on delete cascade on update cascade;
alter table POSSESSO
   add constraint FK_POSSESSO_POSSESSO2_MAINTAIN foreign key (NOMEMAINTAINER)
      references MAINTAINER (NOMEMAINTAINER)
      on delete cascade on update cascade;
alter table POSSESSOC
   add constraint FK_POSSESSO_POSSESSOC_COMPETEN foreign key (COMPETENZA)
      references COMPETENZE (COMPETENZA)
      on delete cascade on update cascade;
alter table POSSESSOC
   add constraint FK_POSSESSO_POSSESSOC_MAINTANA foreign key (ACTIVITYID)
      references MAINTAINANCEACTIVITY (ACTIVITYID)
      on delete cascade on update cascade;
alter table POSSESSOM
   add constraint FK_POSSESSO_POSSESSOM_MATERIAL foreign key (NOMEMATERIALE)
      references MATERIALI (NOMEMATERIALE)
      on delete cascade on update cascade;
alter table POSSESSOM
   add constraint FK_POSSESSO_POSSESSOM_MAINTANA foreign key (ACTIVITYID)
      references MAINTAINANCEACTIVITY (ACTIVITYID)
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
/* Insert in tables */
insert into AMMINISTRATORE (NOMEAMMINISTRATORE) values ('admin');
insert into PLANNER(NOMEPLANNER,NOMEAMMINISTRATORE) values ('AlePla','admin');
insert into PLANNER(NOMEPLANNER,NOMEAMMINISTRATORE) values ('LauraPla','admin');
insert into PLANNER(NOMEPLANNER,NOMEAMMINISTRATORE) values ('ChiaraPla','admin');
insert into PLANNER(NOMEPLANNER,NOMEAMMINISTRATORE) values ('DaniPla','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer1','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer2','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer3','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer4','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer5','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer6','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer7','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer8','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer9','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer10','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer11','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer12','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer13','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer14','admin');
insert into MAINTAINER(NOMEMAINTAINER,NOMEAMMINISTRATORE) values ('maintainer15','admin');
insert into ACCESSO (USERNAMEAC,NOMEAMMINISTRATORE,PASSWORDAC) values ('admin','admin','password');
insert into ACCESSO(USERNAMEAC,NOMEPLANNER,PASSWORDAC) values ('alepla','AlePla','password');
insert into ACCESSO(USERNAMEAC,NOMEPLANNER,PASSWORDAC) values ('laurapla','LauraPla','password');
insert into ACCESSO(USERNAMEAC,NOMEPLANNER,PASSWORDAC) values ('chiarapla','ChiaraPla','password');
insert into ACCESSO(USERNAMEAC,NOMEPLANNER,PASSWORDAC) values ('danipla','DaniPla','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer1','maintainer1','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer2','maintainer2','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer3','maintainer3','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer4','maintainer4','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer5','maintainer5','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer6','maintainer6','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer7','maintainer7','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer8','maintainer8','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer9','maintainer9','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer10','maintainer10','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer11','maintainer11','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer12','maintainer12','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer13','maintainer13','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer14','maintainer14','password');
insert into ACCESSO(USERNAMEAC,NOMEMAINTAINER,PASSWORDAC) values ('maintainer15','maintainer15','password');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase1','base1.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase2','base2.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase3','base3.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase4','base4.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase5','base5.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase6','base6.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase7','base7.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase8','base8.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase9','base9.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase10','base10.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase11','base11.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase12','base12.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase13','base13.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase14','base14.pdf');
insert into MAINTAINANCEPROCEDURE(NOMEPROCEDURA,SMP) values('proceduraBase15','base15.pdf');
insert into COMPETENZE(COMPETENZA) values('Usare interfaccia linea di comando');
insert into COMPETENZE(COMPETENZA) values('Conoscenza SCADA');
insert into COMPETENZE(COMPETENZA) values('Conoscenza VHDL');
insert into COMPETENZE(COMPETENZA) values('Controllare robot');
insert into COMPETENZE(COMPETENZA) values('Usare pc');
insert into COMPETENZE(COMPETENZA) values('Utilizzo tensili per il montaggio');
insert into COMPETENZE(COMPETENZA) values('Capacità di monitoraggio');
insert into COMPETENZE(COMPETENZA) values('Sicurezza di produzione');
insert into COMPETENZE(COMPETENZA) values('Controllo qualità');
insert into COMPETENZE(COMPETENZA) values('Analisi termografica dei componenti');
insert into COMPETENZE(COMPETENZA) values('Tecniche di testing');
insert into COMPETENZE(COMPETENZA) values('Utilizzo DPI');
insert into COMPETENZE(COMPETENZA) values('Utilizzo di strumenti di reporting');
insert into MAINTAINANCETYPE(TIPO) values ('Idraulica');
insert into MAINTAINANCETYPE(TIPO) values ('Elettrica');
insert into MAINTAINANCETYPE(TIPO) values ('Elettronica');
insert into MAINTAINANCETYPE(TIPO) values ('Metallurgica');
insert into MAINTAINANCETYPE(TIPO) values ('Informatica');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('1','proceduraBase1','PLANNED','Attività di prova 1',90,true,1,'Idraulica','2021-1-2','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('2','proceduraBase2','UNPLANNED','Attività di prova 2',50,true,1,'Elettrica','2021-1-2','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('3','proceduraBase3','EXTRA','Attività di prova 3',60,true,1,'Elettronica','2021-1-3','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('4','proceduraBase4','PLANNED','Attività di prova 4',70,true,1,'Metallurgica','2021-1-4','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('5','proceduraBase5','UNPLANNED','Attività di prova 5',20,false,1,'Informatica','2021-1-5','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('6','proceduraBase6','EXTRA','Attività di prova 6',100,true,1,'Idraulica','2021-1-5','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('7','proceduraBase7','PLANNED','Attività di prova 7',70,false,1,'Elettrica','2021-1-7','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('8','proceduraBase8','UNPLANNED','Attività di prova 8',90,false,2,'Elettronica','2021-1-8','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('9','proceduraBase9','EXTRA','Attività di prova 9',40,true,2,'Metallurgica','2021-1-9','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('10','proceduraBase10','UNPLANNED','Attività di prova 10',30,false,2,'Informatica','2021-1-10','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('11','proceduraBase11','EXTRA','Attività di prova 11',80,true,53,'Idraulica','2020-12-11','INPROGRESS');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('12','proceduraBase12','UNPLANNED','Attività di prova 12',150,false,53,'Elettrica','2020-12-11','INPROGRESS');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('13','proceduraBase13','EXTRA','Attività di prova 13',50,true,53,'Elettronica','2020-12-11','INPROGRESS');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('14','proceduraBase14','UNPLANNED','Attività di prova 14',90,false,53,'Metallurgica','2020-12-10','CLOSED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('15','proceduraBase15','UNPLANNED','Attività di prova 15',60,false,53,'Informatica','2020-12-10','CLOSED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('EWO1','proceduraBase1','EWO','EWO di prova 1',80,true,1,'Idraulica','2021-1-2','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('EWO2','proceduraBase2','EWO','EWO di prova 2',150,false,1,'Elettrica','2021-1-3','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('EWO3','proceduraBase3','EWO','EWO di prova 3',50,true,1,'Elettronica','2021-1-4','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('EWO4','proceduraBase4','EWO','EWO di prova 4',90,false,1,'Metallurgica','2021-1-3','NOTSTARTED');
insert into MAINTAINANCEACTIVITY(ACTIVITYID,NOMEPROCEDURA,TIPOLOGIA,DESCRIZIONE,TEMPO,INTERROMPIBILE,SETTIMANA,TIPO,DATA,GENERALSTATE) values('EWO5','proceduraBase5','EWO','EWO di prova 5',60,false,1,'Informatica','2021-1-2','NOTSTARTED');
insert into SITI(FACTORYSITE,AREA) values ('Fisciano','Molding');
insert into SITI(FACTORYSITE,AREA) values ('Nusco','Carpentry');
insert into SITI(FACTORYSITE,AREA) values ('Morra','Painting');
insert into SITI(FACTORYSITE,AREA) values ('Avellino','Administration');
insert into SITI(FACTORYSITE,AREA) values ('Benevento','Management');
insert into SITI(FACTORYSITE,AREA) values ('Caserta','Maintainance');
insert into SITI(FACTORYSITE,AREA) values ('Salerno','Finance');
insert into SITI(FACTORYSITE,AREA) values ('Napoli','Production');
insert into SITI(FACTORYSITE,AREA) values ('Avellino','Vendità');
insert into SITI(FACTORYSITE,AREA) values ('Salerno','Direzione');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('1','Fisciano','Molding','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('2','Nusco','Carpentry','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('3','Morra','Painting','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('4','Avellino','Administration','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('5','Benevento','Management','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('6','Caserta','Maintainance','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('7','Salerno','Finance','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('8','Napoli','Production','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('9','Avellino','Vendità','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('10','Salerno','Direzione','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('11','Nusco','Carpentry','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('12','Morra','Painting','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('13','Fisciano','Molding','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('14','Avellino','Administration','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('15','Benevento','Management','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('EWO1','Nusco','Carpentry','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('EWO2','Morra','Painting','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('EWO3','Fisciano','Molding','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('EWO4','Avellino','Administration','SENT');
insert into POSSESSOS(ACTIVITYID,FACTORYSITE,AREA,TICKETSTATEFORAREA) values ('EWO5','Benevento','Management','SENT');
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-2','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-3','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-4','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-5','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-7','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-8','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-9','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2021-1-10','maintainer15',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer1',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer2',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer3',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer4',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer5',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer6',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer7',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer8',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer9',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer10',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer11',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer12',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer13',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer14',420);
insert into AVAILABILITY(GIORNO,NOMEMAINTAINER,MIN) values ('2020-12-10','maintainer15',420);
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Conoscenza VHDL');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Controllare robot');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Usare pc');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Utilizzo tensili per il montaggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Capacità di monitoraggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Sicurezza di produzione');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Controllo qualità');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Analisi termografica dei componenti');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Tecniche di testing');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Utilizzo DPI');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase1','Utilizzo di strumenti di reporting');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Conoscenza VHDL');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Controllare robot');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Usare pc');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Utilizzo tensili per il montaggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Capacità di monitoraggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Sicurezza di produzione');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Controllo qualità');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Analisi termografica dei componenti');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Tecniche di testing');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Utilizzo DPI');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase2','Utilizzo di strumenti di reporting');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Conoscenza VHDL');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Controllare robot');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Usare pc');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Utilizzo tensili per il montaggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Capacità di monitoraggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Sicurezza di produzione');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Controllo qualità');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Analisi termografica dei componenti');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Tecniche di testing');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Utilizzo DPI');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase3','Utilizzo di strumenti di reporting');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase4','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase4','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase4','Conoscenza VHDL');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase4','Controllare robot');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase4','Usare pc');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase5','Utilizzo tensili per il montaggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase5','Capacità di monitoraggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase5','Sicurezza di produzione');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase5','Controllo qualità');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase5','Analisi termografica dei componenti');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase5','Tecniche di testing');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase5','Utilizzo DPI');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase6','Utilizzo di strumenti di reporting');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase6','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase6','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase7','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase7','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Conoscenza VHDL');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Controllare robot');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Usare pc');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Utilizzo tensili per il montaggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Capacità di monitoraggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Sicurezza di produzione');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Controllo qualità');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Analisi termografica dei componenti');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase8','Tecniche di testing');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase9','Utilizzo DPI');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase9','Utilizzo di strumenti di reporting');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase9','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase9','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase10','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase10','Conoscenza SCADA');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase10','Conoscenza VHDL');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase10','Controllare robot');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase11','Usare pc');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase12','Utilizzo tensili per il montaggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase12','Capacità di monitoraggio');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase12','Sicurezza di produzione');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase12','Controllo qualità');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase13','Analisi termografica dei componenti');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase13','Tecniche di testing');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase13','Utilizzo DPI');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase14','Utilizzo di strumenti di reporting');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase15','Usare interfaccia linea di comando');
insert into COMPETENZERICHIESTE(NOMEPROCEDURA,COMPETENZA) values ('proceduraBase15','Conoscenza SCADA');
insert into MATERIALI(NOMEMATERIALE) values ('Alluminio');
insert into MATERIALI(NOMEMATERIALE) values ('Legno');
insert into MATERIALI(NOMEMATERIALE) values ('Calcestruzzo');
insert into MATERIALI(NOMEMATERIALE) values ('Mattoni');
insert into MATERIALI(NOMEMATERIALE) values ('Catrame');
insert into MATERIALI(NOMEMATERIALE) values ('Gomma');
insert into MATERIALI(NOMEMATERIALE) values ('Silicone');
insert into MATERIALI(NOMEMATERIALE) values ('Resina');
insert into MATERIALI(NOMEMATERIALE) values ('Nylon');
insert into MATERIALI(NOMEMATERIALE) values ('Fibra di carbonio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Usare interfaccia linea di comando');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Conoscenza SCADA');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Conoscenza VHDL');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Controllare robot');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Usare pc');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Utilizzo tensili per il montaggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Capacità di monitoraggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Sicurezza di produzione');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Controllo qualità');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Analisi termografica dei componenti');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Tecniche di testing');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Utilizzo DPI');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer1','Utilizzo di strumenti di reporting');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer2','Usare interfaccia linea di comando');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer2','Conoscenza SCADA');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer2','Conoscenza VHDL');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer2','Controllare robot');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer2','Usare pc');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer2','Utilizzo tensili per il montaggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer3','Capacità di monitoraggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer3','Sicurezza di produzione');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer3','Controllo qualità');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer3','Analisi termografica dei componenti');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer3','Tecniche di testing');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer3','Utilizzo DPI');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer3','Utilizzo di strumenti di reporting');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer4','Usare interfaccia linea di comando');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer4','Conoscenza SCADA');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer5','Conoscenza VHDL');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer5','Controllare robot');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer5','Usare pc');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer6','Utilizzo tensili per il montaggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer6','Capacità di monitoraggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer6','Sicurezza di produzione');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer6','Controllo qualità');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer6','Analisi termografica dei componenti');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer7','Tecniche di testing');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer7','Utilizzo DPI');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer7','Utilizzo di strumenti di reporting');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer8','Usare interfaccia linea di comando');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer8','Conoscenza SCADA');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer8','Conoscenza VHDL');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer8','Controllare robot');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer8','Usare pc');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer8','Utilizzo tensili per il montaggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer9','Capacità di monitoraggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer10','Sicurezza di produzione');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer11','Controllo qualità');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer11','Analisi termografica dei componenti');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer11','Tecniche di testing');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer12','Utilizzo DPI');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer12','Utilizzo di strumenti di reporting');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer12','Usare interfaccia linea di comando');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer13','Conoscenza SCADA');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer13','Conoscenza VHDL');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer13','Controllare robot');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer13','Usare pc');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer13','Utilizzo tensili per il montaggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer13','Capacità di monitoraggio');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer13','Sicurezza di produzione');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer14','Controllo qualità');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer15','Analisi termografica dei componenti');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer15','Tecniche di testing');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer15','Utilizzo DPI');
insert into POSSESSO(NOMEMAINTAINER,COMPETENZA) values ('maintainer15','Utilizzo di strumenti di reporting');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Conoscenza VHDL');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Controllare robot');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Usare pc');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Utilizzo tensili per il montaggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Capacità di monitoraggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('1','Sicurezza di produzione');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Conoscenza VHDL');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Controllare robot');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Usare pc');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Utilizzo tensili per il montaggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Capacità di monitoraggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Sicurezza di produzione');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Controllo qualità');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Analisi termografica dei componenti');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Tecniche di testing');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Utilizzo DPI');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('2','Utilizzo di strumenti di reporting');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Conoscenza VHDL');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Controllare robot');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Usare pc');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Utilizzo tensili per il montaggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Capacità di monitoraggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Sicurezza di produzione');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Controllo qualità');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Analisi termografica dei componenti');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Tecniche di testing');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Utilizzo DPI');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('3','Utilizzo di strumenti di reporting');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('4','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('4','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('4','Conoscenza VHDL');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('4','Controllare robot');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('4','Usare pc');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('5','Utilizzo tensili per il montaggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('5','Capacità di monitoraggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('5','Sicurezza di produzione');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('5','Controllo qualità');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('5','Analisi termografica dei componenti');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('5','Tecniche di testing');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('5','Utilizzo DPI');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('6','Utilizzo di strumenti di reporting');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('6','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('6','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('7','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('7','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Conoscenza VHDL');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Controllare robot');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Usare pc');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Utilizzo tensili per il montaggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Capacità di monitoraggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Sicurezza di produzione');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Controllo qualità');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Analisi termografica dei componenti');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('8','Tecniche di testing');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('9','Utilizzo DPI');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('9','Utilizzo di strumenti di reporting');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('9','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('9','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('10','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('10','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('10','Conoscenza VHDL');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('10','Controllare robot');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('11','Usare pc');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('12','Utilizzo tensili per il montaggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('12','Capacità di monitoraggio');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('12','Sicurezza di produzione');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('12','Controllo qualità');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('13','Analisi termografica dei componenti');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('13','Tecniche di testing');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('13','Utilizzo DPI');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('14','Utilizzo di strumenti di reporting');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('15','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('EWO1','Conoscenza SCADA');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('EWO1','Tecniche di testing');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('EWO2','Utilizzo DPI');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('EWO3','Utilizzo di strumenti di reporting');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('EWO4','Usare interfaccia linea di comando');
insert into POSSESSOC(ACTIVITYID,COMPETENZA) values ('EWO5','Conoscenza SCADA');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('1','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('1','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('1','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('1','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('1','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('2','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('2','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('2','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('2','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('3','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('3','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('3','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('3','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('3','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('4','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('4','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('4','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('4','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('4','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('5','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('5','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('5','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('5','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('5','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('6','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('6','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('6','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('7','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('7','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('8','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('8','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('8','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('9','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('9','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('10','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('10','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('10','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('10','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('11','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('11','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('11','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('11','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('11','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('12','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('12','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('12','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('12','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('12','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('13','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('13','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('13','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('13','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('14','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('14','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('15','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('15','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('15','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO1','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO1','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO1','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO2','Catrame');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO2','Alluminio');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO3','Legno');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO4','Calcestruzzo');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO5','Mattoni');
insert into POSSESSOM(ACTIVITYID,NOMEMATERIALE) values ('EWO5','Catrame');
/* Grant privileges */
grant all privileges on all tables in schema public to gruppo5;