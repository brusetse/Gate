comment on table emp is '雇员表';
comment on column emp.empno is '员工编号'

select * from emp;
--单引号 就像java String 赋值字符串
select * from emp where ename='ALLEN';

--给列起别名

select  ename as "雇员名" ,sal as "雇员薪水" from emp;

select  ename  "雇员名" ,sal as "雇员薪水" from emp;

select  ename  雇员名 ,sal as "雇员薪水" from emp;

--双引号 起别名 
select  ename  "雇 员 名" ,sal as "雇员薪水" from emp;

--表起别名

select * from  emp "雇员表";

--起别名好处
select job,sal from emp;
--子查询里面
select e.job,e.sal  from  emp e;

--部门编号在 10 或20 的雇员名称

select e.ename  from emp e where deptno in  (select deptno from dept where deptno=10 or deptno=20) ;




--
select e.job from emp e;
--去重

select distinct  e.job from emp e;

select * from emp;

select job, deptno from emp;


select distinct e.job,e.deptno  from emp e;

select e.job,e.deptno  from emp e;

--条件比较 
/*
＝，！＝,<>，<,>,<=,>=,
any,some,all
is null,is not null
between x and y
in（list），not in（list）
exists（sub－query）
like  _ ,%,escape ‘\‘   _\% escape ‘\’
*/

select e.* from emp e where e.deptno=10
--<> 不等于
select e.* from emp e where  e.empno<>7782

select e.* from emp e where  e.empno!=7782
select e.* from emp e where e.sal>2000
--找出薪水大于1000 或2000 或3000 这里面某个值的雇员
--满足大于最小的值
select e.ename ,e.job,e.sal from emp e where e.sal > any(1000,2000,3000)
--小于max
select e.ename ,e.job,e.sal from emp e where e.sal < any(1000,2000,3000)
select e.ename ,e.job,e.sal from emp e where e.sal < some(1000,2000,3000)

select e.ename ,e.job,e.sal from emp e where e.sal < all(1000,2000,3000)
select e.ename ,e.job,e.sal from emp e where e.sal > all(1000,2000,3000)

--sql于null 
select e.* from emp e where e.comm=null;
select e.* from emp e where null=null
select e.* from emp e where e.comm is null;
select e.* from emp e where e.comm is not null;


--薪水大于等于1500 小于等于3000

select e.* from emp e where e.sal>=1500 and e.sal<=3000;
select e.* from emp e where e.sal between 1500 and 3000;

--部门10,20里面所有员工
select e.* from emp e where e.deptno=10 or e.deptno=20;
-- 解析sql语句执行顺序  1.from 2.where 3.select
for(遍历emp里面所有的数据时){
   if(deptno==10){
        return true;
        
   }
   
   if(deptno==20){
        return true;
   }
}


select e.* from emp e where e.deptno in (10,20);
--查出公司所有部门里面的员工
select e.* from emp e where e.deptno in (select d.deptno from dept d );


select e.* from emp e where e.deptno not in (10,20);

while(e1里面所有的数据){
       while(e2){
           if(true){
                break;
           }
       }
}

-- 只查出10 或20
select e1.* from emp e1  where  exists( select e2.ename from emp e2 where deptno=10 or deptno=20 );
select 1 from dual;
select 1 from emp;

--and or

--exists(sub-query 只要这里面能返回一条结果，整个表达式就为true)
select e1.* from emp e1  where  exists( select 1 from dept d1 where d1.deptno=10 or d1.deptno=20 and d1.deptno=e1.deptno);

--in exists  in(子查询结果少) exists(子查询结果多)

select e1.* from emp e1  where  exists( select 1 from dept d1 where (d1.deptno=10 or d1.deptno=20) and d1.deptno=e1.deptno);

select e1.* from emp e1  where  exists( select 1 from dept d1 where  e1.deptno in (select deptno from dept) and d1.deptno=e1.deptno);


select e.ename  from emp e where e.ename like '_M%';
select e.ename  from emp e where e.ename like '%M%';
select e.ename  from emp e where e.ename like '%%%';
--找出名字里面有% _
select e.ename,e.*  from emp e where e.ename like '%d%%' escape('d');

insert into emp(empno,ename,sal,deptno) values(8888,'te%st',4000,10);
insert into emp(empno,ename,sal,deptno) values(8889,'1gaga1',4000,10);
insert into emp(empno,ename,sal,deptno) values(8899,'dodo',4000,10);
commit

--找到姓名里面有dodo hehe  testgagalskjdls  lskdjflhellohellolaskjd


--？？？？
select * from emp where  regexp_like(ename,'(\w{2,6})\1')
select * from emp where  regexp_like(sal,'[234]')


