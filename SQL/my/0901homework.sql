/*练习针对Oracle的SCOTT方案
============查询及函数部分==============
第一部分：
1、使用基本查询语句.
    (1)查询DEPT表显示所有部门名称.
    (2)查询EMP表显示所有雇员名及其全年收入(月收入=工资+补助),
    处理NULL行,并指定列别名为"年收入"。（NVL(comm,0) comm取空值时用0替代）
    (3)查询显示不存在雇员的所有部门号。*/
--1    
select d.dname from dept d
--2
select e.ename,12*(e.sal+nvl(e.comm,0)) 年收入 from emp e
--3
select distinct d.deptno from dept d,
(select distinct e.deptno from emp e) where d.deptno not in (select distinct e.deptno from emp e)

/*2、限制查询数据
    (1)查询EMP表显示工资超过2850的雇员姓名和工资。
    (2)查询EMP表显示工资不在1500～2850之间的所有雇员及工资。
    (3)查询EMP表显示代码为7566的雇员姓名及所在部门代码。
    (4)查询EMP表显示部门10和30中工资超过1500的雇员名及工资。
    (5)查询EMP表显示第2个字符为"A"的所有雇员名其工资。
    (6)查询EMP表显示补助非空的所有雇员名及其补助。*/
--1
select e.ename,e.sal from emp e where e.sal>=2850
--2
select e.ename,e.sal from emp e where e.sal not between 1500 and 2850
--3
select e.ename,e.deptno from emp e where e.empno = 7566
--4
select e.ename,e.sal,e.deptno from emp e where e.deptno in (10,30) and e.sal>1500
--5 
select e.ename,e.sal from emp e where e.ename like '_A%'
--6
select e.ename,e.comm from emp e where e.comm is not null

/*3、排序数据
    (1)查询EMP表显示所有雇员名、工资、雇佣日期，并以雇员名的升序进行排序。
    (2)查询EMP表显示在1981年2月1日到1981年5月1日之间雇佣的雇员名、岗位及雇佣日期，并以雇佣日期进行排序。
    (3)查询EMP表显示获得补助的所有雇员名、工资及补助，并以工资升序和补助降序排序。*/
--1
select e.ename,e.sal,e.hiredate from emp e order by e.ename
--2
select e.ename, e.job, e.hiredate from emp e
 where e.hiredate between to_date('1981/02/01', 'yyyy/mm/dd') and
       to_date('1981/05/01', 'yyyy/mm/dd') order by e.hiredate
       
select e.ename, e.job, e.hiredate from emp e
 where e.hiredate between '1-2月-1981' and '1-5月-1981' order by e.hiredate
--3
select e.ename,e.sal,e.comm from emp e where e.comm is not null order by e.sal asc,e.comm desc


--第二部分：
--1．列出至少有一个雇员的所有部门。    
select distinct d.* from dept d,(select distinct e.deptno from emp e) 
where d.deptno in (select distinct e.deptno from emp e)

--2．列出薪金比“SMITH”多的所有雇员。
select e.ename,e.sal from emp e where e.sal > (select e.sal from emp e where e.ename='SMITH')

--3．列出所有雇员的姓名及其上级的姓名。
select e.ename 姓名,e1.ename 上级 from emp e,emp e1 where e.mgr = e1.empno

--4．列出入职日期早于其直接上级的所有雇员。
select e.ename,e.hiredate from emp e,emp e1 where e.mgr = e1.empno and e.hiredate < e1.hiredate

--5．列出部门名称和这些部门的雇员，同时列出那些没有雇员的部门。    
select d.deptno,e.ename from emp e full join dept d on e.deptno = d.deptno order by deptno

--6．列出所有“CLERK”（办事员）的姓名及其部门名称。
select e.ename,e.deptno from emp e where e.job = 'CLERK'

--7．列出各种岗位的最低薪金，并显示最低薪金大于1500所有工作岗位及其最低薪资。
select t.job,t.msal from
(select e.job,min(e.sal) msal from emp e group by e.job)t where t.msal>1500

