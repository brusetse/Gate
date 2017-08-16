--6 用一个查询语句，实现查询各个岗位的总工资和各个部门的总工资和所有雇员的总工资
    select * from (select  e.job,e.deptno,
            sum(e.sal) over(partition by e.job order by e.job),
            sum(e.sal) over(partition by e.deptno order by e.deptno),
            sum(e.sal) over(),
            row_number() over(partition by e.job order by e.job) num
            
      from emp e ) m
      where m.num = 1;
      
      select '雇员总工资','', sum(e.sal) from emp e
      union all
      select '各个部门工资',d.dname ,sum(e.sal) from emp e,dept d where e.deptno = d.deptno group by d.dname
      union all 
      select '各个岗位工资', e.job ,sum(e.sal)   from emp e group by  e.job;
--7 用一个查询语句，实现查询各个岗位的总工资和所有雇员的总工资
 select '雇员总工资','', sum(e.sal) from emp e
      union all
      select '各个岗位工资', e.job ,sum(e.sal)   from emp e group by  e.job;
--8 用一个查询语句，实现查询各个部门的总工资和各个岗位的总工资

      select '各个部门工资',d.dname ,sum(e.sal) from emp e,dept d where e.deptno = d.deptno group by d.dname
      union all 
      select '各个岗位工资', e.job ,sum(e.sal)   from emp e group by  e.job;
--10 通过查询显示每个员工的姓名和工资等级
     select e.ename,s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal;
    
--11找出员工表内工资排名在 第六到第十的员工  （oracle 的分页）
select b.*  from (select a.*,rownum rnum from (select  e.* from emp e  order by e.sal desc ) a  ) b where b.rnum >=6 and b.rnum<=10
