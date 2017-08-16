--找到 部门是10或30  且薪水大于1500
select e.* from emp e where (e.deptno=10 or e.deptno=30) and e.sal>1500;
-- not and or  优先级你可以使用（）提高
select e.* from emp e where  not(e.sal between 1500 and 3000)  and e.deptno=10 
/*
1、查询部门编号为10的员工信息
2、查询年薪大于3万的人员的姓名与部门编号
3、查询佣金为null的人员姓名与工资
4、查询工资大于1500 且 and 含有佣金的人员姓名
5、查询工资大于1500 或 or含有佣金的人员姓名
6、查询姓名里面含有 S 员工信息 工资、名称
7、求姓名以J开头第二个字符O的员工姓名的与工资
8、求包含%的雇员姓名
9、使用in查询部门名称为 SALES 和 RESEARCH 的雇员姓名、工资、部门编号
10、使用exists查询部门名称为SALES和RESEARCH 的雇员姓名、工资、部门编号。
*/
--1
select e.* from emp e where e.deptno=10;
--select            from emp e;
--|| java 字符串连接
select e.ename ||'is job:'|| e.job as "empdesc" from emp e;

select * from emp;

select 18+null from dual;
--2
select (e.sal + nvl(e.comm,0))*12 income,e.ename   from emp e where (e.sal + nvl(e.comm,0))*12>30000;

--3
select e.* from emp e where e.comm is not null;

--4
select e.* from emp e where e.sal>1500 and e.comm is not null;

--5
select e.* from emp e where e.sal>1500 or e.comm is not null;
--6
select e.* from emp e where e.ename  like '%S%'

--7
select e.* from emp e where e.ename  like '%p%%'  escape('p')


--9、使用in查询部门名称为 SALES 和 RESEARCH 的雇员姓名、工资、部门编号
--`.找部门
select d.deptno from dept d where d.dname='SALES' or d.dname='RESEARCH';
--根据部门编号查雇员信息
select e.*
  from emp e
 where e.deptno in (select d.deptno
                      from dept d
                     where d.dname = 'SALES'
                        or d.dname = 'RESEARCH');
 

--10、使用exists查询部门名称为SALES和RESEARCH 的雇员姓名、工资、部门编号。
--exists（是一个子查询） 子查询只要有一个返回结果 就为真
select e.*
  from emp e
 where exists (select d.deptno
          from dept d
         where (d.dname = 'SALES' or d.dname = 'RESEARCH')
           and e.deptno = d.deptno);

--提高效率
select e.*
  from emp e
 where exists (select 1
          from dept d
         where (d.dname = 'SALES' or d.dname = 'RESEARCH')
           and e.deptno = d.deptno);


--order by
--ojb.test
select e.* from emp e where e.deptno=20 order by e.sal;
select e.* from emp e where e.deptno=20 order by e.sal asc;
select e.* from emp e where e.deptno=20 order by e.sal desc;

--  from where select order by  执行顺序
select e.* from emp e  order by e.sal asc, e.empno desc;
 


--union 求并集

select e.* from emp e where e.sal>1500
union 
select e.*  from emp e where e.deptno=10

--列必须相同
select e.ename from emp e where e.sal>1500
union all
select e.ename  from emp e where e.deptno=10
--交集
select e.* from emp e where e.sal>1500
intersect 
select e.*  from emp e where e.deptno=10
--差集

select e.* from emp e where e.sal>1500 --7
minus 
select e.*  from emp e where e.deptno=10 --3


