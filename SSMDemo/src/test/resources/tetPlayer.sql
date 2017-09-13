create table player(
       name varchar2(60),
       id number(10),
       age number(3),
       primary key(id)
)
create table coach(
 name varchar2(60),
       id number(10),
       age number(3),
       salary number(10,1),
       primary key(id)

);

create table team(
       team_name varchar2(60),
       location varchar2(60),
       id number(10),
       coach_id number(10),
       all_salary number(11,1),
       primary key(id)

);
create sequence test_team
minvalue 1
maxvalue 9999999999999
start with 1
increment by 1
nocache;

create sequence test_coach
minvalue 1
maxvalue 9999999999999
start with 1
increment by 1
nocache;

select test_coach.currval from dual

select * from team;

alter table player add team_id number(10) ;

select * from coach;