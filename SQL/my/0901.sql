--1、求平均薪水最高的部门的部门编号
select t1.deptno
  from (select avg(sal) avg_sal, deptno from emp e group by deptno) t1,
       (select max(avg(sal)) max_sal from emp e group by deptno) t2
 where t1.avg_sal = t2.max_sal

--2、求部门平均薪水的等级
select *
  from salgrade sg,
       (select avg(sal) avg_sal, deptno from emp e group by deptno) t
 where t.avg_sal between sg.losal and sg.hisal

--3、求部门平均的薪水等级
select avg(t.grade), t.deptno
  from (select e.deptno, sa.grade
          from emp e
          join salgrade sa
            on e.sal between sa.losal and sa.hisal) t
 group by deptno

--4、求薪水最高的前5名雇员
select t.*,rownum from
(select e.* from emp e order by sal desc)t where rownum<=5

--5、求薪水最高的第6到10名雇员
select t2.*,t2.r from
(select t1.*,rownum r from
(select e.* from emp e order by sal desc)t1 where rownum<=10)t2 where t2.r between 6 and 10
-----------------------------------------------------------------------
select * from emp

select t1.deptno, t1.ms "CLERK", t2.ms "SALESMAN", t3.ms "PRESIDENT"
  from (select e.deptno, max(nvl(sal, 0)) ms
          from emp e
         where job = 'CLERK'
         group by deptno) t1
  full join (select e.deptno, max(nvl(sal, 0)) ms
          from emp e
         where job = 'SALESMAN'
         group by deptno) t2
    on t1.deptno = t2.deptno
  full join (select e.deptno, max(nvl(sal, 0)) ms
          from emp e
         where job = 'PRESIDENT'
         group by deptno) t3
    on t1.deptno = t3.deptno
-----------------------------------------------------
select * from student_score

create table test(
   id number(10) primary key,
   type number(10) ,
   t_id number(10),
   value varchar2(5)
);
insert into test values(100,1,1,'张三');
insert into test values(200,2,1,'男');
insert into test values(300,3,1,'50');

/*
请写出一条查询语句结果如下：

姓名      性别     年龄
--------- -------- ----
张三       男        50
*/
select * from test

select max(decode(t.type, 1, t.value)) 姓名,
       max(decode(t.type, 2, t.value)) 性别,
       max(decode(t.type, 3, t.value)) 年龄
  from test t
 --group by t.t_id

select max(case t.type when 1 then t.value end) 姓名,
max(case t.type when 2 then t.value end) 性别,
max(case t.type when 3 then t.value end) 年龄
from test t --group by t.t_id

select *
  from (select t.value, t.t_id from test t where t.type = 1) t1
  join (select t.value, t.t_id from test t where t.type = 2) t2
    on t1.t_id = t2.t_id
  join (select t.value, t.t_id from test t where t.type = 3) t3
    on t1.t_id = t3.t_id
---------------------------------------------------------------
create table tmp(rq varchar2(10),shengfu varchar2(5))

insert into tmp values('2005-05-09','胜');
insert into tmp values('2005-05-09','胜');
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-10','胜');
insert into tmp values('2005-05-10','负');
insert into tmp values('2005-05-10','负');
/*
2.一道SQL语句面试题，关于group by
表内容：
2005-05-09 胜
2005-05-09 胜
2005-05-09 负
2005-05-09 负
2005-05-10 胜
2005-05-10 负
2005-05-10 负

如果要生成下列结果, 该如何写sql语句?

          胜 负
2005-05-09 2 2
2005-05-10 1 2
*/
select * from tmp

select t.rq,sum(decode(t.shengfu,'胜',1)) 胜,
sum(decode(t.shengfu,'负',1)) 负 from tmp t group by t.rq

select t.rq,sum(case t.shengfu when '胜' then 1 end) 胜,
sum(case t.shengfu when '负' then 1 end) 负 
from tmp t group by t.rq

select m1.rq,m1.co 胜,m2.co 负
from (select t.rq,count(1) co from tmp t where t.shengfu = '胜' group by rq)m1 join
(select t.rq,count(1) co from tmp t where t.shengfu = '负' group by rq)m2 on m1.rq = m2.rq

/*4.1得到类似下面的结果
姓名   语文  数学  英语

王五    89    56    89*/
select * from student_score

select t1.name，t1.score "语文", t2.score "数学", t3.score "英语"
  from (select ss1.name, ss1.score
          from student_score ss1
         where subject = '语文') t1
  join (select ss1.name, ss1.score
          from student_score ss1
         where subject = '数学') t2
    on t1.name = t2.name
  join (select ss1.name, ss1.score
          from student_score ss1
         where subject = '英语') t3
    on t3.name = t2.name
    
