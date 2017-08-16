select * from emp e1
--创建视图
create or replace view v$_emp1 as select * from emp1

select * from v$_emp
--删除视图
drop view v$_emp1

select * from emp
select * from emp1

select * from v$_emp1

select * from v$_emp1 where deptno = 10
--插入数据
insert into v$_emp1(empno,ename,sal) values(8818,'zhangsan1',6000)
--更改数据
update v$_emp1 set ename = 'zhangsan' where ename = 'zhangsan1'
--删除数据
delete from v$_emp1 where ename = 'zhangsan'
--创建只读视图
create or replace view v$_emp2 as (select * from emp1) with read only

drop view v$_emp1

insert into v$_emp2(ename,sal) values ('zhangsan',1800) 
--创建序列
create sequence seq_id increment by 1 start with 1;
--查看序列
select seq_id.currval from dual;

select seq_id.nextval from dual;
--删除序列
drop sequence seq_id
--复制表
create table emp3 as select * from emp where 1=1

select * from emp3
drop table emp3
--插入多行数据
insert into emp3 (select * from emp1 )

delete from emp1 where ename = 'zhangsan1' 
--更改数据
update emp1 set ename = 'lisi' where ename = 'zhangsan'

drop table zzz

select * from zzz
--创建表
create table zzz(id number(2));
--增加列
alter table zzz add (name varchar2(10),age number(3))
--删除列
alter table zzz drop column age
--改表名
rename zzzz to zzz