--8．列出从事“SALES”（销售）工作的雇员的姓名，假定不知道销售部的部门编号。
select e.ename from emp e join dept d on e.deptno = d.deptno where d.dname='SALES'

--9．列出薪金高于公司平均的所有雇员。
select e.* from emp e where e.sal>(select avg(e.sal) from emp e)

--10．列出与“SCOTT”从事相同工作的所有雇员。
select e.* from emp e where e.job = (select e.job from emp e where e.ename = 'SCOTT') and e.ename != 'SCOTT'

--11．列出薪金等于在部门30工作的所有雇员的薪金的雇员的姓名和薪金。
select e.ename,e.sal from emp e where e.sal in(select e.sal from emp e where e.deptno = 30)

--12．列出薪金高于在部门30工作的所有雇员的薪金的雇员的姓名和薪金。
select e.ename,e.sal from emp e where e.sal > all(select e.sal from emp e where e.deptno = 30)

--13．列出在每个部门工作的雇员的数量以及其他信息。
select t.c 雇员数量,d.* from dept d join
(select count(1) c,e.deptno from emp e group by e.deptno)t on d.deptno = t.deptno

--14．列出所有雇员的雇员名称、部门名称和薪金。
select e.ename,d.dname,e.sal from emp e join dept d on e.deptno = d.deptno

--16．列出分配有雇员数量的所有部门的详细信息即使是分配有0个雇员。
select t.c 雇员数量,d.* from dept d full join
(select count(1) c,e.deptno from emp e group by e.deptno)t on d.deptno = t.deptno

--17．列出各种类别工作的最低工资。
select e.job,min(e.sal) from emp e group by job

--18．列出各个部门的MANAGER（经理）的最低薪金。
select e.deptno,min(e.sal) from emp e where e.job = 'MANAGER' group by e.deptno

--19．列出按计算的字段排序的所有雇员的年薪。 ??计算的字段??
select e.ename, e.sal from emp e order by e.sal


--第三部分：
--1.找出各月倒数第3天受雇的所有员工.
select e.* from emp e where to_char(last_day(e.hiredate),'dd')-to_char(e.hiredate,'dd')=2
select e.* from emp e where last_day(e.hiredate)-e.hiredate=2

--2.找出早于12年前受雇的员工.
select e.* from emp e where (sysdate - e.hiredate)/365 >=12

--3.以首字母大写的方式显示所有员工的姓名.
select upper(e.ename) from emp e

--4.显示正好为5个字符的员工的姓名.
select e.ename from emp e where length(e.ename) = 5

--5.显示不带有"R"的员工的姓名
select e.ename from emp e where e.ename not like '%R%'

--6.显示所有员工姓名的前三个字符.
select substr(e.ename,1,3) from emp e

--7.显示所有员工的姓名,用a替换所有"A"
select replace(e.ename,'A','a') from emp e

--8.显示满10年服务年限的员工的姓名和受雇日期.:
select e.ename,e.hiredate from emp e where (sysdate - e.hiredate)/365 >=10

--9.显示员工的详细资料,按姓名排序.
select e.* from emp e order by e.ename

--10.显示员工的姓名和受雇日期,根据其服务年限,将最老的员工排在最前面.
select e.ename,e.hiredate from emp e order by e.hiredate

--11.显示所有员工的姓名、工作和薪金,按工作的降序排序,若工作相同则按薪金排序.
select e.ename,e.job,e.sal from emp e order by job desc ,sal asc

--12.显示所有员工的姓名、加入公司的年份和月份,按受雇日期所在月排序,若月份相同则将最早年份的员工排在最前面.
select e.ename,to_char(e.hiredate,'yyyy') 年份,to_char(e.hiredate,'mm') 月份 
from emp e order by to_char(e.hiredate,'mm') ,to_char(e.hiredate,'yyyy')

--13.显示在一个月为30天的情况所有员工的日薪金,忽略余数.
select e.ename,round(e.sal/30) 日薪金 from emp e

