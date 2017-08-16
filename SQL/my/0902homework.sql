--建立表
create table tb_student
(
       id number(3) primary key,
       no varchar2(10) unique,
       name varchar2(10),
       gender number(1) default 1 check(gender in (1,2)),
       age number(3) default 18,
       email varchar2(20) unique,
       attendtime date
)

create table tb_course
(
       id number(3) primary key,
       name varchar2(10) unique not null,
       describe varchar2(200)
)

create table tb_score
(
       id number(3) primary key,
       stuid number(3),
       couid number(3),
       score number(5,2) default 0 not null,
       foreign key(stuid) references tb_student(id),
       foreign key(couid) references tb_course(id)
)
drop table tb_score
select * from tb_student
select * from tb_course
select * from tb_score

truncate table tb_student
--添加学生信息数据
insert into tb_student(id,no,name,gender,age,email,attendtime) values
(101,'1987xs','张三',1,23,'zhangsan@qq.com','1-9月-2010');
insert into tb_student(id,no,name,gender,age,email,attendtime) values
(102,'8762dg','李四',2,24,'lisi@qq.com','2-9月-2011');
insert into tb_student(id,no,name,gender,age,email,attendtime) values
(103,'1538de','王五',1,25,'wangwu@qq.com','13-8月-2009');
insert into tb_student(id,no,name,gender,age,email,attendtime) values
(104,'6584ew','赵六',2,26,'zhaoliu@qq.com','7-9月-2012');
--添加科目数据
insert into tb_course(id,name,describe) values(1,'语文','阅读与写作');
insert into tb_course(id,name,describe) values(2,'数学','微积分');
insert into tb_course(id,name,describe) values(3,'英语','口语对话');
--添加分数数据
insert into tb_score(id,stuid,couid,score) values(1,101,1,84);
insert into tb_score(id,stuid,couid,score) values(2,101,2,73);
insert into tb_score(id,stuid,couid,score) values(3,101,3,60);
insert into tb_score(id,stuid,couid,score) values(4,102,1,82);
insert into tb_score(id,stuid,couid,score) values(5,102,2,85);
insert into tb_score(id,stuid,couid,score) values(6,103,1,73);
insert into tb_score(id,stuid,couid,score) values(7,103,2,99);
insert into tb_score(id,stuid,couid,score) values(8,103,3,63);
insert into tb_score(id,stuid,couid,score) values(9,104,2,49);
insert into tb_score(id,stuid,couid,score) values(10,104,1,64);
--查询一个学生所有的成绩，（学生名称，学生成绩，科目名称） 
select t2.name 学生姓名, t3.name 科目名称, t1.score 学生成绩
  from tb_score t1
  join tb_student t2
    on t1.stuid = t2.id
  join tb_course t3
    on t1.couid = t3.id order by t2.name
--行转列
select t01.xm 姓名,max(case t01.km when '语文' then t01.cj end) 语文,
max(case t01.km when '数学' then t01.cj end) 数学,
max(case t01.km when '英语' then t01.cj end) 英语
from (select t2.name xm,t3.name km,t1.score cj
  from tb_score t1
  join tb_student t2
    on t1.stuid = t2.id
  join tb_course t3
    on t1.couid = t3.id)t01 group by t01.xm

