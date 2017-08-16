create table STUDENT_SCORE
(
  name    VARCHAR2(20),
  subject VARCHAR2(20),
  score   NUMBER(4,1)
)

insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '语文', 78.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '数学', 88.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('张三', '英语', 98.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '语文', 89.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '数学', 76.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('李四', '英语', 90.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '语文', 99.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '数学', 66.0);
insert into student_score (NAME, SUBJECT, SCORE) values ('王五', '英语', 91.0);


select * from student_score;

--decode  case when

select ss01.name, (case when ss01.subject='语文' then ss01.score end)   "语文" ,
 (case when ss01.subject='数学' then ss01.score end)   "数学",
  (case when ss01.subject='英语' then ss01.score end)   "英语"

 from student_score ss01;
 
 
 --怎么样合并去掉null  
 --case 
 --分组查询
 --聚合函数
select ss01.name, sum(case when ss01.subject='语文' then ss01.score else 0 end)   "语文" ,
sum(case when ss01.subject='数学' then ss01.score else 0 end)   "数学",
sum(case when ss01.subject='英语' then ss01.score else 0 end)   "英语"
 from student_score ss01  group by  ss01.name;
 
 
 select ss01.name, sum(decode(ss01.subject,'语文',ss01.score,0))   "语文" ,
sum(decode(ss01.subject,'数学',ss01.score,0))   "数学",
sum(decode(ss01.subject,'英语',ss01.score ,0))   "英语"
 from student_score ss01  group by  ss01.name;
 
--不允许使用分组 聚合
--web系统
select * from student_score

select t01.name,t01.score "语文",t02.score "数学" from 
(select ss01.name,ss01.score  from student_score ss01 where ss01.subject='语文')t01 join
(select ss01.name,ss01.score from student_score ss01 where ss01.subject='数学')t02 on t01.name=t02.name;



select t01.name,t01.score "语文",t02.score "数学" ,t03.score "英语" from 
(select ss01.name,ss01.score  from student_score ss01 where ss01.subject='语文')t01 join
(select ss01.name,ss01.score from student_score ss01 where ss01.subject='数学')t02 on t01.name=t02.name
join (select ss01.name,ss01.score from student_score ss01 where ss01.subject='英语')t03 on
t02.name=t03.name


--emp
/*
显示格式：  
       语文              数学                英语  
       及格              优秀                不及格   
*/

select tt01.name 姓名,
       (case
         when tt01.语文 >= 80 then
          '优秀'
         when tt01.语文 >= 60 and tt01.语文 < 80 then
          '及格'
         when tt01.语文 < 60 then
          '不及格'
       end) 语文,
       (case
         when tt01.数学 >= 80 then
          '优秀'
         when tt01.数学 >= 60 and tt01.数学 < 80 then
          '及格'
         when tt01.数学 < 60 then
          '不及格'
       end) 数学,
       (case
         when tt01.英语 >= 80 then
          '优秀'
         when tt01.英语 >= 60 and tt01.英语 < 80 then
          '及格'
         when tt01.英语 < 60 then
          '不及格'
       end) 英语
  from (select t01.name,
               t01.score "语文",
               t02.score "数学",
               t03.score "英语"
          from (select ss01.name, ss01.score
                  from student_score ss01
                 where ss01.subject = '语文') t01
          join (select ss01.name, ss01.score
                 from student_score ss01
                where ss01.subject = '数学') t02
            on t01.name = t02.name
          join (select ss01.name, ss01.score
                 from student_score ss01
                where ss01.subject = '英语') t03
            on t02.name = t03.name) tt01
            
            
            
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
姓名      性别     年龄
--------- -------- ----
张三       男        50
*/


insert into test values(101,1,2,'刘二');
insert into test values(201,2,2,'男');
insert into test values(301,3,2,'30');

insert into test values(102,1,3,'刘三');
insert into test values(202,2,3,'女');
insert into test values(302,3,3,'10');


select * from test;
select decode(tt01.type, 1, tt01.value ),
       decode(tt01.type, 2, tt01.value ),
       decode(tt01.type, 3, tt01.value )
  from test tt01;
select * from emp order by ename;  
  select min(ename) from emp;
  
select max(decode(tt01.type, 1, tt01.value )),
       max(decode(tt01.type, 2, tt01.value )),
       max(decode(tt01.type, 3, tt01.value ))
  from test tt01 group by tt01.t_id;
  
  --换方式
  select * from
(select tt01.t_id,tt01.value from test tt01 where tt01.type=1)t01 join
(select tt01.t_id,tt01.value from test tt01 where tt01.type=2)t02 on t01.t_id=t02.t_id 
join
(select tt01.t_id,tt01.value from test tt01 where tt01.type=3)t03 on t02.t_id=t03.t_id
  


create table tmp(rq varchar2(10),shengfu varchar2(5))

insert into tmp values('2005-05-09','胜');
insert into tmp values('2005-05-09','胜');
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-09','负');
insert into tmp values('2005-05-10','胜');
insert into tmp values('2005-05-10','负');
insert into tmp values('2005-05-10','负');

select * from tmp;
          胜 负
2005-05-09 2 2
2005-05-10 1 2
--
select tt01.rq,
sum(decode(tt01.shengfu,'胜',1)) 胜,
sum(decode(tt01.shengfu,'负',1)) 负
from tmp tt01 group by tt01.rq;
--case when

--left join?????

--



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

insert into yj01(month,deptno,yj) values('三月份',03,8);
insert into yj01(month,deptno,yj) values('十一月份',04,8);
insert into yj01(month,deptno,yj) values('十二月份',06,8);

create table yjdept(
       deptno number(10),
       dname varchar2(20)
)

insert into yjdept(deptno,dname) values(01,'国内业务一部');
insert into yjdept(deptno,dname) values(02,'国内业务二部');
insert into yjdept(deptno,dname) values(03,'国内业务三部');
insert into yjdept(deptno,dname) values(04,'国际业务部');

select * from  yj01
select *  from yjdept;


部门dep 一月份      二月份      三月份
--------------------------------------
      01      10        null      null
      02      10         8        null
      03      null       5        8
      04      null      null      9
      
      
select *      from yj01 join  yjdept yd on yj01.deptno=yd.deptno;

select yj.deptno,
sum((case when yj.month='一月份' then yj.yj end)) 一月份,
sum((case when yj.month='二月份' then yj.yj end)) 二月份,
sum((case when yj.month='三月份' then yj.yj end)) 三月份,
sum((case when yj.month='四月份' then yj.yj end)) 四月份,
sum((case when yj.month='五月份' then yj.yj end)) 五月份,
sum((case when yj.month='六月份' then yj.yj end)) 六月份,
sum((case when yj.month='七月份' then yj.yj end)) 七月份,
sum((case when yj.month='八月份' then yj.yj end)) 八月份,
sum((case when yj.month='九月份' then yj.yj end)) 九月份,
sum((case when yj.month='十月份' then yj.yj end)) 十月份,
sum((case when yj.month='十一月份' then yj.yj end)) 十一月份,
sum((case when yj.month='十二月份' then yj.yj end)) 十二月份 
 from yj01 yj left join  yjdept yd on yj.deptno=yd.deptno
group by yj.deptno;
      
      

