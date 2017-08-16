
--查询部门编号为 10 的员工信息
select e.* from emp e where e.deptno=20;
--查询年薪大于 3 万的人员的姓名与部门编号
select e.ename,e.deptno from emp e where e.sal*12>30000;
--查询佣金为null的人员姓名与工资
select e.ename,e.sal from emp e where e.comm is null;
--查询工资大于1500 且 and 含有佣金的人员姓名
select e.* from emp e where e.sal>1500 and e.comm is not null;
--查询工资大于1500 或 or含有佣金的人员姓名
select e.ename from emp e where e.sal>1500 or e.comm is not null;
--查询姓名里面含有 S 员工信息 工资、名称
select e.* from emp e where e.ename like '%S%';
--求姓名以 J 开头第二个字符 O 的员工姓名的与工资
select e.ename,e.sal from emp e where e.ename like 'JO%'; 
--求包含 % 的雇员姓名
select e.ename from emp e where e.ename like '%d%%' escape('d');
--使用 in 查询部门名称为 SALES 和 RESEARCH 的雇员姓名、工资、部门编号
select e.ename,e.sal,e.deptno from emp e where 1 in(select 1 from dept d where d.dname in ( 'SALES' , 'RESEARCH' ) and d.deptno=e.deptno); 
--使用exists查询部门名称为SALES和RESEARCH 的雇员姓名、工资、部门编号 
select e.ename,e.sal,e.deptno from emp e where exists(select 1 from dept d where d.dname in ( 'SALES' , 'RESEARCH' ) and d.deptno=e.deptno); 

/*1、使用基本查询语句.
(1)查询DEPT 表显示所有部门名称.
(2)查询EMP 表显示所有雇员名及其全年收入(月收入=工资+补助),处理NULL行,并指定列别名
为"年收入"。（NVL(comm,0) comm 取空值时用0 替代）
(3)查询显示不存在雇员的所有部门号。*/
select d.dname from dept d;
select e.ename,12*(e.sal+NVL(comm,0)) as "年收入" from emp e;
select d.deptno from dept d where not exists ( select 1 from emp e where e.deptno = d.deptno );

/*2 、限制查询数据
(1)查询EMP表显示工资超过2850的雇员姓名和工资。
(2)查询EMP表显示工资不在1500～2850之间的所有雇员及工资。
(3)查询EMP表显示代码为7566的雇员姓名及所在部门代码。
(4)查询EMP表显示部门10和30中工资超过1500的雇员名及工资。
(5)查询EMP表显示第2个字符为"A"的所有雇员名其工资。
(6)查询EMP表显示补助非空的所有雇员名及其补助。*/
select e.ename,e.sal from emp e where e.sal>2850;
select e.ename,e.sal from emp e where e.sal not between 1500 and 2850;
select e.ename,e.deptno from emp e where e.empno=7566;
select e.ename,e.sal from emp e where e.deptno in (10,30) and e.sal>1500;
select e.ename,e.sal from emp e where e.ename like '_A%';
select e.ename,e.comm from emp e where e.comm is not null;

/*3、排序数据
(1)查询EMP表显示所有雇员名、工资、雇佣日期，并以雇员名的升序进行排序。
(2)查询EMP表显示在1981年2月1日到1981年5月1日之间雇佣的雇员名、岗位及雇佣日期，并
以雇佣日期进行排序。
(3)查询EMP表显示获得补助的所有雇员名、工资及补助，并以工资升序和补助降序排序。*/
select e.ename,e.sal,e.hiredate from emp e order by e.ename;
select e.ename,e.job,e.hiredate from emp e where e.hiredate between '1-2月-1981' and'1-5月-1981' order by e.hiredate;
select e.ename,e.sal,e.comm from emp e where e.comm is not null order by e.sal asc, e.comm desc

select * from emp e

