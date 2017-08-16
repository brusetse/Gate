
  --  (1)查询DEPT表显示所有部门名称.
    select d.dname from dept d;
  --  (2)查询EMP表显示所有雇员名及其全年收入(月收入=工资+补助),处理NULL行,并指定列别名为"年收入"。（NVL(comm,0) comm取空值时用0替代）
    select e.ename,(e.sal+nvl(e.comm,0))*12 年收入  from emp e;
  --  (3)查询显示不存在雇员的所有部门号。
     select d.deptno from emp e,dept d where e.deptno (+)= d.deptno group by d.deptno having count(e.empno)=0;
     select distinct d.deptno from emp e ,dept d where e.deptno (+)= d.deptno  and e.empno is null;
  --  (1)查询EMP表显示工资超过2850的雇员姓名和工资。
      select e.ename,e.sal from emp e where e.sal >2850;
  -- (2)查询EMP表显示工资不在1500～2850之间的所有雇员及工资。
   select  from emp e where e.sal<1500 or e.sal >2850;
    
  --  (3)查询EMP表显示代码为7566的雇员姓名及所在部门代码。
      select e.ename,e.deptno from emp e where e.empno = 7566;
  --  (4)查询EMP表显示部门10和30中工资超过1500的雇员名及工资。
      select e.ename,e.sal from emp e where e.deptno in(10,30) and e.sal>1500;   
  --  (5)查询EMP表显示第2个字符为"A"的所有雇员名其工资。
   select e.ename,e.sal  from emp e where e.ename like '_A%';
  --  (6)查询EMP表显示补助非空的所有雇员名及其补助。
  select e.ename,e.comm from emp e where e.comm is not null;
  --  (1)查询EMP表显示所有雇员名、工资、雇佣日期，并以雇员名的升序进行排序。
      select e.ename,e.sal,e.hiredate from emp e order by e.ename asc; 
  --  (2)查询EMP表显示在1981年2月1日到1981年5月1日之间雇佣的雇员名、岗位及雇佣日期，并以雇佣日期进行排序。
      select e.ename,e.job,e.hiredate from emp e where e.hiredate >=to_date('1981-2-1','yyyy-mm-dd') and e.hiredate <= to_date('1981-5-1','yyyy-mm-dd');
 --   (3)查询EMP表显示获得补助的所有雇员名、工资及补助，并以工资升序和补助降序排序。
      select  e.ename,e.sal,e.comm from emp e where nvl(e.comm,0) >0 order by sal,e.comm desc;
 