select ss1.name, sum(decode(ss1.subject,'语文',ss1.score)) 语文
, sum(decode(ss1.subject,'数学',ss1.score)) 数学
, sum(decode(ss1.subject,'英语',ss1.score)) 英语
from student_score ss1 group by ss1.name

select ss1.name, sum(case  ss1.subject when '语文' then ss1.score end) 语文
, sum(case ss1.subject when '数学' then ss1.score end) 数学
, sum(case ss1.subject when '英语' then ss1.score end) 英语
from student_score ss1 group by ss1.name

/*4.2有一张表，里面有3个字段：语文，数学，英语。其中有3条记录分别表示语文70分，数学80分，英语58分，
请用一条sql语句查询出这三条记录并按以下条件显示出来（并写出您的思路）：  
   大于或等于80表示优秀，大于或等于60表示及格，小于60分表示不及格。  
       显示格式：  
       语文              数学                英语  
       及格              优秀                不及格    */

select ss2.name,(case when ss2.语文 >=80 then '优秀' when ss2.语文>=60 
and ss2.语文<80 then '及格' when ss2.语文<60 then '不及格' end) 语文
，(case when ss2.数学 >=80 then '优秀' when ss2.数学>=60 
and ss2.数学<80 then '及格' when ss2.数学<60 then '不及格' end) 数学
，(case when ss2.英语 >=80 then '优秀' when ss2.英语>=60 
and ss2.英语<80 then '及格' when ss2.英语<60 then '不及格' end) 英语
from
(select ss1.name, sum(case ss1.subject when '语文' then ss1.score end) 语文
, sum(case ss1.subject when '数学' then ss1.score end) 数学
, sum(case ss1.subject when '英语' then ss1.score end) 英语
from student_score ss1 group by ss1.name)ss2
---------------------------------------------------------------
create table yj01(
       month varchar2(10),
       deptno number(10),
       yj number(10)
)

insert into yj01(month,deptno,yj) values('一月份',01,10);
insert into yj01(month,deptno,yj) values('二月份',02,10);
insert into yj01(month,deptno,yj) values('二月份',03,5);
insert into yj01(month,deptno,yj) values('三月份',02,8);
insert into yj01(month,deptno,yj) values('三月份',04,9);
insert into yj01(month,deptno,yj) values('三月份',03,8);

create table yjdept(
       deptno number(10),
       dname varchar2(20)
)

insert into yjdept(deptno,dname) values(01,'国内业务一部');
insert into yjdept(deptno,dname) values(02,'国内业务二部');
insert into yjdept(deptno,dname) values(03,'国内业务三部');
insert into yjdept(deptno,dname) values(04,'国际业务部');
/*
5.请用一个sql语句得出结果
从table1,table2中取出如table3所列格式数据，注意提供的数据及结果不准确，
只是作为一个格式向大家请教。

table1

月份mon 部门dep 业绩yj
-------------------------------
一月份      01      10
一月份      02      10
一月份      03      5
二月份      02      8
二月份      04      9
三月份      03      8

table2

部门dep      部门名称dname
--------------------------------
      01      国内业务一部
      02      国内业务二部
      03      国内业务三部
      04      国际业务部

table3 （result）

部门dep 一月份      二月份      三月份
--------------------------------------
      01      10        null      null
      02      10         8        null
      03      null       5        8
      04      null      null      9
------------------------------------------
*/
select * from yj01
select * from yjdept

select y1.deptno 部门编号,
sum(case when y1.month='一月份' then y1.yj end) 一月份，
sum(case when y1.month='二月份' then y1.yj end) 二月份，
sum(case when y1.month='三月份' then y1.yj end) 三月份
from yj01 y1 join yjdept y2 on y1.deptno=y2.deptno group by y1.deptno

select y1.deptno 部门编号,
sum(decode(y1.month,'一月份',y1.yj)) 一月份，
sum(decode(y1.month,'二月份',y1.yj)) 二月份，
sum(decode(y1.month,'三月份',y1.yj)) 三月份
from yj01 y1 group by deptno
--不行
select t1.yj "一月份",t2.yj "二月份",t3.yj "三月份",t4.yj "四月份"
from (select y1.deptno,y1.month,y1.yj from yj01 y1 where y1.month='一月份')t1
join (select y1.deptno,y1.month,y1.yj from yj01 y1 where y1.month='二月份')t2 on t1.deptno = t2.deptno
join (select y1.deptno,y1.month,y1.yj from yj01 y1 where y1.month='三月份')t3 on t1.deptno = t3.deptno
join (select y1.deptno,y1.month,y1.yj from yj01 y1 where y1.month='四月份')t4 on t1.deptno = t4.deptno
