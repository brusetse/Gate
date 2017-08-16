--公司一共有多少个雇员

select count(e.ename) from emp e;
--exists  即可避免e.ename 为空 null  还可以提高查询效率
select count(1) from emp e;

--部门为10 平均薪水是多少

select  avg(e.sal) from emp e where e.deptno=10;

--平均补贴
--组函数不能null值
select  avg(e.comm) from emp e where e.deptno=10;
select * from emp;
select  avg(nvl(e.comm,0)) from emp e where e.deptno=30;

select  max(e.sal) from emp e where e.deptno=30;

select  min(e.sal) from emp e where e.deptno=30;


--这个月开支
select  sum(e.sal+nvl(e.comm,0)) from emp e where e.deptno=30;


--求每个部门平均的sal是多少

--select 语句里面的列 必须在group by里面出现
--组函数 avg max min  sum count 
--having 分组后的数据进行过滤

--sal>1000 参与平均薪水计算
select e.deptno,avg(e.sal),count(1) from emp e  group by e.deptno having count(1)>5
select e.deptno,avg(e.sal),count(1) from emp e where e.sal>1000 group by e.deptno  


--求部门下雇员的平均工资>2000 人数
select e.deptno,avg(e.sal),count(1) from emp e group by e.deptno  
select deptno,avg(e.sal) from emp e group by e.deptno having avg(e.sal)>2000

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

--1、查询10号部门中编号最新入职的员工，工龄最长的员工的个人信息(名称，sal)。
--工龄最长的
select min(e.hiredate) from emp e where e.deptno=10; 
select * from emp where deptno=10
select max(e.hiredate) from emp e where e.deptno=10;


--in 里面 列过多了！！！
select e1.ename from emp e1 where e1.hiredate in (select min(e.hiredate) ,max(e.hiredate) from emp e where e.deptno=10 )

select e1.ename
  from emp e1
 where e1.hiredate in
       ((select min(e2.hiredate) from emp e2 where e2.deptno = 10),
        (select max(e3.hiredate) from emp e3 where e3.deptno = 10))
                        
                        

--优雅
select e1.ename, e1.hiredate
  from emp e1,
       (select min(e.hiredate) mind, max(e.hiredate) maxd
          from emp e
         where e.deptno = 10) mm2
 where e1.hiredate = mm2.mind
    or e1.hiredate = mm2.maxd
    --1、查询10号部门中编号最新入职的员工，工龄最长的员工的个人信息(名称，sal)。
--第三种？？？  必须有？？ group by having

select e1.ename, e1.hiredate
  from emp e1,
       (select max(e.hiredate) max_day, min(e.hiredate) min_day
          from emp e
         group by deptno
        having deptno = 10) m
 where e1.hiredate = m.max_day
    or e1.hiredate = m.min_day


--2从“software”找到‘f’的位置，用‘*’左右填充到15位，去除其中的‘a’。

select instr('software','f') from dual;
select lpad('software',15,'*') from dual;
select rpad('software',15,'*') from dual;
select replace('software','a') from dual;


--3查询员工的奖金，如果奖金不为NULL显示‘有奖金’，为null则显示无奖金
 
select  nvl2(e.comm,'无奖金','有奖金') from emp e ;

select  decode(e.comm,null,'无奖金','有奖金') from emp e ;

--case when

--

select e.ename ,'无奖金' from emp e where e.comm is null
union
select e.ename ,'有奖金' from emp e where e.comm is not null;
--写一个查询显示当前日期，列标题显示为Date。再显示六个月后的日期，下一个星期 日的日期，该月最后一天的日期。

select sysdate "date",next_day(add_months(sysdate,6),1),trunc(last_day(sysdate)) from dual;

--查询EMP表按管理者编号升序排列，如果管理者编号为空则把为空的在最前显示 

select e.* from emp e order by nvl(e.mgr,0)
select e.* from emp e order by  e.mgr  nulls first;
select e.* from emp e order by  e.mgr  nulls last;



