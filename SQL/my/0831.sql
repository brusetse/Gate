--1.  求部门中薪水最高的人
select *
  from emp e,
       (select deptno, max(e1.sal) max_sal from emp e1 group by e1.deptno) m
 where e.sal = m.max_sal
   and e.deptno = m.deptno
    
select *
  from emp e
  join (select deptno, max(e1.sal) max_sal from emp e1 group by e1.deptno) m
    on (e.sal = m.max_sal and e.deptno = m.deptno)

--2.	求部门平均薪水的等级
select * from 
salgrade s, (select deptno,avg(sal) avg_sal 
from emp group by deptno) t
where t.avg_sal between s.losal and s.hisal;

select *
  from salgrade s
  join (select deptno, avg(sal) avg_sal from emp group by deptno) t
    on (t.avg_sal between s.losal and s.hisal)

--3.	求部门平均的薪水等级
select avg(s.grade) 平均薪水等级, e.deptno
  from emp e
  join salgrade s
    on (e.sal between s.losal and s.hisal)
 group by deptno
--4.	雇员中有哪些人是经理人
select distinct e1.* from emp e join emp e1 on e.mgr = e1.empno

select e.* from emp e where e.empno in (select distinct e.mgr from emp e) 
select e.* from emp e where e.empno not in (select distinct e.mgr from emp e where e.mgr is not null) 
--5.	不准用组函数，求薪水的最高值
select e.* from emp e where e.sal >= all (select e1.sal from emp e1)

--6.	求平均薪水最高的部门的部门编号
select m.deptno, m.avg_sal 平均薪水
  from (select avg(sal) avg_sal, deptno from emp group by deptno) m
 where m.avg_sal >= all (select avg(sal) avg_sal from emp group by deptno)
--组函数嵌套写法(对多可以嵌套一次，group by 只对内层函数有效)
--7.	求平均薪水最高的部门的部门名称
select d.dname, m.avg_sal 平均薪水
  from dept d, (select avg(sal) avg_sal, deptno from emp group by deptno) m
 where m.avg_sal >= all (select avg(sal) avg_sal from emp group by deptno)
   and d.deptno = m.deptno

--8.	求平均薪水的等级最低的部门的部门名称
select d.dname
  from dept d,
       (select s.grade, m.avg_sal, m.deptno
          from salgrade s,
               (select deptno, avg(sal) avg_sal from emp group by deptno) m
         where m.avg_sal between s.losal and s.hisal) t
 where t.grade <= all
 (select s.grade
          from salgrade s,
               (select deptno, avg(sal) avg_sal from emp group by deptno) m
         where m.avg_sal between s.losal and s.hisal)
   and d.deptno = t.deptno;
   
--9.	求部门经理人中平均薪水最低的部门名称 
select t.deptno
  from (select avg(m.sal) avg_sal,deptno
          from (select distinct e1.*
                  from emp e
                  join emp e1
                    on e.mgr = e1.empno) m
         group by deptno) t
 where t.avg_sal <= all (select avg(m.sal) avg_sal
          from (select distinct e1.*
                  from emp e
                  join emp e1
                    on e.mgr = e1.empno) m
         group by deptno)

--10.	求比普通员工的最高薪水还要高的经理人名称(not in)
select distinct e1.* from emp e join emp e1 on e.mgr = e1.empno
where e1.sal
>= all(select e.sal from emp e 
minus
select distinct e1.sal from emp e join emp e1 on e.mgr=e1.empno)

--11.	求薪水最高的前5名雇员
select * from (select * from emp order by sal desc) where rownum<=5 ;

--12.	求薪水最高的第6到第10名雇员(important)
select * from (select * from emp order by sal desc) where rownum<=10
minus
select * from (select * from emp order by sal desc) where rownum<=5

--13.	求最后入职的5名员工
select * from (select * from emp order by hiredate desc) where rownum<=5

--使用99语法更改相应作业：
--1．列出所有雇员的姓名及其上级的姓名。
select worker.ename || ' 的上级是 ' || manager.ename 上下级关系
  from emp worker
  join emp manager
    on worker.mgr = manager.empno
--2．列出入职日期早于其直接上级的所有雇员。
select worker.ename
  from emp worker
  join emp manager
    on worker.mgr = manager.empno
 where worker.hiredate < manager.hiredate
--3．列出所有部门名称及雇员
select e.ename,d.dname,e.deptno from emp e join dept d on e.deptno = d.deptno order by e.deptno
--4．列出所有“CLERK”（办事员）的姓名及其部门名称。
select e.ename,e.job,d.dname from emp e join dept d on e.deptno = d.deptno where e.job = 'CLERK'
--5．列出从事“SALES”（销售）工作的雇员的姓名，假定不知道销售部的部门编号。
select e.ename,d.dname from emp e join dept d on e.deptno = d.deptno where d.dname = 'SALES'
--6．列出在每个部门工作的雇员的数量以及其他信息。
select count(1),e.deptno,avg(e.sal) from emp e group by deptno
--7．列出所有雇员的雇员名称、部门名称和薪金。
select e.ename,d.dname,e.sal from emp e join dept d on e.deptno = d.deptno 
--8.求出部门编号为20的雇员名、部门名、薪水等级
select e.ename, d.dname, s.grade
  from emp e
  join dept d
    on e.deptno = d.deptno
  join salgrade s
    on e.sal between s.losal and s.hisal
 where e.deptno = 20;

select sum(ename) from emp
