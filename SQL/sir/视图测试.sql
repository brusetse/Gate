select * from emp ;

create or replace  view v$_emp as
select * from emp with read only;

--scott 这个用户是一个普通用户
-- sys dba用户给scott授权

--视图当做一个表使用
 select * from v$_emp;
 
 --查询当前用户拥有哪些视图
 SELECT *  FROM user_views
WHERE view_name ='V$_EMP';

drop view V$_EMP;


--测试视图里面的数据修改
insert into V$_EMP(empno,ename,sal,deptno) values(9090,'cai30',4000,10);
delete from V$_EMP where ename='cai30';
update V$_EMP set ename='cai50' where ename='cai10';



select dname, grade from
    (select deptno, avg_sal, grade from
      (select deptno, avg(sal) avg_sal from emp group by deptno) t,
      salgrade s
    where
      t.avg_sal between s.losal and s.hisal )
   t1,
   dept
where t1.deptno = dept.deptno
   and
   t1.grade =
       (select min(grade) from
           (select deptno, avg_sal, grade from
                   (select deptno, avg(sal) avg_sal from emp group by deptno) t,
                   salgrade s
               where
                   t.avg_sal between s.losal and s.hisal )
       );
create or replace view v$_emp_salgrade as
select deptno, avg_sal, grade from
                   (select deptno, avg(sal) avg_sal from emp group by deptno) t,
                   salgrade s
               where
                   t.avg_sal between s.losal and s.hisal
--使用我们往往把一些 重复使用的查询语句 使用视图
--使用视图尽量不用使用 修改的操作，很不好维护
--公司能不用视图就不会视图
select dname, grade
  from v$_emp_salgrade t1, dept
 where t1.deptno = dept.deptno
   and t1.grade = (select min(grade) from v$_emp_salgrade);
   

