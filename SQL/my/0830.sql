select e.* from emp e;

select e.* from emp e where e.deptno=10;
select e.* from emp e where 12*(e.sal+NVL(e.comm,0))>30000;
select e.* from emp e where e.comm is null;
select e.* from emp e where e.sal>1500 and e.comm is not null;
select e.* from emp e where e.sal>1500 or e.comm is not null;
select e.* from emp e where e.ename like '%S%';
select e.* from emp e where e.ename like 'JO%';
select e.* from emp e where e.ename like '%d%%' escape ('d');

select e.*
  from emp e
 where e.deptno in
       (select d.deptno from dept d where d.dname in ('SALES', 'RESEARCH'));

select e.*
  from emp e
 where exists (select 1
          from dept d
         where d.dname in ('SALES', 'RESEARCH')
           and e.deptno = d.deptno);

select e.* from emp e where e.deptno=20 order by e.sal asc;

select e.ename||'职位'||e.job||'工资'||e.sal 个人信息 from emp e
select sysdate from dual;
select current_timestamp from dual;
select current_date from dual;

select ceil(-10),ceil(-20) from dual;

/*  
  1、查询82年员工
2、查询32年工龄的人员
3、显示员工雇佣期 6 个月后下一个星期一的日期
4、找没有上级的员工，把mgr的字段信息输出为 "boss"
5、为所有人长工资，标准是：10部门长10%；20部门长15%；30部门长20%其他部门长18%
*/
select e.* from emp e where to_char(e.hiredate, 'yyyy') like '1982';
select e.* from emp e where round((sysdate - e.hiredate) / 365) = 32;
--add_months
select e.ename,e.hiredate,next_day(add_months(e.hiredate, 6), '星期一') from emp e;
select nvl(to_char(e.mgr), 'boss'), e.ename from emp e where e.mgr is null;
select decode(e.mgr, null, '老板', '员工') from emp e;
select e.ename,
       e.sal,
       sal * (decode(e.deptno, 10, 1.1, 20, 1.15, 30, 1.2, 1.18)) "涨工资"
  from emp e
  
select e.ename,
       e.sal,
       sal * case
         when e.deptno = 10 then
          1.1
         when e.deptno = 20 then
          1.15
         when e.deptno = 30 then
          1.2
         else
          1.18
       end "涨工资"
  from emp e;
  
select round((sysdate-e.hiredate)/365) 工龄 from emp e;   
  
select to_char(current_date,'yyyy/mm/dd hh24:mi:ss') from dual;
select to_char(current_timestamp,'yyyy-mm-dd') from dual;

select current_date from dual;
select current_timestamp from dual;
--months_between
select round(months_between(sysdate,e.hiredate)/12) 工龄 from emp e
--last_day

/*
1、查询10号部门中编号最新入职的员工，工龄最长的员工的个人信息。
2、从“software”找到‘f’的位置，用‘*’左右填充到15位，去除其中的‘a’。
3、查询员工的奖金，如果奖金不为NULL显示‘有奖金’，为null则显示无奖金
4、写一个查询显示当前日期，列标题显示为Date。再显示六个月后的日期，下一个星期 日的日期，该月最后一天的日期。
5、查询EMP表按管理者编号升序排列，如果管理者编号为空则把为空的在最前显示    
6、求部门平均薪水
7、按部门求出工资大于1300人员的 部门编号、平均工资、最小佣金、最大佣金,并且最大佣金大于100
8、找出每个部门的平均、最小、最大薪水
9、查询出雇员名，雇员所在部门名称， 工资等级
*/
--1、查询10号部门中编号最新入职的员工，工龄最长的员工的个人信息。
select max(e.hiredate) from emp e where e.deptno=10;
select min(e.hiredate) from emp e where e.deptno=10;

select max(e.hiredate),min(e.hiredate) from emp e;
select e.ename
  from emp e
 where e.hiredate in
       ((select max(e1.hiredate) from emp e1 where e1.deptno = 10),
        (select min(e2.hiredate) from emp e2 where e2.deptno = 10));

