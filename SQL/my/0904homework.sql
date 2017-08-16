select * from emp1
select * from dept
delete from emp1 where ename = 'zhangsan' or ename = 'lisi' or ename = 'liu4gou'
insert into emp1(empno,ename,sal,deptno) values(seq_id.nextval,'zhangsan',8000,20);
insert into emp1(empno,ename,sal,deptno) values(seq_id.nextval,'lisi',7000,30);
insert into emp1(empno,ename,sal,deptno) values(seq_id.nextval,'wangwu',9000,10);

create sequence seq_id start with 8000 increment by 1

drop sequence seq_id

update emp1 set sal=4000 where ename='zhangsan'


