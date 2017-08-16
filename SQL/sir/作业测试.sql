--1、求平均薪水最高的部门的部门编号
select t1.deptno from (
select avg(sal) vsal,e.deptno from emp e group by e.deptno) t1,
(
  select max(avg(sal)) msal from emp e group by e.deptno
)t2 where t1.vsal = t2.msal;

--???
select avg(sal) vsal,e.deptno from emp e group by e.deptno order by avg(sal) desc
select t01.*,rownum from (
select avg(sal) vsal,e.deptno from emp e group by e.deptno order by avg(sal) desc
)t01 where rownum<=1
--2、求部门平均薪水的等级
--平均薪水
select avg(sal) from emp e group by e.deptno

select * from emp;
--
select sg.grade,t01.deptno,t01.vsal from salgrade sg,(
select avg(sal) vsal,deptno from emp e group by e.deptno
)t01 where t01.vsal between sg.losal and sg.hisal;

--3、求部门平均的薪水等级
--连表
select sg.grade,e.deptno from emp e left join salgrade sg on e.sal between sg.losal and sg.hisal

select avg(t01.grade) from (
select sg.grade,e.deptno from emp e left join salgrade sg on e.sal between sg.losal and sg.hisal
)t01 group by t01.deptno;


--4、求薪水最高的前5名雇员
select * from emp e order by e.sal desc

--原因 select 比 order by先执行 导致了rownum 顺序不对了
select e.*,rownum from emp e order by e.sal desc

--解决
select t01.*,rownum from (
select e.* from emp e order by e.sal desc
) t01 where rownum<=5



select ename,rownum from emp where rownum<=5;
--oracle rownum 直接使用大于
select ename,rownum from emp where rownum>5

select * from (
select ename,rownum r from emp ) t1 where t1.r>5

--5、求薪水最高的第6到10名雇员
--还是前面说的问题
select t01.*,rownum from (
select e.* from emp e order by e.sal desc
) t01 where rownum >=6 and rownum<=10
-- 语句完美吗？--属于不完美？？
select * from (
select t01.*,rownum r from (
select e.* from emp e order by e.sal desc
) t01  )t02 where t02.r>=6 and t02.r<=10

-- 必须掌握！！！！
select * from (
select t01.*,rownum r from (
select e.* from emp e order by e.sal desc
) t01  where rownum<=10)t02 where t02.r>=6  
