--1.  求部门中薪水最高的人(信息 姓名 )
select * from emp e1   join (
select max(e.sal) msal ,e.deptno from emp e group by e.deptno
)t01 on e1.sal = t01.msal


select * from emp e1 ,(
select max(e.sal) msal ,e.deptno from emp e group by e.deptno
)t01 where e1.sal = t01.msal

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



--4.	雇员中有哪些人是经理人

select * from emp e where e.empno in (select e2.mgr from emp e2);

--5.	不准用组函数，求薪水的最高值  
-- max min count avg sum
select * from (
select t01.*,rownum r from  (
select e.sal from emp e order by e.sal
)t01 )t02 where t02.r >=all (select rownum from emp )
 
--
select * from 
(
select t01.*,rownum r from  (
select e.sal from emp e order by e.sal desc)t01)t02 where t02.r=1

--

 --
select t01.*,rownum r from  (
select e.sal from emp e order by e.sal desc) t01 where rownum<=1
--
select * from emp e2 where e2.sal>=all(
       select e.sal from emp e 
)
--
select e.* from emp e where e.sal not in(
select distinct e1.sal  from emp e1,emp e2 where e1.sal<e2.sal );


--6.	求平均薪水最高的部门的部门编号

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

--7.	求平均薪水最高的部门的部门名称
select * from dept d,(
select t1.deptno,t1.vsal from (
select avg(sal) vsal,e.deptno from emp e group by e.deptno) t1,
(
  select max(avg(sal)) msal from emp e group by e.deptno
)t2 where t1.vsal = t2.msal) t01 where d.deptno = t01.deptno;


--8.	求平均薪水的等级最低的部门的部门名称

select *
  from dept d,
       (select avg(t01.grade) vsal, t01.deptno
          from (select sg.grade, e.deptno
                  from emp e
                  left join salgrade sg
                    on e.sal between sg.losal and sg.hisal) t01
         group by t01.deptno) t02
 where d.deptno = t02.deptno
   and t02.vsal = (select min(avg(t01.grade))
                     from (select sg.grade, e.deptno
                             from emp e
                             left join salgrade sg
                               on e.sal between sg.losal and sg.hisal) t01
                    group by t01.deptno);
--9.	求部门经理人中平均薪水最低的部门名称
--求出部门里面经理人的平均薪水
select avg(t01.sal) from
(
select e.deptno,e.sal from emp e where e.empno in(select e2.mgr from emp e2)
) t01 group by t01.deptno

select *
from dept d01    join (
select avg(t01.sal) vsal,t01.deptno from
(
select e.deptno,e.sal from emp e where e.empno in(select e2.mgr from emp e2)
) t01 group by t01.deptno)t02 on d01.deptno=t02.deptno and t02.vsal=(
select min(avg(t03.sal)) from
(
select e1.deptno,e1.sal from emp e1 where e1.empno in(select e3.mgr from emp e3)
) t03 group by t03.deptno
)


--10.	求比普通员工的最高薪水还要高的经理人名称(not in)
--经理人
select * from emp e where e.empno in (select e2.mgr from emp e2)


select * from emp e where e.empno not in (select e2.mgr from emp e2 where e2.mgr is not null)

--找经理人的薪水 大于 普通员工里面最高
select * from 
(select * from emp e where e.empno in (select e2.mgr from emp e2))t01 where t01.sal
>all(
select e.sal from emp e where e.empno not in (select e2.mgr from emp e2 where e2.mgr is not null)
)

--not in 遇到null 时候没有返回值
select * from emp e where e.deptno not in (10,null)


--13.	求最后入职的5名员工
select t01.hiredate,rownum r from
(select * from emp e where e.hiredate is not null order by e.hiredate desc)t01 where rownum<=5

select * from (
select t01.hiredate,rownum r from
(select * from emp e where e.hiredate is not null order by e.hiredate )t01 
) t02 where t02.r>=(select count(1)-5 from emp e2)
