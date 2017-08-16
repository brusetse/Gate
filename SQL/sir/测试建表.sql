create table gzsxtstu01(
       sno number(10) primary key,
       sname varchar2(40) not null,
       age number(3) check(age>0 and age<200),
       indentify varchar2(50) not null unique,
       gender number(1) default(1),
       zhuanye number(20)
             
)
create sequence seq_gzsxtstu01_sno  start with 1 increment by 1;
select seq_gzsxtstu01_sno.nextval from dual;

insert into gzsxtstu01(sno,sname,age,indentify,gender,zhuanye) values(seq_gzsxtstu01_sno.nextval,'cai10',18,'493874593749583798475983',0,5);


select * from gzsxtstu01;


create table gzsxtstu02(
       sno number(10) ,
       sname varchar2(40) not null,
       age number(3) ,
       indentify varchar2(50) not null unique,
       gender number(1) default(1),
       zhuanye number(20),
       constraint pk_con_sno primary key(sno),
       constraint ck_con_age  check(age>0 and age<200)
             
)

drop table gzsxtstu;

create table gzsxtstu(
       sno number(10) ,
       sname varchar2(40) not null,
       age number(3) ,
       indentify varchar2(50) not null unique,
       gender number(1) default(1),
       mjid number(20),
       foreign key(mjid) references sxt_major(scid)             
)

insert into gzsxtstu(sno,sname,age,indentify,gender,mjid) values(seq_gzsxtstu01_sno.nextval,'cai10',18,'493874593749583798475983',0,5);



