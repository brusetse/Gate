--创建视图
create or replace view v$_emp as select * from emp
create or replace view v$_emp_dept as select e.ename,e.deptno,d.dname from emp e,dept d where e.deptno = d.deptno

select * from v$_emp
--删除视图
drop view v$_emp
drop view v$_emp_dept

select * from emp

select * from v$_emp_dept
--插入数据
insert into v$_emp_dept(ename,deptno) values('BOB',10)

insert into v$_emp(ename,deptno,empno) values('BOB',10,8888)
--更改数据
update v$_emp set ename = 'JAMES' where ename = 'BOB'

delete from v$_emp where ename = 'JAMES'

insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7900,'JAMES','CLERK',7698,to_date('1981/3/12','yyyy/dd/mm'),950,30)

select * from user_views where view_name = 'V$_EMP'
--创建只读数据
create or replace view v$_emp as select * from emp with read only
--创建序列
create sequence seq_id start with 5 increment by 5

select seq_id.nextval from dual

select seq_id.currval from dual

drop sequence seq_id

create table emp1 as select * from emp where 1=1

create sequence seq_id start with 1 increment by 1
--约束
create table tb_student
(
       id number(3) primary key,
       no varchar2(10) unique,
       name varchar2(10),
       gender number(1) default 1 check(gender in (1,2)),
       age number(3) default 18,
       email varchar2(20) unique,
       attendtime date
)

create table tb_course
(
       id number(3) primary key,
       name varchar2(10) unique not null,
       describe varchar2(200)
)

create table tb_score
(
       id number(3) primary key,
       stuid number(3),
       couid number(3),
       score number(5,2) default 0 not null,
       foreign key(stuid) references tb_student(id),
       foreign key(couid) references tb_course(id)
)

