insert into emp02(empno,ename,job,sal) values(9091,'gaga01','SALESMAN',1800);

insert into dept(deptno,dname,loc) values(50,'教学部','899');
select * from dept;

create table emptest as select * from emp where deptno=10;

select * from emptest 

insert into emptest select * from emp where deptno=20;

--delete
delete from emptest where deptno=10;
delete from emptest ;
drop table emptest;
--
truncate table emptest;

--update

update emptest set ename='cai10',sal=8989 ,deptno=10 where empno=7902;


insert into emp02(empno,ename,job,sal) values(9091,'gaga01','SALESMAN',1800);


 
insert into dept(deptno,dname,loc) values(61,'教学部2','899');
insert into dept(deptno,dname,loc) values(50,'教学部3','899');
insert into dept(deptno,dname,loc) values(81,'教学部4','899');
--update
--delete


select * from dept;
rollback;

truncate table emp02;
select * from emp02;


insert into emp02(empno,ename,job,sal) values(9096,'gaga0121','SALESMAN',1800);
insert into emp02(empno,ename,job,sal) values(9092,'gag123a01','SALESMAN',1800);
savepoint q2;
insert into emp02(empno,ename,job,sal) values(9093,'gag123a01','SALESMAN',1800);
insert into emp02(empno,ename,job,sal) values(9094,'gag123a01','SALESMAN',1800);
rollback to q2;
--commit;
rollback;


insert into emp02(empno,ename,job,sal) values(9096,'gaga0121','SALESMAN',1800);
insert into emp02(empno,ename,job,sal) values(9092,'gag123a01','SALESMAN',1800);

create table gzsxtstu(
       stuno number(10),
       sname varchar2(50)
)