select e.ename,e.hiredate
  from emp e,
       (select max(e1.hiredate) maxd, min(e1.hiredate) mind
          from emp e1
         where e1.deptno = 10) mm
 where e.hiredate = mm.maxd
    or e.hiredate = mm.mind;
--2、从“software”找到‘f’的位置，用‘*’左右填充到15位，去除其中的‘a’。
select instr('softsware','f') from dual;
select lpad('software',15,'*') from dual;
select rpad('software',15,'*') from dual;
--3、查询员工的奖金，如果奖金不为NULL显示‘有奖金’，为null则显示无奖金
select nvl2(e.comm,'无奖金','有奖金') from emp e ;
select decode(e.comm,null,'无奖金','有奖金') from emp e ;
select case when e.comm is null then '无奖金' else '有奖金' end from emp e;
select e.ename,'无奖金' from emp e where e.comm is null
union
select e.ename,'有奖金' from emp e where e.comm is not null;
--4、写一个查询显示当前日期，列标题显示为Date。再显示六个月后的日期，下一个星期 日的日期，该月最后一天的日期。
select sysdate "Date",
       next_day(add_months(sysdate, 6), '星期日') 六个月后下一个星期日,
       last_day(sysdate) 最后一天
  from dual;
--5、查询EMP表按管理者编号升序排列，如果管理者编号为空则把为空的在最前显示    
select e.* from emp e order by nvl(e.mgr,0);
select e.* from emp e order by e.mgr nulls first;
select e.* from emp e order by e.mgr nulls last;
--6、求部门平均薪水
select round(avg(e.sal)) 平均薪水,e.deptno from emp e group by e.deptno;
--7、按部门求出工资大于1300人员的 部门编号、平均工资、最小佣金、最大佣金,并且最大佣金大于100
select e.deptno, round(avg(e.sal)) 平均工资, min(e.comm), max(e.comm)
  from emp e
 where e.sal > 1300
 group by e.deptno;
--8、找出每个部门的平均、最小、最大薪水
select round(avg(e.sal)),min(e.sal),max(e.sal) from emp e group by e.deptno
--9、查询出雇员名，雇员所在部门名称， 工资等级
select e.ename, d.dname, sal.grade
  from emp e, dept d, salgrade sal
 where e.deptno = d.deptno
   and e.sal between sal.losal and sal.hisal;

--笛卡尔积
select * from emp e ,dept d;
--92等值连接
select * from emp e,dept d where e.deptno=d.deptno;

select * from emp e,salgrade sa where e.sal between sa.losal and sa.hisal;
--自连接
select worker.ename||' 的上司是 '||manager.ename from emp worker,emp manager where worker.mgr = manager.empno;
--右外连接
select * from emp e,dept d where e.deptno(+) = d.deptno
--99语法
select * from emp e cross join dept d;
--自然连接,结果不保留重复的属性
select * from emp e natural join dept d
--using连接,使用using属性连接
select * from emp e join dept d using(deptno) where deptno = 20
--使用on
select * from emp e join dept d on e.deptno = d.deptno;
--99 左外连接 右外连接 全连接
select * from emp e left join dept d on e.deptno = d.deptno;
select * from emp e right join dept d on e.deptno = d.deptno;
select * from emp e full join dept d on e.deptno = d.deptno;

--1.	求部门中薪水最高的人
select *
  from emp e,(select deptno,max(e1.sal) max_sal from emp e1 group by e1.deptno)m
 where e.sal=m.max_sal and e.deptno=m.deptno

--2.	求部门平均薪水的等级

select sa.grade
  from dept d, salgrade sa
 where (select avg(e.sal) from emp e group by e.deptno) between sa.losal and
       sa.hisal

select * from 
salgrade s, (select deptno,avg(sal) avg_sal 
from emp group by deptno) t
where t.avg_sal between s.losal and s.hisal;

select * from emp e join dept d on e.deptno = d.deptno join salgrade s on e.sal between s.losal and s.hisal

