--1.找出各月倒数第3天受雇的所有员工.
  select * from emp e where  e.hiredate = last_day(e.hiredate)-2;
--2.找出早于12年前受雇的员工.
   select e.*  from emp e where  e.hiredate < trunc(sysdate)+(INTERVAL '-30' YEAR);
--3.以首字母大写的方式显示所有员工的姓名.
   select  INITCAP(e.ename) from emp e;
--4.显示正好为5个字符的员工的姓名.
  select * from emp e where length(e.ename) =5;
--5.显示不带有"R"的员工的姓名
    select * from emp e where e.ename not like '%R%';
--6.显示所有员工姓名的前三个字符.
    select substr(e.ename,1,3)  from emp e;
--7.显示所有员工的姓名,用a替换所有"A"
    select replace(e.ename,'A','a') test from emp e;
--8.显示满10年服务年限的员工的姓名和受雇日期.:
     select e.*  from emp e where  e.hiredate > trunc(e.hiredate)+(INTERVAL '-10' YEAR);
--9.显示员工的详细资料,按姓名排序.
     select * from emp e order by e.ename;
--10.显示员工的姓名和受雇日期,根据其服务年限,将最老的员工排在最前面.
      select * from emp e order by e.hiredate asc;
--11.显示所有员工的姓名、工作和薪金,按工作的降序排序,若工作相同则按薪金排序.
      select * from emp e order by e.job desc,e.sal;
--12.显示所有员工的姓名、加入公司的年份和月份,按受雇日期所在月排序,若月份相同则将最早年份的员工排在最前面.
      select e.ename,e.hiredate,to_char(e.hiredate,'MM'),to_char(e.hiredate,'yyyy') from  emp e order by to_char(e.hiredate,'MM'),to_char(e.hiredate,'yyyy');
--14.找出在(任何年份的)2月受聘的所有员工。
      select * from emp e where to_char(e.hiredate,'MM') = 2;
--15.对于每个员工,显示其加入公司的天数.
      select  e.ename,ceil(sysdate-e.hiredate) from emp e ;
--16.显示姓名字段的任何位置包含"A"的所有员工的姓名.
      select * from emp e where e.ename  like '%A%';