--14.找出在(任何年份的)2月受聘的所有员工。
select e.* from emp e where to_char(e.hiredate,'mm')=2

--15.对于每个员工,显示其加入公司的天数.
select e.ename,round(sysdate - e.hiredate) 加入天数 from emp e

--16.显示姓名字段的任何位置包含"A"的所有员工的姓名.
select e.ename from emp e where e.ename like '%A%'

--17.以年月日的方式显示所有员工的服务年限. (大概)
select trunc((sysdate - e.hiredate) / 365) 年,
       trunc(mod((sysdate - e.hiredate), 365) / 30) 月,
       trunc(mod(mod((sysdate - e.hiredate), 365), 30)) 日
  from emp e



--第四部分：
--6 用一个查询语句，实现查询各个岗位的总工资和各个部门的总工资和所有雇员的总工资
select max(case t.deptno when 10 then t.sum_sal end) "部门10",
max(case t.deptno when 20 then t.sum_sal end) "部门20",
max(case t.deptno when 30 then t.sum_sal end) "部门30",
max(case t.deptno when 40 then t.sum_sal end) "部门40",
max(case t2.job when 'CLERK' then t2.sum_sal end) "CLERK" ,
max(case t2.job when 'SALESMAN' then t2.sum_sal end) "SALESMAN" ,
max(case t2.job when 'PRESIDENT' then t2.sum_sal end) "PRESIDENT" ,
max(case t2.job when 'MANAGER' then t2.sum_sal end) "MANAGER" ,
max(case t2.job when 'ANALYST' then t2.sum_sal end) "ANALYST" ,
max(t3.sum_sal) 总工资
from (select e.deptno,sum(e.sal) sum_sal from emp e group by e.deptno)t,
(select e.job,sum(e.sal) sum_sal from emp e group by e.job)t2,
(select sum(e.sal) sum_sal from emp e)t3
--7 用一个查询语句，实现查询各个岗位的总工资和所有雇员的总工资
select max(case t.job when 'CLERK' then t.sum_sal end) "CLERK" ,
max(case t.job when 'SALESMAN' then t.sum_sal end) "SALESMAN" ,
max(case t.job when 'PRESIDENT' then t.sum_sal end) "PRESIDENT" ,
max(case t.job when 'MANAGER' then t.sum_sal end) "MANAGER" ,
max(case t.job when 'ANALYST' then t.sum_sal end) "ANALYST",
sum(t.sum_sal) 总工资
from (select e.job,sum(e.sal) sum_sal from emp e group by e.job)t
--8 用一个查询语句，实现查询各个部门的总工资和各个岗位的总工资
select max(case t.deptno when 10 then t.sum_sal end) "部门10",
max(case t.deptno when 20 then t.sum_sal end) "部门20",
max(case t.deptno when 30 then t.sum_sal end) "部门30",
max(case t.deptno when 40 then t.sum_sal end) "部门40",
max(case t2.job when 'CLERK' then t2.sum_sal end) "CLERK" ,
max(case t2.job when 'SALESMAN' then t2.sum_sal end) "SALESMAN" ,
max(case t2.job when 'PRESIDENT' then t2.sum_sal end) "PRESIDENT" ,
max(case t2.job when 'MANAGER' then t2.sum_sal end) "MANAGER" ,
max(case t2.job when 'ANALYST' then t2.sum_sal end) "ANALYST"
from (select e.deptno,sum(e.sal) sum_sal from emp e group by e.deptno)t,
(select e.job,sum(e.sal) sum_sal from emp e group by e.job)t2
--10 通过查询显示每个员工的姓名和工资等级
select e.ename,sa.grade from emp e join salgrade sa on e.sal between sa.losal and sa.hisal
--11 通过查询显示每个员工的姓名和部门名称，并通过部门的不同分组
select e.ename,e.deptno from emp e join dept d on e.deptno = d.deptno order by deptno
--12 查询每个员工的姓名和他的上司的名字
select e1.ename||' 的上司是 '||e2.ename from emp e1 join emp e2 on e1.mgr = e2.empno

