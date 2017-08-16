--笛卡尔积
select * from emp e,dept d;
--92 等值连接

select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno;
select * from emp e,dept d where e.deptno = d.deptno;
-- 非等值连接
--!= <> > < > >= <= between and 

--以后写sql养成练好习惯 必须表别名。
select e.ename, sg.grade ,e.*,sg.* from emp e ,salgrade sg where e.sal between sg.losal and sg.hisal;

--找出雇员领导的姓名
 --自己连接自己 自连接
 select * from emp ;
 select worker.ename || ' mangaer is' || manager.ename
   from emp worker, emp manager
  where worker.mgr = manager.empno;
  
  -- 测试外连接  
  insert into emp(ename,sal,empno) values('cai10',9999,80);
  commit

-- 左外连接
select * from emp e,dept d where e.deptno=d.deptno(+)
--右外连接
select * from emp e,dept d where e.deptno(+)=d.deptno 


--99语法

select * from  emp e cross join dept d;
--等同于
select * from  emp e ,dept d;

--自然连接

select * from emp e natural join dept d;

select e.ename,e.ename,e.sal,deptno,d.loc
	from emp e join dept d using(deptno)
	where deptno=20


-- tablea join tableb on condition
--内连接（等值连接） inner 省
select * from emp e inner join dept d on e.deptno=d.deptno;

--99 左外连接 右外连接

select * from emp e left join dept d on e.deptno=d.deptno;

select * from emp e right join dept d on e.deptno=d.deptno;
--全连接
select * from emp e full join dept d on e.deptno=d.deptno;


