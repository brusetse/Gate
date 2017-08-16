--1．列出至少有一个雇员的所有部门。    
select   e.deptno ,count(e.empno) from emp e where e.deptno is not null  group by e.deptno having count(e.empno)>0 ;
--2．列出薪金比“SMITH”多的所有雇员。
select * from emp e where e.sal > (select p.sal from emp p where p.ename='SMITH');
--3．列出所有雇员的姓名及其上级的姓名。
select e.ename ,p.ename "上级姓名"  from emp e, emp p where e.mgr = p.empno(+);
--4．列出入职日期早于其直接上级的所有雇员。
select e.ename ,p.ename "上级姓名"  from emp e, emp p where e.mgr = p.empno(+) and e.hiredate < p.hiredate;
--5．列出部门名称和这些部门的雇员，同时列出那些没有雇员的部门。
    select d.dname,e.ename from emp e,dept d where e.deptno (+)= d.deptno;
--6．列出所有“CLERK”（办事员）的姓名及其部门名称。
    select e.ename,d.dname from emp e , dept d where e.deptno = d.deptno and e.job='CLERK';
--7．列出各种岗位的最低薪金,并显示最低薪金大于1500所有工作岗位及其最低薪资。
 select  e.job,min(e.sal) sal from emp e  group by e.job having min(e.sal) >1500;
--8．列出从事“SALES”（销售）工作的雇员的姓名，假定不知道销售部的部门编号。
    select e.ename from emp e,dept d where e.deptno = d.deptno and e.job = 'SALES' ;
--9．列出薪金高于公司平均的所有雇员。
    select  e.ename from emp e where e.sal > ( select avg(p.sal) from emp p );
--10．列出与“SCOTT”从事相同工作的所有雇员。
    select e.ename  from emp e where e.ename <> 'SCOTT' and  e.job = (select p.job from emp p where p.ename = 'SCOTT') ;
--11．列出薪金等于在部门30工作的所有雇员的薪金的雇员的姓名和薪金。
    select e.ename,e.sal  from emp e where e.deptno != 30 and  e.sal = any( select p.sal from emp p  where p.deptno = 30);
--12．列出薪金高于在部门30工作的所有雇员的薪金的雇员的姓名和薪金。
    select e.ename,e.sal  from emp e where e.deptno != 30 and  e.sal > all( select p.sal from emp p  where p.deptno = 30);  
--13．列出在每个部门工作的雇员的数量以及其他信息。
    select d.deptno,d.dname,d.loc,count(e.empno)  from emp e ,dept d where e.deptno (+)= d.deptno group by d.deptno,d.dname,d.loc;

--14．列出所有雇员的雇员名称、部门名称和薪金。
    select e.ename,d.dname,e.sal from emp e ,dept d where e.deptno (+)= d.deptno;

--15．列出从事同一种工作但属于不同部门雇员的不同组合。
    select  distinct e.empno,e.ename ,e.job  ,e.deptno
    from emp e  ,(select p.job ,p.deptno from emp p group by p.job ,p.deptno  ) m 
    where e.deptno != m.deptno
    and e.job = m.job
    
--16．列出分配有雇员数量的所有部门的详细信息即使是分配有0个雇员。
     select count(e.empno),d.deptno,d.dname,d.loc from emp e,dept d where e.deptno (+)= d.deptno   group by d.deptno,d.dname,d.loc
--17．列出各种类别工作的最低工资。
      select min(e.sal) from emp e  group by e.job;
--18．列出各个部门的MANAGER（经理）的最低薪金。
      select e.deptno,min(e.sal)  from emp e where  e.job ='MANAGER'  group by e.deptno ;
--19．列出按计算的字段排序的所有雇员的年薪。
      select * from (select  e.ename,(e.sal+nvl(e.comm,0))*12 salbyyear  from emp e) m order by m.salbyyear;
    
